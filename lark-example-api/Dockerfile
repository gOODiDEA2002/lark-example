FROM harbor-dev.sanqlt.com/ci/java-run:1.0.0
COPY ./target/*.jar /opt/app.jar
EXPOSE 1001
ENTRYPOINT ["/bin/sh", "/opt/entrypoint.sh"]