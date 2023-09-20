package Swing1_Frame;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T01_WindowClosing extends Frame {
	public T01_WindowClosing() {
		//super("스윙연습!! ");
		setTitle("스윙연습!!");
		setSize(300,200);

 }
	
	
	public static void main(String[] args) {
		T01_WindowClosing t1 = new T01_WindowClosing();
		t1.setVisible(true);

	}
}
