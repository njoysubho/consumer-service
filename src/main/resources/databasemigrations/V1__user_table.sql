create schema if not exists consumer;

SET search_path = consumer, pg_catalog;

create table users(
id UUID primary key,
external_id varchar(255) NOT NULL,
name varchar(255),
email varchar(255) NOT NULL UNIQUE,
created_on timestamp NOT NULL,
created_by timestamp NOT NULL,
modified_on timestamp
);