package Swing2_JFrame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_invokeLater2 extends JFrame{

	public T02_invokeLater2() {
		setTitle("스윙 이벤트 큐 연습"); //먼저 들어온게 먼저나가는 큐의 개념 = 단일 스레드 
		setSize(300, 200);
		
		System.out.println("22222222222222222222"); 
	
//		addWindowListener(new WindowAdapter() { //여러개의 메소드가 있으면 어뎁터 사용함
//			@Override
//			public void windowClosing(WindowEvent e) { //그중 하나만 씀
//				System.exit(0);
//			}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 위에 거 안 쓰고 JFrame 닫는 거 쓰면 됨.
	}
	
	
	public static void main(String[] args) { // main 메인스레드
		System.out.println("11111111111111111");
		
		SwingUtilities.invokeLater(new Runnable() { // 스윙에서 처리하는 애들(느림)을 처리하려고 스레드를 따로 만듦. 메인에서 처리하는 거랑 별도로 처리됨.
			@Override
			public void run() {
				T02_invokeLater2 t02 = new T02_invokeLater2(); //윈도우 생성
				t02.setVisible(true);
				System.out.println(Thread.currentThread().getName()); //실행 
			}
		});
		
		System.out.println("33333333333333333333333");
		System.out.println(Thread.currentThread().getName()); 
	}
}
