
CREATE TABLE users
(
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(1) NOT NULL
);
ALTER TABLE users
ADD CONSTRAINT unique_login
UNIQUE (login);

CREATE TABLE images
(
  id SERIAL PRIMARY KEY NOT NULL,
  content OID NOT NULL,
  user_id INT NOT NULL,
  created_on TIMESTAMP NOT NULL
);

ALTER TABLE images
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id)
REFERENCES users(id);

CREATE TABLE user_subscriptions (
  follower_id INT NOT NULL,
  following_id INT NOT NULL,
  PRIMARY KEY (follower_id, following_id)
);

ALTER TABLE user_subscriptions
ADD FOREIGN KEY (follower_id)
REFERENCES users;

ALTER TABLE user_subscriptions
ADD FOREIGN KEY (following_id)
REFERENCES users;
