FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY build/libs/*.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]