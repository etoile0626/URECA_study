package kr.co.ureca.s6querydsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface EmpCustomRepository extends JpaRepository<Emp, Long>{
	public List<Emp> empByDeptno(Integer deptno);
}
