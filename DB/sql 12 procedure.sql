/*
 * 문법 1단계 : begin ~ end
 */
CREATE PROCEDURE `proc_test1`()
BEGIN
	select 'hello';
END

call proc_test1();

/*
 * 변수 선언
 */
CREATE PROCEDURE `proc_test2`()
BEGIN
	declare TEST_EMPNO integer;
	declare TEST_ENAME varchar(10);

	set TEST_EMPNO = 10;
	set TEST_ENAME = 'hi';

	select TEST_EMPNO, TEST_ENAME;
END

call proc_test2();

/*
 * select문을 이용하여 변수 채우기
 * - select 와 from 사이에 into문 사용
 */
CREATE PROCEDURE `proc_test3`()
BEGIN
	declare TEST_EMPNO integer;

	select empno into TEST_EMPNO from emp where ename = 'ALLEN';
	select TEST_EMPNO;
END

call proc_test3();

/*
 * select문을 이용하여 변수 채우기
 * - select 와 from 사이에 into문 사용
 */
CREATE PROCEDURE `proc_test4`()
BEGIN
	declare TEST_EMPNO integer;
	declare TEST_ENAME varchar(10);

	select empno, ename into TEST_EMPNO, TEST_ENAME
        from emp where comm = 1400;

	select TEST_EMPNO, TEST_ENAME;
END

call proc_test4();

/*
 * begin과 end 사이에는 select문이 여러 개 올 수 있음
 */
CREATE PROCEDURE `proc_test5`()
BEGIN
	declare TEST_EMPNO integer;
	declare TEST_DNAME varchar(20);

	select empno into TEST_EMPNO
        from emp where ename = 'SMITH';

	select dname into TEST_DNAME
        from dept where deptno = 40;

	select TEST_EMPNO, TEST_DNAME;
END

call proc_test5();

/*
 * select문이 찾아온 data를 이용하여 다시 select 하기
 */
CREATE PROCEDURE `proc_test6`()
BEGIN
	declare TEST_DEPTNO integer;
	declare TEST_DNAME varchar(20);

	select deptno into TEST_DEPTNO
        from emp where ename = 'MILLER';

	select dname into TEST_DNAME
        from dept where deptno = TEST_DEPTNO;

	select TEST_DEPTNO, TEST_DNAME;
END

call proc_test6();

/*
 * if문 : if then ; ~ elseif then ; ~ elseif then ; ~ else ; ~ end if;
 */
CREATE PROCEDURE `proc_test7`()
BEGIN
	declare TEST_DEPTNO integer;
	declare TEST_DNAME varchar(20);

	select deptno into TEST_DEPTNO
        from emp where ename = 'MILLER';

	if(TEST_DEPTNO = 10) then set TEST_DNAME = '경리';
	elseif(TEST_DEPTNO = 20) then set TEST_DNAME = '연구';
	elseif(TEST_DEPTNO = 30) then set TEST_DNAME = '영업';
	else set TEST_DNAME = '운영';
	end if;

	select TEST_DEPTNO, TEST_DNAME;
END

call proc_test7();

/*
 * Loop문 : loop ~ leave ~ end loop;
 */
CREATE PROCEDURE `proc_test8`()
BEGIN
	DECLARE test_no INT DEFAULT 0;

	loop_name:LOOP 
		SET test_no = test_no + 1;
		IF(test_no > 10) THEN
			LEAVE loop_name;
		END IF;
	END LOOP;

	SELECT test_no;
END

call proc_test8();

/*
 * repeat문 : repeat ~ until ~ end repeat;
 */
CREATE PROCEDURE `proc_test9`()
BEGIN
	DECLARE test_no INT DEFAULT 0;

	repeat 
		SET test_no = test_no + 1;
		until test_no > 9
	END repeat;

	SELECT test_no;
END

call proc_test9();

/*
 * while문 : while ~ do ~ end while;
 */
CREATE PROCEDURE `proc_test10`()
BEGIN
	DECLARE test_no INT DEFAULT 1;

	while(test_no < 7) do
		SET test_no = test_no + 1;
	END while;

	SELECT test_no;
END

call proc_test10();

/*
 * 외부에서 입력 받기 1
 */
CREATE PROCEDURE `proc_test11`(in int_var integer)
BEGIN
	DECLARE loop_var INT default 1;
	DECLARE test_num INT;

	SET test_num = int_var;

	while(loop_var < 7) do
		SET test_num = test_num + 1;
		SET loop_var = loop_var + 1;
	END while;

	SELECT test_num;
END

call proc_test11(100);

/*
 * 외부에서 입력 받기 2
 */
CREATE PROCEDURE `proc_test12`(in char_var varchar(40))
BEGIN
	declare TEST_EMPNO integer;
	declare TEST_ENAME varchar(20);
	declare TEST_JOB varchar(20);
	declare TEST_SAL integer;
	declare TEST_DEPTNO integer;

	select empno, ename, job, sal, deptno
	into TEST_EMPNO, TEST_ENAME, TEST_JOB, TEST_SAL, TEST_DEPTNO
	from emp
	where ename = char_var;

	SELECT TEST_EMPNO, TEST_ENAME, TEST_JOB, TEST_SAL, TEST_DEPTNO;
END

call proc_test12('SMITH');

/*
 * in & out
 */
CREATE PROCEDURE `proc_test13`(in num1 integer
				, in giho char(1), in num2 integer, out result integer)
BEGIN
	if(giho = '+') then set result = num1 + num2;
	elseif(giho = '-') then set result = num1 - num2;
	elseif(giho = '*') then set result = num1 - num2;
	elseif(giho = '/') then set result = num1 - num2;
	elseif(giho = '%') then set result = mod(num1, num2);
	else set result = num1 + num2;
	end if;
END

call proc_test13(55, '*', 3, @res);
select @res;

/*
 * CURSOR
 */
drop table proc14;

create table proc14
as select * from emp where 1 = 2;

CREATE PROCEDURE `proc_test14`(in int_var integer)
BEGIN
	declare TEST_EMPNO integer;
	declare TEST_ENAME varchar(20);
	declare TEST_JOB varchar(20);
	declare TEST_SAL integer;
	declare TEST_DEPTNO integer;

	declare end_flag BOOLEAN DEFAULT FALSE;

	declare select_cursor cursor for
		select empno, ename, job, sal, deptno
        from emp
        where deptno = int_var;

	declare CONTINUE HANDLER FOR NOT FOUND SET end_flag = TRUE;

	open select_cursor;

	loop_name:LOOP
		IF end_flag THEN
			LEAVE loop_name;
		END IF;

		fetch select_cursor
                into TEST_EMPNO, TEST_ENAME, TEST_JOB, TEST_SAL, TEST_DEPTNO;

		insert into proc14(empno, ename, job, sal, deptno)
		values(tempno, tename, tjob, tsal, tdeptno);
	END LOOP;

END

call proc_test14(20);

SELECT * FROM urecadb.proc14;
