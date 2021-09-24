FROM goodidea2002/ci:java-run
COPY ./target/*.jar /opt/app.jar
EXPOSE 5001
#entrypoint.sh
#java -jar $JAVA_OPTS /opt/app.jar $1 2>&1
ENTRYPOINT ["/bin/sh", "/opt/entrypoint.sh"]