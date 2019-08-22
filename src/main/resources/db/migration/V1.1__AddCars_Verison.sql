CREATE SEQUENCE cars_id_seq;
CREATE TABLE cars (
    id bigint not null DEFAULT NEXTVAL('cars_id_seq'),
    brand varchar(255) not NULL,
    model varchar(255) not NULL,
    year int not NULL,
    color varchar(255) not NULL,
    miles int not NULL,
    primary key (id)
);
ALTER SEQUENCE cars_id_seq OWNED BY cars.id;