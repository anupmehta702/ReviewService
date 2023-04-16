# ReviewService
This is a review service for products


TODO 
1) Change output to success output for POST, PUT and Delete 
2) Correct WebsecurityConfig to use bcrypt for password
2) change datatype of averageReview to double and noOfReviews to Long
3) Add database 
4) Add cache
5) know all properties of postgres that are used
6) Add HTTPS to loadbalancer
7) Add password in secret file 
8) Read about networks in docker
9) read about docker volume

docker-compose commands - 
1) go to base project 
2) run command " docker-compose build " then " docker-compose up "
other docker-compose commands - docker-compose build ,  docker-compose down

postgres commands - 
1)  To run standalone postgres -
cd postgres-db
docker build -t standalone-postgres .
docker run -d --name standalone-postgres-container -p 5432:5432 standalone-postgres
2) To enter postgres,
docker exec -it 34a1678b7378 bash
psql -U postgres
/dt for list of tables
/d+ <table-name>

redis commands -
1) To run standalone redis - 
docker run --name standalone-redis -p 6379:6379 -d redis
2) to debug -
docker exec -it standalone-redis sh
redis-cli
set name anup
get name anup
keys * // to get all keys
get productReviewCache::AB1234


Reference - 
Load balancer --> https://blog.devgenius.io/load-balancing-a-spring-boot-application-with-nginx-and-docker-e701f74c011d
Postgres --> https://www.docker.com/blog/kickstart-your-spring-boot-application-development/
             https://github.com/eugenp/tutorials/blob/master/docker-modules/docker-spring-boot-postgres/src/main/docker/docker-compose.yml 
Redis --> https://medium.com/idomongodb/installing-redis-server-using-docker-container-453c3cfffbdf
