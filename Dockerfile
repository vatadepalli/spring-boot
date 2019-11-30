FROM ubuntu:latest

LABEL maintainer="@vatadepalli"

RUN apt-get update && apt-get install -y openjdk-8-jdk

ENV version=docker_prod
ENV dbuser=admin
ENV dbpass=password321
ENV jdbcurl=jdbc:mysql://pma-database-aws.czjmfzuhci6g.us-east-1.rds.amazonaws.com:3306/pma
ENV SPRING_PROFILES_ACTIVE=prod

WORKDIR /usr/local/bin/

ADD ./target/pma-app.jar .

ENTRYPOINT [ "java", "-jar", "pma-app.jar" ]