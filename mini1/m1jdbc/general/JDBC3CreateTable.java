package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class JDBC3CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1단계
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계. Driver 클래스를 찾아오는 중
		
		//2단계
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";	//jdbc+:+(jdbc 이름) 후 ip port(mysql의 경우 디폴드 3306) dbname 적는 부분은 다 상이함
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3단계
		Statement stmt = con.createStatement();
		
		//4단계
		String query = "CREATE TABLE test_board("
				+ "bre_no INT PRIMARY KEY AUTO_INCREMENT"	//AUTO_INCREMENT = 데이터가 들어올때마다 자동으로 값을 늘려서 넣어줌
				+ ", brd_title varchar(150) NOT NULL"
				+ ", brd_writer varchar(60)"				//앞쪽에 쉼표 관리하는게 더 편함
				+ ", brd_cntns VARCHAR(3000) NOT NULL"			//3000 = 한글 1000자, cntns = contents
				+ ", brd_date DATETIME NOT NULL"
				+ ")";
		//ResultSet와 excuteQuery는 select를 날릴때만 받음, 정수형으로 성공 갯수를 받고 excuteUpdate를 사용.
		int successCount = stmt.executeUpdate(query);		
		
		//5단계
		stmt.close();
		con.close();
	}

}
