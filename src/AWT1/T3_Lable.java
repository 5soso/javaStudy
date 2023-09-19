package AWT1;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T3_Lable extends Frame implements WindowListener{
	
	public T3_Lable() {
		super("프레임 테스트");
		setSize(400, 300);
		
		//이름(Label)
		Label lbl = new Label("회 원 가 입 폼");
		this.add(lbl);
		
		setVisible(true);
		
		
		//디자인
		/*------------------------------------------------------*/
		//감시자
		
		addWindowListener(this); //현재 떠있는 화면 거 감시해라
	}
	
	public static void main(String[] args) {
		new T3_Lable();
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
