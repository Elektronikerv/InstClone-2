
CREATE TABLE users
(
    id SERIAL PRIMARY KEY NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(1) NOT NULL
);
ALTER TABLE users
 ADD CONSTRAINT unique_email UNIQUE (email);

