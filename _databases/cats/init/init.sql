-- Cats database init script
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

INSERT INTO cat
(id,"name",age,color,normal_speed,jump_speed,agility,eyesight)
VALUES
(1,'Leo',5.0,'grey',NULL,NULL,NULL,NULL),
(3,'Molly',3.0,'white',NULL,NULL,NULL,NULL),
(2,'Simba',2.0,'ginger',NULL,NULL,NULL,NULL);

