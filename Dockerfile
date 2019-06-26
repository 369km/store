FROM ascdc/jdk8
MAINTAINER fudoyang
COPY target/store-1.0.jar store.jar
CMD java -jar store.jar