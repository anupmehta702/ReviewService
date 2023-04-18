

# ReviewService
This is a review service for products

### postgres commands - 
1) To run standalone postgres -
cd postgres-db
docker build -t standalone-postgres .
docker run -d --name standalone-postgres-container -p 5432:5432 standalone-postgres
2) To enter postgres,
docker exec -it <containerID> bash
psql -U postgres
\c review-service-db
\dt for list of tables
\d+ <table-name>

### Redis commands -
1) To run standalone redis - 
docker run --name standalone-redis -p 6379:6379 -d redis
2) to debug -
docker exec -it standalone-redis sh
redis-cli
set name anup
get name anup
keys * // to get all keys
get productReviewCache::AB1234


### Reference - 
1) Load balancer --> https://blog.devgenius.io/load-balancing-a-spring-boot-application-with-nginx-and-docker-e701f74c011d
2) Postgres --> https://www.docker.com/blog/kickstart-your-spring-boot-application-development/
             https://github.com/eugenp/tutorials/blob/master/docker-modules/docker-spring-boot-postgres/src/main/docker/docker-compose.yml 
3) Redis --> https://medium.com/idomongodb/installing-redis-server-using-docker-container-453c3cfffbdf
