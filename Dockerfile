FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY target/consumer-service-*.jar consumer-service.jar
EXPOSE 8080
RUN mkdir -p /srv/logs
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar consumer-service.jar