#COPY ./target/lark-example-api-1.0.0-SNAPSHOT.jar /opt/app.jar
FROM 192.168.99.91:8080/devops/java-run:1.0.0
COPY ./target/*.jar /opt/app.jar
EXPOSE 1001
ENTRYPOINT ["/bin/sh", "/opt/entrypoint.sh"]