/*
 * create table : 테이블을 만드는 명령어
 * - create table 테이블이름 ( 속성이름 datatype(크기), 속성이름 datatype(크기) );
 */
create table customer
(
			 -- 속성명 속성의 datatype (data size)
             cust_id integer primary key -- Integer는 크기 지정을 하지 않음(mysql 한정)
             -- primary key = not null + unique
             -- not null : null 값이 올 수 없다
             -- unique : 이 속성으로 들어오는 값들은 중복될 수 없다 (유일해야한다)
			 , t_nm varchar(4)  -- 여러단어붙어있을땐 언더바로 구분해서 속성명 설정, 약어도 많이 사용함
             , join_date datetime
             , drop_yn char(1)  -- drop 여부 확인하는 속성,  int(1)만 주어도 될듯
);

drop table customer;

create table customer
(
    cust_id varchar(30) primary key
    , cust_pwd varchar(30)
    , cust_name varchar(30)
    , cust_hphone varchar(13)  -- 010-1234-5678의 포맷
    , cust_post_code varchar(5)
    , cust_addr varchar(150)
    , cust_addr_detail varchar(150)
    , cust_grade integer
    , cust_mile integer
);

/*
 * desc : 테이블 구조를 보여달라는 명령어
 */
desc customer;

/*
 * alter table : 테이블 구조를 수정하라는 명령어
 * - add : 속성 추가
 * - modify : 속성 변경
 * - rename column [이전속성이름] to [새속성이름] : 속성 이름 변경
 * - drop column : 속성 삭제
 */

alter table customer 
	-- add(cust_age numeric(3));        -- 속성 추가
	-- modify cust_age decimal(5, 2);	-- 속성 타입 변경
	-- rename column cust_mile to cust_mileage; -- 속성 이름 변경
    drop column cust_age;               -- 속성 삭제
desc customer;

alter table customer add(cust_age numeric(3));

desc customer;

alter table customer modify cust_grade integer;

desc customer;

alter table customer rename column cust_mile to cust_mileage;

desc customer;

alter table customer modify cust_mileage numeric(7);

desc customer;

alter table customer drop column cust_age;

desc customer;

/*
 * drop table : 테이블 삭제
 * drop table [테이블이름]
 */
drop table customer
