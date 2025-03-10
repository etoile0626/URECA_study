package menubook.customer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustUpFrm extends JFrame{			//customer 수정 화면(update/delete)
	
	private JPanel panInsert, panButton;
	private JLabel labelName,  labelAddress, labelPhone; //label = 이름표
	protected JTextField tfName, tfAddress, tfPhone;		//접근 가능해야해서 같은 패키지에서만 접근하도록
	private JButton btnUpdate, btnDelete, btnCancel;
	
	public CustUpFrm() {
		panInsert = new JPanel();
		panButton = new JPanel();
		labelName = new JLabel("Name");
		labelAddress = new JLabel("Address");
		labelPhone= new JLabel("Phone");
		tfName = new JTextField();		
		tfAddress = new JTextField();	
		tfPhone = new JTextField();	
		btnUpdate = new JButton("고객 수정");
		btnDelete = new JButton("고객 삭제");
		btnCancel = new JButton("수정 취소");
		
		makeGui();
	}

	private void makeGui() {
		setTitle("고객 수정");
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
		panButton.add(btnUpdate);
		panButton.add(btnDelete);
		panButton.add(btnCancel);
		
	}
	
	public void addEvent(CustControl custControl) {
		btnUpdate.addActionListener(custControl);
		btnDelete.addActionListener(custControl);
		btnCancel.addActionListener(custControl);
	}
}