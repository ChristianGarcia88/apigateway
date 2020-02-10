FROM openjdk:8
ADD  target/Zull-0.0.1-SNAPSHOT.jar  zull.jar
EXPOSE 9191
ENTRYPOINT ["java", "-jar", "zull.jar"]