#验证API

###本地验证
curl -X POST "http://127.0.0.1:1001/test/hello.api" -d "id=123&name=xxx"

###三顷粮田测试环境
curl -X POST "http://techwis-api-qa.sanqlt.com/lark-example-api/test/hello.api" -d "id=123&name=xxx"

#测试Service

###本地
curl --location --request POST 'http://127.0.0.1:3001/test/hello.srv' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": 123
}'

###三顷粮田测试环境
curl --location --request POST 'http://techwis-service-qa.sanqlt.com/lark-example-service/test/hello.srv' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": 123
}'