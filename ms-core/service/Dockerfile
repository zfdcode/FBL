FROM frolvlad/alpine-oraclejdk8:slim

COPY target/coreservice.jar /var/ms/coreservice.jar
COPY config-local.json /var/ms/config-local.json

WORKDIR /var/ms

RUN java -version

CMD ["java","-jar","coreservice.jar","server","config-local.json"]

EXPOSE 8444