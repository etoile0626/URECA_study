package kr.co.ureca.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
@Controller
@Service
@Repository //이 세종류가 아니면 @Component쓰기
*/

import kr.co.ureca.dto.EmpDTO;

@Controller
public class HomeController {
	
	@Autowired //자동으로 묶어주는 어노테이션 Autowired를 통해 sql 세션을 묶어줌
	private SqlSession sqlSession;
	
	// /hello라는 요청에 대해서 GET 방식을 통해서 응답함. 
	//GET: 주소창에 요청한 내용이 보임, 공식적으로는 최대 256바이트 POST: 요청한 내용이 주소창에 보이지 않음, 크기에 제한이 없음
	@RequestMapping(value = "/hello", method = RequestMethod.GET) 
	public String hello() {			//controller에 있는 메소드들은 보통 string 리턴
		
		//mybatis 호출 어케함? => sqlSesssion.selectList()를 통해, 괄호 안에는 "mapperName.queryName"의 형태로
		List<EmpDTO> list = sqlSession.selectList("MybatisSample.SampleEmp"); 
		System.out.println(list);
		
		return "hello";				// /WEB-INF/views/hello.jsp
		//hello()가 호출되면 hello를 줄건데 prefix와 subfix 사이에 들어가게됨
	}
	
}
