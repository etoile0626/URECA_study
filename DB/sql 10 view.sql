/*
 * view 생성을 위한 기본 테이블 만들기
 */
drop table emp3;

create table emp3
as select * from emp;

/*
 * create view
 * - create view [뷰이름] as [서브쿼리]
 * - 뷰는 테이블처럼 select, insert, update, delete 가능
 * - 물리적인 테이블이 아닌 가상의 테이블
 * - 뷰에서 수행되는 select, insert, update, delete는
 *   사실은 뷰가 대표하는 테이블 또는 뷰가 만들어진 기초 테이블에서 수행됨
 */
drop view view_emp30;

create view view_emp30
as
select ename, job, sal, deptno
from emp3;

select * from view_emp30;

/*
 * create or replace view
 * - 뷰가 없으면 생성, 있으면 수정하라
 */
create or replace view view_emp30
as
select * from emp3 where deptno = 20;

select * from view_emp30;

/*
 * 뷰를 사용한 insert는 뷰의 기초 테이블에 data가 입력됨
 */
insert into view_emp30
values(1111, '김태희', '배우', null, CURDATE(), 100, 10000, 20);

select * from view_emp30;

insert into view_emp30
values(1112, '원빈', '배우', null, CURDATE(), 500, 5000, 30);

select * from view_emp30;

select * from emp3;

/*
 * 뷰를 사용한 update는 뷰에서 조회 가능한 data만 update 가능
 */
select @@sql_safe_updates;

set sql_safe_updates = 0;

select @@sql_safe_updates;

update view_emp30 set deptno = 20
where ename = '원빈'; -- error는 아니나, data 변경 안됨.

select * from emp3;

update view_emp30 set deptno = 30
where ename = '김태희';

select * from view_emp30;

select * from emp3;

set sql_safe_updates = 1;

select @@sql_safe_updates;

/*
 * with check option
 * - 뷰를 만든 select문의 where 조건절의 속성은 update 불가
 */
insert into view_emp30
values(1113, '아이유', '가수', null, curdate(), 500, 5000, 20);

select * from view_emp30;

create or replace view view_emp30
as
select * from emp3
where deptno = 20 with check option;

select @@sql_safe_updates;

set sql_safe_updates = 0;

select @@sql_safe_updates;

update view_emp30 set deptno = 30
where ename = '아이유'; -- error

set sql_safe_updates = 1;

select @@sql_safe_updates;

/*
 * 뷰를 사용한 delete는 뷰에서 조회 가능한 data만 delete 가능
 */
select * from view_emp30;

select * from emp3;

select @@sql_safe_updates;

set sql_safe_updates = 0;

select @@sql_safe_updates;

delete from view_emp30 where ename = '김태희'; -- error는 아니나, data 삭제 안됨.

delete from view_emp30 where ename = '아이유';

select * from emp3;

set sql_safe_updates = 1;

select @@sql_safe_updates;

/*
 * 조인을 사용하여, read only 뷰를 만드는 방법.
 * - 해당 뷰를 통한 insert / delete를 불가능하게 막음
 */
select @@sql_safe_updates;

set sql_safe_updates = 0;

select @@sql_safe_updates;

update emp3 set deptno = 20
where job = '배우';

create or replace view view_emp30
as
select e.empno, e.ename, e.job, e.mgr
	, e.hiredate, e.sal, e.comm, d.deptno
from emp3 e, dept d
where e.deptno = d.deptno
and e.deptno = 20;

select * from view_emp30;

insert into view_emp30
values(2111, '아이유', '가수', null, curdate() , 500, 5000, 20); -- error

update view_emp30 set ename = '아이유' where empno = 7369;

delete from view_emp30 where empno = 7369; -- error

select * from emp3;

set sql_safe_updates = 1;

select @@sql_safe_updates;

/*
 * drop view
 * - drop view [뷰이름]
 */
drop view view_emp30;

drop table emp3;
