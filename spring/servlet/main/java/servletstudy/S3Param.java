package servletstudy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class S3Param extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("nickName"));
		
		String[] fruitArr = (req.getParameterValues("fruit"));
		System.out.println(Arrays.toString(fruitArr));
		
		Enumeration<String> enu = req.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			System.out.println("enu :" + req.getParameter(name));
		}
		
		Map<String, String[]> map = req.getParameterMap();
		Set<String> set = map.keySet(); // map에서 name들을 가져온다
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(Arrays.toString(map.get(name)));
		}
	}
}
