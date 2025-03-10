package menubook.book;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookInsFrm extends JFrame{			//book 입력 화면(Insert)
	
	//bookID는 자동증가하게 테이블 옵션을 바꿨음
	private JPanel panInsert, panButton;
	private JLabel labelBookName,  labelPublisher, labelPrice; //label = 이름표
	protected JTextField tfBookName, tfPublisher, tfPrice;		//접근 가능해야해서 같은 패키지에서만 접근하도록
	private JButton btnSave, btnCancel;
	
	public BookInsFrm() {
		panInsert = new JPanel();
		panButton = new JPanel();
		labelBookName = new JLabel("BookName");
		labelPublisher = new JLabel("Publisher");
		labelPrice= new JLabel("Price");
		tfBookName = new JTextField();		
		tfPublisher = new JTextField();	
		tfPrice = new JTextField();	
		btnSave = new JButton("도서 저장");
		btnCancel = new JButton("입력 취소");
		
		makeGui();
	}

	private void makeGui() {
		setTitle("도서 정보 입력");
		setSize(500, 500);
		//===================================
		add(panInsert, BorderLayout.CENTER);
		panInsert.setLayout(null);			//null 레이아웃 => 좌표를 찍어 붙여야함
		panInsert.add(labelBookName);		labelBookName.setBounds(10, 10, 100, 35);
		panInsert.add(labelPublisher);		labelPublisher.setBounds(10, 50, 100, 35);
		panInsert.add(labelPrice);			labelPrice.setBounds(10, 90, 100, 35);
		panInsert.add(tfBookName);			tfBookName.setBounds(120, 10, 300, 35);
		panInsert.add(tfPublisher);			tfPublisher.setBounds(120, 50, 300, 35);
		panInsert.add(tfPrice);				tfPrice.setBounds(120, 90, 300, 35);
		//===================================
		add(panButton, BorderLayout.SOUTH);
		panButton.add(btnSave);
		panButton.add(btnCancel);
		
		
		//setvisiable은 이벤트를 통해
	}
	
	public void addEvent(BookControl bookControl) {
		btnCancel.addActionListener(bookControl);
		btnSave.addActionListener(bookControl);
	}
}
