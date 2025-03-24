package kr.co.ureca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.co.ureca.entity.Emp;

public interface EmpRepository extends CrudRepository<Emp, Long> {

	public List<Emp> findAll();

} // interface
