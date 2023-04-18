

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

