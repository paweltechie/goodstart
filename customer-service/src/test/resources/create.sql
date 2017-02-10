CREATE TABLE IF NOT EXISTS nelson.customer (
  id VARCHAR(45) NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  street_1 VARCHAR(45) NULL,
  street_2 VARCHAR(45) NULL,
  city VARCHAR(45) NULL,
  state VARCHAR(45) NOT NULL,
  sip VARCHAR(45) NULL,
  country VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
 