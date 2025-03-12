create table prod_stock
(
    prod_no int primary key auto_increment
   ,prod_name varchar(60)
   ,prod_quantity int
);

create table prod_sale
(
    sale_no int primary key auto_increment
   ,prod_no int
   ,sale_quantity int
);

insert into prod_stock values(1,'»õ¿ì±ø',100);
insert into prod_stock values(2,'¾çÆÄ¸µ',100);
insert into prod_stock values(3,'»©»©·Î',100);

CREATE TRIGGER `prod_sale_AFTER_INSERT`
AFTER INSERT ON `prod_sale` FOR EACH ROW
BEGIN
    update prod_stock set prod_quantity = prod_quantity - new.sale_quantity
    where prod_no = new.prod_no;
END

insert into prod_sale values(1, 1, 5);

CREATE TRIGGER `prod_sale_AFTER_UPDATE`
AFTER UPDATE ON `prod_sale` FOR EACH ROW BEGIN
    update prod_stock
    set prod_quantity = prod_quantity + old.sale_quantity - new.sale_quantity
    where prod_no = new.prod_no;
END

update prod_sale set sale_quantity = 3
where sale_no = 1;

CREATE TRIGGER `prod_sale_AFTER_DELETE`
AFTER DELETE ON `prod_sale` FOR EACH ROW BEGIN
    update prod_stock set prod_quantity = prod_quantity + old.sale_quantity
    where prod_no = old.prod_no;
END

delete from prod_sale where sale_no = 1;
