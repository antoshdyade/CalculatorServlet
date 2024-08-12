# Use the official Tomcat image as a base
FROM tomcat:9.0

# Remove the default web apps (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file to the webapps directory
COPY target/CalculatorApp.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 (internal Tomcat port)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

