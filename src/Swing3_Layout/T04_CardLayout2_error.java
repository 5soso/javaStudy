package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class T04_CardLayout2_error extends JFrame {
	private JPanel pnb1, pnb2, pnb3, pn1, pn2, pn3;
	private JButton btn1, btn2;
	private JLabel lbl1;
	
	public T04_CardLayout2_error() {
		setTitle("CardLayout 연습");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		//BorderLayout blayer = new BorderLayout();  
		
		pnb1 = new JPanel();
		//pnb1.setBackground(Color.ORANGE);
		pnb2 = new JPanel();
		pnb2.setBackground(Color.BLUE);
		
		CardLayout card = new CardLayout(); //Border레이아웃 센터에 Card레이아웃을 집어 넣기 위해서  생성
		//setLayout(new CardLayout()); //콘텐트팬에 들어간다.
		
//		lbl1 = new JLabel();
//		lbl1.setText("이곳은 레이블입니다."); // 같은 표현 => lbl1 = new JLabel("이곳은 레이블입니다.");
//		
//		pnb3 = new JPanel();
//		pnb3.add(lbl1);

		
		pnb1.setLayout(card);
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		
		pnb2.add(btn1);
		pnb2.add(btn2); //컴포넌트가 팬널에 올라감 -> 레이아웃에 줘야함.
		
		add(pnb1, BorderLayout.CENTER); //제일 밑에 콘텐트팬 - 보더레이아웃 - 팬널1번(카드레이아웃을 담았음) - 오렌지색깔이 나옴.
		add(pnb2, BorderLayout.SOUTH);

	/*----------------------------------------------------------------------------------------------------------*/
	
		addMouseListener(new MouseAdapter() { // 구현메소드가 너무 많을 때, 리스너를 꺼내놓고, 필요한 거 하나만 두고 다 지운후, Adapter를 쓴다.
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(getContentPane());
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout2_error t04 = new T04_CardLayout2_error();
				t04.setVisible(true);
			}
		});
	}
}
