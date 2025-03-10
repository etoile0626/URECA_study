package menubook;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class MenuControl implements ActionListener{ //메뉴 컨트롤러는 버튼과 동일하게 동작->액션리스너 받아옴

	private CardLayout card;
	private JFrame frm;
	private JDialog dialog;					//에러 알람용
	
	public MenuControl() {}
	public MenuControl(JFrame frm, CardLayout card, JDialog dialog){
		this.frm = frm;
		this.card = card;
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	//메뉴들에 대한 컨트롤
		String command = e.getActionCommand();
		
		if(command.equals("도서 관리")) {
			card.show(frm.getContentPane(), "BookList"); //frm.???에서 ???는 패널의 별칭(이름)
		}else if(command.equals("고객 관리")) {
			card.show(frm.getContentPane(), "CustList"); //고객 관리 메뉴가 눌리면 고객관리 화면이 뜨도록
		}else if(command.equals("주문 관리")) {
			card.show(frm.getContentPane(), "OrdList");	//주문 관리 메뉴가 눌리면 고객관리 화면이 뜨도록
		}else if( command.equals("알림 닫기") ) {			//알람 끄는 이벤트
			dialog.setVisible(false);
		}
		
	}

}
