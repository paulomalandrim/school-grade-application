CREATE TABLE subjects (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_subjects PRIMARY KEY (id)
);