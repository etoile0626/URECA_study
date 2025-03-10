package menubook.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CustDAO {
	private Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/madangdb";
	private String user = "madang";
	private String password = "madang";

	public CustDAO() throws ClassNotFoundException, SQLException {		//dao 생성하면서 db와 커넥션 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	}

	public void close() throws SQLException {
		con.close();
	} // close
	
	public Vector<Vector<String>> readAll() throws SQLException{
		String sqlSelectAll = "select * from customer";
		
		Vector<Vector<String>> list = new Vector<Vector<String>>(); //쿼리 결과를 벡터가 든 벡터로 받음
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add(rs.getString("custid"));		//속성 하나하나 값을 받아옴
			obj.add(rs.getString("name"));
			obj.add(rs.getString("address"));
			obj.add(rs.getString("phone"));
			list.add(obj);
		}
		
		rs.close();
		stmt.close();
		
		return list;
	}

	public int insertOne(String name, String address, String phone) throws SQLException {
		int successCnt = 0;
		String sqlInsertOne = "insert into customer(name, address, phone)"
				+ " value(?, ?, ?)";
		
		PreparedStatement psmt = con.prepareStatement(sqlInsertOne);
		psmt.setString(1, name);
		psmt.setString(2, address);
		psmt.setString(3, phone);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}

	public int updateOne(String custID, String name, String address, String phone) throws SQLException {
		int successCnt = 0;
		String sqlUpdateOne = "update customer set name=?, address=?, phone=?"
				+ " where custid=?";
		
		PreparedStatement psmt = con.prepareStatement(sqlUpdateOne);
		psmt.setString(1, name);
		psmt.setString(2, address);
		psmt.setString(3, phone);
		psmt.setString(4, custID);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}

	public int deleteOne(String custID) throws SQLException {
		int successCnt = 0;
		String sqlDeleteOne = "delete from customer"
				+ " where custid=?";
		
		PreparedStatement psmt = con.prepareStatement(sqlDeleteOne);
		psmt.setString(1, custID);
		successCnt = psmt.executeUpdate();
		psmt.close();
		
		return successCnt;
	}
}
