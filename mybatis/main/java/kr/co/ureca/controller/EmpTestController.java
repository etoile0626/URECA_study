package kr.co.ureca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.EmpSearchDTO;
import kr.co.ureca.service.EmpTestService;

@Controller
public class EmpTestController {
	
	@Autowired
	private EmpTestService empTestService;

	@RequestMapping(value = "/empAll", method = RequestMethod.GET)
	public String empSelectAll() {
		List<EmpDTO> list = empTestService.empSelectAll();
		System.out.println( list );
		return "hello";
	}

	@RequestMapping(value = "/empByName", method = RequestMethod.GET)
	public String empSelectByEname() {
		EmpDTO dto = empTestService.empSelectByEname("ADAMS");
		System.out.println( dto );
		return "hello";
	}

	//POST를 보내는게 맞음, 화면에서 만들어서 보내는게 아니라 POST 방식이 안먹음 => 여기서 임시로 GET방식으로
	@RequestMapping(value = "/empIns", method = RequestMethod.GET) //원래는 POST가 맞음
	public String empInsert() {
		EmpDTO dto = new EmpDTO(null, "YOUNG", "CLERK", null, null, "1000", "200", "40");
		int successCnt = empTestService.empInsert(dto);
		System.out.println("insert-Controller-SuccessCnt : "+successCnt);
		System.out.println("empInsert-controller-selectKey : " + dto.getEmpno());
		return "hello";
	}
	
	//POST를 보내는게 맞음, 화면에서 만들어서 보내는게 아니라 POST 방식이 안먹음 => 여기서 임시로 GET방식으로
	@RequestMapping(value = "/empInsList", method = RequestMethod.GET)
	public String empInsertList() {
		EmpDTO dto1 = new EmpDTO(null, "YAN", "CLERK", null, null, "1000", "200", "40");
		EmpDTO dto2 = new EmpDTO(null, "YUL", "CLERK", null, null, "1000", "200", "40");
		EmpDTO dto3 = new EmpDTO(null, "YOL", "CLERK", null, null, "1000", "200", "40");
		ArrayList<EmpDTO> insList = new ArrayList<>();
		insList.add(dto1); insList.add(dto2); insList.add(dto3);
		int successCnt = empTestService.empInsertList(insList);
		System.out.println("insertList-Controller-SuccessCnt : "+successCnt);
		
		return "hello";
	}

	//POST를 보내는게 맞으나, 화면에서 만들어서 보내는게 아니라 POST 방식이 안먹음 => 여기서 임시로 GET방식으로
	@RequestMapping(value = "/empUp", method = RequestMethod.GET)
	public String empUpdate() {
		EmpDTO dto = new EmpDTO("7935", "YULLIAN", "ANALIST", null, null, "2000", null, null);
		int successCnt = empTestService.empUpdate(dto);
		System.out.println("update-Controller-SuccessCnt : "+successCnt);
		return "hello";
	}

	@RequestMapping(value = "/selectIn", method = RequestMethod.GET)
	public String selectIn() {
		ArrayList<String> enameList = new ArrayList<>();
		enameList.add("MILLER"); enameList.add("ADAMS"); enameList.add("JAMES");
		List<EmpDTO> list = empTestService.selectIn(enameList);
		System.out.println("selectIn-Controller-SuccessCnt : "+ list );
		return "hello";
	}
	
	@RequestMapping(value = "/selectSearch", method = RequestMethod.GET)
	public String selectSearch() {		//검색 요건이 여러개인 경우
		EmpSearchDTO dto1 = new EmpSearchDTO("SMITH", null, null);
		List<EmpDTO> list1 = empTestService.selctSearch(dto1);
		System.out.println("selectSearch-controller-list1"+list1);
		
		EmpSearchDTO dto2 = new EmpSearchDTO(null, "MANAGER", null);
		List<EmpDTO> list2 = empTestService.selctSearch(dto2);
		System.out.println("selectSearch-controller-list2"+list2);
		
		EmpSearchDTO dto3 = new EmpSearchDTO(null, null, "10");
		List<EmpDTO> list3 = empTestService.selctSearch(dto3);
		System.out.println("selectSearch-controller-list3"+list3);
		
		return "hello";
	}
	
	//delete는 패스
	
}
