CREATE TABLE teacher (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   nome VARCHAR(255),
   CONSTRAINT pk_teacher PRIMARY KEY (id)
);