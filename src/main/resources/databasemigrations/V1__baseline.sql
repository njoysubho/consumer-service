CREATE SCHEMA IF NOT EXISTS consumer;
SET search_path TO consumer,public;

create table consumers(
 id UUID primary key,
 firebase_id varchar(255) not null,
 email varchar(255) not null,
 name varchar(255) not null,
 created_at timestamp not null,
 modified_at timestamp not null
)