create database order_system;
use order_system;

drop table if exists dishes;
create table dishes(
    dishId int primary key auto_increment,
    name varchar(20),
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
    dishId int,
    foreign key (orderId) references order_user(orderId),
    foreign key (dishId) references dishes(dishId)
);

