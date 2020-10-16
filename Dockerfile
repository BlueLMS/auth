FROM openjdk:11
ADD target/auth-*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
