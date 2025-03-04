/*
 * index 생성
 * create index [index이름] on 데이블이름(속성이름)
 * pk와 uk는 자동으로 인덱스 생성
 */

drop table emp3;

create table emp3
as
select * from emp;

create index idx_emp3_sal
on emp3(sal);

/*
 * index 정보 조회
 */
show index from emp3;

/* 쿼리탭 - explain current statement 비교 */
select * from emp;
select * from emp where ename = 'ALLEN';
select * from emp3 where sal = 3000;

/*
 * index 삭제
 * - drop index [index이름]
 */
drop index idx_emp3_sal on emp3;

drop index idx_emp_test on emp;

create index idx_emp_test on emp(job, sal);

select * from emp where job='ANALYST' and sal = 3000; -- index O

select * from emp where job='ANALYST'; -- index O (인덱스 선언 시, 맨 앞에 위치한 값)

select * from emp where sal = 3000; -- index X

drop index idx_emp_test on emp;

create index idx_emp_test on emp(sal, job);

select * from emp where sal = 3000 and job='ANALYST'; -- index O

select * from emp where job='ANALYST'; -- index X

select * from emp where sal = 3000; -- index O (인덱스 선언 시, 맨 앞에 위치한 값)
