package kr.co.ureca.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long>{

}
