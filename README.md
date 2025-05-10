# 软件体系架构实验

## 题目
1. 使用socket实现一个web简单服务器，监听80或8080端口，接收从浏览器发送的请求并将请求打印出来，然后回复下面一段html文字，显示在浏览器中。
<html>
<head>
<meta charset="utf-8">
<title>软件体系架构实验</title>
</head>
<body>
<h1>软件体系架构实验(1)</h1>
<p>软件体系架构实验(1), WEB服务器实现</p >
</body>
</html>

2.  实现一个消息中间件服务器及客户端，服务器监听端口，最少3个客户端连接到服务器，任何一个客户端发送消息，服务器都转发到其他两个。
服务器需要记录客户端连接上来的socket，保证数据能正常转发。
检查点：
  1) 是否为C/S架构；
  2) 是否实现要求的功能。

3. 使用cpp-httplib库实现一个简单的RESTful 服务器，返回json数据。
检查点：
 1）使用cpp-httplib，支持从浏览器上请求
 2）实现两个以上的请求，并支持带参数,，把参数在json中返回（如：http://localhost/query?name=abc）

## 步骤
1. html
2. cpp.exe
3. post自己请求
curl --location --request POST 'localhost:8081/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "username": "test_user",
        "password": "123456",
        "role": "admin"
    }}'
