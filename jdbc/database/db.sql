create database if not exists `jdbc-test`;

use `jdbc-test`;

drop table if exists `Task`;
create table `Task` (
    `id` int auto_increment not null,
    `category` varchar(255),
    `dueDate` datetime,
    primary key (`id`)
);

insert into `Task` (`id`, `category`, `dueDate`) values(1, 'category1', '2015-05-23 12:40:00');
insert into `Task` (`id`, `category`, `dueDate`) values(2, 'category2', '2015-08-20 11:45:00');
insert into `Task` (`id`, `category`, `dueDate`) values(3, 'category3', '2015-10-01 09:30:00');
insert into `Task` (`id`, `category`, `dueDate`) values(4, 'category4', '2015-12-30 18:17:00');