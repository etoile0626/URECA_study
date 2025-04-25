package kr.co.ureca.s5getpost.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.s5getpost.service.RestTestService;

@WebMvcTest(RestTestController.class)
class RestTestControllerTest3 {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RestTestService service;

//	@Test
//	@DisplayName("MockMvc를 통한 Test")
	void test() throws Exception {

		// given
		given( service.findById(7L) )
			.willReturn( new EmpDTO(7L, 7782,"CLARK", "MANAGER", 7839
						, "1981-06-09", 2450, null, 10) ); 

		String id = "7";

		// {"id":7,"empno":7782,"ename":"CLARK","job":"MANAGER","mgr":7839,"hiredate":"1981-06-09","sal":2450,"comm":null,"deptno":10}
		mockMvc.perform( get("/rest-test/no2/" + id) )
				.andExpect( status().isOk() )
				.andExpect( jsonPath("$.id").exists() )
				.andExpect( jsonPath("$.empno").exists() )
				.andExpect( jsonPath("$.ename").exists() )
				.andExpect( jsonPath("$.job").exists() )
				.andExpect( jsonPath("$.mgr").exists() )
				.andExpect( jsonPath("$.hiredate").exists() )
				.andExpect( jsonPath("$.deptno").exists() )
				.andDo( print() );

		// verify
		verify( service ).findById(7L);

	} // test

	@Test
	void createEmpTest() throws Exception {

		given	(	service.empInsert(
						new EmpDTO(null, 1111, "Hong", "CLERK", 9999, "2020-01-01", 1200, 200, 40)
				)
		) // given
		.willReturn(	new EmpDTO(1L, 1111, "Hong", "CLERK", 9999, "2020-01-01", 1200, 200, 40)
		); // willReturn

		EmpDTO dto = new EmpDTO(null, 1111, "Hong", "CLERK", 9999, "2020-01-01", 1200, 200, 40);

		ObjectMapper mapper = new ObjectMapper();
		String content = mapper.writeValueAsString(dto);

		mockMvc.perform(post("/rest-test/no7")
						.contentType(MediaType.APPLICATION_JSON)
						.characterEncoding(StandardCharsets.UTF_8)
						.accept(MediaType.APPLICATION_JSON)
						.content(content))
		.andExpect(status().isOk())
//		.andExpect(jsonPath("$.empno").exists())
//		.andExpect(jsonPath("$.ename").exists())
//		.andExpect(jsonPath("$.job").exists())
//		.andExpect(jsonPath("$.sal").exists())
//		.andExpect(jsonPath("$.deptno").exists())
		.andDo(print());

//		verify(service).empInsert(
//				new EmpDTO(null, 1111, "Hong", "CLERK", 9999, "2020-01-01", 1200, 200, 40)
//		); // verify

	} // createEmpTest

} // class
