FROM maven:3.8.2-jdk-8

WORKDIR /product-service
COPY . .
RUN mvn clean package install -DskipTests

# -Dcom.sun.jndi.ldap.objext.disableEndpointIdentification=true to exclude identification for externalProduct certificate
CMD mvn spring-boot:run -Dcom.sun.jndi.ldap.objext.disableEndpointIdentification=true