-- Mice database init script
create table if not exists mouse
(
    id                bigserial primary key,
    age               real not null,
    color             varchar,
    normal_speed      real,
    top_speed         real,
    reproductive_rate integer,
    is_dead           boolean,
    killer_id         bigint
);

create index is_dead_idx on mouse (is_dead);

INSERT INTO mouse
(id,age,color,normal_speed,top_speed,reproductive_rate,is_dead,killer_id)
VALUES
(1,1.0,'white',NULL,NULL,NULL,NULL,NULL),
(2,1.0,'white',NULL,NULL,NULL,NULL,NULL),
(5,1.0,'white',NULL,NULL,NULL,NULL,NULL),
(6,1.0,'white',NULL,NULL,NULL,NULL,NULL),
(8,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(9,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(10,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(11,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(12,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(13,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(14,2.0,'grey',NULL,NULL,NULL,NULL,NULL),
(15,1.0,'grey',NULL,NULL,NULL,NULL,NULL);

