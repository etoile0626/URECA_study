package menubook;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import menubook.book.BookControl;
import menubook.book.BookInsFrm;
import menubook.book.BookListPan;
import menubook.book.BookUpFrm;
import menubook.customer.CustControl;
import menubook.customer.CustInsFrm;
import menubook.customer.CustListPan;
import menubook.customer.CustUpFrm;
import menubook.order.OrdControl;
import menubook.order.OrdInsFrm;
import menubook.order.OrdListPan;
import menubook.order.OrdUpFrm;

/*
 * 제출해야할 프로젝트, mini 프로젝트 파일 전체로 드리기
 * 메인은 프레임, 나머지 패키지 book customer order는 패널을 가지고 있음
 */
public class Main {

	private JFrame frm;
	private CardLayout card;
	//=======================================================
	private MenuBar menuBar;
	private Menu menu1;
	private MenuItem menuItemBook, menuItemCust, menuItemOrd;
	private MenuControl menuControl;
	//=======================================================dialog에 라벨과 버튼 붙여서 추가
	private JDialog dialog;
	private JLabel dialogLabel;								//에러메세지 출력용 라벨
	private JButton dialogBtnClose;	//close용
	//=======================================================
	private BookListPan bookListPan;
	private BookInsFrm bookInsFrm;
	private BookUpFrm bookUpFrm;
	private BookControl bookControl;
	//=======================================================
	private CustListPan custListPan;						
	private CustInsFrm custInsFrm;
	private CustUpFrm custUpFrm;
	private CustControl custControl;
	//=======================================================
	private OrdListPan  ordListPan;
	private OrdInsFrm ordInsFrm;
	private OrdUpFrm ordUpFrm;
	private OrdControl ordControl;
	
	private Main(){
		frm = new JFrame("도서 판매 시스템");
		card = new CardLayout();
		//=======================================================메뉴
		menuBar =new MenuBar();
		menu1 = new Menu("선 택");
		menuItemBook = new MenuItem("도서 관리");
		menuItemCust = new MenuItem("고객 관리");
		menuItemOrd = new MenuItem("주문 관리");
		menuControl = new MenuControl(frm, card, dialog);
		//=======================================================
		//modal-true면 알람을 닫기 전까지 프레임 접근 금지(현업가서도 쓰는 개념)
		dialog = new JDialog(frm, "알림", true);		//dialog의 부모프레임, 메세지, modal
		dialogLabel = new JLabel("");				//에러 메서지 표시용
		dialogBtnClose = new JButton("알림 닫기");
		//=======================================================book 관련 화면
		bookListPan = new BookListPan();
		bookInsFrm = new BookInsFrm();
		bookUpFrm = new BookUpFrm();
		//=======================================================cust 관련화면
		custListPan = new CustListPan();
		custInsFrm = new CustInsFrm();
		custUpFrm = new CustUpFrm();
		//=======================================================order 관련 화면
		ordListPan = new OrdListPan();
		ordInsFrm = new OrdInsFrm();
		ordUpFrm = new OrdUpFrm();
	}
	
	private void makeGui() {
		frm.setSize(500, 500);
		//=======================================================메뉴
		frm.setMenuBar(menuBar);
		menuBar.add(menu1);
		menu1.add(menuItemBook);	menu1.addSeparator();
		menu1.add(menuItemCust);	menu1.addSeparator();
		menu1.add(menuItemOrd);
		//=======================================================각 패널 프레임에 붙이기
		frm.setLayout(card);									//	(카드레이아웃으로)
		frm.add(bookListPan, "BookList");
		frm.add(custListPan, "CustList");
		frm.add(ordListPan, "OrdList");
		//=======================================================
		dialog.setSize(300, 100);
		dialog.setLayout( new GridLayout(2,1) );
		dialog.add(dialogLabel);
		dialog.add(dialogBtnClose);
		//=======================================================
		frm.setVisible(true);
	}
	
	private void addEvent() {
		dialogBtnClose.addActionListener(menuControl);
		menuItemBook.addActionListener(menuControl);	//각 패널의 이벤트 처리를 메뉴 컨트롤에서(버튼처럼 동작)
		menuItemCust.addActionListener(menuControl);
		menuItemOrd.addActionListener(menuControl);
		//=======================================================
				// Anonymous Inner Class
		frm.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						bookControl.daoClose();
						custControl.daoClose();
						ordControl.daoClose();
						System.exit(0);
					}
				}
		);
		
		bookControl = new BookControl(bookListPan, bookInsFrm, bookUpFrm, dialog, dialogLabel);
		bookListPan.addEvent(bookControl);
		bookInsFrm.addEvent(bookControl);
		bookUpFrm.addEvent(bookControl);
		//=======================================================
		custControl = new CustControl(custListPan, custInsFrm, custUpFrm, dialog, dialogLabel);
		custListPan.addEvent(custControl);
		custInsFrm.addEvent(custControl);
		custUpFrm.addEvent(custControl);
		//=======================================================
		ordControl= new OrdControl(ordListPan, ordInsFrm, ordUpFrm, dialog, dialogLabel);
		ordListPan.addEvent(ordControl);
		ordInsFrm.addEvent(ordControl);
		ordUpFrm.addEvent(ordControl);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.makeGui();
		m.addEvent();
	}

}
