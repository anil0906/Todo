create database todo;

use todo;

create table todo_task(
task_id int primary key auto_increment,
task_status varchar(255),
task_description varchar(1000)
);