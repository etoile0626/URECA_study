package menubook.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustControl extends MouseAdapter implements ActionListener{

	private CustInsFrm custInsFrm;
	private CustUpFrm custUpFrm;
	private JTable table;
	private JDialog dialog;
	private JLabel dialogLabel;
	private CustDAO dao;
	private Vector<Vector<String>> readAllData = null;
	private Vector<String> colNames;
	private String selectedCustID;
	
	public CustControl(CustListPan custListPan, CustInsFrm custInsFrm, CustUpFrm custUpFrm, 
			JDialog dialog, JLabel dialogLabel)  { 
		this.table = custListPan.table;
		this.custInsFrm = custInsFrm;
		this.custUpFrm = custUpFrm;
		this.dialog = dialog;
		this.dialogLabel = dialogLabel;							//필요한 데이터 생성자로 받아옴
		try {
			dao = new CustDAO();								//dao로 벡터가 있는 벡터를 받아옴
		} catch( ClassNotFoundException | SQLException e ) {
//			e.printStackTrace();
			dialogOpen("도서 관리를 위한 커넥션 연결에 실패 하였습니다.");
		}
		colNames = new Vector<String>();
		colNames.add("CustID");		colNames.add("Name");
		colNames.add("Address");	colNames.add("Phone");
	}
	
	public void daoClose() {
		try {
			dao.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			dialogOpen("고객 관리를 위한 커넥션 종료를 실패 하였습니다.");
		}
	} // daoClose
	
	private void dialogOpen( String message ) {
		this.dialogLabel.setText(message);
		this.dialog.setVisible(true);
	} // dialogOpen
	
	public void readAll() {						//고객 목록 조회
		//1. dao.readAll();
		try {
			readAllData = dao.readAll();						//데이터를 DAO에서 가져오고 있음
		}catch(SQLException e){
			//e.printStackTrace();
			readAllData = new Vector<Vector<String>>();
			dialogOpen("고객 목록 조회에 실패 하였습니다.");
		}
		
		//2. BookListPan의 jtable에 data 입력
		DefaultTableModel model = new DefaultTableModel(readAllData, colNames);
		table.setModel(model);
	}
		
	private void insertOne() {					//고객 1명 추가
		int successCnt = 0;
		try {
			successCnt = dao.insertOne(custInsFrm.tfName.getText()
					, custInsFrm.tfAddress.getText()
					, custInsFrm.tfPhone.getText());
		} catch (SQLException e) {
			//e.printStackTrace(); //-디버깅 용
		}
		if(successCnt < 1) {					//입력 실패
			dialogOpen("고객 정보 입력에 실패 하였습니다.");
		} else {								//입력 성공->입력창 초기화 후 목록 조회(업데이트 반영) 
			custInsFrm.tfName.setText("");
			custInsFrm.tfAddress.setText("");
			custInsFrm.tfPhone.setText("");
			this.readAll();
			
		}
	}
	
	private void updateOne() {
		int successCnt = 0;
		try {
			successCnt = dao.updateOne(selectedCustID, custUpFrm.tfName.getText()
					, custUpFrm.tfAddress.getText()
					, custUpFrm.tfPhone.getText());
		} catch (SQLException e) {
			//e.printStackTrace(); //-디버깅 용
		}
		if(successCnt < 1) {					//수정 실패
			dialogOpen("고객 정보 수정에 실패 하였습니다.");
		} else {								//수정 후 창 닫기 & 목록 조회(업데이트 반영) 
			custUpFrm.setVisible(false);
			this.readAll();
		}
	}
	
	private void deleteOne() {
		int successCnt = 0;
		try {
			successCnt = dao.deleteOne(selectedCustID);
		} catch (SQLException e) {
			//e.printStackTrace(); //-디버깅 용
		}
		if(successCnt < 1) {					//삭제 실패
			dialogOpen("고객 정보 삭제에 실패 하였습니다.");
		} else {								//삭제 후 창 닫기 & 목록 조회(업데이트 반영) 
			custUpFrm.setVisible(false);
			this.readAll();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();			//버튼 누르는 부분
		if( command.equals("목록 조회") ) {				//목록 조회 버튼 누르면
			this.readAll();
		} else if( command.equals("고객 추가") ) {			//도서 추가 버튼을 누르면
			custInsFrm.setVisible(true); 				//도서 추가 화면이 보이게
		} else if( command.equals("입력 취소") ) {
			custInsFrm.setVisible(false); 				//도서 추가 화면이 안 보이게(안 보이게만 함)
		} else if ( command.equals("고객 저장") ) {
			this.insertOne();
		} else if ( command.equals("고객 수정") ) {
			this.updateOne();
		} else if ( command.equals("고객 삭제") ) {
			this.deleteOne();
		} else if ( command.equals("수정 취소") ) {
			custUpFrm.setVisible(false);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIdx = table.getSelectedRow();
		Vector<String> readOne = readAllData.get(rowIdx);		//마우스 클릭하면 클릭한 행의 값을 하나 가져옴
		
		selectedCustID = readOne.get(0);
		custUpFrm.tfName.setText(readOne.get(1));
		custUpFrm.tfAddress.setText(readOne.get(2));
		custUpFrm.tfPhone.setText(readOne.get(3));
		custUpFrm.setVisible(true);
	}

}
