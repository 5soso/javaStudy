package y_JTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class T2_image extends JFrame {


	private JPanel contentPane;
	private ButtonGroup btnGroup = new ButtonGroup();
	private JRadioButton rdImg1, rdImg2, rdImg3, rdImg4, rdImg5, rdImg6;
	private JButton btnInfor;
	private JLabel lblInfor;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T2_image frame = new T2_image();
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
	public T2_image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);	
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 84);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		rdImg1 = new JRadioButton("그림 1");
		rdImg1.setFont(new Font("굴림", Font.PLAIN, 17));
		rdImg1.setBounds(38, 25, 86, 35);
		btnGroup.add(rdImg1);
		pn1.add(rdImg1);
		
		rdImg2 = new JRadioButton("그림 2");
		rdImg2.setFont(new Font("굴림", Font.PLAIN, 17));
		rdImg2.setBounds(162, 25, 86, 35);
		btnGroup.add(rdImg2);
		pn1.add(rdImg2);
		
		rdImg3 = new JRadioButton("그림 3");
		rdImg3.setFont(new Font("굴림", Font.PLAIN, 17));
		rdImg3.setBounds(286, 25, 86, 35);
		btnGroup.add(rdImg3);
		pn1.add(rdImg3);
		
		rdImg4 = new JRadioButton("그림 4");
		rdImg4.setFont(new Font("굴림", Font.PLAIN, 17));
		rdImg4.setBounds(410, 25, 86, 35);
		btnGroup.add(rdImg4);
		pn1.add(rdImg4);
		
		rdImg5 = new JRadioButton("그림 5");
		rdImg5.setFont(new Font("굴림", Font.PLAIN, 17));
		rdImg5.setBounds(534, 25, 86, 35);
		btnGroup.add(rdImg5);
		pn1.add(rdImg5);
		
		rdImg6 = new JRadioButton("그림 6");
		rdImg6.setFont(new Font("굴림", Font.PLAIN, 17));
		rdImg6.setBounds(658, 25, 86, 35);
		btnGroup.add(rdImg6);
		pn1.add(rdImg6);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 84, 784, 395);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblImage = new JLabel("이곳에 선택한 그림이 출력됩니다");
		lblImage.setForeground(new Color(255, 0, 0));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(12, 10, 760, 375);
		pn2.add(lblImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 477, 784, 84);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnExit = new JButton("종  료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 14));
		btnExit.setBounds(577, 21, 172, 42);
		pn3.add(btnExit);
		
		btnInfor = new JButton("그림정보 출력");
		btnInfor.setFont(new Font("굴림", Font.PLAIN, 14));
		btnInfor.setBounds(12, 21, 172, 42);
		pn3.add(btnInfor);
		
		lblInfor = new JLabel();
		lblInfor.setForeground(new Color(0, 0, 0));
		lblInfor.setFont(new Font("굴림", Font.PLAIN, 10));
		lblInfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor.setBounds(195, 21, 370, 42);
		pn3.add(lblInfor);
		
		/*============================================================================================*/
		
		
		// '그림정보출력'버튼을 클릭할 때 수행처리
		btnInfor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String photo = "그림을 클릭하면 해당그림 파일의 정보가 출력됩니다.";
				if(lblImage.getIcon() != null) photo = lblImage.getIcon().toString();
				System.out.println("photo : " + photo);
				lblInfor.setText(photo);
			}
		});
		
		//출력된 그림을 출력할 때 수행처리 ------------------------ 오류 
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String photo = "";
				if(lblImage.getIcon() != null) photo = lblImage.getIcon().toString(); 
				System.out.println("photo : " + photo);
				lblInfor.setText(photo);
			}
		});

		// 1이면 클릭했을때, 발생하지 않으면 0
		// 그림 1 라디오버튼을 클릭하면 처리할 내용
		rdImg1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1 ) lblImage.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
			}
		});
		
		// 그림 2 라디오버튼을 클릭하면 처리할 내용
		rdImg2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1 ) lblImage.setIcon(new ImageIcon(getClass().getResource("./images/2.jpg")));
			}
		});
		
		// 그림 3 라디오버튼을 클릭하면 처리할 내용
		rdImg3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1 ) lblImage.setIcon(new ImageIcon(getClass().getResource("./images/3.jpg")));
			}
		});
		
		// 그림 4 라디오버튼을 클릭하면 처리할 내용
		rdImg4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1 ) lblImage.setIcon(new ImageIcon(getClass().getResource("./images/4.jpg")));
			}
		});
		
		// 그림 5 라디오버튼을 클릭하면 처리할 내용
		rdImg5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1 ) lblImage.setIcon(new ImageIcon(getClass().getResource("./images/5.jpg")));
			}
		});
		
		// 그림 6 라디오버튼을 클릭하면 처리할 내용
		rdImg6.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1 ) lblImage.setIcon(new ImageIcon(getClass().getResource("./images/8.jpg")));
			}
		});
		
		
		//종료버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}

}
