package Swing3_Layout;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

//GrideLayout 연습 : 하나 빠져도 다른 버튼들이 격자 안 그자리 그대로 있음. 
@SuppressWarnings("serial")
public class T03_GridLayout_b extends JFrame{
	private JButton btn1;
	private JLabel lbl1;
	
	public T03_GridLayout_b() {
		setTitle("GrideLayout 연습");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(2,1));
		
		add(getLbl1());
		add(getBtn1());
		
//		add(getBtn6());
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setText("아아아ㅏ");
				
			}
		});
	}
	
	
	private JLabel getLbl1() {
		lbl1 = new JLabel("레이블");
		return lbl1;
	}


	private JButton getBtn1() {
		btn1 = new JButton("버튼 1");
		return btn1;
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			T03_GridLayout_b t03 = new T03_GridLayout_b();
			t03.setVisible(true);
				
			}
		});
	}
}
