CREATE TABLE prices_tbl(
id int PRIMARY KEY,
id_brand INT ,
start_date_time TIMESTAMP not null,
end_date_time TIMESTAMP not null,
price_list INT,
product_id INT,
priority INT,
price FLOAT,
curr VARCHAR(3),
start_date VARCHAR(10),
end_date VARCHAR(10));

