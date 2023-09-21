package 복습;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_CardLayout4 extends JFrame {
	private JButton btn1, btn2, btn3, btn4;
	
	public T04_CardLayout4() {
		setTitle("카드레이아웃4 연습");
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CardLayout card = new CardLayout();
		setLayout(card);
		
		btn1 = new JButton("킁");
		btn2 = new JButton("킁킁");
		btn3 = new JButton("긍긍긍");
		btn4 = new JButton("왈!");
		
		btn1.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		btn2.setIcon(new ImageIcon(getClass().getResource("./images/2.jpg")));
		btn3.setIcon(new ImageIcon(getClass().getResource("./images/3.jpg")));
		btn4.setIcon(new ImageIcon(getClass().getResource("./images/4.jpg")));
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		/*============================================================================*/
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());;
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());;
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());;
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());;
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout4 t04 = new T04_CardLayout4();
				t04.setVisible(true);
			}
		});
	}
}
