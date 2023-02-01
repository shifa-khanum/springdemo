FROM openjdk:11
ADD target/demo_springboot-1.0.0.jar demo_springboot-1.0.0.jar
ENTRYPOINT ["java", "-jar","demo_springboot-1.0.0.jar"]
EXPOSE 9091