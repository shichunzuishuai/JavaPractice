create database order_system;
use order_system;

drop table if exists dishes;
create table dishes(
    dishId int primary key auto_increment,
    name varchar(50) unique,
    price int  -- 以分为单位,使用int来表示,不要用double 或float,会存在误差
);

drop table if exists use ;
create table user(
    userId int primary key auto_increment,
    name varchar(50) unique,
    password varchar(50),
    isAdmin int -- 是否是管理员,0表示不是,1表示是
);

drop table if exists order_user;
create table order_user(
    orderId int primary key auto_increment,
    userId int, -- 需要和user中的userId具有关联关系
    time datetime, -- 下单时间
    isDone int, -- 1表示订单完结, 0表示订单未完结
    foreign key (userId) references user(userId)
);

drop table if exists order_dish;
create table order_dish(
    orderId int,
    dishName varchar(50),
    dishPrice int,
    dishId int,
    foreign key (orderId) references order_user(orderId)
);

insert into user values (null,'admin','123',1);

insert into dishes values (null,'红烧茄子',1200);
insert into dishes values (null,'烧花鸭',1200);
insert into dishes values (null,'酱肘子',1200);


DELETE FROM order_user WHERE orderId IN (21,22,23,24,25,26,27,28,29,30,31,32,33);
delete from order_dish where dishId = 7;

show table status from order_system where name='dishes';
show table status from order_system where name='order_dish';