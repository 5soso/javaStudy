package Swing1_Frame;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T01_FrameExtends extends Frame implements WindowListener{
	public T01_FrameExtends() {
		//super("스윙연습!! ");
		setTitle("스윙연습!!");
		setSize(300,200);
		
		addWindowListener(this);

 }
	
	
	public static void main(String[] args) {
		T01_FrameExtends t1 = new T01_FrameExtends();
		t1.setVisible(true);

	}


	@Override
	public void windowOpened(WindowEvent e) {}


	@Override
	public void windowClosing(WindowEvent e) {System.exit(0);}


	@Override
	public void windowClosed(WindowEvent e) {}


	@Override
	public void windowIconified(WindowEvent e) {}


	@Override
	public void windowDeiconified(WindowEvent e) {}


	@Override
	public void windowActivated(WindowEvent e) {}


	@Override
	public void windowDeactivated(WindowEvent e) {}
}
