CREATE TABLE IF NOT EXISTS PRODUCT_REVIEW (
    product_id varchar(50) PRIMARY KEY,
    average_review_score int NOT NULL,
    no_of_reviews int NOT NULL
);

INSERT INTO PRODUCT_REVIEW(product_id,average_review_score,no_of_reviews) VALUES('AB1234',100,4);
INSERT INTO PRODUCT_REVIEW(product_id,average_review_score,no_of_reviews) VALUES('CD1234',90,2);
INSERT INTO PRODUCT_REVIEW(product_id,average_review_score,no_of_reviews) VALUES('EF1234',80,5);
