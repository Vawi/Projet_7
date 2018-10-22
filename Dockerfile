FROM tomcat:9.0.12-jre8

COPY /Projet_7_service/target/Projet_7_service.war /usr/local/tomcat/webapps/services.war