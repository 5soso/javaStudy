package Windowbuilder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class T02 extends JFrame {
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JCheckBox chckbxHobby1, chckbxHobby2, chckbxHobby3, chckbxHobby4;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T02 frame = new T02();
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
	public T02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 55);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("라디오버튼 연습");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 28));
		lblTitle.setBounds(24, 10, 511, 35);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 75, 560, 216);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성 별");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 45, 96, 36);
		pn2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("취 미");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(44, 98, 96, 36);
		pn2.add(lblNewLabel_1);
		
		rdbtnMale = new JRadioButton("남 자");
		rdbtnMale.setFont(new Font("굴림", Font.PLAIN, 18));
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(161, 45, 78, 36);
		pn2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여 자");
		rdbtnFemale.setSelected(true);
		rdbtnFemale.setFont(new Font("굴림", Font.PLAIN, 18));
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(314, 45, 78, 36);
		pn2.add(rdbtnFemale);
		
		JLabel lblMsg = new JLabel("메세지 출력");
		lblMsg.setBackground(Color.PINK);
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 18));
		lblMsg.setBounds(44, 132, 468, 55);
		pn2.add(lblMsg);
		
		chckbxHobby1 = new JCheckBox("등 산");
		chckbxHobby1.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxHobby1.setBounds(161, 106, 67, 23);
		pn2.add(chckbxHobby1);
		
		chckbxHobby2 = new JCheckBox("낚 시");
		chckbxHobby2.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxHobby2.setBounds(248, 106, 67, 23);
		pn2.add(chckbxHobby2);
		
		chckbxHobby3 = new JCheckBox("수 영");
		chckbxHobby3.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxHobby3.setBounds(340, 106, 67, 23);
		pn2.add(chckbxHobby3);
		
		chckbxHobby4 = new JCheckBox("러 닝");
		chckbxHobby4.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxHobby4.setBounds(430, 106, 67, 23);
		pn2.add(chckbxHobby4);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 301, 560, 50);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//전송버튼
		JButton btnSubmit = new JButton("전 송");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "";
					if(rdbtnMale.isSelected()) gender = rdbtnMale.getText();
					else if(rdbtnFemale.isSelected()) gender = rdbtnFemale.getText();
					
					String hobby = "";
					if(chckbxHobby1.isSelected()) hobby += chckbxHobby1.getText() + "/";
					if(chckbxHobby2.isSelected()) hobby += chckbxHobby2.getText() + "/";
					if(chckbxHobby3.isSelected()) hobby += chckbxHobby3.getText() + "/";
					if(chckbxHobby4.isSelected()) hobby += chckbxHobby4.getText() + "/";
					
					lblMsg.setText(gender + ": " + hobby);
					JOptionPane.showMessageDialog(null, "성별 : " + gender + " : " + hobby);
			}
		});
		btnSubmit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSubmit.setBounds(120, 10, 163, 30);
		pn3.add(btnSubmit);
		
		JButton btnReset = new JButton("종 료");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReset.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReset.setBounds(295, 10, 163, 30);
		pn3.add(btnReset);
	}
}
