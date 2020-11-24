FROM java:8-jdk-alpine
LABEL module_name="lark-example" module_type="service"
RUN  apk add -U tzdata && \
     ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
COPY ./target/lark-example-api-1.0.0-SNAPSHOT.jar /opt/app.jar
COPY entrypoint.sh /opt/entrypoint.sh

EXPOSE 3001
ENTRYPOINT ["/bin/sh", "/opt/entrypoint.sh"]