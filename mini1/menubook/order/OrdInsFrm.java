package menubook.order;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class OrdInsFrm extends JFrame{			//book 입력 화면(Insert)
	
	//orderID는 자동증가하게 테이블 옵션을 바꿨음
	private JPanel panInsert, panButton;
	//==================================
	private JLabel labelName;
	protected JTextField tfName;
	private JButton btnCustSearch;
	protected JTable custTable;
	private JScrollPane custScrollPan;
	//==================================
	private JLabel labelBookName;
	protected JTextField tfBookName;
	private JButton btnBookSearch;
	protected JTable bookTable;
	private JScrollPane bookScrollPan;
	//==================================
	private JLabel labelSalePrice;
	protected JTextField tfSalePrice;
	//==================================
	private JButton btnSave, btnCancel;
	
	public OrdInsFrm() {
		panButton = new JPanel();
		panInsert = new JPanel();
		//==================================
		labelName = new JLabel("Name");
		tfName = new JTextField();
		btnCustSearch = new JButton("고객 검색");
		custTable = new JTable();
		custTable.setName("CustTable");
		custScrollPan = new JScrollPane(custTable);
		//==================================
		labelBookName = new JLabel("BookName");
		tfBookName = new JTextField();
		btnBookSearch = new JButton("도서 검색");
		bookTable = new JTable();
		bookTable.setName("BookTable");
		bookScrollPan = new JScrollPane(bookTable);
		//==================================
		labelSalePrice = new JLabel("SalePrice");
		tfSalePrice = new JTextField();
		//==================================
		btnSave = new JButton("주문 저장");
		btnCancel = new JButton("입력 취소");
		
		makeGui();
	}

	private void makeGui() {
		setTitle("주문 정보 입력");
		setSize(500, 500);
		//==================================
		add(panInsert, BorderLayout.CENTER);
		panInsert.setLayout(null);
		//==================================
		panInsert.add(labelName);		labelName.setBounds(10, 10, 100, 35);
		panInsert.add(tfName);			tfName.setBounds(120, 10, 200, 35);
		panInsert.add(btnCustSearch);	btnCustSearch.setBounds(330, 10, 90, 35);
		panInsert.add(custScrollPan);	custScrollPan.setBounds(10, 50, 410, 75);
		//==================================
		panInsert.add(labelBookName);	labelBookName.setBounds(10, 130, 100, 35);
		panInsert.add(tfBookName);		tfBookName.setBounds(120, 130, 200, 35);
		panInsert.add(btnBookSearch);	btnBookSearch.setBounds(330, 130, 90, 35);
		panInsert.add(bookScrollPan);	bookScrollPan.setBounds(10, 170, 410, 75);
		//==================================
		panInsert.add(labelSalePrice);	panInsert.add(tfSalePrice);
		labelSalePrice.setBounds(10, 250, 100, 35);
		tfSalePrice.setBounds(120, 250, 300, 35);
		//==================================
		add(panButton, BorderLayout.SOUTH);
		panButton.add(btnSave);	panButton.add(btnCancel);
		
		//setvisiable은 이벤트를 통해
	}
	
	public void addEvent(OrdControl ordControl) {
		btnBookSearch.addActionListener(ordControl);
		btnCustSearch.addActionListener(ordControl);
		bookTable.addMouseListener(ordControl);
		custTable.addMouseListener(ordControl);
		btnSave.addActionListener(ordControl);
		btnCancel.addActionListener(ordControl);
	}
}
