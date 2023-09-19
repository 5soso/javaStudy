package AWT1;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T2_WindowClose extends Frame implements WindowListener{
	
	public T2_WindowClose() {
		super("프레임 테스트");
		setSize(400, 300);
		setVisible(true);
		
		addWindowListener(this); //현재 떠있는 거 감시해라
	}
	
	public static void main(String[] args) {
		new T2_WindowClose();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) { //필요한 거 빼고 다 닫아 놓기. //실행 메소드만 만들었음. 연결해주는 거 만들어야함.
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
