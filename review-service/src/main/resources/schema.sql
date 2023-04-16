CREATE TABLE IF NOT EXISTS PRODUCT_REVIEW (
    product_id varchar(50) PRIMARY KEY,
    average_review_score int NOT NULL,
    no_of_reviews int NOT NULL
);