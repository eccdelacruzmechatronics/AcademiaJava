DROP TABLE services IF EXISTS;

CREATE TABLE service (
    serviceId VARCHAR(20) NOT NULL,
    serviceName VARCHAR(20),
    serviceDesc VARCHAR(60),
    cost VARCHAR(30)
);
