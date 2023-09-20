package Swing3_Layout;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//GrideLayout 연습 : 하나 빠져도 다른 버튼들이 격자 안 그자리 그대로 있음. 
@SuppressWarnings("serial")
public class T03_GridLayout extends JFrame{
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	
	public T03_GridLayout() {
		setTitle("GrideLayout 연습");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(2,3));
		
		add(getBtn1());
		add(getBtn2());
		add(getBtn3());
		add(getBtn4());
		add(getBtn5());
//		add(getBtn6());

	}
	
	
	private JButton getBtn1() {
		btn1 = new JButton("버튼 1");
		return btn1;
	}

	private JButton getBtn2() {
		btn2 = new JButton("버튼 2");
		return btn2;
	}

	private JButton getBtn3() {
		btn3 = new JButton("버튼 3");
		return btn3;
	}

	private JButton getBtn4() {
		btn4 = new JButton("버튼 4");
		return btn4;
	}

	private JButton getBtn5() {
		btn5 = new JButton("버튼 5");
		return btn5;
	}

//	private JButton getBtn6() {
//		btn6 = new JButton("버튼 6");
//		return btn6;
//	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			T03_GridLayout t03 = new T03_GridLayout();
			t03.setVisible(true);
				
			}
		});
	}
}
