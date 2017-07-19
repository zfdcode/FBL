# FBL Core Microservice

## Module structure
- service: microservice implementation (technical code)
- bdo: contains representations of the business data objects
- persistence: module for the data persistence/database interaction
- imagestorage: module for the image storage implementation

## Buidling all modules
Run "mvn package" or for a clean build "mvn clean package" in the projects root directory.

## Emigrating db structure
```
mvn clean install
java -jar service/target/coreservice.jar db drop-all --confirm-delete-everything service/config-local.json
java -jar service/target/coreservice.jar db migrate service/config-local.json
```