package m2swing.level3;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
/*
 * Emp테이블을 볼 수 있는 뷰
 */
public class EmpView {
	
	private JFrame frm;
	private JList list;
	private EmpDAO dao;
	private List<EmpDTO> arrList;
	private EmpWindowEventProcessor winEventProc;
	
	public EmpView() throws ClassNotFoundException, SQLException {
		frm = new JFrame("프레임 로딩과 함께 EMP 테이블 Select All & List");
		//========================
		dao = new EmpDAO();
		arrList = dao.selectAll();
		//========================
		list = new JList( arrList.toArray() );
	}

	private void makeGui() {
		frm.setSize(500, 500);
		frm.add(list);
		frm.setVisible(true);
	}
	
	private void addEvent() {
		winEventProc = new EmpWindowEventProcessor();
		frm.addWindowListener(winEventProc);
	}
	
	public static void main(String[] args) {
		EmpView ev = null;
		try {							//EmpView 객체 생성시 생기는 예외처리
			ev = new EmpView();
			ev.makeGui();
			ev.addEvent();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				ev.dao.close();
			} catch (NullPointerException | SQLException e1) {
				e1.printStackTrace();
			}
		} 
	}
}
