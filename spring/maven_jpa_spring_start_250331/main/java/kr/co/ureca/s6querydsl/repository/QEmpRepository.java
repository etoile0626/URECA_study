package kr.co.ureca.s6querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import kr.co.ureca.entity.Emp;

public interface QEmpRepository
					extends JpaRepository<Emp, Long>
							, ListQuerydslPredicateExecutor<Emp> {

} // interface
