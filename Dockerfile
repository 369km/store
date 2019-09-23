FROM fudongyang/jdk-8u212-maven-3.6.1
MAINTAINER fudongyang
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
CMD java -jar app.jar