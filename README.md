前端html
cpp.exe直接起

post自己请求
curl --location --request POST 'localhost:8081/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "username": "test_user",
        "password": "123456",
        "role": "admin"
    }}'
