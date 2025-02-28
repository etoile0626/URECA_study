/*
 * 제약 조건이 없는 테이블 예
 * - 오류 data 입력이 가능
 */
 create table product
(
    prod_no VARCHAR(15)
   ,prod_name VARCHAR(60)
   ,prod_price integer
   ,prod_stock integer
   ,prod_company VARCHAR(60)
);

select * from product;

insert into product values(null,null,null,null,null);
insert into product values(null,null,null,null,null);
insert into product values(null,null,null,null,null);

select * from product;

drop table product;

create table product
(
    prod_no VARCHAR(15) primary key
   ,prod_name VARCHAR(60) unique
   ,prod_price integer
   ,prod_stock integer
   ,prod_company VARCHAR(60) not null
);

select * from product;

insert into product values(null,null,null,null,null); -- error

insert into product values ('p01', null, null, null, null); -- error

insert into product values ('p01', null, null, null, '농심');
insert into product values ('p02', null, null, null, '농심'); -- unique도 null은 들어감.
insert into product values ('p03', null, -1500, -100, '농심'); -- 물리적 허용, 논리적 오류.

select * from product;

drop table product;

/*
 * 제약 조건이 있는 테이블 예
 * - 이상한 data의 입력을 예방
 *
 * 제약 조건(CONSTRAINT)이란?
 * 테이블에 오류/이상한 data의 입력을 예방하기 위한, 최소한의 규칙을 의미
 *
 * 제약 조건의 종류
 * - primary key : not null + unique + 자동 index 생성
 * - foriegn key : 외부 테이블을 참조/연결/참고 가능하게 해주는 속성
 * - not null : data를 반드시 입력해야 하는 속성
 * - unique : 다른 row에 있는 같은 속성의 data와 중복되면 안되는 속성
 * - check : 연산을 통해 입력 data를 검사하는 제약 조건
 */
create table product
(
    prod_no VARCHAR(15) primary key
   ,prod_name VARCHAR(45) unique
   ,prod_price integer check(prod_price >= 0)
   ,prod_stock integer check(prod_stock >= 0)
   ,prod_company VARCHAR(30) not null
);

select * from product;

insert into product values('1', '새우깡', -1000, 10, '농심'); -- error -- -1000
insert into product values('1', '새우깡', 1000, 10, null); -- error -- not null
insert into product values('1', '새우깡', 1000, 10, '농심');
insert into product values('1', '양파링', 1000, 10, '농심'); -- error -- pk
insert into product values('2', '새우깡', 1000, 10, '농심'); -- error -- unique
insert into product values('2', '양파링', 1000, 10, '농심');
insert into product values('p01', '새우깡', null, null, '농심');

select * from product;

insert into product values('p01','새우깡',-1500,-100,'농심'); -- error -- -1500 -100

select * from product;

insert into product values('p01','매운새우깡',1500,100,'농심');

select * from product;

drop table product;

create table product(
	prod_no varchar(15) primary key
    , prod_name varchar(60) unique not null
    , prod_price integer check(prod_price >= 0) not null default 0
    , prod_stock integer check(prod_stock >= 0) not null default 0
    , prod_company varchar(60) not null
);

insert into product values('p01', '새우깡', null, null, '농심'); -- error
insert into product values('p02', '양파링', -1500, 10, '농심'); -- error -- check
insert into product(prod_no, prod_name, prod_company) values('p03', '짱구', '농심');

/*
 * 제약 조건을 확인하는 sql문
 * - select * from information_schema.table_constraints;
 */
select * from information_schema.table_constraints;

DROP TABLE `product`;

CREATE TABLE `product` (
  `prod_no` varchar(15) NOT NULL,
  `prod_name` varchar(60) NOT NULL,
  `prod_price` int NOT NULL DEFAULT '1000',
  `prod_stock` int NOT NULL DEFAULT '0',
  `prod_company` varchar(60) NOT NULL,
  PRIMARY KEY `product_no_pk` (`prod_no`),
  UNIQUE KEY `product_name_uk` (`prod_name`),
  CONSTRAINT `product_price_chk` CHECK ((`prod_price` >= 0)),
  CONSTRAINT `product_stock_chk` CHECK ((`prod_stock` >= 0))
);

select * from information_schema.table_constraints where constraint_schema = 'ureca';

/*
 * 제약 조건의 삭제 / 추가
 * 참고 - 기본키) ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건이름] PRIMARY KEY(컬럼명);
 * 참고 - 외래키) ALTER TABLE [테이블명] DROP FOREIGN KEY [제약조건이름];
 * 참고 - 외래키) ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건이름] FOREIGN KEY(컬럼명)
 *             REFERENCES [부모테이블명](PK컬럼명) [ON DELETE CASCADE / ON UPDATE CASCADE];
 */

alter table dept add constraint dept_no_pk primary key(deptno);

select * from information_schema.table_constraints where constraint_schema = 'ureca';

alter table emp add constraint emp_deptno_fk foreign key(deptno)
	references dept(deptno) on update cascade;

select * from information_schema.table_constraints where constraint_schema = 'ureca';

alter table emp drop foreign key emp_deptno_fk;

select * from information_schema.table_constraints where constraint_schema = 'ureca';

select * from information_schema.table_constraints where table_name = 'product';

alter table product drop constraint product_chk_1;

select * from information_schema.table_constraints where table_name = 'product';

alter table product add constraint chk_prod_price check(prod_price >= 0);

select * from information_schema.table_constraints where table_name = 'product';

alter table dept add constraint dept_dname_uk unique(dname);

select * from information_schema.table_constraints where table_name = 'dept';

alter table dept drop constraint dept_dname_uk;

select * from information_schema.table_constraints where table_name = 'dept';
