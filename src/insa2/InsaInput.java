package insa2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsaInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JButton btnClose, btnInput, btnReset;
	private ButtonGroup buttonGroup = new ButtonGroup(); //라디오버튼 형식의 '남자', '여자'를 같은 그룹으로 묶어줘야한다.
	private JRadioButton rdMale, rdFemale; 
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	
	int res = 0;
	
	public InsaInput() {
		setVisible(true);//main 메소드 주석처리하고 setVisivle() 메소드사용. 해석 : 나를 생성하는 시점에서 보여달라.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.GRAY);
		pn1.setBounds(0, 0, 784, 86);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 폼(복습)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 10, 729, 66);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 89, 784, 383);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성  명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 20));
		lblName.setBounds(54, 54, 183, 61);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나  이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 20));
		lblAge.setBounds(54, 137, 183, 61);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성  별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 20));
		lblGender.setBounds(54, 222, 183, 61);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입 사 일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.PLAIN, 20));
		lblIpsail.setBounds(54, 298, 183, 61);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setFont(new Font("굴림", Font.PLAIN, 20));
		txtName.setBounds(302, 64, 246, 36);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.LEFT);
		txtAge.setFont(new Font("굴림", Font.PLAIN, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(302, 149, 246, 36);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남  자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 20));
		rdMale.setBounds(302, 243, 84, 23);
		buttonGroup.add(rdMale); //버튼그룹에 rdMale을 넣어라. 남자라디오버튼을 그룹으로 묶었음
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여  자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 20));
		rdFemale.setBounds(464, 243, 84, 23);
		buttonGroup.add(rdFemale); //버튼그룹에 rdFemal을 넣아라. 여자라디오버튼을 그룹으로 묶었음.
		pn2.add(rdFemale);
		
		//콤보박스 날짜 디자인
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi; // imsi 변수 준 이유? 안 줘도 됨..
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i] = imsi + ""; //int타입을 String타입으로 변환했다.
			//yy[i] = i + 2000 + ""; // imsi 사용 안 할 때
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		JComboBox cbYY = new JComboBox(yy); // yy 넣기
		cbYY.setFont(new Font("굴림", Font.PLAIN, 18));
		cbYY.setBounds(302, 319, 84, 23);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);// mm 넣기
		cbMM.setFont(new Font("굴림", Font.PLAIN, 18));
		cbMM.setBounds(462, 318, 57, 23);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);// dd 넣기
		cbDD.setFont(new Font("굴림", Font.PLAIN, 18));
		cbDD.setBounds(582, 319, 57, 23);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.PLAIN, 18));
		lblYY.setBounds(390, 313, 32, 32);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("굴림", Font.PLAIN, 18));
		lblMM.setBounds(520, 313, 32, 32);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("굴림", Font.PLAIN, 18));
		lblDD.setBounds(640, 313, 32, 32);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 475, 784, 86);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInput.setBounds(77, 10, 158, 52);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 20));
		btnReset.setBounds(312, 10, 158, 52);
		pn3.add(btnReset);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 20));
		btnClose.setBounds(547, 10, 158, 52);
		pn3.add(btnClose);
		
		
		/*===============================================================================================*/
		
		//회원 가입하기 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText(); //'JTextFeild의 성명입력란'에 입력된 이름(Text)을 Name으로 받는다.
				String age = txtAge.getText(); //'JTextFeild의 나이입력란'에 입력된 나이(Text)를 Age로 받는다.
				String gender; 
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem(); //getSelectedItem()이란, 콤보박스에 입력된 것을 뜻한다.
				
				//trim()  : 문자열의 양 옆, 즉 문자열의 제일 왼쪽 공백, 오른쪽 공백만 제거
				//JOptionPane : 사용자에게 값을 묻거나 정보를 알려주는 표준 대화 상자를 쉽게 팝업해서 이용할 수 있게 해주는 클래스이다.
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 다시 입력하세요?"); //앞에 null은 무슨 뜻..?
					txtName.requestFocus(); //txtName(JTextField로 만든 txtName 화면)으로 커서를 갖다 놓아라.
				}
				else if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 다시 입력하세요?");
					txtAge.requestFocus(); //txtAge(JTextField로 만든 txtAge 화면)으로 커서를 갖다 놓아라.
				}
				else {
					if(!Pattern.matches("^[0-9]*$", age)) { //matches() 메서드의 첫번째 매개값은 정규표현식이고 두번째 매개값은 검증 대상 문자열이다.
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요."); //나이에, 숫자0-9까지가 들어가 있지 않는다면 (!) 팝업창을 띄워라
						txtAge.requestFocus();
					}
					else {
						if(rdMale.isSelected()) gender = "남자"; //만약, 남자라디오버튼이 선택되었으면, 성별은 남자로 등록해라. //기본값을 남자로 두었기 때문에.
						else gender = "여자";
						
						// 모든 체크(요구사항)이 끝나면, DB에 새로운 회원을 가입처리한다.
						// 회원명 중복처리
						vo = dao.getNameSearch(name);
						if(vo.getName() != null) { //vo에서 읽은 이름의 값이 null이 아니면 = 값이 있으면
							JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 다시 입력하세요.");
							txtName.requestFocus(); //성명입력란으로 커서 갖다 놓아라.
						}
						else { //중복되지 않았으면,
							//정삭적으로 자료가 입력되었다면, vo에 담아있는 값을 DB에 저장한다.
							vo.setName(name);
							vo.setAge(Integer.parseInt(age)); //age를 String으로 선언했기 때문에(어디에서?..위에서ㅎ), int로 강제형변환을 해준다.
							vo.setGender(gender);
							vo.setIpsail(ipsail);
							
							//vo에 담긴 자료를 DB에 저장시켜준다.
							res = dao.setInsaInput(vo); //바로 위에서 자료체크해서..DB에 저장시켰는데 왜 또 여기서 하는지?
							
							if(res == 0) { // res == 0이면 해석 : 
								JOptionPane.showMessageDialog(null, "회원가입 실패. 다시 입력하세요");
								txtName.requestFocus();
							}
							else {
								JOptionPane.showMessageDialog(null, "반갑습니다. 회원에 가입되셨습니다.");
							}
				
							/*다음 입력자료 처리를 위한 준비...
								txtName.setText(""); 
								txtAge.setText("");
								rdMale.setSelected(true);
								txtName.requestFocus();  
								해석 : 이름과 나이의 창을 공백처리하고, 기본값으로 설정해둔 성별 라디오버튼을 남자로 선택해라. 성명입력란으로 커서를 갖다 두어라.
							*/
							btnReset.doClick(); //btnReset버튼 호출함. 근데 위에 거 주석처리하고 btnRest메소드만 불러도 되는지? 아 밑에 있네 ㅎㅎㅎ
						}
					}
				}
			}
		});
		
		//다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(""); 
				txtAge.setText("");
				rdMale.setSelected(true);
				
				//오늘 날짜로 입사일을 채우기... (여기서 입사일을 오늘날짜로 바꾸는 계산을 위한 서비스클래스 필요함)
				InsaService service = new InsaService();
				vo = service.getDefaultDate(); //년,월,일 세개를 한번에 담아다니고 싶으니까 vo에 담아서 객체로 가져온다. //서비스객체에 있는 리턴값 vo랑 같은 vo이다.
				
				//vo에 가져온 날짜 데이터를 날짜 콤보상자에 넣어준다.
				cbYY.setSelectedItem(vo.getStrYY());
				cbMM.setSelectedItem(vo.getStrMM());
				cbDD.setSelectedItem(vo.getStrYY());
				
				txtName.requestFocus(); 
			}
		});
		
		//창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0); 이거로 닫으면 InsaMain도 다 닫힘
				dispose(); //잠깐 창만 닫는 dispose()사용해야 한다.
			}
		});
	}
	
// 메인메소드 주석처리한 이유 :  
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	
} 
