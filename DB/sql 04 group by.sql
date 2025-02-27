select deptno, max(sal), min(sal), sum(sal) from emp
group by deptno order by deptno;

select deptno, job, max(sal), min(sal), sum(sal), count(sal) from emp
group by deptno, job
having count(sal) >= 2
order by deptno;

select deptno, sum(sal) from emp
group by deptno having sum(sal) > 9000;
 -- group by를 먼저 수행한 결과에 대해, 다시 검색 조건을 추가할 때 having 사용.

/*
 * group by
 * - group by 뒤에 오는 속성을 기준으로 테이블 내의 data를 group으로 묶는 것
 * - group by 뒤에 오는 속성은 ,(comma)를 이용하여 여러개 선언이 가능
 * - 주의!!! group by는 group 함수와 반드시 함께 쓰여야 함!
 * - 그룹 함수 : max, min, sum, avg, count
 * - 주의!!! order by는 group by 뒤에 옴
 * - 주의!!! group by가 있는 select 문의 속성에는
 *          그룹 함수로 표현된 속성과 group by 뒤에 선언된 속성만이 올 수 있음
 *
 * having
 * - group by에 조건절을 만드는 명령어
 * - and 또는 or를 통해 조건을 추가할 수 있음
 * - 일반 select 문에서 where와 같은 역활을 함
 * - having 뒤에는 조건 비교 기준 속성, 비교 연산자, 조건 비교 기준 data가 옴
 * - having 뒤에는 그룹 함수로 표현된 속성과 group by 뒤에 선언된 속성만이 올 수 있음
 */
select max(sal) from emp;
select min(sal) from emp;
select sum(sal) from emp;
select avg(sal) from emp;
select count(sal) from emp;

select deptno, max(sal) from emp group by deptno;
select deptno, min(sal) from emp group by deptno;
select deptno, sum(sal) from emp group by deptno;
select deptno, avg(sal) from emp group by deptno;
select deptno, count(sal) from emp group by deptno order by deptno;

--select deptno, count(sal) from emp order by deptno group by deptno;--error order by가 젤 뒤로 와야함
--select ename, job, max(sal) from emp group by job;--error ename이 끼어든게 문제

select job, max(sal) from emp group by job;
select job, min(sal) from emp group by job;
select job, sum(sal) from emp group by job;
select job, avg(sal) from emp group by job;
select job, count(sal) from emp group by job;

select deptno, max(sal) from emp
group by deptno having deptno = 10;

select deptno, max(sal) from emp
group by deptno having max(sal) > 1000;

select deptno, max(sal) from emp
group by deptno having max(sal) > 1000 and deptno = 10; -- having도 and 또는 or를 통해 조건절 연장 가능

select deptno, max(sal) from emp
group by deptno having deptno = 10 or deptno = 20; -- having도 and 또는 or를 통해 조건절 연장 가능

select deptno, job, max(sal) from emp
group by deptno, job having deptno = 10;


/* QUIZ
1. 모든 사원의 급여 최고액, 최저액, 총액, 평균, 사원수를 구하시오.

2. job 별로 급여 최고액, 최저액, 총액, 평균, 사원수를 구하시오. (group by job)

3. 모든 사원의 급여 최고액과 최저액의 차액을 구하시오.

4. deptno 별로 급여 최고액, 최저액, 총액, 평균, 사원수를 구하시오. (group by deptno)
*/
select max(sal), min(sal), sum(sal), avg(sal), count(sal) from emp;

select job, max(sal), min(sal), sum(sal), avg(sal), count(sal) from emp
group by job;

select max(sal) - min(sal) from emp;

select deptno, max(sal), min(sal), sum(sal), avg(sal), count(sal) from emp
group by deptno;

/*
 * 그룹 함수
 * - 그룹(많은 data가 있는 상황)에서 결과를 도출하는 함수
 * - count, sum, avg, max, min
 */
select count(sal) from emp;
select sum(sal) from emp;
select avg(sal) from emp;
select max(sal) from emp;
select min(sal) from emp;

/*
 * group by
 * - 그룹을 설정하는 명령어
 * - group by 뒤에 오는 속성을 기준으로 table 내에 group을 만드는 것
 * - group by 뒤에 오는 속성은 ,(comma)를 이용하여 여러 개의 속성이 올 수 있음
 * - 주의!!! group by는 group 함수와 반드시 함께 쓰여야 함!
 * - 주의!!! order by는 group by 뒤에 옴
 * - 주의!!! group by가 있는 select 문의 속성에는
 *          그룹 함수로 표현된 속성과 group by 뒤에 선언된 속성만이 올 수 있음
 */
select deptno from emp;
select deptno from emp group by deptno;

select max(sal) from emp;
select deptno, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by deptno;
select job, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by job;

--select deptno, count(sal), sum(sal), avg(sal), max(sal), min(sal)
--from emp order by deptno group by deptno;--error
select deptno, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by deptno order by deptno;

--select deptno, job, count(sal), sum(sal), avg(sal), max(sal), min(sal)
--from emp group by deptno;--error
select deptno, job, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by deptno, job;

select substr(ename, 1, 1), count(*)
from emp
group by substr(ename, 1, 1)
order by substr(ename, 1, 1);

/*
 * having
 * - group by에 조건절을 만드는 명령어
 * - 일반 select 문에서 where와 같은 역활을 함
 * - having 뒤에는 조건 비교 기준 속성, 비교 연산자, 조건 비교 기준 data가 옴
 * - having 뒤에는 그룹 함수로 표현된 속성과 group by 뒤에 선언된 속성만이 올 수 있음
 * - and 또는 or를 통해 조건을 추가할 수 있음
 */
select deptno, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp where deptno = 10 group by deptno;

select deptno, job, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp where deptno = 10 group by deptno, job;

select deptno, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by deptno having deptno = 10;

select deptno, job, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by deptno, job having deptno = 10 and job = 'MANAGER';

select deptno, job, count(sal), sum(sal), avg(sal), max(sal), min(sal)
from emp group by deptno, job having deptno = 10 or job = 'MANAGER';

select deptno, max(sal) from emp
group by deptno having max(sal) > 1000;
