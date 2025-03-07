package m2swing.level2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalcWindowEventProcessor extends WindowAdapter { //어뎁터를 extends하여 필요한 메소드만 구현
	
	@Override
	public void windowClosing(WindowEvent e) { //닫는 메소드만 구현
		System.exit(0);
	}

}
