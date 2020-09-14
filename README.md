# Read Me
This project is to test what the performance impact is of using json over HTTP and if Grpc is a better alternative for this. There are 3 versions created:

- json client/server;
- grpc client/intermediate/server;
- reference.

The idea is to send a GET request to the client, which redirect this request to zero or more intermediate nodes and then to the server. 
The communication between the client/server is either json or grpc. 

To compare it with an all-in-memory approach, a reference project is created in two versions, 
a [Spring Boot](https://spring.io/projects/spring-boot) version and a [Quarkus](https://quarkus.io/) version.

## Design
The goals is to have a simple REST/Database application with as little source code as possible, 
and with a minimal amount of functionality to be useable as test case.

## build
The applications can be build in a runable jar version and a docker version.

The runable jar versions are build via:

``mvn clean install``

The docker versions are build via:

``mvn clean install -P docker``

The maven environment is already prepared to have Spring boot docker images, extension 'sb', and Spring Native docker images, extension 'gvm'. 

## Run
A docker compose file is created for the spring boot docker images. Run it via:

``docker-compose -f docker-compose-sb.yml up``

A version with runable jars is available as well, file ``runall.bat``. The number of intermediate components is arbitrary
chosen to be 5.

## Load Test
A jmeter script is available to check the performance

Perform the following steps:

1. start the applications (docker version or runable jar version)
1. check json version: http://localhost:8080/customer/all
1. check grpc version: http://localhost:8180/customer/all
1. check spring boot reference version: http://localhost:8280/customer/all
1. check quarkus reference version: http://localhost:8380/customer/all
1. goto jmeter directory and run:
``<path to jmeter>\jmeter.bat -n -p user.properties -t customer.jmx -l testresults.jtl -e -o report -f``

### configuration
The file 'user.properties' describes jmeter test configuration parameters.

| Parameter | Description | Default value |
| --------- | ----------- | ------------- |
| duration  | Duration in seconds of test for a particular version (jsn,grpc, refence) | 30
| users     | number of parallel users | 10

## Work in Progress
An first attempt to create native applications with using [Spring GraalVM Native](https://github.com/spring-projects-experimental/spring-graalvm-native) 
is still in progress.  