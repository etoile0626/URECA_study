-- partition by는 row들 사이에 경계선 긋기
-- order by는 partition 내의 row들 줄 세우기
-- over는 partition과 order가 적용된 대상들을 대상으로 한다는 의미
-- row_number는 단순 row 번호
select ename, job, sal, deptno
, row_number() over(partition by deptno order by sal desc) apply_over
from emp;

-- partition 없으면 전체 데이터 대상
select ename, job, sal, deptno
, row_number() over(order by sal desc) apply_over
from emp;

-- rank는 순위 : 1위가 2명이면 2위 없이 바로 3위 출력
select ename, job, sal, deptno
, rank() over(partition by deptno order by sal desc) apply_over
from emp;

select ename, job, sal, deptno
, rank() over(order by sal desc) apply_over
from emp;

-- dense_rank는 순위 : 1위가 2명이어도 2위 출력
select ename, job, sal, deptno
, dense_rank() over(partition by deptno order by sal desc) apply_over
from emp;

select ename, job, sal, deptno
, dense_rank() over(order by sal desc) apply_over
from emp;

-- first_value : partition에서 가장 먼저 나오는 값
select ename, job, sal, deptno
, first_value(sal) over(partition by deptno order by sal desc) apply_over
from emp;

select ename, job, sal, deptno
, first_value(sal) over(order by sal desc) apply_over
from emp;

-- last_value : partition에서 가장 나중에 나오는 값
select ename, job, sal, deptno
, last_value(sal) over(partition by deptno order by sal desc
			ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) apply_over
from emp;

select ename, job, sal, deptno
, last_value(sal) over(order by sal desc
			ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) apply_over
from emp;

-- lag : 앞의 n번째에 나오는 값
select ename, job, sal, deptno
, lag(sal) over(order by sal desc)
from emp;

select ename, job, sal, deptno
, lag(sal, 3) over(order by sal desc)
from emp;

select deptno, sal
, lag(sal) over(partition by deptno order by sal desc) apply_over
from emp;

-- lead : 뒤의 n번째에 나오는 값
select ename, job, sal, deptno
, lead(sal) over(order by sal desc) apply_over
from emp;

select ename, job, sal, deptno
, lead(sal,3) over(order by sal desc) apply_over
from emp;

select deptno, sal
, lead(sal,2) over(partition by deptno order by sal desc) apply_over
from emp;

-- ratio_to_report : 비율 / oracle만
-- over()에 order by 불가
select deptno, sal
, ratio_to_report(sal) over(partition by deptno)
from emp; -- 부서 내에서의 값의 비율

select deptno, sal
, ratio_to_report(sal) over()
from emp; -- 전체에서의 값의 비율

-- percent_rank : partition에서 가장 먼저 나온 것을 0, 가장 나중에 나온 것을 1로 하여, 값이 아닌 행의 순서별 백분율을 구한다.
select deptno, sal
, percent_rank() over(partition by deptno order by sal desc) apply_over
from emp; -- 반에서 내 성적의 위치 (내신 등급 생각하라)

-- cume_dist : partition 전체 건수의 분포 위치를 0 ~ 1 사이의 누적 백분율로 구한다.
select deptno, sal
, cume_dist() over(partition by deptno order by sal desc) apply_over
from emp; -- 반에서 내 성적의 위치 (내신 등급 생각하라)

-- ntile : 파티션에서 전체 건수를 n으로 등분한 결과를 조회한다.
select deptno, sal
, ntile(10) over(order by sal desc) apply_over
from emp; -- 반에서 내 성적의 위치 (내신 등급 생각하라)
