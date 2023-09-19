package AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T4_Button extends Frame implements WindowListener, ActionListener{
	
	public T4_Button() {
		super("프레임 테스트");
		//setSize(400, 300);
		setBounds(300, 300, 400, 300); //(x,y 오른쪽 좌표)(로 창이 떨어진다)
		
		
		// 이름표(Label) :레이블 컴포넌트
		Label lbl = new Label("회 원 가 입 폼..........");
		this.add(lbl);
		
		
		// 버튼 컴포넌트
		Button btnExit = new Button("종 료"); //레이블 위에 종료버튼이 덮어씌워짐
		add(btnExit);
		
		
		setVisible(true);
		
		
	
		/*------------------------------------------------------*/
	
		btnExit.addActionListener(this); //버튼을 누르는 '행위'이기 때문에 ActionListener 사용 //다중인터페이스 
		
		addWindowListener(this); //현재 떠있는 화면 거 감시해라
	}
	
	public static void main(String[] args) {
		new T4_Button();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
