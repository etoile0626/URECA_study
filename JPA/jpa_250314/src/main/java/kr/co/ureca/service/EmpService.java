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
	}
	
	public List<Emp> empFindAllOrder() {
		List<Emp> list = empRepository.findAllOrderByDeptnoDesc();
		
		return list;
	}

	public Emp empFindByEname(String ename) {
		Emp empEntity = empRepository.findByEname(ename);
		return empEntity;
	}

	public Emp empFindByNameAndSal(String ename, Integer sal) {
		Emp empEntity = empRepository.findByEnameAndSal(ename, sal);
		return empEntity;
	}

	public Emp empFindByNameAndJobAndSal(String ename, String job, Integer sal) {
		Emp empEntity = empRepository.findByEnameAndJobAndSal(ename, job, sal);
		return empEntity;
	}
	
	public List<Emp> empFindByNameOrJobOrSal(String ename, String job, Integer sal) {
		List<Emp> empList = empRepository.findByEnameOrJobOrSal(ename, job, sal);
		return empList;
	}
	
	public List<Emp> empFindByJobLike(String job) {
		List<Emp> empList = empRepository.findByJobLike(job);
		return empList;
	}

	public Long empInsert(Emp newEmp) {//저장 전 객체는 pk가 null
		Emp saveAfterEmp = empRepository.save(newEmp);		//save는 수정후 엔티티 객체 반환
		return saveAfterEmp.getId();	//저장 후 객체는 pk 뒤에 생성됨
	}

	public Emp empUpdate(Emp upEmp) {
		//업데이트를 위해 PK를 가지고 entity 조회를 먼저 해봄
		//findById로 나오는 객체는 Optional이라는 애한테 감싸져서 나옴
		Optional<Emp> optEmp = empRepository.findById(upEmp.getId());
		Emp empEntity = optEmp.get();	//optEmp에서 get으로 Emp 객체 가져옴
		
		empEntity.setEname(upEmp.getEname());
		empEntity.setJob(upEmp.getJob());
		empEntity.setSal(upEmp.getSal());
		empEntity.setComm(upEmp.getComm());
		empEntity.setDeptno(upEmp.getDeptno());
		
		
		Emp empAfterUpdate = empRepository.save(empEntity);		//save는 수정후 엔티티 객체 반환
		return empAfterUpdate;
	}

	public void empDelete(Emp empDel) {
		Optional<Emp> optEmp = empRepository.findById( empDel.getId());
		Emp empEntity = optEmp.get();
		
		empRepository.delete(empEntity);						//emp 객체(행) 하나 삭제
	}

	public List<Emp> findByQueryJob(String job) {
		List<Emp> empList = null;
		empList = empRepository.findByQueryJobParam(job);
		//위랑 아래는 같은 쿼리, 다른표현, 다른 리턴값을 가짐
/*		List<Object[]> list = empRepository.findByQueryJob(job);
		empList = new ArrayList<>();
		for(Object[] obj : list) {
			Emp tmpEmp = new Emp();
			tmpEmp.setId( (Long) obj[0]);
			tmpEmp.setEmpno( (Integer) obj[1]);
			tmpEmp.setEname( (String) obj[2]);
			tmpEmp.setJob( (String) obj[3]);
			tmpEmp.setMgr( (Integer) obj[4]);
			tmpEmp.setHiredate( (String) obj[5]);
			tmpEmp.setSal( (Integer) obj[6]);
			tmpEmp.setComm( (Integer) obj[7]);
			tmpEmp.setDeptno( (Integer) obj[8]);
			empList.add(tmpEmp);
		}*/
		return empList;
	}

	public Emp findByQueryName(String ename) {
		Emp empEntity = null;
		//empEntity = empRepository.findByQueryEname(ename);
		empEntity = empRepository.findByQueryEnameParam(ename);
		//위 2개는 같은 쿼리, 다른 표현임
		return empEntity;
	}

}
