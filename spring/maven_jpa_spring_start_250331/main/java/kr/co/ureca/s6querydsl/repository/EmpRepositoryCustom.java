package kr.co.ureca.s6querydsl.repository;

import java.util.List;

import kr.co.ureca.entity.Emp;

public interface EmpRepositoryCustom {
	
	public List<Emp> empByDeptno(Integer deptno); 
}
