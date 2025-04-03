package kr.co.ureca.s5getpost.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import kr.co.ureca.dto.EmpDTO;

@SpringBootTest
class RestTestControllerTest2 {

	@Autowired
	private RestTestController controller;
	
	//테스트 코드로 돌린것도 db에 저장됨
	@Test
	void testEmpInsert() {
		EmpDTO dto = new EmpDTO(null, 1111, "Hong", "CLERK", 9999, "2020-01-01", 1200, 200, 40);
		
		EmpDTO rtnDto = controller.no6(dto);			//insert
		
		assertThat(rtnDto).isNotEqualTo(null);
		
		assertThat(rtnDto).isInstanceOf(EmpDTO.class);	//클래스가 EmpDTO인지 확인
		
		assertThat(rtnDto.getEmpno()).isEqualTo(1111);
		
		assertThat(rtnDto.getEname()).isEqualTo("Hong");
		
		System.out.println("============================");
		System.out.println(rtnDto);
		System.out.println("============================");
	}
	
	@Test
	void testEmpUpdate(){
		EmpDTO dto = new EmpDTO(null, 1111, "HongGilDong", "Analist", 9999, "2020-01-01", 2400, 0, 40);
		
		ResponseEntity<EmpDTO> rtnObj = controller.no9(dto);	//update
		
		assertThat(rtnObj).isNotNull();
		
		assertThat(rtnObj).isInstanceOf(ResponseEntity.class);
		
		assertThat(rtnObj.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		assertThat(rtnObj.getBody()).isNotNull();
		
		assertThat(rtnObj.getBody()).isInstanceOf(EmpDTO.class);

		assertThat(rtnObj.getBody().getEmpno()).isEqualTo(1111);
		
		assertThat(rtnObj.getBody().getEname()).isEqualTo("HongGilDong");
	}
	
	@Test
	void testNo2() {
		EmpDTO dto = controller.no2(7L);	
		
		assertThat(dto).isNotNull();
	}

}
