FROM java:8
FROM openjdk:8u111-jdk-alpine

# Default Environment
ARG DB_HOST=127.0.0.1:3306
ARG DB_NAME=db
ARG DB_USER=user
ARG DB_PASSWORD=password

# Dynamic Environment
ENV DB_HOST=$DB_HOST \
  DB_NAME=$DB_NAME \
  DB_USER=$DB_USER \
  DB_PASSWORD=$DB_PASSWORD

VOLUME /tmp

EXPOSE 8080
ADD ./target/price-0.0.1-SNAPSHOT.jar price-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","price-0.0.1-SNAPSHOT.jar"]