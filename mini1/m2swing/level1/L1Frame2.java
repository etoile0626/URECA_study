package m2swing.level1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * addEvent 개선의 예
 */
public class L1Frame2 {
	
	private JFrame frm;
	private WindowEventProcessor winEcentProc;
	
	public L1Frame2() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다");
		winEcentProc = new WindowEventProcessor();
	}
	
	public void makeGui() {
		frm.setSize(500, 500);
		frm.setVisible(true);				//visible 해줘야 나옴
	}
	
	public void addEvent() {			//이게 이벤트 처리의 하나의 포맷
		frm.addWindowListener(winEcentProc);
	}
	
	public static void main(String[] args) {
		L1Frame2 test = new L1Frame2();
		test.makeGui();
		test.addEvent();
	}

}
