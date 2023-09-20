package Swing2_JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow1 extends JWindow implements MouseListener { //JWindow는 컨테이너이다.
	JButton exitBtn;
	
	public T04_JWindow1() {
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
		
		exitBtn.addMouseListener(this);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow1 t04 = new T04_JWindow1(); 
				t04.setVisible(true);
				
			}
		});
	}


	@Override
	public void mouseClicked(MouseEvent e) { //마우스 클릭한 순간
		System.exit(0);
	}


	@Override
	public void mousePressed(MouseEvent e) {}  //누르는순간


	@Override
	public void mouseReleased(MouseEvent e) {}//놓는순간


	@Override
	public void mouseEntered(MouseEvent e) {} //들어가는 순간


	@Override
	public void mouseExited(MouseEvent e) {} //빠져나가는 순간
}
