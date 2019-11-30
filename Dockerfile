FROM ubuntu:latest

LABEL maintainer="@vatadepalli"

RUN apt-get update && apt-get install -y openjdk-8-jdk

ENV version=docker_prod
ENV dbuser=admin
ENV dbpass=<mysql-password>
ENV jdbcurl=jdbc:mysql://<aws-db-url:3306>/pma
ENV SPRING_PROFILES_ACTIVE=prod

WORKDIR /usr/local/bin/

ADD ./target/pma-app.jar .

ENTRYPOINT [ "java", "-jar", "pma-app.jar" ]
