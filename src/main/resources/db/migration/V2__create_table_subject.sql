CREATE TABLE subject (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_subject PRIMARY KEY (id)
);