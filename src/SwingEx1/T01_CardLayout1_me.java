package SwingEx1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_CardLayout1_me extends JFrame {
	private JButton btn1, btn2, btn3, btn4;
	private JPanel pnCenter, pnSouth;
	private JLabel lbl1,lbl2,lbl3,lbl4;
	
	
	public T01_CardLayout1_me() {
		setTitle("카드레이아웃연습");
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout()); // 보더레이아웃까지 생성했다.
		
		lbl1 = new JLabel();
		lbl2 = new JLabel();
		lbl3 = new JLabel();
		lbl4 = new JLabel(); //레이블 생성
		
		lbl1.setIcon(new ImageIcon("./images/1.jpg"));
		lbl2.setIcon(new ImageIcon("./images/2.jpg"));
		lbl3.setIcon(new ImageIcon("./images/3.jpg"));
		lbl4.setIcon(new ImageIcon("./images/4.jpg"));
		
		pnCenter = new JPanel();
		pnCenter.add(lbl1);
		

		

	
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
