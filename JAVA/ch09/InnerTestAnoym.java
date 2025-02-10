package ch09;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerTestAnoym {
	
	Frame frm;
	
	public InnerTestAnoym() {
		frm = new Frame("Anoymous Inner Class Test");
	}
	
	public void makeGUI() {
		frm.setSize(500, 500);
		frm.setBackground(Color.PINK);
		frm.setVisible(true);
		frm.addWindowListener(
				new WindowAdapter() { //anoymous inner class, 한 번쓰기위해 만드는 클래스
				
				public void windowClosing(WindowEvent e) {
					System.out.println("Window close");
					System.exit(0);
				}//windowclosing
				}//new
			); //addWindowListener
	}//makeGUI
	
	public static void main(String[] args) {
		
		InnerTestAnoym anoym = new InnerTestAnoym();
		anoym.makeGUI();
		
	}

}
