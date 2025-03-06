package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC 5가지 
 * 1. Driver loading (mysql-connector-j-8.4.0.jar를 가지고 옴.)
 * 		Driver: DBMS 제조사가 제공하는 클라이언트 모듈.
 * 2. connection 확립
 * 3. Statement & query
 * 4. 결과 확인 : CUD - CUD 건수 리턴, R - ResultSet 리턴
 * 5. 연결 해제
 */
public class JDBC1Overview {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계. Driver 클래스를 찾아오는 중
		
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";// 2단계. 연결명령, ip(localhost로 가져와도 됨, port. dbname.
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		String query = "SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, "
				+ "d.dname, d.loc"
				+ " From emp e, dept d"					//맨 앞에 한 칸 뛰어서 2번째줄 마지막과 붙지 않도록
				+ " WHEHE e.deptno = d.deptno";
		Statement stmt = con.createStatement();			//3단계. 쿼리문 만들어서 보내기
		ResultSet rs = stmt.executeQuery(query);		//쿼리에 대한 정답을 ResultSet으로 받음
														
		/*												//4단계. 결과 확인
		while(rs.next()) {								//select 한 순서대로 가져오는 중
			System.out.println(rs.getInt(1) + "\t");	//숫자면 숫자로
			System.out.println(rs.getString(2) + "\t");	//문자면 문자로 받기
			System.out.println(rs.getString(3) + "\t");
			System.out.println(rs.getInt(4) + "\t");
			System.out.println(rs.getString(5) + "\t");
			System.out.println(rs.getInt(6) + "\t");
			System.out.println(rs.getInt(7) + "\t");
			System.out.println(rs.getInt(8) + "\t");
			System.out.println(rs.getString(9) + "\t");
			System.out.println(rs.getString(10));
		}*/
		while(rs.next()) {								
			System.out.print(rs.getString("sal") + "\t");
			System.out.print(rs.getInt("empno") + "\t");	
			System.out.print(rs.getString("ename") + "\t\t");
			System.out.print(rs.getString("job") + "\t\t");
			System.out.print(rs.getInt("mgr") + "\t");
			System.out.print(rs.getString("hiredate") + "\t");
			System.out.print(rs.getInt("comm") + "\t");
			System.out.print(rs.getInt("deptno") + "\t");
			System.out.print(rs.getString("dname") + "\t\t");
			System.out.println(rs.getString("loc"));;
		}
		
		rs.close();										//5.연결 해제
		stmt.close();
		con.close();
	}

}
