START "GRPC Client"         /min java -Xmx256m -jar grpc-client\target\grpc-client.jar           --server.port=8180 --grpc.server.port=6560
START "GRPC Intermediate-1" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6560 --grpc.server.port=6561
START "GRPC Intermediate-2" /min java -Xmx128m -jar grpc-intermediate\target\grpc-intermediate.jar --grpc.port=6561 --grpc.server.port=6565
START "GRPC Server"         /min java -Xmx128m -jar grpc-server\target\grpc-server.jar             --grpc.port=6565

START "JSON Client"         /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8080 --json.server.port=8081
START "JSON Intermediate-1" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8081 --json.server.port=8082
START "JSON Intermediate-2" /min java -Xmx256m -jar json-client\target\json-client.jar --server.port=8082 --json.server.port=8090
START "JSON Server"         /min java -Xmx256m -jar json-server\target\json-server.jar --server.port=8090

START "RSocket Client"         /min java -Xmx256m -jar rsocket-client\target\rsocket-client.jar --server.port=8280 --rsocket.server.port=7001
START "RSocket Intermediate-1" /min java -Xmx256m -jar rsocket-client\target\rsocket-client.jar --server.port=8281 --spring.rsocket.server.port=7001 --rsocket.server.port=7002
START "RSocket Intermediate-2" /min java -Xmx256m -jar rsocket-client\target\rsocket-client.jar --server.port=8282 --spring.rsocket.server.port=7002 --rsocket.server.port=7000
START "RSocket Server"         /min java -Xmx128m -jar rsocket-server\target\rsocket-server.jar --spring.rsocket.server.port=7000

START "Reference"           /min java -Xmx256m -jar reference\target\reference.jar --server.port=8380
