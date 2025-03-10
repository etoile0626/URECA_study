package menubook.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OrdDAO {
	private Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/madangdb";
	private String user = "madang";
	private String password = "madang";

	public OrdDAO() throws ClassNotFoundException, SQLException {		//dao 생성하면서 db와 커넥션 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	}

	public void close() throws SQLException {
		con.close();
	} // close
	
	public Vector<Vector<String>> readAll() throws SQLException{
		String sqlSelectAll = "SELECT o.orderid, o.custid, c.name"
				+ ", o.bookid, b.bookname, o.saleprice, o.orderdate"
				+ " FROM orders o, customer c, book b"		//세 테이블 조인해서 보여줌
				+ " WHERE o.custid = c.custid"
				+ " AND o.bookid = b.bookid";
		
		Vector<Vector<String>> list = new Vector<Vector<String>>(); //쿼리 결과를 벡터가 든 벡터로 받음
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add(rs.getString("orderid"));		//속성 하나하나 값을 받아옴
			obj.add( rs.getString("custid") );
			obj.add( rs.getString("name") );
			obj.add( rs.getString("bookid") );
			obj.add( rs.getString("bookname") );
			obj.add( rs.getString("saleprice") );
			obj.add( rs.getString("orderdate") );
			list.add(obj);
		}
		
		rs.close();
		stmt.close();
		
		return list;
	}
	
	public Vector<Vector<String>> readAllCust() throws SQLException {
		String sqlSelectAll = "SELECT * FROM customer";

		Vector<Vector<String>> list = new Vector<Vector<String>>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add( rs.getString("custid") );
			obj.add( rs.getString("name") );
			obj.add( rs.getString("address") );
			obj.add( rs.getString("phone") );
			list.add(obj);
		} // while
		rs.close();
		stmt.close();

		return list;
	} // readAllCust
	
	public Vector<Vector<String>> readAllBook() throws SQLException {
		String sqlSelectAll = "SELECT * FROM book";

		Vector<Vector<String>> list = new Vector<Vector<String>>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add( rs.getString("bookid") );
			obj.add( rs.getString("bookname") );
			obj.add( rs.getString("publisher") );
			obj.add( rs.getString("price") );
			list.add(obj);
		} // while
		rs.close();
		stmt.close();

		return list;
	} // readAllBook

	public int insertOne(String custID, String bookID, String salePrice) throws SQLException {
		int successCnt = 0;
		String sqlInsertOne = "insert into orders(custid, bookid, saleprice, orderdate)"
				+ " value(?, ?, ?, now())";
		
		PreparedStatement psmt = con.prepareStatement(sqlInsertOne);
		psmt.setString(1, custID);
		psmt.setString(2, bookID);
		psmt.setString(3, salePrice);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}

	public int updateOne(String selectedOrdID, String custID, String bookID, String salePrice) throws SQLException {
		int successCnt = 0;
		String sqlUpdateOne = "update orders set custid=?, bookid=?,"
				+ " saleprice=?"
				+ " where orderid=?";
		
		PreparedStatement psmt = con.prepareStatement(sqlUpdateOne);
		psmt.setString(1, custID);
		psmt.setString(2, bookID);
		psmt.setString(3, salePrice);
		psmt.setString(4, selectedOrdID);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}

	public int deleteOne(String orderID) throws SQLException {
		int successCnt = 0;
		String sqlDeleteOne = "delete from orders"
				+ " where orderid=?";
		
		PreparedStatement psmt = con.prepareStatement(sqlDeleteOne);
		psmt.setString(1, orderID);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}
	
}
