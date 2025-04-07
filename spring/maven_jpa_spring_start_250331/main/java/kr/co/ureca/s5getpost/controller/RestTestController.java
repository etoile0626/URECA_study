package kr.co.ureca.s5getpost.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.s5getpost.service.RestTestService;
import org.springframework.web.bind.annotation.PutMapping;


// @Controller : client의 request를 받고, client에게 response를 전송하는 역할을 하는 객체.
// @ResponseBody : @Controller는 일반적으로 view name을 return하나, @ResponseBody일 경우는 html body를 return 함.
// @RestController : @Controller + @ResponseBody, 일반적으로 html body를 return 함.
@RestController
@RequestMapping("/rest-test")
public class RestTestController {

	@Autowired
	private RestTestService service;

	//class의 @RequestMapping과 method의 @RequestMapping을 결합한 uri에 대응됨.
	// http://localhost:8080/rest-test/no1
	// 메소드의 @RequestMapping은 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping으로 대체될 수 있다.
	@RequestMapping(value = "/no1", method = RequestMethod.GET)
	public String no1() {
		return "hello world"; // @RestController에서는 html body로 return 됨.
	} // no1

	// @PathVariable : client가 uri에 포함시켜 보낸 data를 받는 annotation.
	// http://localhost:8080/rest-test/no2/data
	@GetMapping("/no2/{id}")
	public EmpDTO no2(@PathVariable Long id) { // 변수명을 @GetMapping의 {id}와 같게 선언!!!
		EmpDTO dto = service.findById(id);
		return dto;
	} // no2

	// http://localhost:8080/rest-test/no3/data
	@GetMapping("/no3/{data}")
	public EmpDTO no3(@PathVariable("data") Long id) { // 변수명을 @GetMapping의 {data}와 다를 경우!!!
		EmpDTO dto = service.findById(id);
		return dto;
	} // no3

	// http://localhost:8080/rest-test/no4?empno=9999&ename=modi&job=bbbb&mgr=5555&hiredate=2025-03-31&sal=1200&comm=100&deptno=40
	@GetMapping("/no4")
	public EmpDTO no4( @RequestParam Integer empno, @RequestParam String ename, @RequestParam String job
						, @RequestParam Integer mgr, @RequestParam String hiredate, @RequestParam Integer sal
						, @RequestParam Integer comm, @RequestParam Integer deptno) {
		EmpDTO dto = new EmpDTO(null, empno, ename, job, mgr, hiredate, sal, comm, deptno);
		EmpDTO returnDto = service.empInsert(dto);
		return returnDto;
	} // no4

	// http://localhost:8080/rest-test/no5?empno=9999&ename=modi&job=bbbb&mgr=5555&hiredate=2025-03-31&sal=1200&comm=100&deptno=40
	@GetMapping("/no5")
	public String no5( @RequestParam Map<String, Object> params ) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>");
		params.entrySet().forEach( map -> {
			sb.append( "<p>" + map.getKey() + " : " + map.getValue() + "</p>" );
		} );
		sb.append("</h3>");
		return sb.toString();
	} // no5

	// http://localhost:8080/rest-test/no6?empno=9999&ename=modi&job=bbbb&mgr=5555&hiredate=2025-03-31&sal=1200&comm=100&deptno=40
	@GetMapping("/no6")
	public EmpDTO no6( EmpDTO dto ) {
		EmpDTO returnDto = service.empInsert(dto);
		return returnDto;
	} // no6

	// http method post : reat-api에서 insert 요청으로 분류.
	// @RequestBody : request의 header와 body 중에 body의 내용을 지정된 객체로 매핑하는 역할.
	// @RequestBody : JSON 형식의 복잡한 데이터 구조를 받는 것에 용이함.
	// http://localhost:8080/rest-test/no7
	@PostMapping("/no7")
	public EmpDTO no7( EmpDTO dto ) {
		EmpDTO returnDto = service.empInsert(dto);
		return returnDto;
	} // no7

	// http method put : reat-api에서 update 요청으로 분류.
	// http://localhost:8080/rest-test/no8
	@PutMapping("/no8")
	public EmpDTO no8( EmpDTO dto ) {
		EmpDTO returnDto = service.empUpdate(dto);
		return returnDto;
	} // no8

	// ResponseEntity : 상태값을 client에게 전달할 수 있음.
	// http://localhost:8080/rest-test/no9
	@PutMapping("/no9")
	public ResponseEntity<EmpDTO> no9( EmpDTO dto ) {
		EmpDTO returnDto = service.empUpdate(dto);
		return ResponseEntity.status(HttpStatus.OK).body(returnDto);
	} // no9

	// http://localhost:8080/rest-test/no10
	@DeleteMapping("/no10")
	public ResponseEntity<String> no10( EmpDTO dto ) {
		String message = service.empDelete(dto);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	} // no10

	// http://localhost:8080/rest-test/no11/data
	@DeleteMapping("/no11/{empno}")
	public ResponseEntity<String> no11( @PathVariable Integer empno ) {
		EmpDTO dto = new EmpDTO();
		dto.setEmpno(empno);
		String message = service.empDelete(dto);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	} // no11

} // class
