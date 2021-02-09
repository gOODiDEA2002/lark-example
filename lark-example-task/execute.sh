#!/bin/bash

# 本地执行Task
url="http://127.0.0.1:6001/run"
token="123456"
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