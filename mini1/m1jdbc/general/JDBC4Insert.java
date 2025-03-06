package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC4Insert {

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
		
		//data in 
		Scanner sc = new Scanner(System.in);
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
		
		//4단계
		int successCount = 0;
		String query = "INSERT INTO test_board(brd_title, brd_writer, brd_cntns, brd_date)"
					+ " values('"+title+"', '"+writer+"', '"+contents+"', now() )";	//쉼표로 다 묶어줘야함..짜증남
		//ResultSet와 excuteQuery는 select를 날릴때만 받음, 정수형으로 성공 갯수를 받고 excuteUpdate를 사용.
		successCount = stmt.executeUpdate(query);	
		System.out.println(successCount+"건이 입력 되었습니다.");
				
		//5단계
		stmt.close();
		con.close();
		sc.close();
	}

}
