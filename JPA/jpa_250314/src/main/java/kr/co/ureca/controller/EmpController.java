package kr.co.ureca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "/empAll", method = RequestMethod.GET)
	public String empFindAll() {
		List<Emp> list = empService.empFindAll();
		System.out.println(list);
		
		list = empService.empFindAllOrder();
		System.out.println(list);
		
		return "hello";
	}
	
	@RequestMapping(value = "/empByName", method=RequestMethod.GET)
	public String empFindByEname() {
		String ename = "MILLER";
		Integer sal = 1300;
		String job = "CLERK";
		
		Emp empEntity = empService.empFindByEname(ename);
		System.out.println("FindByEname : "+empEntity);
		
		empEntity = empService.empFindByNameAndSal(ename, sal);
		System.out.println("FindByNameAndSal : " + empEntity);
		
		empEntity = empService.empFindByNameAndJobAndSal(ename, job, sal);	//and로 2개 이상 연결가능
		System.out.println("FindByNameAndJobAndSal : " + empEntity);
		
		List<Emp> empList = empService.empFindByNameOrJobOrSal(ename, job, sal);	//or도 사용가능
		System.out.println("FindByNameAndJobAndSal : " + empList);
		
		empList = empService.empFindByJobLike("%SALES%");	//like 검색으로 SALES가 들어간 애 찾아보기, 와일드카드도 붙여주기
		System.out.println("empFindByJobLike : " + empList);
		
		return "hello";
	}
	
	@RequestMapping(value = "/empIns", method=RequestMethod.GET)
	public String empInsert() {								//JPA로 insert
		Emp newEmp = new Emp();
		newEmp.setEmpno(Integer.valueOf(9999));
		newEmp.setEname("Hong");
		newEmp.setJob("CLERK");
		newEmp.setSal(Integer.valueOf(1200));
		newEmp.setComm(Integer.valueOf(600));
		newEmp.setDeptno(Integer.valueOf(40));
		
		Long primaryKey = empService.empInsert(newEmp);
		System.out.println(primaryKey);
		
		return "hello";
	}
	
	@RequestMapping(value = "/empUp", method=RequestMethod.GET)
	public String empUpdate() {
		Emp upEmp = new Emp();
		upEmp.setId(15L);
		upEmp.setEmpno(Integer.valueOf(9999)); //얜 안바뀌는데 안 써도 되나?
		upEmp.setEname("HongGD");
		upEmp.setJob("ANALIST");
		upEmp.setSal(Integer.valueOf(2400));
		upEmp.setComm(null);
		upEmp.setDeptno(Integer.valueOf(20));
		
		Emp empAfterUpdate = empService.empUpdate(upEmp);
		System.out.println(empAfterUpdate);
		
		return "hello";
	}
	
	@RequestMapping(value = "/empDel", method=RequestMethod.GET)
	public String requestMethodName() {
		Emp empDel = new Emp();
		empDel.setId(15L);
		empService.empDelete(empDel);
		
		return "hello";
	}
	
	@RequestMapping(value="/findBy", method = RequestMethod.GET)
	public String findByQuery() {	//쿼리를 사용하는 예
		String ename = "MARTIN";
		String job = "SALESMAN";
		Integer sal = 3000;
		
		Emp empEntity = empService.findByQueryName(ename);
		System.out.println("findByQueryName : " + empEntity);
		
		List<Emp> list = empService.findByQueryJob(job);
		System.out.println("findByQueryJob : " + list);
		
		return "hello";
	}
	
}

	