create DATABASE catsdb;
\c catsdb;
--CREATE EXTENSION IF NOT EXISTS plpgsql;
create table if not exists cat
(
  id bigserial primary key,
    name varchar not null,
    age real,
    color varchar,
    normal_speed real,
    jump_speed real,
    agility int,
    eyesight real
);

create index if not exists cat_name_idx on cat(name);
