# Running the microservice local
- "mvn package"
- "java -jar target/coreservice.jar server config-local.json"
- Recommended to add a run configuration in the IDEA

The service is locally running at port 8444 (http://localhost:8444).The Api can be accessed at http://localhost:8444/api/* and the Swagger Api documentation at http://localhost:8444/api/swagger.

# Building Docker container
- "mvn package" or explicitly "mvn dockerfile:build"

# Documentation of the core libraries
- Dropwizard: http://dropwizard.io
- Swagger: http://swagger.io
- Docker: https://www.docker.com

# Requirements
- Java JDK 8
- Maven (https://maven.apache.org)
- For Docker, if needed: local installation
- Recommended IDEA: IntelliJ IDEA (https://www.jetbrains.com/idea/)