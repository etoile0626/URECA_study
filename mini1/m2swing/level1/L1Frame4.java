package m2swing.level1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Layout : 컴포넌트 배치를 위한 디자인 가이드
 * flowLayout의 예
 * flowLayout : 흐르는데로(좌->우/위->아래) 컴포넌트 배치
 */
public class L1Frame4 {
	
	private JFrame frm;
	private FlowLayout flow;
	private JButton btn1, btn2;
	private WindowEventProcessor winEcentProc;
	
	public L1Frame4() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다");
		flow = new FlowLayout();
		btn1 = new JButton("버튼 이름은 여기에");
		btn2 = new JButton("rjqn");
		winEcentProc = new WindowEventProcessor();
	}
	
	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(flow);
		frm.add(btn1);
		frm.add(btn2);
		frm.setVisible(true);				//visible 해줘야 나옴
	}
	
	public void addEvent() {			//이게 이벤트 처리의 하나의 포맷
		frm.addWindowListener(winEcentProc);
	}
	
	public static void main(String[] args) {
		L1Frame4 test = new L1Frame4();
		test.makeGui();
		test.addEvent();
	}

}
