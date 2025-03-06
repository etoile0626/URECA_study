package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC4InsertPrepare {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1단계
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계. Driver 클래스를 찾아오는 중
			
		//2단계
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";	//jdbc+:+(jdbc 이름) 후 ip port(mysql의 경우 디폴드 3306) dbname 적는 부분은 다 상이함
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);
				
		//3단계
		//data in 
		Scanner sc = new Scanner(System.in);
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
				
		//Statement stmt = con.createStatement(); => psmt로 대체
		//더 쉽게 만들기(아래)
		String query = "INSERT INTO test_board(brd_title, brd_writer, brd_cntns, brd_date)"
						+ " values(?, ?, ?, now() )";
		PreparedStatement psmt = con.prepareStatement(query); //근데 얘는 쿼리를 가지고 만들어야해서 쿼리 생성 먼저 해줘야함
		psmt.setString(1, title);			//1번째 물음표를 title로		
		psmt.setString(2, writer);			//2번째 물음표를 writer로
		psmt.setString(3, contents);		//3번째 물음표를 contents로
		
		//4단계
		int successCount = 0;
		successCount = psmt.executeUpdate();		//stmt가 아닌 psmt에 쿼리를 날릴땐 인자 안 넣음(이미 넣어줘서)
		System.out.println(successCount+"건이 입력 되었습니다.");
				
		//5단계
		psmt.close();
		con.close();
		sc.close();
	}

}
