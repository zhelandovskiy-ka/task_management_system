FROM openjdk:17-jdk-slim
WORKDIR /app
COPY /target/task_management_system.jar /app/task_management_system.jar
ENTRYPOINT ["java","-jar","task_management_system.jar"]