package Swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow2 extends JWindow { //JWindow는 컨테이너이다.
	JButton exitBtn;
	
	public T04_JWindow2() {
		setSize(600,350);
		
		exitBtn = new JButton("종료");
		add(exitBtn);
		
//		exitBtn.addActionListener(new ActionListener() { 버튼의 감시자 이용해서 직접 처리하기.
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//				
//			}
//		});
		
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0); 완전히 끝낼 때 씀, 번호주기 0번...1번...
				
				//setVisible(false); 잠시 가릴 때 쓴다. 현재 스레드 끝낸 게 아니라 닫아줌. 윈도우에서 사용
				dispose(); //객체가 메모리에서 소멸된다.(밑에 생성한 객체 없어짐) 다른 것은 떠있음
			}
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow2 t04 = new T04_JWindow2(); 
				t04.setVisible(true);
			}
		});
	}

}
