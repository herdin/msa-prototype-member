FROM alpine:3.10

RUN apk add openjdk11
RUN mkdir /msa
COPY ./build/libs/jsm-1.0-SNAPSHOT.jar /msa

CMD ["java", "-jar", "/msa/jsm-1.0-SNAPSHOT.jar"]