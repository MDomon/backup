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

drop table if exists take_book_transaction;

create table take_book_transaction(
id int not null primary key auto_increment,
book_user_name varchar(50),
book_name varchar(50),
book_author_name varchar(50),
book_infomation varchar(255),
book_master_id int,
book_date datetime,
updated_date datetime
);

drop table if exists give_book_transaction;

create table give_book_transaction(
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


INSERT INTO user_transaction(user_id, user_pass, user_name)
VALUES("t", "t", "太郎"),("m", "m", "masa"),("h", "h", "花子"),("j", "j", "Jon"),("y", "y", "よーちゃん"),("a", "a", "a");


INSERT INTO book_transaction(book_user_name,book_name,book_author_name,book_infomation,book_master_id,book_date)
VALUES("太郎","こころ","夏目漱石","夏目漱石の著書、こころです。",1,"2017/01/01"),
("太郎","こころ","夏目漱石","夏目漱石の著書、こころです。",1,"2017/01/02"),
("太郎","こころ","夏目漱石","夏目漱石の著書、こころです。",1,"2017/01/03"),
("太郎","こころ","夏目漱石","夏目漱石の著書、こころです。",1,"2017/01/04"),
("太郎","こころ","夏目漱石","夏目漱石の著書、こころです。",1,"2017/01/05"),
("太郎","こころ","夏目漱石","夏目漱石の著書、こころです。",1,"2017/01/07"),
("masa","お金2.0","佐藤航陽","新しい経済について書かれた本です。",2,"2017/01/04"),
("masa","未来に先回りする思考法","佐藤航陽","テクノロジーと人類について書かれた本です。",2,"2017/01/08"),
("masa","学問のすすめ","福沢諭吉","福沢諭吉の学問のすすめです。",2,"2017/05/01"),
("花子","指輪物語","JRRトールキン","ロードオブザリングの原作です。",3,"2016/01/01"),
("花子","ハリーポッター","JKローリング","一部汚れています。",3,"2018/01/01"),
("花子","不思議の国のアリス","ルイスキャロル","ほぼ新品の美品です。",3,"2017/10/10"),
("Jon","洞窟の女王","ヘンリーライダーハガード","先週買ったばかりです。",4,"2017/06/23"),
("よーちゃん","国家","プラトン","",5,"2017/01/17"),
("よーちゃん","ソクラテスの弁明","プラトン","",5,"2015/08/09"),
("a","ソクラテスの弁明","プラトン","",6,"2017/02/20"),
("a","指輪物語","JRRトールキン","面白いのでお勧めです！",6,"2017/01/01"),
("a","学問のすすめ","福沢諭吉","勉強する気になります。",6,"2016/12/27");




INSERT INTO tweet_transaction(tweet_user_name,tweet_message,tweet_master_id,tweet_date)
VALUES("太郎","夏目漱石最高！みんなも読んでみてー",1,"2017/01/02"),
("太郎","こころは本当にいいわー",1,"2017/01/04"),
("太郎","こころが特におすすめです！",1,"2017/01/07"),
("masa","最近は教養書を中心に読んでいます。何かおススメないでしょうか？",2,"2017/01/05"),
("masa","みんなのおすすめを聞かせてください",2,"2017/01/10"),
("花子","ファンタジーものが好きです。",3,"2016/01/01"),
("花子","ハリーポッターシリーズは全部10回以上読んだわ。",3,"2017/10/10"),
("花子","おすすめのファンタジー小説があったら教えてほしいなー",3,"2018/01/01"),
("Jon","はじめまして、よろしくおねがいします。",4,"2017/06/23"),
("よーちゃん","人生は哲学",5,"2017/01/17"),
("a","好きなジャンルはないけど面白そうな本は手あたり次第読む派",6,"2017/01/01"),
("a","評価高そうなやつとかとりあえず読んでく",6,"2017/01/01");