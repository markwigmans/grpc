START "GRPC Client"         java -Xmx256m -jar grpc-client\target\grpc-client.jar           --server.port=8180 --grpc.server.port=6560
START "GRPC Intermediate-1" java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6560 --grpc.server.port=6561
START "GRPC Intermediate-2" java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6561 --grpc.server.port=6562
START "GRPC Intermediate-3" java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6562 --grpc.server.port=6563
START "GRPC Intermediate-4" java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6563 --grpc.server.port=6564
START "GRPC Intermediate-5" java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6564 --grpc.server.port=6565
START "GRPC Server"         java -Xmx128m -jar grpc-server\target\grpc-server.jar             --grpc.port=6565

START "JSON Client"         java -Xmx256m -jar json-client\target\json-client.jar --server.port=8080 --json.server.port=8081
START "JSON Intermediate-1" java -Xmx256m -jar json-client\target\json-client.jar --server.port=8081 --json.server.port=8082
START "JSON Intermediate-2" java -Xmx256m -jar json-client\target\json-client.jar --server.port=8082 --json.server.port=8083
START "JSON Intermediate-3" java -Xmx256m -jar json-client\target\json-client.jar --server.port=8083 --json.server.port=8084
START "JSON Intermediate-4" java -Xmx256m -jar json-client\target\json-client.jar --server.port=8084 --json.server.port=8085
START "JSON Intermediate-5" java -Xmx256m -jar json-client\target\json-client.jar --server.port=8085 --json.server.port=8090
START "JSON Server"         java -Xmx256m -jar json-server\target\json-server.jar --server.port=8090

START "Reference"           java -Xmx256m -jar reference\target\reference.jar --server.port=8280
