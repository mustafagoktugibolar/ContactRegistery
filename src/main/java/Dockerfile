FROM ubuntu:latest
LABEL authors="mustafagoktugibolar"

ENTRYPOINT ["top", "-b"]
FROM openjdk
WORKDIR /app
COPY . /app
RUN Main.java
CMD ["java", "Main"]