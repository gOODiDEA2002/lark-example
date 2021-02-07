#!/bin/bash

# 本地执行
url="http://127.0.0.1:3001/test/hello.srv"
echo -e "->request: $url\n"
curl --location --request POST $url \
--header 'Content-Type: application/json' \
--data-raw '{
"id": 123
}'
echo -e "\n"
#
url="http://127.0.0.1:3001/test/order/get.srv"
echo -e "->request: $url\n"
curl --location --request POST $url \
--header 'Content-Type: application/json' \
--data-raw '{
"orderId": 2
}'