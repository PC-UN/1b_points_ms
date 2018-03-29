FROM glassfish

COPY db-server/mysql-connector-java-5.1.34.jar glassfish/lib/mysql-connector-java-5.1.34.jar
COPY app-server/domain.xml glassfish/domains/domain1/config/domain.xml
COPY app-server/admin-keyfile glassfish/domains/domain1/config/admin-keyfile
COPY target/points.war glassfish/domains/domain1/autodeploy/points.war
