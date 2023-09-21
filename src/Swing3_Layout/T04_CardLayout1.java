package Swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/* 
 	CardLayout 사용법
	카드레이아웃 제어 메솓, : first(), last(), next(), show()
	first() : 첫번째 카드 보이기
	last() : 마지막 카드 보이기
	next() : 다음 카드 보이기
	show() : 지정된 카드 보이기
*/
@SuppressWarnings("serial")
public class T04_CardLayout1 extends JFrame {
	private JPanel pn1, pn2, pn3;
	
	public T04_CardLayout1() {
		setTitle("CardLayout 연습");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CardLayout card = new CardLayout();
		//setLayout(new CardLayout());
		setLayout(card);
		
		
//		pn1 = new JPanel();
//		pn1.setBackground(Color.RED); //열거형은 대문자로 사용하기

		pn2 = new JPanel();
		pn2.setBackground(Color.GREEN);
		pn2.setName("green");
		
		add("mint",getPn1());
		add(pn2); //카드레이아웃은 먼저 만들어진 것을 보여준다. 그다음 만든 판넬을 보기 위해서는 어떤 명령을 해줘야한다. 
		add("yellow",getP3());
	
	/*----------------------------------------------------------------------------------------------------------*/
	
		addMouseListener(new MouseAdapter() { // 구현메소드가 너무 많을 때, 리스너를 꺼내놓고, 필요한 거 하나만 두고 다 지운후, Adapter를 쓴다.
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(getContentPane());
			}
		});
	}

	
	private JPanel getP3() {
		pn3 = new JPanel();
		pn3.setBackground(Color.YELLOW);
		return pn3;
	}


	private JPanel getPn1() { //메소드를 따로 빼줌..
		pn1 = new JPanel();
		//pn1.setBackground(Color.RED);
		pn1.setBackground(new Color(117,253,255)); //Color(r,g,b) : 0번부터 255번까지 마음대로 사용 가능하다.
		return pn1;
		
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout1 t04 = new T04_CardLayout1();
				t04.setVisible(true);
			}
		});
	}
}
