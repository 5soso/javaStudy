package Swing2_JFrame;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow3 extends JWindow { //JWindow는 컨테이너이다.
	JButton exitBtn;
	
	public T04_JWindow3() {
		setSize(600,350);
		
		exitBtn = new JButton("종료");
		add(exitBtn);
		
		// JWindow를 화면 중앙에 뜨우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint(); // LocalGraphicsEnvironment()객체의 가운데 정보를 가져옴. 가운데로 좌표 점을 가져온 상태이다. 
		int leftTopX = centerPoint.x - this.getWidth()/2;
		int leftTopY = centerPoint.y - this.getWidth()/2;
		setLocation(leftTopX, leftTopY);
		
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose(); //객체가 메모리에서 소멸된다.(밑에 생성한 객체 없어짐) 다른 것은 떠있음
			}
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow3 t04 = new T04_JWindow3(); 
				t04.setVisible(true);
			}
		});
	}

}
