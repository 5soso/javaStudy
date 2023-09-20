package Swing2_JFrame;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow5 extends JWindow { //JWindow는 컨테이너이다.
	JLabel lblImg;
	
	public T04_JWindow5() {
		setSize(600,350);
		
		//lblImg = new JLabel("안녕하세요.");
		//lblImg = new JLabel("안녕하세요.");
		//add(lblImg);
		
		lblImg = new JLabel(); 
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		add(lblImg);
		
		setLocationRelativeTo(null); // 화면 가운데 view(window) 배치하기
		 
		addMouseListener(new MouseAdapter() { // 화면에 있는 마우스에 있는 것을 제어할때는 변수명 안 쓴다.
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				dispose(); //객체가 메모리에서 소멸된다. = 스레드를 날린다. 그래서 속도가 느리다.(밑에 생성한 객체 없어짐) 다른 것은 떠있음 
			}
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow5 t05 = new T04_JWindow5(); 
				t05.setVisible(true);
			}
		});
	}

}
