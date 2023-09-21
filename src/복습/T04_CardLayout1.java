package 복습;

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
	
	public T04_CardLayout1() { //스레드 생성?
		setTitle("카드레이아웃 연습"); //제일 윗줄 제목창
		setSize(250,400); //창의 세로, 가로 길이
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기
		setLocationRelativeTo(null); // 윈도우 창을 가운데로 띄움 
		
		CardLayout card = new CardLayout(); //카드 레이아웃 생성
		setLayout(card); //카드레이아웃을 붙여라.
		
		//pn1 = new JPanel(); 패널1을 객체로 생성하여 변수를 선언함
		//pn1.setBackground(Color.BLUE);

		pn2 = new JPanel();
		pn2.setBackground(Color.YELLOW);
		
		add("bule", getPn1()); // ContentPane에 패널1을 붙여라. 근데 ContentPane 위에 CardLayout이 있음. 즉 CarLayout에 패널이 붙음.
		add(pn2);
		
		add("yellow", getPn3());
		
		/*---------------------------------------------------------------------*/
		
		addMouseListener(new MouseAdapter() { //마우스 감시자 생성
			@Override
			public void mouseClicked(MouseEvent e) { //클릭 행동할 때 
				card.next(getContentPane()); //카드에 콘텐트팬을 불러와라?
			}
		});
	}

	private JPanel getPn3() {
		pn3 = new JPanel();
		pn3.setBackground(Color.MAGENTA);
		return pn3;
	}

	private JPanel getPn1() {
		pn1 = new JPanel();
		pn1.setBackground(new Color(255,0,0));
		//pn1.setBackground(Color.cyan);
		return pn1;
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() { //invokeLater가 Runnable을 부름. Runnable에 의해서 제어된다.. 
			@Override
			public void run() {
				T04_CardLayout1 t04 = new T04_CardLayout1(); // T04_CardLayout1()클래스를 생성함
				t04.setVisible(true);  // t04 를 화면에 보여라. (extends 해야 됨)
			}
		});
		
	}
}
