package lab1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class lab1 {

    public static void main(String[] args) {
        int port = 8011; // 监听8080端口
        try (ServerSocket serverSocket = new ServerSocket(port)) { // 使用 ServerSocket 监听客户端连接
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    handleRequest(socket);
                } catch (IOException e) {
                    System.err.println("Error handling client request: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server on port " + port + ": " + e.getMessage());
        }
    }

    private static void handleRequest(Socket socket) throws IOException {
        // 读取请求
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder request = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            request.append(line).append("\n");
        }
        System.out.println("Received request:\n" + request);

        // 构造HTML响应
        String htmlContent = "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>软件体系架构实验</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>软件体系架构(1)</h1>\n" +
                "<p>软件体系架构实验(1), WEB服务器实现</p>\n" +
                "</body>\n" +
                "</html>";

        byte[] htmlBytes = htmlContent.getBytes(StandardCharsets.UTF_8);
        String responseHeader = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html; charset=utf-8\r\n" +
                "Content-Length: " + htmlBytes.length + "\r\n" +
                "\r\n";

        // 发送响应
        OutputStream out = socket.getOutputStream();
        out.write(responseHeader.getBytes(StandardCharsets.UTF_8));
        out.write(htmlBytes);
        out.flush();
    }
}