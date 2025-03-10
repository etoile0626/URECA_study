package menubook.customer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustInsFrm extends JFrame{			//customer 입력 화면(Insert)
	
	//bookID는 자동증가하게 테이블 옵션을 바꿨음
	private JPanel panInsert, panButton;
	private JLabel labelName,  labelAddress, labelPhone; //label = 이름표
	protected JTextField tfName, tfAddress, tfPhone;		//접근 가능해야해서 같은 패키지에서만 접근하도록
	private JButton btnSave, btnCancel;
	
	public CustInsFrm() {
		panInsert = new JPanel();
		panButton = new JPanel();
		labelName = new JLabel("Name");
		labelAddress = new JLabel("Address");
		labelPhone= new JLabel("Phone");
		tfName = new JTextField();		
		tfAddress = new JTextField();	
		tfPhone = new JTextField();	
		btnSave = new JButton("고객 저장");
		btnCancel = new JButton("입력 취소");
		
		makeGui();
	}

	private void makeGui() {
		setTitle("고객 정보 입력");
		setSize(500, 500);
		//===================================
		add(panInsert, BorderLayout.CENTER);
		panInsert.setLayout(null);			//null 레이아웃 => 좌표를 찍어 붙여야함
		panInsert.add(labelName);			labelName.setBounds(10, 10, 100, 35);
		panInsert.add(labelAddress);		labelAddress.setBounds(10, 50, 100, 35);
		panInsert.add(labelPhone);			labelPhone.setBounds(10, 90, 100, 35);
		panInsert.add(tfName);				tfName.setBounds(120, 10, 300, 35);
		panInsert.add(tfAddress);			tfAddress.setBounds(120, 50, 300, 35);
		panInsert.add(tfPhone);				tfPhone.setBounds(120, 90, 300, 35);
		//===================================
		add(panButton, BorderLayout.SOUTH);
		panButton.add(btnSave);
		panButton.add(btnCancel);
		
		
		//setvisiable은 이벤트를 통해
	}
	
	public void addEvent(CustControl custControl) {
		btnCancel.addActionListener(custControl);
		btnSave.addActionListener(custControl);
	}
}
