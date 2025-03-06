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
 * 지시자 관련 method
 * -afterLast : 맨 끝 데이터의 뒤로 이동
 * -beforeFirst : 맨 첫 데이터의 앞으로 이동
 * -first : 맨 첫 데이터 이동
 * -last : 맨 뒤 데이터 이동
 * -next : 다음 아래 데이터로 이동
 * -previous : 다음 위 데이터로 이동(이전 데이터)
 * -absolute : 지정된 순서의 데이터로 이동
 * -relative : 현재 데이터 에서 지정된 거리의 데이터로 이동
 * -isAfterLast : 지시자의 위치가 맨 끝 데이터의 뒤(AfterLast)인가?
 * -isBeforeFirst : 지시자의 위치가 맨 앞 데이터의 앞(BeforeFirst)인가?
 * -isFirst : 지시자의 위치가 맨 첫 데이터(first) 인가?
 * -isLast : 지시자의 위치가 맨 뒤 데이터(last) 인가?
 */
public class JDBC5ResultSet {

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
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //TYPE_FORWARD_ONLY를 깨기 위해 statment 생성시 초기값 설정
				
		//4단계
		String query = "SELECT e.*, d.*"
				+ " From emp e, dept d"					//맨 앞에 한 칸 뛰어서 2번째줄 마지막과 붙지 않도록
				+ " WHERE e.deptno = d.deptno"
				+ " ORDER BY e.ename";
		//ResultSet와 excuteQuery는 select를 날릴때만 받음, 정수형으로 성공 갯수를 받고 excuteUpdate를 사용.
		ResultSet rs = stmt.executeQuery(query);		
		
		//rs traverse
		System.out.println("rs.isBeforeFirst() : " + rs.isBeforeFirst());
		System.out.println("rs.isAfterLast() : " + rs.isAfterLast());
		rs.afterLast();										//TYPE_FORWARD_ONLY가 디폴트라 수행이 안됨
		System.out.println("rs.afterLast() 수행");
		System.out.println("rs.isBeforeFirst() : " + rs.isBeforeFirst());
		System.out.println("rs.isAfterLast() : " + rs.isAfterLast());
		System.out.println("==============================");
		rs.beforeFirst();										//TYPE_FORWARD_ONLY가 디폴트라 수행이 안됨
		System.out.println("rs.beforeFirst() 수행");
		rs.next();
		System.out.println("rs.next() 수행");
		System.out.println(rs.getString("ename"));
		rs.next();
		System.out.println("rs.next() 수행");
		System.out.println(rs.getString("ename"));
		rs.previous();
		System.out.println("rs.previous() 수행");
		System.out.println(rs.getString("ename"));
		System.out.println("==============================");
		rs.last();
		System.out.println("rs.last() 수행");
		System.out.println(rs.getString("ename"));
		rs.previous();
		System.out.println("rs.previous() 수행");
		System.out.println(rs.getString("ename"));
		System.out.println("==============================");
		rs.absolute(3);
		System.out.println("rs.absolute(3) 수행");
		System.out.println(rs.getString("ename"));
		rs.relative(2);
		System.out.println("rs.relative(2) 수행");
		System.out.println(rs.getString("ename"));
		rs.relative(-2);
		System.out.println("rs.relative(-2) 수행");
		System.out.println(rs.getString("ename"));
				
		//5단계
		rs.close();
		stmt.close();
		con.close();

	}

}
