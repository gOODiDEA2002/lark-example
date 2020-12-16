FROM harbor-dev.sanqlt.com/ci/java-run:1.0.0
COPY ./target/*.jar /opt/app.jar
EXPOSE 3001
#entrypoint.sh
#java -jar $JAVA_OPTS /opt/app.jar $1 2>&1
ENTRYPOINT ["/bin/sh", "/opt/entrypoint.sh"]