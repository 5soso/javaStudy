package Windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class T99 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhoneN;
	private JTextField txtAddress;
	private JButton btnExit, btnInput, btnReset;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T99 frame = new T99();
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
	public T99() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.ORANGE);
		pn1.setBounds(0, 0, 684, 85);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원 가 입 창");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(57, 22, 563, 46);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.CYAN);
		pn2.setBounds(0, 86, 684, 399);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("굴림", Font.PLAIN, 18));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(120, 46, 130, 39);
		pn2.add(lblId);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("굴림", Font.PLAIN, 18));
		lblPwd.setBounds(120, 108, 130, 39);
		pn2.add(lblPwd);
		
		JLabel lblName = new JLabel("성  명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setBounds(120, 167, 130, 39);
		pn2.add(lblName);
		
		JLabel lblPhonN = new JLabel("전화번호");
		lblPhonN.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhonN.setFont(new Font("굴림", Font.PLAIN, 18));
		lblPhonN.setBounds(120, 226, 130, 39);
		pn2.add(lblPhonN);
		
		JLabel lblAddress = new JLabel("주  소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("굴림", Font.PLAIN, 18));
		lblAddress.setBounds(120, 290, 130, 39);
		pn2.add(lblAddress);
		
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 18));
		txtId.setBounds(319, 52, 150, 29);
		pn2.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(319, 177, 150, 29);
		pn2.add(txtName);
		
		txtPhoneN = new JTextField();
		txtPhoneN.setFont(new Font("굴림", Font.PLAIN, 18));
		txtPhoneN.setColumns(10);
		txtPhoneN.setBounds(319, 236, 150, 29);
		pn2.add(txtPhoneN);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("굴림", Font.PLAIN, 18));
		txtAddress.setColumns(10);
		txtAddress.setBounds(319, 290, 150, 29);
		pn2.add(txtAddress);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("굴림", Font.PLAIN, 18));
		txtPwd.setBounds(319, 114, 150, 29);
		pn2.add(txtPwd);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.MAGENTA);
		pn3.setBounds(0, 484, 684, 77);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("회원가입");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
		btnInput.setBounds(72, 18, 132, 49);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReset.setBounds(276, 18, 132, 49);
		pn3.add(btnReset);
		
		btnExit = new JButton("창닫기");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(480, 18, 132, 49);
		pn3.add(btnExit);
		
		/*====================================================================*/
		
		//창닫기 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtPhoneN.setText("");
				txtAddress.setText("");
			}
		});
		
		//회원가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += txtId.getText() + "/";
				str += txtPwd.getText() + "/";
				str += txtName.getText() + "/";
				str += txtPhoneN.getText() + "/";
				str += txtAddress.getText();
				JOptionPane.showMessageDialog(null, str);
			}
		});
	}
}
