package m2swing.level1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Layout : 컴포넌트 배치를 위한 디자인 가이드
 * BoardLayout의 예
 * BoardLayout : 동 서 남 북 중앙으로 컴포넌트를 배치, frame 객체의 기본 레이아웃
 */
public class L1Frame3 {
	
	private JFrame frm;
	private JButton btn;
	private JPanel pan1, pan2, pan3, pan4, pan5;
	private WindowEventProcessor winEcentProc;
	
	public L1Frame3() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다");
		btn = new JButton("버튼 이름은 여기에");
		pan1 = new JPanel(); pan1.setBackground(Color.blue);
		pan2 = new JPanel(); pan2.setBackground(Color.DARK_GRAY);
		pan3 = new JPanel(); pan3.setBackground(Color.pink);
		pan4 = new JPanel(); pan4.setBackground(Color.green);
		pan5 = new JPanel(); pan5.setBackground(Color.orange);
		winEcentProc = new WindowEventProcessor();
	}
	
	public void makeGui() {
		frm.setSize(500, 500);
		pan1.add(btn);
		frm.add(pan1, BorderLayout.SOUTH);
		frm.add(pan2, BorderLayout.CENTER);
		frm.add(pan3, BorderLayout.WEST);
		frm.add(pan4, BorderLayout.EAST);
		frm.add(pan5, BorderLayout.NORTH);
		frm.setVisible(true);				//visible 해줘야 나옴
	}
	
	public void addEvent() {			//이게 이벤트 처리의 하나의 포맷
		frm.addWindowListener(winEcentProc);
	}
	
	public static void main(String[] args) {
		L1Frame3 test = new L1Frame3();
		test.makeGui();
		test.addEvent();
	}

}
