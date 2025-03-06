package m2swing.level1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * AWT : Abstract Window Toolkit : GUI 만드는 도구
 */
public class L1Frame {
	
	private JFrame frm;
	
	public L1Frame() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다");
	}
	
	public void makeGui() {
		frm.setSize(500, 500);
		frm.setVisible(true);				//visible 해줘야 나옴
	}
	
	public void addEvent() {			//이게 이벤트 처리의 하나의 포맷
		frm.addWindowListener(				//동작 감지 센서 같은거라 보면 됨?
				new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);			//0은 정상을 표시하는 약속된 숫자
					}
				}
			);
	}
	
	public static void main(String[] args) {
		L1Frame test = new L1Frame();
		test.makeGui();
		test.addEvent();
	}

}
