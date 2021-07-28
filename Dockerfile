FROM openjdk:8
EXPOSE 8080
ADD target/code-metrane.jar code-metrane.jar
ENTRYPOINT ["java","-jar","/code-metrane.jar"]