/*
 * join
 * - 두 개 이상의 테이블을 연결하여, data를 추출하는 select 기법
 */
select * from emp; -- 14 row

select * from dept; -- 4 row

/*
 * cross join (Cartesian Product)
 * - 두 개 이상의 테이블에서 모든 가능한 경우의 수를 조회하는 것
 * 주의!!! cross join (Cartesian Product) 수행 금지
 */
select * from emp, dept; -- 56 row

/*
 * equi join
 * - 동등한 조건으로 두 개 이상의 테이블을 조회하는 것
 * - 동등 비교 연산자 사용한 join 문
 * - 가장 많이 사용하는 join문
 */
select * from emp, dept where emp.deptno = dept.deptno;

/*
 * 조회 data의 모호성을 제거하기 위해
 * 테이블이름.속성이름 으로 접근 가능
 * - 테이블 별명(alias)를 통해서도 속성에 접근 가능
 */
select emp.ename, emp.job, emp.deptno, dept.deptno, dept.dname, dept.loc
from emp, dept
where emp.deptno = dept.deptno;

select 별명e.ename, 별명e.job, 별명e.deptno, 별명d.deptno, 별명d.dname, 별명d.loc
from emp 별명e, dept 별명d
where 별명e.deptno = 별명d.deptno;

select e.ename, e.job, e.deptno, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

/*
 * non - equi join
 * - 동등 비교 연산자가 아닌 연산자를 통해 join 하는 방법
 */
select * from emp;

select * from salgrade;

select e.ename, e.job, e.sal, s.grade
from emp e, salgrade s
where e.sal >= s.losal
and e.sal <= s.hisal
;

select e.ename, e.job, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

/*
 * 세 개 이상의 테이블 join
 * - 기준 테이블을 중심으로 순차적으로 join을 실행
 */
select e.ename, e.job, d.dname, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal
;

 -- 사원번호, 사원명, 직업, 급여, 커미션, 부서번호, 부서명, 급여등급
select e.empno, e.ename, e.job, e.sal, e.comm, e.deptno, d.dname, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal
order by deptno, job;

/*
 * self join
 * - 테이블 하나에서 다시 자신의 테이블로 조인을 하는 방법
 */
select * from emp;

 -- self join
select e1.ename, e1.job, e1.sal, e1.mgr '관리자사번', e2.ename '관리자명'
from emp e1, emp e2 -- e1은 사원목록, e2는 관리자 목록으로 가정하자.
where e1.mgr = e2.empno;

select e1.ename, e1.job, e1.sal, e1.mgr '관리자사번', e2.ename '관리자명'
from emp e1 left outer join emp e2 -- e1은 사원목록, e2는 관리자 목록으로 가정하자.
on e1.mgr = e2.empno;

 -- 결재상신자 정보
select e1.empno "결재상신사번", e1.ename "결재상신사원명", d1.dname "결재상신부서"
from emp e1, dept d1
where e1.deptno = d1.deptno;

 -- 결재자 정보
select e2.empno "결재자사번", e2.ename "결재자사원명", d2.dname "결재부서"
from emp e2, dept d2
where e2.deptno = d2.deptno;

 -- 결재 정보
select e1.empno "결재상신사번", e1.ename "결재상신사원명", d1.dname "결재상신부서"
		, e2.empno "결재자사번", e2.ename "결재자사원명", d2.dname "결재부서"
from emp e1, dept d1, emp e2, dept d2
where e1.deptno = d1.deptno
and e2.deptno = d2.deptno
and e1.mgr = e2.empno;

 -- 결재 정보
select e1.empno "결재상신사번", e1.ename "결재상신사원명", d1.dname "결재상신부서"
		, e2.empno "결재자사번", e2.ename "결재자사원명", d2.dname "결재부서"
from emp e1 left outer join emp e2 on e1.mgr = e2.empno, dept d1, dept d2
where e1.deptno = d1.deptno
and e2.deptno = d2.deptno;

select e1.empno '상신자사번', e1.ename '상신자명'
 		, d1.deptno '상신부서번호', d1.dname '상신부서명'
        , e2.empno '결재자사번', e2.ename '결재자명'
 		, d2.deptno '결재부서번호', d2.dname '결재부서명'
from emp e1 left outer join emp e2 on e1.mgr = e2.empno
			left outer join dept d2 on e2.deptno = d2.deptno
, dept d1
where e1.deptno = d1.deptno;

select e1.ename "결재 상신", e2.ename "결재자"
from emp e1, emp e2
where e1.mgr = e2.empno
order by e2.ename;

select e1.ename "결재 상신", e1.job, d1.dname
     , e2.ename "결재자", e2.job, d2.dname
from emp e1, emp e2, dept d1, dept d2
where e1.mgr = e2.empno
and e1.deptno = d1.deptno
and e2.deptno = d2.deptno
order by e2.ename;

/*
 * inner join
 */
select * from emp, dept where emp.deptno = dept.deptno;

select * from emp inner join dept on emp.deptno = dept.deptno;

/*
 * left outer join
 * - 왼쪽에 위치한 테이블의 내용을 모두 출력하라
 */
insert into customer
values ('apple', '1111', 'tiffany', '010', 'seoul', 9, 9000);

select * from customer c, product p
where c.cust_id = p.prod_no; -- 조회 안되는 것이 당연하다.

select * from customer c left outer join product p
on c.cust_id = p.prod_no; -- 조인 여부와 관계 없이, left table은 모두 출력.

/*
 * right outer join
 * - 오른쪽에 위치한 테이블의 내용을 모두 출력하라
 */
select * from customer c right outer join product p
on c.cust_id = p.prod_no; -- 조인 여부와 관계 없이, right table은 모두 출력.

/*
 * full outer join
 * - 양쪽에 위치한 테이블의 내용을 모두 출력하라
 * - MYSQL은 지원하지 않음. -> left outer join과 right outer join을 UNION으로 묶어서 사용.
 */
select * from customer c full outer join product p
on c.cust_id = p.prod_no; -- 조인 여부와 관계 없이, 모든 테이블 row를 출력.

select * from customer c left outer join product p
on c.cust_id = p.prod_no
union
select * from customer c right outer join product p
on c.cust_id = p.prod_no; -- 조인 여부와 관계 없이, 모든 테이블 row를 출력.
