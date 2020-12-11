INSERT INTO product(productNum, productName, cityName, DepartureTime, productPrice, productDesc, productStatus)" +
            " VALUES (${productNum}, ${productName}, ${cityName}, ${departureTime}, ${productPrice}, ${productDesc}, ${productStatus})

CREATE TABLE orders(
                       id INT auto_increment PRIMARY KEY,
                       orderNum VARCHAR(20) NOT NULL UNIQUE,
                       orderTime timestamp,
                       peopleCount INT,
                       orderDesc VARCHAR(500),
                       payType INT,
                       orderStatus INT,
                       productId int,
                       memberId varchar(32),
                       FOREIGN KEY (productId) REFERENCES product(id),
                       FOREIGN KEY (memberId) REFERENCES member(id)
)

CREATE TABLE order_traveller(
                                orderId varchar(32),
                                travellerId varchar(32),
                                PRIMARY KEY (orderId,travellerId),
                                FOREIGN KEY (orderId) REFERENCES orders(id),
                                FOREIGN KEY (travellerId) REFERENCES traveller(id)
)
