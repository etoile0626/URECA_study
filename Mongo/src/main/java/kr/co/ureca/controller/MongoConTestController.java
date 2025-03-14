package kr.co.ureca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ureca.dto.EmpDTO;

@Controller
public class MongoConTestController {

	@Autowired
	private MongoOperations mongoOps;

	@RequestMapping(value = "/conTest", method = RequestMethod.GET)
	public String mongoConnectionTest() {

		EmpDTO dto = new EmpDTO("11","kim","CLERK",null,null,"800",null,"40");

		mongoOps.insert(dto, "emp");

		return "hello";
	} // mongoConnectionTest

	@RequestMapping(value = "/conTest2", method = RequestMethod.GET)
	public String mongoCreateTestCollection() {

		mongoOps.dropCollection("emp");

		EmpDTO dto1 = new EmpDTO("7369","SMITH","CLERK","7902","1980-12-17","800",null,"20");
		EmpDTO dto2 = new EmpDTO("7499","ALLEN","SALESMAN","7698","1981-02-20","1600","300","30");
		EmpDTO dto3 = new EmpDTO("7521","WARD","SALESMAN","7698","1981-02-22","1250","500","30");
		EmpDTO dto4 = new EmpDTO("7566","JONES","MANAGER","7839","1981-04-02","2975",null,"20");
		EmpDTO dto5 = new EmpDTO("7654","MARTIN","SALESMAN","7698","1981-09-28","1250","1400","30");
		EmpDTO dto6 = new EmpDTO("7698","BLAKE","MANAGER","7839","1981-05-01","2850",null,"30");
		EmpDTO dto7 = new EmpDTO("7782","CLARK","MANAGER","7839","1981-06-09","2450",null,"10");
		EmpDTO dto8 = new EmpDTO("7788","SCOTT","ANALYST","7566","1982-12-09","3000",null,"20");
		EmpDTO dto9 = new EmpDTO("7839","KING","PRESIDENT",null,"1981-11-17","5000",null,"10");
		EmpDTO dto10 = new EmpDTO("7844","TURNER","SALESMAN","7698","1981-09-08","1500",null,"30");
		EmpDTO dto11 = new EmpDTO("7876","ADAMS","CLERK","7788","1983-01-12","1100",null,"20");
		EmpDTO dto12 = new EmpDTO("7900","JAMES","CLERK","7698","1981-03-12","950",null,"30");
		EmpDTO dto13 = new EmpDTO("7902","FORD","ANALYST","7566","1981-03-12","3000",null,"20");
		EmpDTO dto14 = new EmpDTO("7934","MILLER","CLERK","7782","1982-01-12","1300",null,"10");

		ArrayList<EmpDTO> list = new ArrayList<>();
		list.add(dto1);		list.add(dto2);		list.add(dto3);		list.add(dto4);		list.add(dto5);
		list.add(dto6);		list.add(dto7);		list.add(dto8);		list.add(dto9);		list.add(dto10);
		list.add(dto11);	list.add(dto12);	list.add(dto13);	list.add(dto14);

		mongoOps.insert(list, "emp");

		return "hello";
	} // mongoCreateTestCollection

	@RequestMapping(value="/fineOne", method = RequestMethod.GET)
	public String findOne(EmpDTO dto) {
		
		Query sql = new Query( Criteria.where("ENAME").is("JAMES") );
		dto = mongoOps.findOne(sql, EmpDTO.class, "emp");
		System.out.println("findOne-is: :" + dto);
		
		//findOne
		sql = new Query ( Criteria.where("sal").gte("3000"));
		List<EmpDTO> list = mongoOps.find(sql, EmpDTO.class, "emp");
		System.out.println( "findOne-get :" + dto);
		
		//findall
		list = mongoOps.findAll(EmpDTO.class, "emp");
		System.out.println( "findOne-findAll :"+list);
		
		return "hello";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update() {
		
		Query query = new Query( Criteria.where("sal").is("3000") );
		
		Update update = Update.update("sal", 1200);
		
		mongoOps.updateFirst(query, update, "emp");
		
		query = new Query(Criteria.where("deptno").is(20));
		update = Update.update("deptno", "50");
		mongoOps.updateMulti(query, update, "emp");
		
		return "hello";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.GET)
	public String remove() {
		
		Query query = new Query( Criteria.where("deptno").is("30") );
		
		mongoOps.remove(query, "emp");
		
		return "hello";
	}
	
	@RequestMapping(value="/drop", method = RequestMethod.GET)
	public String drop() {
		
		mongoOps.dropCollection("emp");
		
		return "hello";
	}
	/*
	@RequestMapping(value="", method = RequestMethod.GET)
	public String name() {
		return "hello";
	}*/
} // class
