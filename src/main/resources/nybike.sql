--创建数据库
create database nybikedb;
--使用数据库
use nybikedb;
--创建状态表
create table t_status(
    station_id varchar (20) comment '站点id',
    num_bikes_available int ,
    num_docks_disabled int,
    num_docks_available int,
    num_ebikes_available int,
    num_bikes_disabled int,
    station_status varchar (20),
    last_reported bigint,
    create_time timestamp default current_timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


select station_id, num_bikes_available, create_time from t_status where station_id = ? and create_time > DATE_SUB(NOW(), INTERVAL ?);
-- 创建保存历史数据的表
create table t_trip_202006(
    tripduration int,
    starttime varchar(30),  --起始时间
    stoptime varchar(30),
    start_station_id int,
    start_station_name varchar (50),
    start_station_latitude double,
    start_station_longitude double,
    end_station_id int,
    end_station_name varchar(50),
    end_station_latitude double,
    end_station_longitude double,
    bikeid int,    --自行车的ID
    usertype varchar(20) ,
    birth_year int,
    gender int comment '0-未知,1-女性,2-男性'
);