FROM fudongyang/jdk-8u212-maven-3.6.1
MAINTAINER fudongyang
COPY target/store-*.jar app.jar
CMD java -jar app.jar