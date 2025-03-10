package menubook.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookControl extends MouseAdapter implements ActionListener{

	private BookInsFrm bookInsFrm;
	private BookUpFrm bookUpFrm;
	private JTable table;
	private JDialog dialog;
	private JLabel dialogLabel;
	private BookDAO dao;
	private Vector<Vector<String>> readAllData = null;
	private Vector<String> colNames;
	private String selectedBookID;
	
	public BookControl(BookListPan bookListPan, BookInsFrm bookInsFrm, BookUpFrm bookUpFrm, 
			JDialog dialog, JLabel dialogLabel)  { 
		this.table = bookListPan.table;
		this.bookInsFrm = bookInsFrm;
		this.bookUpFrm = bookUpFrm;
		this.dialog = dialog;
		this.dialogLabel = dialogLabel;							//필요한 데이터 생성자로 받아옴
		try {
			dao = new BookDAO();								//dao로 벡터가 있는 벡터를 받아옴
		} catch( ClassNotFoundException | SQLException e ) {
//			e.printStackTrace();
			dialogOpen("도서 관리를 위한 커넥션 연결에 실패 하였습니다.");
		}
		colNames = new Vector<String>();
		colNames.add("BookID");		colNames.add("BookName");
		colNames.add("Publisher");	colNames.add("Price");
	}
	
	public void daoClose() {
		try {
			dao.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			dialogOpen("도서 관리를 위한 커넥션 종료를 실패 하였습니다.");
		}
	} // daoClose
	
	private void dialogOpen( String message ) {
		this.dialogLabel.setText(message);
		this.dialog.setVisible(true);
	} // dialogOpen
	
	public void readAll() {						//도서 목록 조회
		//1. dao.readAll();
		try {
			readAllData = dao.readAll();						//데이터를 DAO에서 가져오고 있음
		}catch(SQLException e){
			//e.printStackTrace();
			readAllData = new Vector<Vector<String>>();
			dialogOpen("도서 목록 조회에 실패 하였습니다.");
		}
		
		//2. BookListPan의 jtable에 data 입력
		DefaultTableModel model = new DefaultTableModel(readAllData, colNames);
		table.setModel(model);
	}
		
	private void insertOne() {					//도서 1개 추가
		int successCnt = 0;
		try {
			successCnt = dao.insertOne(bookInsFrm.tfBookName.getText()
					, bookInsFrm.tfPublisher.getText()
					, bookInsFrm.tfPrice.getText());
		} catch (SQLException e) {
			//e.printStackTrace(); //-디버깅 용
		}
		if(successCnt < 1) {					//입력 실패
			dialogOpen("도서 정보 입력에 실패 하였습니다.");
		} else {								//입력 성공->입력창 초기화 후 목록 조회(업데이트 반영) 
			bookInsFrm.tfBookName.setText("");
			bookInsFrm.tfPublisher.setText("");
			bookInsFrm.tfPrice.setText("");
			this.readAll();
			
		}
	}
	
	private void updateOne() {
		int successCnt = 0;
		try {
			successCnt = dao.updateOne(selectedBookID, bookUpFrm.tfBookName.getText()
					, bookUpFrm.tfPublisher.getText()
					, bookUpFrm.tfPrice.getText());
		} catch (SQLException e) {
			//e.printStackTrace(); //-디버깅 용
		}
		if(successCnt < 1) {					//수정 실패
			dialogOpen("도서 정보 수정에 실패 하였습니다.");
		} else {								//수정 후 창 닫기 & 목록 조회(업데이트 반영) 
			bookUpFrm.setVisible(false);
			this.readAll();
		}
	}
	
	private void deleteOne() {
		int successCnt = 0;
		try {
			successCnt = dao.deleteOne(selectedBookID);
		} catch (SQLException e) {
			//e.printStackTrace(); //-디버깅 용
		}
		if(successCnt < 1) {					//삭제 실패
			dialogOpen("도서 정보 삭제에 실패 하였습니다.");
		} else {								//삭제 후 창 닫기 & 목록 조회(업데이트 반영) 
			bookUpFrm.setVisible(false);
			this.readAll();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();			//버튼 누르는 부분
		if( command.equals("목록 조회") ) {				//목록 조회 버튼 누르면
			this.readAll();
		} else if( command.equals("도서 추가") ) {			//도서 추가 버튼을 누르면
			bookInsFrm.setVisible(true); 				//도서 추가 화면이 보이게
		} else if( command.equals("입력 취소") ) {
			bookInsFrm.setVisible(false); 				//도서 추가 화면이 안 보이게(안 보이게만 함)
		} else if ( command.equals("도서 저장") ) {
			this.insertOne();
		} else if ( command.equals("도서 수정") ) {
			this.updateOne();
		} else if ( command.equals("도서 삭제") ) {
			this.deleteOne();
		} else if ( command.equals("수정 취소") ) {
			bookUpFrm.setVisible(false);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIdx = table.getSelectedRow();
		Vector<String> readOne = readAllData.get(rowIdx);		//마우스 클릭하면 클릭한 행의 값을 하나 가져옴
		
		selectedBookID = readOne.get(0);
		bookUpFrm.tfBookName.setText(readOne.get(1));
		bookUpFrm.tfPublisher.setText(readOne.get(2));
		bookUpFrm.tfPrice.setText(readOne.get(3));
		bookUpFrm.setVisible(true);
	}

}
