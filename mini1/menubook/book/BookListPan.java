package menubook.book;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BookListPan extends JPanel {
	
	private JPanel pan;
	private JButton btnAdd, btnReadAll;
	private BorderLayout border;
	protected JTable table;
	private JScrollPane scrollPan;
	
	public BookListPan() {
		pan = new JPanel();
		btnAdd = new JButton("도서 추가");
		btnReadAll = new JButton("목록 조회");
		border = new BorderLayout();
		table = new JTable();						//테이블에 
		scrollPan = new JScrollPane(table);			//데이터가 늘어나면 자동으로 스크롤로 늘리려고 생성
		//==================================
		makeGui();									//생성자에서 gui를 만들도록 설정
	}
	
	public void makeGui() {
		setLayout(border);
		setSize(500, 500);
		add(scrollPan, BorderLayout.CENTER);
		add(pan, BorderLayout.SOUTH);
		pan.add(btnAdd);
		pan.add(btnReadAll);
		setVisible(true);
	}
	
	public void addEvent(BookControl bookControl) {
		btnAdd.addActionListener(bookControl);				//도서 추가 버튼
		btnReadAll.addActionListener(bookControl);			//목록 조회 버튼
		table.addMouseListener(bookControl);               	//마우스 모션 감지
	}
}
