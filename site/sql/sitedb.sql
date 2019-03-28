set names utf8;
set foreign_key_checks=0;

drop database if exists sitedb;
create database if not exists sitedb;
use sitedb;

drop table if exists login_user;
create table login_user(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16) unique,
user_name varchar(50),
admin_flg varchar(1),
insert_date datetime,
update_date datetime);

drop table if exists item;
create table item(
id int not null primary key auto_increment,
item_name varchar(30),
price int,
stock int,
insert_date datetime,
update_date datetime);

drop table if exists buy_item;
create table buy_item(
id int not null primary key auto_increment,
item_id int,
total_price int,
total_count int,
username varchar(16),
pay varchar(30),
insert_date datetime,
update_date datetime);

insert into item(item_name,price,stock) values("ノートBook",100,50),("ボールペン",120,30);
insert into login_user(login_id,login_pass,user_name,admin_flg) values("internous","internous01","test","a");