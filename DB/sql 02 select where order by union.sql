/*
  여러 줄 주석
*/
-- 한 줄 주석

/*
 * select : 검색 명령어 (찾아라 라는 의미)
 * select 뒤에는 찾고 싶은 속성명이 위치
 * - 속성명은 여러 개를 ,(comma)로 연결 가능
 * - 속성명 자리에 * 가 올 경우, 모든 속성을 의미함
 * - * 사용은 시스템 성능을 저하 시킬 수 있기 때문에 바람직하지 않음
 * - 가독성은 위해서도 * 사용은 바람직하지 않음
 * - 찾고자하는 속성이 많더라도, 속성명을 모두 명시하는 것이 바람직
 *
 * from : 찾는 data가 있는 table 지정 명령어
 * from의 뒤에는 찾는 data가 있는 table명 위치
 * - from 뒤의 table명은 여러 개를 ,(comma)로 연결 가능
 *
 * where : from 뒤에 지정된 table 내에서, 원하는 조건을 지정하는 명령어
 * - 조건절이라 함
 * - 조건절에는 조건의 기준 속성, 조건 연산자, 조건 기준 data 세가지 위치
 * - 예) where job = 'MANAGER'
 * - 주의!!! 문자열은 작은 따옴표('')로 감싸줌
 * - 주의!!! 명령어는 대소문자 구분이 없음
 * - 주의!!! 저장 data는 대소문자 구분이 있음
 *
 * 조건절에는 = > < >= <= <> != 와 같은 비교 연산자가 올 수 있음
 *
 * 조건절의 like : 비슷한 data 검색
 * - like와 함게 쓰이는 % : 모든 글자 (글자 수와 무관, 글자가 없는 경우도 포함)
 * - like와 함게 쓰이는 _ : 한 글자
 *
 * regexp : 정규식 검색, '^a' 라고하면 첫문자가 a인 모든 사람을 의미
 *
 * distinct : 중복 제거 명령어
 *
 * count() : 조회 결과 개수를 알려주는 함수
 * - 예) select count(*) from emp; -> emp table의 저장된 전체 개수를 알려줌
 * - null 이 아닌 data의 갯수만을 조회함
 *
 * select 절에서 사칙 연산 사용 가능
 *
 * dual : 일종의 가상 테이블
 *
 * select 속성에 별명(alias) 주기
 * - 조회한 속성명을 as 를 사용하여 바꿀 수 있음
 * - 예) select sal as 급여 from emp;
 * - 조회한 속성명을 as 없이도 바꿀 수 있음
 * - 예) select sal 급여 from emp;
 * - 조회한 속성명을 "" 를 사용하여 바꿀 수 있음
 * - 예) select sal as "급 여" from emp; -> 띄어쓰기 하고싶으면 따옴표 안에 넣기(속성 한정)
 *
 * 테이블 이름에 별명(alias) 주기
 * - select 속성을 호출할 때, 테이블명.속성명 으로 표시할 수 있음
 * - 예) select emp.ename 직원이름 from emp;
 * - 테이블 이름도 테이블 명 뒤에 별명을 줄 수 있음
 * - 예) select ename 직원이름 from emp 직원테이블;
 * - 테이블의 별명으로 select 속성을 호출할 수 있음
 * - 예) select 직원테이블.ename 직원이름 from emp 직원테이블;
 *
 * null : data 없음을 의미 (0 또는 공백이 아님)
 * - 특정 조건이 null인 data를 찾을 때, 조건절에 is null 사용
 * - 예) where comm is null
 * - 특정 조건이 null이 아닌 data를 찾을 때, 조건절에 is not null 사용
 * - 예) where comm is not null
 *
 * and와 or : 조건절을 추가하는 명령어
 * - and : 앞의 조건과 뒤의 조건이 모두 만족하는 결과를 만듬 (교집합)
 * - or : or 앞의 조건을 만족하거나, or 뒤의 조건을 만족하는 모든 결과를 만듬 (합집합)
 * - and 또는 or는 원하는 경우의 수만큼 추가 가능
 *
 * between and : 범위 검색
 * - 예) where sal >= 1100 and sal <= 2450;
 * - 예) where sal between 1100 and 2450;
 *
 * in : in 뒤에 오는 ()안에 포함되는 data 검색
 * - 예) where sal in (800, 1600, 2450);
 * not in : in 뒤에 오는 ()안에 포함되지 않는 data 검색
 * - 예) where sal not in (800, 1600, 2450);
 *
 * order by : data의 정렬
 * - order by 뒤에는 정렬 기준으로 선택하는 속성이 옴
 * - order by 뒤에는 여러 속성을 ,(comma)로 연결하여 사용 가능
 * - asc : 숫자(작은 숫자부터), 문자(사전 순서대로), 날자(빠른 날자부터), null(맨뒤에)
 * - desc : 숫자(큰 숫자부터), 문자(사전 역순으로), 날자(최근 날자부터), null(맨앞에)
 * - asc 가 기본 적용
 */

show tables; -- 현재 사용자가 접근 가능한 모든 table 조회

select * from emp;

select ename from emp;

select empno, ename, job, sal, deptno from emp;

select empno, ename, job, sal, deptno from emp where job = 'MANAGER';

select empno, ename, job, sal, deptno from emp where job > 'MANAGER';

select empno, ename, job, sal, deptno from emp where job >= 'MANAGER';

select empno, ename, job, sal, deptno from emp where job < 'MANAGER';

select empno, ename, job, sal, deptno from emp where job <= 'MANAGER';

select empno, ename, job, sal, deptno from emp where job <> 'MANAGER'; /*<> - 다르다는 의미*/

select empno, ename, job, sal, deptno from emp where job != 'MANAGER';

select empno, ename, job, sal, deptno from emp where sal = 1500;

select empno, ename, job, sal, deptno from emp where sal > 1500;

select empno, ename, job, sal, deptno from emp where sal >= 1500;

select empno, ename, job, sal, deptno from emp where sal < 1500;

select empno, ename, job, sal, deptno from emp where sal <= 1500;

select empno, ename, job, sal, deptno from emp where sal <> 1500;

select empno, ename, job, sal, deptno from emp where sal != 1500;

select empno, ename, job, sal, deptno from emp where ename like 'A%';

select empno, ename, job, sal, deptno from emp where ename like '%S';

select empno, ename, job, sal, deptno from emp where ename like '%L%';

select empno, ename, job, sal, deptno from emp where ename like '_L%';

select empno, ename, job, sal, deptno from emp where ename like '__L%';

select empno, ename, job, sal, deptno from emp where ename like '___L%';

select empno, ename, job, sal, deptno from emp where ename like '__A__';

-- 2024.07.12. START
select * from emp where empno regexp '9'; -- empno에 9가 들어간 모든 사람.

select * from emp where ename regexp '^[A]'; -- ename 첫 문자가 A인 사람.

select * from emp where ename regexp '^[A-C]'; -- ename 첫 문자가 A부터 C인 사람(A, B, C).
-- 2024.07.12. END

select job from emp;

select distinct job from emp;

select count(*) from emp;

select count(job) from emp;

select count(distinct job) from emp;	--중복되지 않은 job의 개수를 세줌

select count(comm) from emp;  --null값은 카운팅하지 않음

select 100 + 200 from dual; --오라클 방식, 오라클의 경우 가상 테이블(여기선 dual)을 하나 끼고 연산해야 값이 나왔음

select 100 - 200 from dual;

select 100 * 200 from dual;

select 100 / 200 from dual;

select 100 + 200;              --mysql 방식, 가상테이블 없어도 됨

select 100 - 200;

select 100 * 200;

select 100 / 200;

select empno, ename, job, sal, sal * 12   --연산이 되다보니 이런것도 가능하더라
from emp;

select empno, ename, job, sal, sal * 12, comm, sal * 12 + comm
from emp;

select empno, ename, job, sal, sal * 12, ifnull(comm, 0), sal * 12 + ifnull(comm, 0)
from emp;

select sal * 12 as 연봉 from emp;  --as로 별명 붙이기 가능, 별명의 띄어쓰기는 안됨

select sal * 12 연봉 from emp;

select sal * 12 as "연 봉" from emp; --띄어쓰기 쓰고 싶으면 따옴표로 묶기

select empno, ename, job, sal, sal * 12 as 연봉
, ifnull(comm, 0) 성과급, sal * 12 + ifnull(comm, 0) "총 연 봉" --ifnull()->null이면 뒤에 값을 넣어주세요
from emp;

select ename, job, sal, sal * 12 + ifnull(comm, 0) 연봉 from emp order by sal desc;
select ename, job, sal, sal * 12 + ifnull(comm, 0) AS 연봉 from emp order by sal desc;
select ename, job, sal, sal * 12 + ifnull(comm, 0) "연 봉" from emp order by sal desc;
select ename, job, sal, sal * 12 + ifnull(comm, 0) AS "연 봉" from emp order by sal desc;
select ename, job, sal, sal * 12 + ifnull(comm, 0) '연 봉' from emp order by sal desc;
select ename, job, sal, sal * 12 + ifnull(comm, 0) AS '연 봉' from emp order by sal desc;

select ename 직원이름 from emp;

select emp.ename 직원이름 from emp;

select ename 직원이름 from emp 직원테이블;

select 직원테이블.ename 직원이름 from emp 직원테이블;

select ename, job, sal from emp;
select emp.ename, emp.job, emp.sal from emp;
select ename, job, sal from emp 직원테이블;
select 직원테이블.ename, 직원테이블.job, 직원테이블.sal from emp 직원테이블;
select emp.ename, emp.job, emp.sal from emp 직원테이블; /* error -> emp 대신 직원 테이블로 별명을 지칭해서 직원테이블.ename과 같은 식으로*/

select empno, ename, job, sal, comm from emp where comm is null;

select empno, ename, job, sal, comm from emp where comm is not null;

select concat('H','E', 'L', 'L', 'O') as 인사 from dual;

select concat('H', 'E', 'L', 'L', 'O') as 인사;
select concat('H', concat('E', concat('L', concat('L', 'O')))) as 인사;
select 'H' || 'E' || 'L' || 'L' || 'O' as 인사 from dual; /* oracle */

select empno, ename, job, sal, deptno from emp where deptno = 30;

select empno, ename, job, sal, deptno from emp where job = 'MANAGER';

select empno, ename, job, sal, deptno from emp
where deptno = 30 and job = 'MANAGER';

select empno, ename, job, sal, deptno from emp
where deptno = 30 or job = 'MANAGER';

select empno, ename, job, sal, deptno from emp
where deptno = 30 and job = 'SALESMAN' and sal > 1500;

select empno, ename, job, sal, deptno from emp
where deptno = 30 or job = 'SALESMAN' or sal > 1500;

select ename, job, sal, deptno from emp where deptno = 30;
select ename, job, sal, deptno from emp where job = 'MANAGER';
select ename, job, sal, deptno from emp
where deptno = 30 and job = 'SALESMAN' and sal >= 1500;

select ename, job, sal, deptno from emp where deptno = 10;
select ename, job, sal, deptno from emp where job = 'MANAGER';
select ename, job, sal, deptno from emp
where deptno = 10 or job = 'MANAGER' or sal > 1000;

select empno, ename, job, sal, deptno from emp
where sal >= 1100 and sal <= 2450;

select empno, ename, job, sal, deptno from emp
where sal between 1100 and 2450;

select empno, ename, job, sal, deptno from emp
where ename >= 'ALLEN' and ename <= 'SCOTT';

select empno, ename, job, sal, deptno from emp
where ename between 'ALLEN' and 'SCOTT';

select * from emp where sal between 1100 and 2450 order by sal;
select * from emp where sal >= 1100 and sal <= 2450 order by sal;

select * from emp where ename between 'BLAKE' and 'KING' order by ename;
select * from emp where ename >= 'BLAKE' and ename <= 'KING' order by ename;

select empno, ename, job, sal, deptno from emp
where sal = 800 or sal = 1600 or sal = 2450;

select empno, ename, job, sal, deptno from emp
where sal in (800, 1600, 2450);

select empno, ename, job, sal, deptno from emp
where sal != 800 and sal != 1600 and sal != 2450;

select empno, ename, job, sal, deptno from emp
where sal not in (800, 1600, 2450);

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by sal;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by sal desc;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by ename;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by ename desc;

select empno, ename, job, hiredate, sal, deptno from emp
order by hiredate;

select empno, ename, job, hiredate, sal, deptno from emp
order by hiredate desc;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by comm;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by comm desc;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by deptno;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by deptno, sal;

select empno, ename, job, hiredate, sal, comm, deptno from emp
order by deptno desc, sal;

/*
 * union
 * - 하나 이상의 select 문을 합치는 명령어
 * - 합집합을 구함
 * - 다만, 중복 data는 제거
 * 주의!!! 각각의 select문의 결과 속성의 갯수와 속성 자리의 Data Type이 같아야 함
 * 주의!!! 각각의 select문의 테이블과 속성은 달라도 된다
 * 
 * union all
 * - 하나 이상의 select 문을 합치는 명령어
 * - union과 동일한 기능
 * - 중복 data 제거가 없음
 * 주의!!! 각각의 select문의 결과 속성의 갯수와 속성 자리의 Data Type이 같아야 함
 * 주의!!! 각각의 select문의 테이블과 속성은 달라도 된다
 */
select empno, ename, job, hiredate, sal, comm, deptno from emp
where deptno = 30
union
select empno, ename, job, hiredate, sal, comm, deptno from emp
where job = 'MANAGER';

select empno, ename, job, hiredate, sal, comm, deptno from emp
where deptno = 30
union all
select empno, ename, job, hiredate, sal, comm, deptno from emp
where job = 'MANAGER';

select empno, ename, job, hiredate, sal, comm, deptno from emp
where deptno = 30
union -- union all
select empno, ename, job, hiredate, sal, comm from emp
where job = 'MANAGER';--error

select empno, ename, job, hiredate, sal, comm, deptno from emp
where deptno = 30
union -- union all
select empno, empno, job, hiredate, sal, comm, deptno from emp
where job = 'MANAGER';--error

select empno, ename from emp
union
select deptno, dname from dept;--테이블이나 속성명이 달라도, select 갯수와 data type만 맞으면 ok

/* QUIZ
1. emp에서 사원 이름, 급여, 입사일 출력

2. emp에서 별명 부여 : deptno  -> 부서번호

3. emp에서 job을 중복 제거하고 출력

4. emp에서 급여가 1500 이하인 직원의 사번, 이름, 직업, 급여, 부서번호 출력

5. emp에서 이름이 MARTIN인 직원의 정보를 출력

6. emp에서 급여가 950 또는 1250 또는 2975 인 직원의 정보를 출력

7. emp에서 급여가 950 또는 1250 또는 2975 이 아닌 직원의 정보를 출력

8. emp에서 이름이 S로 긑나는 직원의 정보를 출력

9. emp에서 mgr이 null인 직원의 정보를 출력

10. emp에서 모든 직원의 사번,이름,직업,입사일,부서번호를 입사일이 최근 순으로 출력

11. emp에서 모든 직원의 사번,이름,직업,입사일,부서번호를 입사일이 오래된 순으로 출력
*/

1.
select empno, ename, job, hiredate, sal, comm, deptno from emp;

2.
select empno, ename, job, hiredate, sal, comm, deptno 부서번호 from emp;

3.
select distinct job from emp;

4.
select empno, ename, job, hiredate, sal, comm, deptno from emp
where sal <= 1500;

5.
select empno, ename, job, hiredate, sal, comm, deptno from emp
where ename = 'MARTIN';

6.
select empno, ename, job, hiredate, sal, comm, deptno from emp
where sal in (950, 1250, 2975);
--where sal = 950 or sal = 1250 or sal = 2975;

7.
select empno, ename, job, hiredate, sal, comm, deptno from emp
where sal not in (950, 1250, 2975);
--where sal != 950 and sal != 1250 and sal != 2975;

8.
select empno, ename, job, hiredate, sal, comm, deptno from emp
where ename like '%S';

9.
select empno, ename, job, hiredate, sal, comm, deptno
from emp where mgr is null;

10.
select empno, ename, job, hiredate, sal, comm, deptno
from emp
order by hiredate desc;

11.
select empno, ename, job, hiredate, sal, comm, deptno
from emp
order by hiredate asc;
