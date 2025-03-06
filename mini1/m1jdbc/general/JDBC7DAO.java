package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO : Data(Base) Access Object
 */
public class JDBC7DAO {	//얘는 메인이 없음
	
	private Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/ureca";	//jdbc+:+(jdbc 이름) 후 ip port(mysql의 경우 디폴드 3306) dbname 적는 부분은 다 상이함
	private String user = "ureca";
	private String password = "ureca";
	private String sqlSelectAll = "select * from emp";
	
	public JDBC7DAO() throws ClassNotFoundException, SQLException{	//연결을 얼마나 많이 맺고 끊든 한번만 호출되면 됨
		//step1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2단계
		con = DriverManager.getConnection(url, user, password);
	}
	
	//ResultSet 객체는 connection을 통해 dbms의 외부스키마에 생성된 조회 결과 반영
	//=> 커넥션 종료시 더 이상 참조 불가능, 따라서 다른 객체와 공유하는게 바람직하지 않음?
	//=> DTO(Data Transfer Object) 또는 VO(Value Object)를 사용한다!
	public List<EmpDTO> selectAll() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		
		List<EmpDTO> list = new ArrayList<>();
		
		while(rs.next()) {	//바람직한 모습, ResultSet을 반환하는게 아닌 DTO 객체에 저장해서 list로 반환함 ->connection이 꺼져도 값에 접근이 가능해짐
			EmpDTO dto = new EmpDTO();
			
			dto.setEmpno(rs.getString("empno"));
			dto.setEname(rs.getString("ename"));
			dto.setJob(rs.getString("job"));
			dto.setMgr(rs.getString("mgr"));
			dto.setHiredate(rs.getString("hiredate"));
			dto.setSal(rs.getString("sal"));
			dto.setComm(rs.getString("comm"));
			dto.setDeptno(rs.getString("deptno"));
			
			list.add(dto);
		}
		
		//close();				//resultSet도 같이 꺼짐 =>resultset이 자바에만 있는게 아님!
		return list;		
	}
	
	public void close() throws SQLException {
		//5단계
		con.close();
	}
}
