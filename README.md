# spring-cloud-function-sample
Example of Spring cloud function 


To test from command line using curl, run below commands:

1. Function with object
curl -H "Content-Type: text/plain" -H "Accept: application/json" localhost:8080/findsame -d "{\"data1\":\"1\",\"data2\":\"1\",\"data3\":\"1\"}"

2. Function with String 
curl -H "Content-Type: text/plain" -H "Accept: text/plain" localhost:8080/uppercase -d foo

3. Supplier 
curl -H "Content-Type: text/plain" -H "Accept: text/plain" localhost:8080/hello


Some more examples are there with Flux.
