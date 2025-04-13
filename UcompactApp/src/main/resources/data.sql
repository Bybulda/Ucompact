Drop table if EXISTS short_url;
CREATE TABLE  short_url(
     id serial PRIMARY KEY, origin_url VARCHAR  NOT NULL, shorten_url VARCHAR NOT NULL UNIQUE
)