FROM frolvlad/alpine-oraclejdk8:slim

COPY target/coreservice.jar /var/ms/coreservice.jar
COPY config-prod.json /var/ms/config-prod.json

WORKDIR /var/ms

RUN mkdir upload

RUN java -version

CMD ["java","-jar","coreservice.jar","server","config-prod.json"]

EXPOSE 80