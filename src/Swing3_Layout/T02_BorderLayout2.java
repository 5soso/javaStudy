package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//BorderLayout 연습
@SuppressWarnings("serial")
public class T02_BorderLayout2 extends JFrame {
	private JButton btnNorth, btnWest, btnEast; 
	private JTextField txtSouth;
	private JTextField txtCenter;
	
	public T02_BorderLayout2() {
		setTitle("BorderLayout 연습");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.getContentPane().add(getBtnNorth(), BorderLayout.NORTH);
		this.getContentPane().add(getTxtSouth(), BorderLayout.SOUTH);
		this.getContentPane().add(getBtnWest(), BorderLayout.WEST);
		this.getContentPane().add(getBtnEast(), BorderLayout.EAST);
		add(getTxtCenter(), BorderLayout.CENTER);
	}

	
	private JTextField getTxtCenter() {
		txtCenter = new JTextField("센터");
		return txtCenter;
	}


	private Component getBtnEast() {
		btnEast = new JButton("동쪽");
		return btnEast;
	}

	private Component getBtnWest() {
		btnWest = new JButton("서쪽");
		return btnWest;
	}


	private JTextField getTxtSouth() {
		txtSouth = new JTextField("남쪽");
		return txtSouth;
	}

	private Component getBtnNorth() {
		btnNorth = new JButton("북쪽");
		return btnNorth;
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_BorderLayout2 t02 = new T02_BorderLayout2();
				t02.setVisible(true);
			}
		});
	}
}
