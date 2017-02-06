
# HyperQueue

HyperQueue (HQ) is a  network enabled  in­memory event queuing system . It allows clients to connect to the server (or  broker ) and take on one of the following two roles: a  producer , or a  consumer . The broker has multiple named  topics  (or  queues).

The main services are:

# Create topic service

URL: https://localhost:4430/dev/v1/topic/{topic_name}

Example:

URL: https://localhost:4430/dev/v1/topic/newUsers

Response body: cde303d3-fb79-42ab-bf52-de2854b3c418

# Produce message service

URL: https://localhost:4430/dev/v1/push/{topic_name}

Example:

URL: https://localhost:4430/dev/v1/push/newUsers

Request body: {"data":"1554886"}

Response body: true

# Consume message service

URL: https://localhost:4430/dev/v1/pop/{session_id}

Example:

URL: https://localhost:4430/dev/v1/pop/cde303d3-fb79-42ab-bf52-de2854b3c418

Response body: {"data":"1554886"}

# Open session service

# How to run the application

- Generate a keystore with the following command:

keytool -genkey -alias alias -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650 -dname "CN=Unknown, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown" -keypass password -storepass password

- Generate a certificate with the following command:

keytool -export -alias alias -storepass password -file mycertificate.cer -keystore keystore.p12

- Add certificate in Chrome --> Settings --> HTTPS/SSL --> Manage certificates --> System

You can run the application using ./mvnw spring-boot:run

# Improvements

- Finish unit tests
- Finish integration tests
- Add browser interface
- Reactive Programming feature

