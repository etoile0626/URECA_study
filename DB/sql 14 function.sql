SET GLOBAL log_bin_trust_function_creators = on;

CREATE FUNCTION `empno_ename_func`(int_var int)
RETURNS varchar(60)
BEGIN
	declare ret_ename varchar(60);

	select ename into ret_ename
    from emp where empno = int_var;

	RETURN ret_ename;
END

select empno_ename_func(7698);

select empno_ename_func(empno) from emp;
