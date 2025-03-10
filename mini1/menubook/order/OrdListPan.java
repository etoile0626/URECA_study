package menubook.order;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrdListPan extends JPanel {

	private JPanel pan;
	private JButton btnAdd, btnReadAll;
	private BorderLayout border;
	protected JTable table;
	private JScrollPane scrollPan;

	public OrdListPan() {
		pan = new JPanel();
		btnAdd = new JButton("주문 추가");
		btnReadAll = new JButton("목록 조회");
		border = new BorderLayout();
		table = new JTable();
		table.setName("ListTable");
		scrollPan = new JScrollPane(table);
		//==================================
		makeGui();
	}

	public void makeGui() {
		setLayout(border);
		setSize(500, 500);
		add(scrollPan, BorderLayout.CENTER);
		add(pan, BorderLayout.SOUTH);
		pan.add(btnAdd);
		pan.add(btnReadAll);
		setVisible(true);
	} // makeGui

	public void addEvent(OrdControl ordControl) {
		btnAdd.addActionListener(ordControl);				//도서 추가 버튼
		btnReadAll.addActionListener(ordControl);			//목록 조회 버튼
		table.addMouseListener(ordControl);               	//마우스 모션 감지
	} // addEvent

} // class
