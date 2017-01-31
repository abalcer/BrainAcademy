create database if not exists `jdbc-test`;

use `jdbc-test`;


drop table if exists `TaskCategory`;
create table `TaskCategory` (
    `id` bigint auto_increment not null,
    `name` varchar(255),
    primary key (`id`)
);

drop table if exists `Task`;
create table `Task` (
    `id` bigint auto_increment not null,
    `categoryId` bigint,
    `dueDate` datetime,
    primary key (`id`),
    key IDX_CATEGORY_ID (`categoryId`),
    constraint FK_TASK_CATEGORY foreign key (`categoryId`) references `TaskCategory` (`id`)
);

insert into `TaskCategory` (`id`, `name`) values(1, 'category1');
insert into `TaskCategory` (`id`, `name`) values(2, 'category2');
insert into `TaskCategory` (`id`, `name`) values(3, 'category3');
insert into `TaskCategory` (`id`, `name`) values(4, 'category4');
insert into `TaskCategory` (`id`, `name`) values(5, 'category5');

insert into `Task` (`id`, `categoryId`, `dueDate`) values(1, 1, '2015-05-23 12:40:00');
insert into `Task` (`id`, `categoryId`, `dueDate`) values(2, 1, '2015-08-20 11:45:00');
insert into `Task` (`id`, `categoryId`, `dueDate`) values(3, 2, '2015-10-01 09:30:00');
insert into `Task` (`id`, `categoryId`, `dueDate`) values(4, 3, '2015-12-30 18:17:00');
insert into `Task` (`id`, `categoryId`, `dueDate`) values(5, null, '2015-12-30 18:17:00');
insert into `Task` (`id`, `categoryId`, `dueDate`) values(6, null, '2015-12-30 18:17:00');