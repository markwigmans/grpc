# Read Me
This project is to test what the performance impact is of using [JSON](https://en.wikipedia.org/wiki/JSON) over HTTP 
and if [gRPC](https://grpc.io/) is a better alternative for this. There are 3 versions created:

- json client/server;
- grpc client/intermediate/server;
- reference.

The idea is to send a GET request to the client, which redirect this request to zero or more intermediate nodes and 
then to the server. The communication between the client/server is either json or grpc. 

To compare it with an all-in-memory approach, a reference project is created. 

## Design
The goals is to have a simple REST/Database application with as little source code as possible, 
and with a minimal amount of functionality to be useable as test case.

## Requirements
To build the application, Java 11 (for example [OpenJDK](https://openjdk.java.net/projects/jdk/11/)) and apache [maven](https://maven.apache.org/) are required.
For the docker version, a [Docker](https://www.docker.com/) environment is required as well.

## build
The applications can be build in a runable jar version or a docker version.

The runable jar versions are build via:

``mvn clean install``

The docker versions are build via:

``mvn clean install -P docker``

## Run
A docker compose file is created for the spring boot docker images. Run it via:

``
docker-compose --env-file env.dev -f docker-compose.yml up
``

A version with runable jars is available as well, file ``runall.bat``. The number of intermediate components is arbitrary
chosen to be 2.

## Load Test
A jmeter script is available to check the relative performance of the different solutions.

Perform the following steps:

1. start the applications (docker version or runable jar version)
1. check json version: http://localhost:8080/customer/all
1. check grpc version: http://localhost:8180/customer/all
1. check spring boot reference version: http://localhost:8280/customer/all
1. goto jmeter directory and run:
``<path to jmeter>\jmeter.bat -n -p user.properties -t customer.jmx -l testresults.jtl -e -o report -f``

### configuration
The file 'user.properties' describes jmeter test configuration parameters.

| Parameter | Description | Default value |
| --------- | ----------- | ------------- |
| duration  | Duration in seconds of test for a particular version (jsn,grpc, refence) | 30
| users     | number of parallel users | 10

### Ports used

| Application | Port |
| ----------- | ---- |
| json        | 8080 | 
| gRPC        | 8180 |
| RSocket     | 8280 |
| Reference   | 8380 |
