FROM maven:3.8.1 as MAVEN_BUILD
COPY ./ ./
RUN mvn clean install

FROM tomcat:9.0-jre8
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=MAVEN_BUILD target/coinbase-pro-1.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]