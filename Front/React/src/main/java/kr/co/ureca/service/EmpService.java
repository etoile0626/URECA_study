package kr.co.ureca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

	public List<Emp> empFindAll() {

		List<Emp> list = empRepository.findAll();

		return list;
	} // empFindAll

	public Emp empFindById(String id) {

		Optional<Emp> empOpt = empRepository.findById( Long.parseLong(id) );

		Emp emp = empOpt.get();

		return emp;
	} // empFindById

	public Long empInsert(Emp emp) {
		Emp savedEmp = empRepository.save(emp);

		return savedEmp.getId();
	} // empInsRow

	public Long empDelete(String id) {
		Optional<Emp> empOpt = empRepository.findById( Long.parseLong(id) );

		Emp emp = empOpt.get();

		Long deletePK = emp.getId();

		empRepository.delete(emp);

		return deletePK;
	} // primaryKey

	public Long empUpdate(Emp emp) {
		Emp savedEmp = empRepository.save(emp);

		return savedEmp.getId();
	} // empInsRow

} // class
