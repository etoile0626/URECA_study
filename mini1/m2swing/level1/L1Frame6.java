package m2swing.level1;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * nullLayout의 예
 * 좌표값을 할용하여 컴포넌트 배치
 */
public class L1Frame6 {
	
	private JFrame frm;
	private JTextField tf1, tf2;
	private JButton btn1, btn2; 
	private WindowEventProcessor winEcentProc;
	private ActionEventProcessor actionEventProc;
	
	public L1Frame6() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다");
		tf1 = new JTextField();
		tf2 = new JTextField();
		btn1 = new JButton("ToDown");
		btn2 = new JButton("ToUp");
		winEcentProc = new WindowEventProcessor();
		actionEventProc = new ActionEventProcessor(tf1, tf2);
	}
	
	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(null);
		tf1.setBounds(10, 20, 200, 30);
		frm.add(tf1);
		tf2.setBounds(10, 70, 200, 30);
		frm.add(tf2);
		btn1.setBounds(240, 20, 100, 30);
		frm.add(btn1);
		btn2.setBounds(240, 70, 100, 30);
		frm.add(btn2);
		frm.setVisible(true);				//visible 해줘야 나옴
	}
	
	public void addEvent() {			//이게 이벤트 처리의 하나의 포맷
		frm.addWindowListener(winEcentProc);
		btn1.addActionListener(actionEventProc);
		btn2.addActionListener(actionEventProc);
	}
	
	public static void main(String[] args) {
		L1Frame6 test = new L1Frame6();
		test.makeGui();
		test.addEvent();
	}

}
