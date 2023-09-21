package Swing3_Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//GrideLayout 연습 : 하나 빠져도 다른 버튼들이 격자 안 그자리 그대로 있음. 
@SuppressWarnings("serial")
public class T03_GridLayout2 extends JFrame{ 
	private JButton[][] btn; //같은 타입, 똑같은 내용 = 배열로 줄 수 있음.
	private JButton btn6;
	
	public T03_GridLayout2() {
		setTitle("GrideLayout 연습");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(2,3));
		
		for(int r=0; r<2; r++) { //2행
			for(int c=0; c<3; c++) { //3열
				add(getBtn()[r][c]);
			}
		}
		
//		add(getBtn1());
//		add(getBtn2());
//		add(getBtn3());
//		add(getBtn4());
//		add(getBtn5());
		add(getBtn6());

	}
	
	private JButton getBtn6() {
		btn6 = new JButton();
		return btn6;
	}

	private JButton[][] getBtn() {
		int cnt = 1;
		btn = new JButton[2][3];
		for(int r=0; r<2; r++) {
			for(int c=0; c<3; c++) {
				btn[r][c] = new JButton("버튼"+cnt);
				cnt++;
			}
		}
		return btn;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			T03_GridLayout2 t03 = new T03_GridLayout2();
			t03.setVisible(true);
			}
		});
	}
}
