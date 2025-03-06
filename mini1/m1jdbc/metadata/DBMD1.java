package m1jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DatabaseMetaData
 * - DBMS로부터 전달 받는 Database 정보 객체
 * - DBMS 정보 : getDatabaseProductName, getDatabaseProductVersion,
 *   getDatabaseMajorVersion, getDatabaseMinorVersion
 * - Driver 정보 : getDriverName, getDriverVersion,
 *   getDriverMajorVersion, getDriverMinorVersion
 *   getJDBCMajorVersion, getJDBCMinorVersion
 * - Connection 정보 : getURL, getUserName
 *   isReadOnly, getDefaultTransactionIsolation
 */
public class DBMD1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		DatabaseMetaData dbmd = con.getMetaData();	//메타데이터 가져옴

		System.out.println("getDatabaseProductName : " + dbmd.getDatabaseProductName());
		System.out.println("getDatabaseProductVersion : " + dbmd.getDatabaseProductVersion());
		System.out.println("==============================");
		System.out.println("getDriverName : " + dbmd.getDriverName());
		System.out.println("getDriverVersion : " + dbmd.getDriverVersion());
		System.out.println("==============================");
		System.out.println("getJDBCMajorVersion : " + dbmd.getJDBCMajorVersion());
		System.out.println("getJDBCMinorVersion : " + dbmd.getJDBCMinorVersion());
		System.out.println("==============================");
		System.out.println("getURL : " + dbmd.getURL());
		System.out.println("getUserName : " + dbmd.getUserName());
		System.out.println("isReadOnly : " + dbmd.isReadOnly());
		System.out.println("getDefaultTransactionIsolation : " + dbmd.getDefaultTransactionIsolation());
		System.out.println("=============================="); 
		//트랜잭션 레벨
		System.out.println("TRANSACTION_NONE : " + Connection.TRANSACTION_NONE);	//다 안 막아짐
		System.out.println("TRANSACTION_READ_COMMITTED : " + Connection.TRANSACTION_READ_COMMITTED); //dirty-read(다른 사람이 쓴걸 내가 읽게되는 현상)가 안 막아짐
		System.out.println("TRANSACTION_READ_UNCOMMITTED : " + Connection.TRANSACTION_READ_UNCOMMITTED); // non-repeatable read(한 트랜젝션에서 읽어도 값이 달라짐)가 안 막아짐
		System.out.println("TRANSACTION_REPEATABLE_READ : " + Connection.TRANSACTION_REPEATABLE_READ); //phantom read(없던 데이터가 생기는 현상)가 안 막아짐
		System.out.println("TRANSACTION_SERIALIZABLE : " + Connection.TRANSACTION_SERIALIZABLE); // 다 막아짐

		// Step5.
		con.close();
	} // main

} // class
