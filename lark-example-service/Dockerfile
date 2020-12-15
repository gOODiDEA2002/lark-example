FROM harbor-dev.sanqlt.com/ci/java-run:1.0.0
COPY ./target/*.jar /opt/app.jar
EXPOSE 3001
ENTRYPOINT ["/bin/sh", "/opt/entrypoint.sh"]