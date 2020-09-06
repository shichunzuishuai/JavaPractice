db.Configuration.ProxyCreationEnabled = false;
-- 数据库
drop database if exists `musicserver`;
create database if not exists `musicserver` character set utf8;


-- 使用数据库
use `musicserver`;


DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
`id` int PRIMARY KEY AUTO_INCREMENT,
`title` varchar(50) NOT NULL,
`singer` varchar(30) NOT NULL,
`time` varchar(13) NOT NULL,
`url` varchar(100) NOT NULL,
`userid` int(11) NOT NULL
);


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` varchar(20) NOT NULL,
`password` varchar(32) NOT NULL,
`age` INT NOT NULL,
`gender` varchar(2) NOT NULL,
`email` varchar(50) NOT NULL
);


DROP TABLE IF EXISTS `lovemusic`;
CREATE TABLE `lovemusic` (
`id` int PRIMARY KEY AUTO_INCREMENT,
`user_id` int(11) NOT NULL,
`music_id` int(11) NOT NULL
);

INSERT INTO user(username,password,age,gender,email) VALUES("bit","123","10","男","1262913815@qq.com");


INSERT INTO music(title, singer, time, url, userid) values ("南方姑娘","赵雷","2020-07-21","music\\南方姑娘",1);

INSERT INTO music(title, singer, time, url, userid) values ("红装","徐良","2020-07-30","music\\红装",1);

select * from music where id in(select * from lovemusic where "user_id"=?);

select * from music where title in(select * from lovemusic where "userid"=?)


insert into lovemusic(user_id,music_id) values (1,1);

delete from lovemusic where id=2 and id = 3;


insert into user (username,password,age,gender,email)VALUES("long","123","22","男","1174753347@qq.com");

delete from user where  id=(2,3,4,5,6,7,8,9,10,11,12,13,14,15);







