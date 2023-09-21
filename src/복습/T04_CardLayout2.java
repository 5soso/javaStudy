package 복습;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_CardLayout2 extends JFrame {
	private JPanel  pnb2, pnb3;
	private JButton btn1, btn2;
	private JLabel lbl1;
	
	public T04_CardLayout2() {
		setTitle("카드레이아웃 연습2");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
	
		pnb2 = new JPanel();
		pnb2.setBackground(Color.BLUE);
		pnb3 = new JPanel();
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		
		pnb3.add(btn1);
		pnb3.add(btn2);
		
		add(getLbl1(), BorderLayout.CENTER);
		add(pnb3, BorderLayout.SOUTH);
		
		/* ------------------------------------------------------- */
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

	private JLabel getLbl1() {
		lbl1 = new JLabel();
		lbl1.setIcon(new ImageIcon(getClass().getResource("./images/11.jpg")));
		return lbl1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout2 t04 = new T04_CardLayout2();
				t04.setVisible(true);
			}
		});
	}
}
