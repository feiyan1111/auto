CREATE SEQUENCE cars_id_seq;
CREATE TABLE cars (
    id bigint not null DEFAULT NEXTVAL('cars_id_seq'),
    brand varchar(255) not NULL,
    model varchar(255) not NULL,
    year varchar(255) not NULL,
    color varchar(255) not NULL,
    miles varchar(255) not NULL,
    primary key (id)
);
ALTER SEQUENCE cars_id_seq OWNED BY cars.id;