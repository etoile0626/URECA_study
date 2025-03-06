package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * connection.setAutoCommit(false);
 * connection.commit();
 * connection.rollback(); <-이게 끝임
 */
public class JDBC6Commit {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1단계
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계. Driver 클래스를 찾아오는 중
		
		//2단계
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";	//jdbc+:+(jdbc 이름) 후 ip port(mysql의 경우 디폴드 3306) dbname 적는 부분은 다 상이함
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);
		
		//Connection 생성 직후
		con.setAutoCommit(false);
		
		//3단계
		Statement stmt = con.createStatement();
		
		//4단계
		String query1 = "INSERT INTO test_board(brd_title, brd_writer, brd_cntns, brd_date)"
				+ " values('테스트1', '수업1', '수업 중 테스트1', now());";
		String query2 = "INSERT INTO test_board(brd_title, brd_writer, brd_cntns, brd_date)"
				+ " values('테스트2', '수업2', '수업 중 테스트2', now());";
		//ResultSet와 excuteQuery는 select를 날릴때만 받음, 정수형으로 성공 갯수를 받고 excuteUpdate를 사용.
		int sCnt1 = 0, sCnt2 = 0;
		sCnt1 = stmt.executeUpdate(query1);		
		sCnt2 = stmt.executeUpdate(query2);	
		
		con.commit();									//오토커밋꺼져있으니까 이거 해야함
		//con.rollback();					//rollback을 몇번 하고 커밋해보면 bre_no에 차이가 있음을 알 수 있음
		System.out.println((sCnt1+sCnt2)+"건이 입력되었습니다.");
		
		//5단계
		stmt.close();
		con.close();
	}

}
