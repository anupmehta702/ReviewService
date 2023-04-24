# Product & Review Service overview
This is a review service for products

## Architecture
Below is the architecture diagram for the entire application .
![image](https://user-images.githubusercontent.com/12785130/233911592-2ac61cf1-54cd-4311-847f-85d178678ae2.png)

Note - All the components are deployed as docker containers via docker-compose

### Tools / services -
1) **Nginx Load balancer** - Acts as load balancer for multi instances of product-service and review-service
2) **Postgres DB** - SQL DB for both services ( going forward we can always use seperate DBs as per requirement)
3) **Redis cache** - Distributed cache for both services
4) **review-service** - hosting /review CRUD APIs
5) **product-service** - hosting /product API ( which internally calls /review/{productId} API of review service
6) **external-product-service** - hosting https enabled /addidas/api/products API 

## Startup
Navigate to the folder containing docker-compose.yaml and run below commands to deploy all the services  -
1) docker-compose build
2) docker-compose up

## API details 
You can find the API details in /postman-api-collection


## Features 
1) **High availability and designed for failure** - achieved via deploying multi instances of both services and using distributed cache across the instances. Also exceptions handled seperately in both service
2) **Reusability** - Using common load balancer, postgres DB and Redis containers for both the services. AS per load requirements, we could have a dedicated DB and cache for both services
3) **Junit** - good unit test coverage with functional endpoint tests
4) **Scalable** - design is scalable ,wherein as per load you can add / reduce number of service instances.
5) **Containerized** - Every service is docker containerized and can be run collectively using docker-compose command.

## TODO / Work in progress
1) Currently not using docker volumes, include it and encrypt it
2) Deploy seperate DB for product-service instead of using common postgres DB
3) Use https instead of http for all API communication 
4) Enhance docker network security
5) Currently using Basic Auth for authentication, need to enhance the security using API gateway and JWT and API tokens



