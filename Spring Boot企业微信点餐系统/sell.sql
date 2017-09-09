create table product_info (
    product_id varchar(32) not null,
    product_name varchar(64) not null,
    product_price decimal(8,2) not null comment "商品价格",
    product_stock int not null comment "商品库存",
    product_description varchar(64) comment "商品描述",
    product_icon varchar(512) not null comment "商品图片",
    category_type int not null comment "类目编号",
    create_time timestamp not null default current_timestamp comment "默认当前时间",
    update_time timestamp not null default current_timestamp on update current_timestamp
    comment "update时候自动更新时间",
    primary key (product_id)
) comment "商品信息表";

MySQL 5.7 以上支持default current_timestamp

create table product_category (
    category_id int not null auto_increment,
    category_name varchar(64) not null,
    category_type int not null comment "类目编号",
    create_time timestamp not null default current_timestamp comment "默认当前时间",
    update_time timestamp not null default current_timestamp on update current_timestamp
    comment "update时候自动更新时间",
    primary key (category_id),
    unique key 'uqe_category_type' (category_type)
) comment "商品类目表"; 