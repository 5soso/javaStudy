package Swing3_Layout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Homeworks extends JFrame {

	public Homeworks() {
		setTitle("연습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		
	}
		
		
	
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			Homeworks home = new Homeworks();
			home.setVisible(true);
			}
		});
	}
}
