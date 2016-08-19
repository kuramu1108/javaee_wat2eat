/**
 * Author:  garysnmb
 * Created: 2016/08/15
 */

create table review (
    id varchar(255) primary key not null,
    title varchar(255) not null,
    comment varchar(255),
    rating integer,
    restaurantid varchar(255) not null,
    userid varchar(255) not null,
    reviewedDate date
);

create table wat2eataccount (
    id varchar(255) primary key not null,
    password varchar(255) not null,
    gender char,
    age integer,
    nationality varchar(255)
);

create table restaurant (
    id varchar(255) primary key not null,
    restaurantname varchar(255) not null,
    address varchar(255) not null, 
    website varchar (255),
    lat float,
    lng float
);

create table lookup (
    id varchar(255) primary key not null,
    reviewid varchar(255) not null,
    accountid varchar(255) not null,
    restaurantid varchar(255) not null
);
