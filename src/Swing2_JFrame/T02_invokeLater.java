package Swing2_JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T02_invokeLater extends JFrame{

	public T02_invokeLater() {
		setTitle("스윙 이벤트 큐 연습"); //먼저 들어온게 먼저나가는 큐의 개념 = 단일 스레드 
		setSize(300, 200);
		
		System.out.println("22222222222222222222"); 
	
		addWindowListener(new WindowAdapter() { //여러개의 메소드가 있으면 어뎁터 사용함
			@Override
			public void windowClosing(WindowEvent e) { //그중 하나만 씀
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		System.out.println("11111111111111111");
		
		T02_invokeLater t02 = new T02_invokeLater(); //윈도우 생성
		t02.setVisible(true);
		System.out.println(Thread.currentThread().getName()); //실행 
		
		
		System.out.println("33333333333333333333333");
		
		
		
	}
	
}
