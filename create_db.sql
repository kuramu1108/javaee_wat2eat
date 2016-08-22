/**
 * Author:  garysnmb
 * Created: 2016/08/15
 */

create table w.review (
    id integer not null primary key generated always as identity (start with 1, increment by 1),
    title varchar(255) not null,
    comment varchar(255),
    rating integer,
    restaurantid integer not null,
    userid varchar(255) not null,
    reviewdate date
);

create table w.account (
    id varchar(255) not null primary key,
    password varchar(255) not null,
    gender char,
    age integer,
    nationality varchar(255)
);

create table w.restaurant (
    id integer not null primary key generated always as identity (start with 1, increment by 1),
    restaurantname varchar(255) not null,
    address varchar(255) not null, 
    rating integer,
    website varchar (255),
    lat float,
    lng float
);

-- create table w.lookup (
--     id integer not null primary key generated always as identity (start with 1, increment by 1),
--     reviewid integer not null,
--     accountid varchar(255) not null,
--     restaurantid integer not null
-- );

create view jdbcrealm_user (username, password) as
select id, password
from w.account;

create view jdbcrealm_group (username, groupname) as
select id, 'Users'
from w.account