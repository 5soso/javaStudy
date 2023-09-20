package AWT2_Adaptor;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_Closing2 extends Frame {
	Button btnExit;
	
	public T1_Closing2() { // 이 객체가 생성할 때 타이틀을 준다
		super("어댑터 활용"); // 부모창 frame에 올라간다.
		this.setBounds(300, 250, 300, 350);
		
		btnExit = new Button("종  료");
		this.add(btnExit);
		
		this.setVisible(true);
		
		///////////////////////////////////////////////////////////////////
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { //여기서 e는 에러메세지e 가 아닌 event이다.
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T1_Closing2();
	}

}
