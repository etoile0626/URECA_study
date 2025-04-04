package kr.co.ureca.s6querydsl.repository;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface QEmpRepository extends JpaRepository<Emp, Long>
										, ListQuerydslPredicateExecutor<Emp>{
}
