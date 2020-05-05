create table user(
id int(11) not null auto_increment,
username varchar(32) not null comment '用户名称',
birthday datetime default null comment '生日',
sex char(1) default null comment '性别',
address varchar(256) default null comment '地址',
primary key (id)
)engine=InnoDB default charset=utf8;

insert into user (id, username, birthday, sex, address) values (41,'老王','2018-02-27 17:47:08', '男', '北京顺义');
insert into user (id, username, birthday, sex, address) values (46,'小老王','2018-02-27 17:47:08', '男', '北京顺义');
insert into user (id, username, birthday, sex, address) values (44,'大老王','2018-02-27 17:47:08', '男', '北京顺义');
insert into user (id, username, birthday, sex, address) values (45,'老老王','2018-02-27 17:47:08', '男', '北京顺义');

