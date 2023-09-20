package Swing2_JFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_ImagieIcon extends JFrame {

	public T03_ImagieIcon() {
		setTitle("창제목");
		setSize(600,500);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setIconImage(new ImageIcon(getClass().getResource("./images/01.jpg")).getImage()); //images 패키지 안에 사진 넣는 법? Swing2_JFrame 패키지 복붙후,파일명뒤에 .images 쓰면 됨.
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_ImagieIcon t03 = new T03_ImagieIcon();
				t03.setVisible(true);
			}
		});
	}
}
