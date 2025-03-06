package m1jdbc.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBC7DAOMain {

	public static void main(String[] args) {
		
		JDBC7DAO dao = null;
		try {
			dao = new JDBC7DAO();
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("커넥션이 연결되지 않았습니다");
		}
		
		try {
			List<EmpDTO>list = dao.selectAll();
			for(EmpDTO dto : list) {
				System.out.println(dto.getEmpno() +"\t");
				System.out.println(dto.getEname() +"\t");
				System.out.println(dto.getJob() +"\t");
				System.out.println(dto.getMgr() +"\t");
				System.out.println(dto.getHiredate() +"\t");
				System.out.println(dto.getSal() +"\t");
				System.out.println(dto.getComm() +"\t");
				System.out.println(dto.getDeptno() +"\t");
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("조회 중 오류 발생");
		}
		
		try {
			dao.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("연결 해제 중 오류 발생");
		}
	}

}
