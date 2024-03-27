FROM eclipse-temurin:17
COPY target/contacts-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xmx2048M","-jar","/app.jar"]