CREATE TABLE users
(
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    avatar OID NULL
);
ALTER TABLE users
ADD CONSTRAINT unique_login
UNIQUE (login);

CREATE TABLE images
(
  id SERIAL PRIMARY KEY NOT NULL,
  content OID NOT NULL,
  description VARCHAR(255),
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
  PRIMARY KEY(follower_id, following_id)
);

ALTER TABLE user_subscriptions
ADD FOREIGN KEY (follower_id)
REFERENCES users;

ALTER TABLE user_subscriptions
ADD FOREIGN KEY (following_id)
REFERENCES users;


CREATE TABLE likes (
  id SERIAL PRIMARY KEY NOT NULL,
  image_id INT NOT NULL,
  user_id INT NOT NULL
);

ALTER TABLE likes
ADD FOREIGN KEY (image_id)
REFERENCES images;

ALTER TABLE likes
ADD FOREIGN KEY (user_id)
REFERENCES users;

CREATE TABLE comments (
  id SERIAL PRIMARY KEY NOT NULL,
  text VARCHAR(255) NOT NULL,
  image_id INT NOT NULL,
  user_id INT NOT NULL,
  created_on TIMESTAMP NOT NULL
);

ALTER TABLE comments
ADD FOREIGN KEY (image_id)
REFERENCES images;

ALTER TABLE comments
ADD FOREIGN KEY (user_id)
REFERENCES users;