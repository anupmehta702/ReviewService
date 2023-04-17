CREATE TABLE IF NOT EXISTS PRODUCT (
    product_id varchar(50) PRIMARY KEY,
    product_type varchar(100) NOT NULL,
    name varchar(100) NOT NULL
);

INSERT INTO PRODUCT(product_id,product_type,name) VALUES('AB1234','sports','Adidas shoes');
INSERT INTO PRODUCT(product_id,product_type,name) VALUES('CD1234','clothes','Adidas dry fit');
INSERT INTO PRODUCT(product_id,product_type,name) VALUES('EF1234','merchandise','adidas cap');