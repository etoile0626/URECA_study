package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//servlet 컨테이너 등록이 필요함 (spring boot에서 @controller/service 등등 하던것 처럼)
//->servlet에선 @Webservlet(관리는 쉬우나 목록화가 어려움)이나 web.xml()에서 수행함
@WebServlet(value="/s1")
//RequestMapping의 역할  + 톰 캣에서 현재 프로그램을 등록
//web.xml에 등록하는 행위로 대체 가능
public class S1Start extends HttpServlet{

	/*
	 * get : 데이터를 주소에 포함시켜 보내는 방법
	 *	   : 주소 창에 data가 보임 ->기본 암호화도 없어 보안 취약
	 *	   : post 보다 비교적 빠름
	 *	   : w3c 공식 입장은 주소외의 256byte까지만 유효하다 (실제와는 다름, 더 많이도 보내짐)
	 * 
	 * QueryString : get 방식에서 주소 창에 연결된 data를 의미
	 * 제조 방식 : 1.주소 뒤에 ? 붙이기
	 * 			2. name=value의 형태(받은 데이터 이름 = 값의 형태)
	 * 			3. &를 붙인다
	 * 			4. data의 갯수만큼 name=value&을 반복 (	name=value&name=value&name=value&)	
	 *  ex)http://localhost:8080/s1?ename=modi&job=salesman&deptno=40
	 * 
	 * post : 전달하려는 data를 숨겨서 보내는 방법
	 * 		: 기본 암호화 존재, 보안이 get보다 비교적 좋음
	 * 		: -> 암호화의 시간적 delay 존재 -> get보다 비교적 느림
	 * 		: get보다 대량 data 전송에 유리
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpServletRequest(req) : 클라이언트의 정보를 담은 객체
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getRemotePort());
		
		String inData = req.getParameter("ename");
		System.out.println(inData);	//ename이라는 이름을 가진 form형식의 데이터를 가지고 올 것임
		
		//HttpServletResponse(res) : 클라이언트에게 보낼 정보를 담을 객체 (아직 담겨 있는건 아님)
		PrintWriter out = resp.getWriter();
		//jsp의 최대 단점 : 여기에 html을 써야함
		out.print("<html><head><meta charset='UTF-8'><title>do get</title></head><body>");
		out.print("<h1>Get Test !!</h1>");
		out.print("<h1>"+inData+"</h1></body></html>");
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inData = req.getParameter("job");
		System.out.println("!!!!!!!!! POST !!!!!!!!!!");
		
		System.out.println(inData);	//job이라는 이름을 가진 form형식의 데이터를 가지고 올 것임
		
		//HttpServletResponse(res) : 클라이언트에게 보낼 정보를 담을 객체 (아직 담겨 있는건 아님)
		PrintWriter out = resp.getWriter();
		//jsp의 최대 단점 : 여기에 html을 써야함
		out.print("<html><head><meta charset='UTF-8'><title>do get</title></head><body>");
		out.print("<h1>Post Test !!</h1>");
		out.print("<h1>"+inData+"</h1></body></html>");
		
		out.close();
		
	}
	
}
