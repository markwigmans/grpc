rem START "GRPC Client"         /min java -Xmx256m -jar grpc-client\target\grpc-client.jar           --server.port=8180 --grpc.server.port=6560
rem START "GRPC Intermediate-1" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6560 --grpc.server.port=6565
rem START "GRPC Intermediate-2" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6561 --grpc.server.port=6562
rem START "GRPC Intermediate-3" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6562 --grpc.server.port=6563
rem START "GRPC Intermediate-4" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6563 --grpc.server.port=6564
rem START "GRPC Intermediate-5" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6564 --grpc.server.port=6565
rem START "GRPC Server"         /min java -Xmx128m -jar grpc-server\target\grpc-server.jar             --grpc.port=6565

rem START "JSON Client"         /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8080 --json.server.port=8081
rem START "JSON Intermediate-1" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8081 --json.server.port=8090
rem START "JSON Intermediate-2" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8082 --json.server.port=8083
rem START "JSON Intermediate-3" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8083 --json.server.port=8084
rem START "JSON Intermediate-4" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8084 --json.server.port=8085
rem START "JSON Intermediate-5" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8085 --json.server.port=8090
rem START "JSON Server"         /min java -Xmx256m -jar json-server\target\json-server.jar --server.port=8090

START "Reference"           /min java -Xmx256m -jar reference\target\reference.jar --server.port=8280
START "Reference Quarkus"   /min java -Xmx128m -jar reference-quarkus\target\reference-quarkus-runner.jar
