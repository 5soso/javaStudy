package SwingEx1;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_Tabbed extends JFrame{
	private JTabbedPane tabbedPane;
	private JPanel pnTab1, pnTab2;
	
	public T03_Tabbed() {
		setTitle("Tabbed 연습");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false); //고정
		
		add(getTabbed(), BorderLayout.CENTER);
	}
	
	private JTabbedPane getTabbed() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.addTab("탭1", getPnTabl1());
		tabbedPane.addTab("탭2", getPnTabl2());
		return tabbedPane;
	}

	//두번째 탭설정
	private JPanel getPnTabl2() {
		pnTab2 = new JPanel();
		JLabel lblImge = new JLabel(); //이블록 안에서 사용하고 버릴거임.
		lblImge.setIcon(new ImageIcon(getClass().getResource("./images/2.jpg")));
		pnTab2.add(lblImge);
		return pnTab2;
	}

	//첫번째 탭설정
	private JPanel getPnTabl1() {
		pnTab1 = new JPanel();
		JLabel lblImge = new JLabel(); //이 블록 안에서 사용하고 버릴 레이블이다.
		lblImge.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		pnTab1.add(lblImge);
		return pnTab1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T03_Tabbed t03 = new T03_Tabbed();
				t03.setVisible(true);
				
			}
		});
	}
}
