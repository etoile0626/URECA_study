package kr.co.ureca.s5annotation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.s5annotation.service.RestTestService;

//@Controller : client의 request를 받고 response를 보내는 역할을 하는 객체
//@ResponseBody : 일반적으로 @Controller는 view name을 return 하나, 이 어노테이션이 있으면 html body(객체)를 반환해줌
@RestController // @Controller + @ResponseBody, 일반적으로 html body를 반환해줌
@RequestMapping("/rest-test")
public class RestTestController {
	
	@Autowired
	private RestTestService service;
	
	//class의 @RequestMapping과 메소드의 @RequestMapping이 결합되어 uri에 대응됨
	@RequestMapping(value = "/no1", method = RequestMethod.GET)	// /rest-test/no1
	public String no1() {
		return "hello world";				//이게 html의 body로 리턴되는거임
	}
	
	//@RequestMapping ==> @PostMapping @PutMapping @GetMapping @DeleteMapping으로 대체 가능
	
										// /rest-test/no2/data 같은 방식으로 옴
	//@PathVariable - 클라이언트가 보내는 uri에 포함시켜 보낸 data를 받는 어노테이션
	@GetMapping("/no2")
	public EmpDTO no2(@PathVariable Long id) { // 변수명을 @GetMapping의 {id}와 같게 선언!!!
		EmpDTO dto = service.findById(id);
		return dto;
	} // no2

	// http://localhost:8080/rest-test/no3/data
	@GetMapping("/no3/{data}")
	public EmpDTO no3(@PathVariable("data") Long id) { // 변수명을 @GetMapping의 {id}와 다를 경우!!!
		EmpDTO dto = service.findById(id);
		return dto;
	} // no3
	
	@GetMapping("/no4")
	//@RequestParam = request로부터 파라미터를 받아오는 애 -> 근데 이러면 arg 리스트가 너무 많아짐(불편해!!)
	public EmpDTO no4(@RequestParam Integer empno, @RequestParam String ename, 
			@RequestParam String job, @RequestParam Integer mgr, 
			@RequestParam String hiredate, @RequestParam Integer sal,
			@RequestParam Integer comm, @RequestParam Integer deptno) {
		
		EmpDTO dto = new EmpDTO(null, empno, ename, job, mgr, hiredate, sal, comm, deptno);
		EmpDTO returnDto = service.empInsert(dto);
		return returnDto;
	} // no4
	
	@GetMapping("/no5")
	//no4의 해결책 -> Map으로 받자! => 그래도 불편함
	public String no5(@RequestParam Map<String, Object> params) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>");
		params.entrySet().forEach( map -> {
			sb.append("<p>"+map.getKey() + " " + map.getValue() + "</p>");
		});
		sb.append("</h3>");
		return sb.toString();
	} // no5
	
	@GetMapping("/no6")
	//그래서 그냥 dto로 받으면 편하다
	public EmpDTO no6(EmpDTO dto) {
		
		EmpDTO returnDto = service.empInsert(dto);
		return returnDto;
	} 
	
	@PostMapping("/no7")	
	//6번이랑 같은데 post 방식일뿐 / get = 조회 / post = 입력의 역할로 많이 쓰임
	//@RequestBody = request의 헤더와 바디 중 body의 내용을 지정된 객체로 매핑시켜줌
	public EmpDTO no7( EmpDTO dto) {
		EmpDTO returnDto = service.empInsert(dto);
		return returnDto;
	}
	
	//수정
	@PutMapping("/no8")	//put = RestAPI에서 update의 역할로 쓰여짐
	public EmpDTO no8(EmpDTO dto) {
		EmpDTO returnDto = service.empUpdate(dto);
		return returnDto;
	}
	
	@PutMapping("/no9")	//ResponseEntity-상태값을 포함해서 리턴하는 애
	public ResponseEntity<EmpDTO> no9(EmpDTO dto) {
		EmpDTO returnDto = service.empUpdate(dto);
							//http 상태 코드를 넣을 수 있음		//<EmpDTO>를 하겠다는 뜻
		return ResponseEntity.status(HttpStatus.OK).body(returnDto);
	}
	
	@PutMapping("/no10")	//이번엔 삭제
	public ResponseEntity<String> no10(EmpDTO dto) {
		String message = service.empDelete(dto);
							//http 상태 코드를 넣을 수 있음		
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@PutMapping("/no11/{empno}")	//이번엔 삭제
	public ResponseEntity<String> no11(@PathVariable Integer empno) {
		EmpDTO dto = new EmpDTO();
		dto.setEmpno(empno);
		String message = service.empDelete(dto);
							//http 상태 코드를 넣을 수 있음		
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
}
