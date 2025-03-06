package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC2Prepared {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		String inData = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계. Driver 클래스를 찾아오는 중
		
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";// 2단계. 연결명령, ip(localhost로 가져와도 됨, port.
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		String query = "SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, "
				+ "d.dname, d.loc"
				+ " From emp e, dept d"					//맨 앞에 한 칸 뛰어서 2번째줄 마지막과 붙지 않도록
				+ " WHEHE e.deptno = d.deptno"
				+ " AND ename = ?";						//조회조건을 입력값으로 받아서 쿼리문에 전달중(조건문에 리본 수정)
		PreparedStatement psmt = con.prepareStatement(query);
		psmt.setString(1, inData); 					//쿼리의 첫번째 물음표를 inData로 교체해라
		
		//Statement stmt = con.createStatement();			//3단계. 쿼리문 만들어서 보내기
		ResultSet rs = psmt.executeQuery(query);		//쿼리에 대한 정답
														
														//4단계. 결과 확인
		while(rs.next()) {								//select 한 순서대로 가져오는 중
			System.out.print(rs.getString("sal") + "\t");
			System.out.print(rs.getInt("empno") + "\t");
			System.out.print(rs.getString("ename") + "\t\t");
			System.out.print(rs.getString("job") + "\t\t");
			System.out.print(rs.getInt("mgr") + "\t");
			System.out.print(rs.getString("hiredate") + "\t");
			System.out.print(rs.getInt("comm") + "\t");
			System.out.print(rs.getInt("deptno") + "\t");
			System.out.print(rs.getString("dname") + "\t\t");
			System.out.println(rs.getString("loc"));
		}
		
		rs.close();										//5.연결 해제
		psmt.close();
		con.close();
	}

}
