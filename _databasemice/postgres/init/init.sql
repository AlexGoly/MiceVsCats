create DATABASE micedb;
\c catsdb;
--CREATE EXTENSION IF NOT EXISTS plpgsql;
create table  if not exist mice
(
    id                bigserial
        primary key,
    age               real not null,
    color             varchar,
    normal_speed      real,
    top_speed         real,
    reproductive_rate integer,
    is_dead           boolean
);

create index is_dead_idx
    on mice (is_dead);

