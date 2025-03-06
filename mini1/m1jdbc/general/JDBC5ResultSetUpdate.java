package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ResultSet : select 수행의 결과 집합 (테이블/표 형태)
 * 결과 집합에 지시자가 포함되어 있다. (커서같은 느낌)
 * 
 * Result Type
 * - TYPE_FORWARD_ONLY : 단방향 이동.
 * - TYPE_SCROLL_INSENSITIVE : 양방향 이동 + UPDATE 불가.
 * - TYPE_SCROLL_SENSITIVE : 양방향 이동 + UPDATE 가능.
 * - CONCUR_READ_ONLY : 읽기 전용.
 * - CONCUR_UPDATABLE : UPDATE 가능.
 */
public class JDBC5ResultSetUpdate {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1단계
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계. Driver 클래스를 찾아오는 중
				
		//2단계
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";	//jdbc+:+(jdbc 이름) 후 ip port(mysql의 경우 디폴드 3306) dbname 적는 부분은 다 상이함
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);
				
		//3단계
		Statement stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //statment 생성시 초기값 설정
				
		//4단계
		String query = "SELECT * From emp3";					
		
		//ResultSet와 excuteQuery는 select를 날릴때만 받음, 정수형으로 성공 갯수를 받고 excuteUpdate를 사용.
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			if(rs.getString("ename").equals("MILLER")) {
				rs.updateInt("comm", 100);		//MILLER를 찾아서 MILLER의 comm을 100으로 변경
				rs.updateRow();
			}
		}
				
		//5단계
		rs.close();
		stmt.close();
		con.close();

	}

}
