FROM openjdk:8
ADD target/clusus_test.jar clusus_test.jar
ENTRYPOINT ["java","-jar","clusus_test.jar"]
