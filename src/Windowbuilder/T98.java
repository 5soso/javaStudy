package Windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class T98 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T98 frame = new T98();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T98() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pan1 = new JPanel();
		pan1.setBounds(23, 10, 634, 51);
		contentPane.add(pan1);
		pan1.setLayout(null);
		
		JLabel lblTitle = new JLabel("성격유형검사 (MBTI)");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(183, 10, 287, 41);
		pan1.add(lblTitle);
		
		JPanel pan2 = new JPanel();
		pan2.setBounds(22, 71, 634, 313);
		contentPane.add(pan2);
		pan2.setLayout(null);
		
		JLabel lbl = new JLabel("이 름 입 력");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl.setBounds(27, 21, 101, 38);
		pan2.add(lbl);
		
		JPanel pan3 = new JPanel();
		pan3.setBounds(23, 400, 634, 51);
		contentPane.add(pan3);
		pan3.setLayout(null);
	}

}
