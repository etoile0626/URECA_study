drop table customer;

truncate table customer; -- 테이블의 내용 모두를 버림.

/*
 * insert / update / delete 수행을 위한 테이블 작성
 */
create table customer
(
    cust_id VARCHAR(30) primary key
   ,cust_pwd VARCHAR(30) not null
   ,cust_name VARCHAR(30)
   ,cust_tel VARCHAR(13)
   ,cust_addr VARCHAR(90)
   ,cust_grade INTEGER
   ,cust_mileage INTEGER
);

/*
 * insert
 * - 테이블에 data를 입력하라는 명령어
 * - into, values와 함께 사용
 * - into는 입력을 수행할 테이블을 지정하는 명령어
 * - into의 뒤에는 입력을 수행할 테이블 이름이 옴
 * - 테이블 이름의 뒤에는 입력을 수행할 속성을 지정하는 소괄호()가 옴
 * - 소괄호()의 뒤에는 values 명령어가 옴
 * - values는 지정된 속성에 대입할 값을 지정한 소괄호()를 가짐
 * - values뒤에 오는 소괄호() 안의 속성 값은
 *   테이블 이름의 뒤에 오는 소괄호() 안의 속성과 자리의 위치가 같아야 함
 * - 속성 전체 값을 입력하는 경우, 테이블 이름 뒤에 오는 소괄호() 생략 가능
 * - insert into 테이블명 (속성3, 속성4, 속성5, 속성2, 속성1)
 *   values(속성3에 넣을 data, 속성4에 넣을 data, 속성5에 넣을 data, 속성2에 넣을 data, 속성1에 넣을 data);
 */
insert into customer
(cust_id, cust_pwd, cust_name, cust_tel, cust_addr, cust_grade, cust_mileage)
values('apple', '1111', 'kimth', '010', 'seoul', 9, 1000);

insert into customer
(cust_id, cust_pwd, cust_name, cust_tel, cust_addr, cust_grade, cust_mileage)
values('apple', '1111', 'kimth', '010', 9, 'seoul', 1000); -- error -- 36라인이 35라인의 순서를 어겼다.

insert into customer
values('banana', '1111', 'jangdg', '010', 'seoul', 1, 1000);

insert into customer
values ('peach', '1111', 'ambor'); -- error -- 테이블 명 뒤의 속성 목록이 없을 경우, 전체 속성 입력해야함.

insert into customer (cust_id, cust_pwd, cust_name, cust_grade, cust_mileage)
values('cherry', '1111', 'jangdonggun', 1, 1000);

alter table customer modify cust_grade integer default 1;

alter table customer modify cust_mileage integer default 1000;

insert into customer (cust_id, cust_pwd, cust_name)
values('peach', '1111', 'tipany');

insert into customer
 (cust_mileage, cust_grade, cust_id, cust_pwd, cust_name, cust_tel      , cust_addr)
values
 (1000        , 1         , 'apple' , '1111' , 'kimth'  , '010-9876-5432', '서울시');

insert into customer values
 ('honggd', '010-9871-5431', '인천시', 1000, 1, 'banana', '1111'); -- error
 
insert into customer values
 ('banana', '1111', 'honggd', '010-9871-5431', '인천시', 1000, 1);

insert into customer values
 ('cherry', '1111', 'kanggc', '010-1871-1431', '수원시'); -- error

insert into customer
 (cust_grade, cust_mileage, cust_id, cust_pwd, cust_name)
values
 (1, 1000, 'cherry', '1111', 'kanggc');

alter table customer modify cust_grade integer default 1;

alter table customer modify cust_mileage integer default 1000;

desc customer;

insert into customer (cust_id, cust_pwd, cust_name)
values ('DragonFruit', '9999', 'GD'); 

truncate table customer;

/*
 * Start : Test Data 입력.
insert into customer
(cust_id, cust_pwd, cust_name, cust_tel, cust_addr, cust_grade, cust_mileage)
values('apple', '1111', 'kimth', '010', 'seoul', 9, 1000);

insert into customer
values('banana', '1111', 'jangdg', '010', 'seoul', 1, 1000);

insert into customer (cust_id, cust_pwd, cust_name, cust_grade, cust_mileage)
values('cherry', '1111', 'jangdonggun', 1, 1000);

insert into customer (cust_id, cust_pwd, cust_name)
values('peach', '1111', 'tipany');
 * End : Test Data 입력.
 */

/*
 * update
 * - 테이블 내의 data를 수정하라는 명령어
 * - set, where절과 함께 사용
 * - update 뒤에는 수정하려는 테이블 이름이 옴
 * - 테이블 이름 뒤에는 set 명령어가 옴
 * - set은 수정하려는 속성과 값을 지정하는 명령어
 * - set의 뒤에는 수정하려는 (속성명 = 수정값) 이 옴
 * - 수정하려는 (속성명 = 수정값)은 ,(comma) 를 사용하여 여러개 올 수 있음
 * - 주의!!! 반드시 where절을 이용하여, 수정하려는 data를 정확히 지정해야 함!!!
 * - 주의!!! 수정하려는 data를 정확히 지정하지 않으면, 엉뚱한 data가 변경됨!!!
 * - Tip!!! 현장에서는 수정 전에, 수정 대상 data에 대한 select를 수행 후, 수정함
 */
select * from customer
where cust_id = 'apple';

update customer set cust_name = 'kimtaehee', cust_mileage = 9000
where cust_id = 'apple';

/*
 * sql_safe_updates 1은 pk를 통한 update/delete가 아니면, 허용하지 않는다.
 */
update customer set cust_name = 'GDragon'; -- error

select @@sql_safe_updates;

set sql_safe_updates = 0;

select @@sql_safe_updates;

update customer set cust_name = 'GDragon';

set sql_safe_updates = 1;

select @@sql_safe_updates;

update customer c set c.cust_mileage = 2000
where c.cust_mileage = 1000; -- error

desc customer;

update customer c set c.cust_name = 'kimtaehee'
where c.cust_id = 'apple';

update customer c set c.cust_name = 'honggildong'
where c.cust_id = 'banana';

update customer c set c.cust_name = 'kanggamchan'
where c.cust_id = 'cherry';

/*
 * delete
 * - 테이블 내의 data row를 삭제하라는 명령어
 * - from, where절과 함께 사용
 * - delete의 뒤에는 from이 옴
 * - from 이후는 select의 용법과 같음
 * - 주의!!! 반드시 where절을 이용하여, 삭제하려는 data를 정확히 지정해야 함!!!
 * - 주의!!! 삭제하려는 data를 정확히 지정하지 않으면, 엉뚱한 data가 삭제됨!!!
 * - Tip!!! 현장에서는 삭제 전에, 삭제 대상 data에 대한 select를 수행 후, 삭제함
 */
select * from customer
where cust_id = 'banana';

delete from customer
where cust_id = 'banana';

/*
 * transaction = trans + action
 * - DB server로 전달된 명령이 수행 완료된 상태를 commit이라고 함
 * - DB server로 전달된 명령을 수행 후, 취소하려면, 전제조건이 autocommit이 false 상태이어야 함
 * - autocommit이 false 상태에서만 명령 수행을 취소할 수 있음
 * - DB server로 전달된 명령의 수행을 취소하는 명령어를 rollback이라 함
 * - DB server로 전달된 명령의 수행을 확정하는 명령어를 commit이라고 함
 * - DB server의 autocommit 상태를 바꾸는 명령 : set autocommit = true / set autocommit = false
 * - DB server의 autocommit 상태를 확인하는 명령 : select @@autocommit
 */

select @@autocommit; -- 1:autocommit true, 0:autocommit false.

set autocommit = false;
set autocommit = true;

/* Start : truncate table customer; -- rollback 안됨.
 * set autocommit = false;
 * delete from customer where cust_id = 'apple';
 * rollback;
 * truncate table customer; -- rollback 안됨.
 * rollback;
 * End : truncate table customer; -- rollback 안됨.
 */

set autocommit = false;

truncate table customer; -- rollback 안됨.

insert into customer
values('apple', '1111', 'kimtaehee', '010', 'seoul', 9, 9000);

select * from customer;

rollback;

select * from customer;

insert into customer
values('apple', '1111', 'kimtaehee', '010', 'seoul', 9, 9000);

commit;  

select * from customer;

rollback;

select * from customer;

set autocommit = true;

insert into customer
values('banana', '1111', 'tiffany', '010', 'seoul', 1, 1000);

select * from customer;

rollback;

select * from customer;

set autocommit = false;

select @@autocommit;

delete from customer where cust_id = 'DragonFruit';

select * from customer;

rollback;

select * from customer;

/*
 * delete는 rollback 가능.
 * truncate는 rollback 불가능.
 */
set autocommit = false;

select @@autocommit;

truncate table customer;

select * from customer;

rollback;

select * from customer;

/* 트랜잭션 실습 */
set autocommit = false;

select @@autocommit;

insert into customer (cust_id, cust_pwd, cust_name) values ('apple', '1111', 'kim');

select * from customer;

rollback;

select * from customer;

insert into customer (cust_id, cust_pwd, cust_name) values ('apple', '1111', 'kim');

commit; -- 저장 장치에 반영 완료.

select * from customer;

rollback;

select * from customer;

/* 하나의 트랜잭션이라는 의미 */
set autocommit = false;

select @@autocommit;

insert into customer (cust_id, cust_pwd, cust_name) values ('banana', '2222', 'hong');
insert into customer (cust_id, cust_pwd, cust_name) values ('cherry', '3333', 'kang');

commit; -- 저장 장치에 반영 완료.

select * from customer;

delete from customer where cust_id = 'apple';
select * from customer;
delete from customer where cust_id = 'banana';
select * from customer;
delete from customer where cust_id = 'cherry';
select * from customer;

rollback; -- commit을 수행하기 전까지는 하나의 트랜잭션.

select * from customer;

/* savepoint */
set autocommit = false;

select @@autocommit;

select * from customer;

delete from customer where cust_id = 'apple';
select * from customer;
savepoint sa1;
delete from customer where cust_id = 'banana';
select * from customer;
delete from customer where cust_id = 'cherry';
select * from customer;

rollback to sa1;

select * from customer;

rollback;

select * from customer;
