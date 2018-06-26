CREATE SCHEMA IF NOT EXISTS soapstore
CHARACTER SET utf8
COLLATE utf8_general_ci;
COMMIT;

CREATE TABLE users (
  id         BIGINT AUTO_INCREMENT,
  login      VARCHAR(100),
  password   VARCHAR(100),
  salt       VARCHAR(100)

  PRIMARY KEY (id)
);

CREATE TABLE products (
  id    BIGINT AUTO_INCREMENT,
  name  VARCHAR(100),
  price DOUBLE,
  image_ref VARCHAR (500),
  date  DATETIME DEFAULT CURRENT_TIMESTAMP ,

  PRIMARY KEY (id)
);