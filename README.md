# 验证

## API

* 本地启动
```bash
java -jar lark-example-api/target/lark-example-api-1.0.0-SNAPSHOT.jar --spring.profiles.active=playground
java -jar lark-example-api/target/lark-example-api-1.0.0-SNAPSHOT.jar --spring.profiles.active=qa
```

* 文档
```
http://127.0.0.1:1001/swagger-ui.html
```

* 本地访问
```bash
curl -X POST "http://127.0.0.1:1001/test/hello.api" -d "id=123&name=xxx"
```

* Playground环境访问
```bash
curl -X POST "http://api.lark-cloud.com/lark-example-api/lark/v1/test/hello.api" -d "id=123&name=xxx"
```

* QA环境访问
```bash
curl -X POST "https://api-qa.alzjqr.cn/lark-example-api/test/hello.api" -d "id=123&name=xxx"
```

## Service

* 本地启动
```bash
java -jar lark-example-service/target/lark-example-service-1.0.0-SNAPSHOT.jar --spring.profiles.active=playground
java -jar lark-example-service/target/lark-example-service-1.0.0-SNAPSHOT.jar --spring.profiles.active=qa
```
* 本地访问
```bash
curl --location --request POST 'http://127.0.0.1:3001/lark/TestService/Hello' \
--header 'Content-Type: application/json' \
--data-raw '{
	"service": "TestService",
	"method": "Hello",
	"args": [
		{
			"type": 150,
			"data": "{\"id\":123,\"type\":\"GOOD\"}"
		}
	]
}'
```
```bash
curl --location --request POST 'http://127.0.0.1:3001/lark/TestService/getOrder' \
--header 'Content-Type: application/json' \
--data-raw '{
	"service": "TestService",
	"method": "getOrder",
	"args": [
		{
			"type": 150,
			"data": "{\"orderId\":2}"
		}
	]
}'
```

* Playground环境访问
```bash
curl --location --request POST 'http://service.lark-cloud.com/lark-example-service/lark/TestService/Hello' \
--header 'Content-Type: application/json' \
--data-raw '{
	"service": "TestService",
	"method": "Hello",
	"args": [
		{
			"type": 150,
			"data": "{\"id\":123,\"type\":\"GOOD\"}"
		}
	]
}'
```

```bash
curl --location --request POST 'http://service.lark-cloud.com/lark-example-service/lark/TestService/getOrder' \
--header 'Content-Type: application/json' \
--data-raw '{
	"service": "TestService",
	"method": "getOrder",
	"args": [
		{
			"type": 150,
			"data": "{\"orderId\":2}"
		}
	]
}'
```
* QA环境访问
```bash
curl --location --request POST 'http://service-qa.alzjqr.cn/lark-example-service/lark/TestService/Hello' \
--header 'Content-Type: application/json' \
--data-raw '{
	"service": "TestService",
	"method": "Hello",
	"args": [
		{
			"type": 150,
			"data": "{\"id\":123,\"type\":\"GOOD\"}"
		}
	]
}'
```

```bash
curl --location --request POST 'http://service-qa.alzjqr.cn/lark-example-service/lark/TestService/getOrder' \
--header 'Content-Type: application/json' \
--data-raw '{
	"service": "TestService",
	"method": "getOrder",
	"args": [
		{
			"type": 150,
			"data": "{\"orderId\":2}"
		}
	]
}'
```

## Task

* 本地启动
```bash
java -jar lark-example-task/target/lark-example-task-1.0.0-SNAPSHOT.jar --spring.profiles.active=playground
java -jar lark-example-task/target/lark-example-task-1.0.0-SNAPSHOT.jar --spring.profiles.active=qa
```

* 本地访问
```bash
url="http://127.0.0.1:6001/run"
token="12345678"
task="TestTask"
echo -e "->request: $url $task\n"
curl --location --request POST $url \
--header 'Content-Type: application/json' \
--header 'XXL-JOB-ACCESS-TOKEN:$token' \
--data-raw '{
        "jobId": 1,
        "executorHandler": '\"$task\"',
        "executorParams": "",
        "logId": 1,
        "logDateTime":1586629003729
}'
```

* Playground环境访问
```bash
url="http://task.lark-cloud.com/lark-example-task/run"
token="12345678"
task="TestTask"
echo -e "->request: $url $task\n"
curl --location --request POST $url \
--header 'Content-Type: application/json' \
--header 'XXL-JOB-ACCESS-TOKEN:$token' \
--data-raw '{
        "jobId": 1,
        "executorHandler": '\"$task\"',
        "executorParams": "",
        "logId": 1,
        "logDateTime":1586629003729
}'
```

## Msg-Handler

* 本地启动
```bash
java -jar lark-example-msg-handler/target/lark-example-msg-handler-1.0.0-SNAPSHOT.jar --spring.profiles.active=playground
java -jar lark-example-msg-handler/target/lark-example-msg-handler-1.0.0-SNAPSHOT.jar --spring.profiles.active=qa
```

* 本地访问
```bash
handler="OrderCreateHandlerImpl"
url="http://127.0.0.1:5001/run/${handler}"
echo -e "->request: $url $handler\n"
curl --location --request POST $url \
--header 'Content-Type: application/json' \
--data-raw '{
      "orderId":123,
      "userId":456
    }'
```

* Playground环境访问
```bash
handler="OrderCreateHandlerImpl"
url="http://handler.lark-cloud.com/run/${handler}"
echo -e "->request: $url $handler\n"
curl --location --request POST $url \
--header 'Content-Type: application/json' \
--data-raw '{
      "orderId":123,
      "userId":456
    }'
```
