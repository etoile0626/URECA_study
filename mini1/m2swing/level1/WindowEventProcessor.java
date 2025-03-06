package m2swing.level1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventProcessor implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened(열리고 나서 일어남)");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("closing(닫는 중에 일어남)");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("closed(닫히고 나서 일어남-완전히 닫히기 전에 종료하면 얘가 실행 안됨)");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified(최소화됐을때)");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified(다시 화면이 커졌을때)");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated - focus 획득");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated - focus 상실");
	}

}
