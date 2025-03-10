package menubook.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BookDAO {
	private Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/madangdb";
	private String user = "madang";
	private String password = "madang";

	public BookDAO() throws ClassNotFoundException, SQLException {		//dao 생성하면서 db와 커넥션 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	}

	public void close() throws SQLException {
		con.close();
	} // close
	
	public Vector<Vector<String>> readAll() throws SQLException{
		String sqlSelectAll = "select * from book";
		
		Vector<Vector<String>> list = new Vector<Vector<String>>(); //쿼리 결과를 벡터가 든 벡터로 받음
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add(rs.getString("bookid"));		//속성 하나하나 값을 받아옴
			obj.add(rs.getString("bookname"));
			obj.add(rs.getString("publisher"));
			obj.add(rs.getString("price"));
			list.add(obj);
		}
		
		rs.close();
		stmt.close();
		
		return list;
	}

	public int insertOne(String bookname, String publisher, String price) throws SQLException {
		int successCnt = 0;
		String sqlInsertOne = "insert into book(bookname, publisher, price)"
				+ " value(?, ?, ?)";
		
		PreparedStatement psmt = con.prepareStatement(sqlInsertOne);
		psmt.setString(1, bookname);
		psmt.setString(2, publisher);
		psmt.setString(3, price);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}

	public int updateOne(String bookID, String bookname, String publisher, String price) throws SQLException {
		int successCnt = 0;
		String sqlUpdateOne = "update book set bookname=?, publisher=?, price=?"
				+ " where bookid=?";
		
		PreparedStatement psmt = con.prepareStatement(sqlUpdateOne);
		psmt.setString(1, bookname);
		psmt.setString(2, publisher);
		psmt.setString(3, price);
		psmt.setString(4, bookID);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}

	public int deleteOne(String bookID) throws SQLException {
		int successCnt = 0;
		String sqlDeleteOne = "delete from book"
				+ " where bookid=?";
		
		PreparedStatement psmt = con.prepareStatement(sqlDeleteOne);
		psmt.setString(1, bookID);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}
}
