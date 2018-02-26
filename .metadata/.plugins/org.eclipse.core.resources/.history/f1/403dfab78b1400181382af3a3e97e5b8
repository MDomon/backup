drop database if exists bookshare;

create database if not exists bookshare;
use bookshare;



drop table if exists user_transaction;

create table user_transaction(
id int not null primary key auto_increment,
user_id varchar(16) unique,
user_pass varchar(16),
user_name varchar(50),
user_bookcoin int default 5,
user_give_book int default 0,
user_take_book int default 0,
insert_date datetime,
updated_date datetime
);


drop table if exists book_transaction;

create table book_transaction(
id int not null primary key auto_increment,
book_user_name varchar(50),
book_name varchar(50),
book_author_name varchar(50),
book_infomation varchar(255),
book_master_id int,
book_date datetime,
updated_date datetime
);


drop table if exists tweet_transaction;

create table tweet_transaction(
id int not null primary key auto_increment,
tweet_user_name varchar(50),
tweet_message varchar(255),
tweet_master_id int,
tweet_date datetime,
delete_date datetime
);




drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);




INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("NoteBook", 100, 50);
INSERT INTO user_transaction(user_id, user_pass, user_name) VALUES("internous", "internous01", "test");