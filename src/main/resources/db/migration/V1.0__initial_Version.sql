CREATE SEQUENCE users_id_seq;
CREATE TABLE Users (
id bigint not null DEFAULT NEXTVAL('users_id_seq'),
username varchar(255) not NULL UNIQUE,
first_name varchar(255),
last_name varchar(255),
primary key (id)
);
ALTER SEQUENCE users_id_seq OWNED BY Users.id;
