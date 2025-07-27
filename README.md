Setup Instructions
Configure MongoDB

Set up MongoDB databases for both order-service and product-service.

Update the application.properties or application.yml files with respective MongoDB URIs.

Start Services in Order

Run the Eureka Server first

Then start the order-service and product-service

Finally, run the API Gateway

Test the Application

Use port 8000 (API Gateway) to send all requests

Example: http://localhost:8000/order/... or http://localhost:8000/product/...

🧰 Tech Stack
Java + Spring Boot

Eureka Server (Service Discovery)

Spring Cloud API Gateway

MongoDB (for both services)
