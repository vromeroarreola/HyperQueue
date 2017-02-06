
# HyperQueue

HyperQueue (HQ) is a  network enabled  in­memory event queuing system . It allows clients to connect to the server (or  broker ) and take on one of the following two roles: a  producer , or a  consumer . The broker has multiple named  topics  (or  queues).

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

# Improvements

- Finish unit tests
- Finish integration tests
- Add browser interface
