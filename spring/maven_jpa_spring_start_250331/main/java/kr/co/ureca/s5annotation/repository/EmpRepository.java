package kr.co.ureca.s5annotation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	
	@Override
	default Optional<Emp> findById(Long id) {
		return Optional.empty();
	}

	public Emp findByEmpno(Integer empno);
}
