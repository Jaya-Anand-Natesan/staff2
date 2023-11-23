FROM openjdk:17
ADD target/Springboot-Staff_Addition-mysql.jar Springboot-Staff_Addition-mysql.jar
ENTRYPOINT ["java","-jar","Springboot-Staff_Addition-mysql.jar"]