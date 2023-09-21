package SwingEx1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_CardLayout1_me extends JFrame {
	private JButton btn1, btn2, btn3, btn4;
	
	
	public T01_CardLayout1_me() {
		setTitle("카드레이아웃연습");
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		
		

	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T01_CardLayout1_me t01 = new T01_CardLayout1_me();
				t01.setVisible(true);
			}
		});
	}
}
