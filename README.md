# Read Me
This project is to test what the performance impact is of jusing Json over HTTP or GRPC. There are 3 versions created:

- json client/server;
- grpc client/server;
- reference.

The idea is to send a GET request to the client, which redirect this request to the server.  The communication
between the client/server is either json or grpc. To compare it with an all-in-memory approach, a reference project is 
created.

## build
A profile 'docker' is used, to build docker containers.

``mvn clean install -P docker``

## Load Test
A jmeter script is available to check the performance

goto jmeter directory and run:

``C:\tools\apache-jmeter-5.3\bin\jmeter.bat -n -p user.properties -t customer.jmx -l testresults.jtl -e -o report -f``