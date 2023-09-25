package xDataBase;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import xDataBase.InsaDAO;
import xDataBase.InsaVO;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InsaList extends JFrame {

	private JPanel contentPane;
	private final JPanel pn1 = new JPanel();
	private JTable tbl;
	private JScrollPane sp;
	private ButtonGroup gednerGroup = new ButtonGroup();
	private JButton btnCondition, btnList, btnExit;
	private JComboBox cbCondition;

	@SuppressWarnings("rawtypes")
	Vector title, vData;
	DefaultTableModel dtm;

	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;
	
	@SuppressWarnings("unchecked")
	public InsaList() {
		setVisible(true);
		
		
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)"); //생성자에서 해야 됨. 창 열자마자 보여야 하니까
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		pn1.setBounds(0, 0, 784, 84);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		btnExit = new JButton("종   료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 20));
		btnExit.setBounds(659, 27, 113, 47);
		pn1.add(btnExit);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.PLAIN, 20));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 29, 97, 47);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setFont(new Font("굴림", Font.PLAIN, 14));
		txtCondition.setBounds(121, 30, 125, 44);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new JButton("조건검색");
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCondition.setFont(new Font("굴림", Font.PLAIN, 16));
		btnCondition.setBounds(263, 27, 118, 47);
		pn1.add(btnCondition);
		
		btnList = new JButton("전체검색");
		btnList.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList.setBounds(403, 27, 118, 47);
		pn1.add(btnList);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 83, 784, 374);
		contentPane.add(pn2);
		pn2.setLayout(null);
				
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 467, 784, 94);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnNameAssending = new JButton("성명 오름차순");
		btnNameAssending.setBounds(236, 10, 142, 34);
		pn3.add(btnNameAssending);
		
		JButton btnNameDesc = new JButton("성명 내림차순");
		btnNameDesc.setBounds(236, 54, 142, 34);
		pn3.add(btnNameDesc);
		
		JButton btnIpsailAssending = new JButton("입사일 오름차순");
		btnIpsailAssending.setBounds(407, 10, 142, 34);
		pn3.add(btnIpsailAssending);
		
		JButton btnIpsailAssending_1 = new JButton("입사일 내림차순");
		btnIpsailAssending_1.setBounds(407, 54, 142, 34);
		pn3.add(btnIpsailAssending_1);
		
		JRadioButton rdFemale = new JRadioButton("여  자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 16));
		rdFemale.setBounds(16, 16, 72, 23);
		gednerGroup.add(rdFemale);
		pn3.add(rdFemale);
		
		JRadioButton rdMale = new JRadioButton("남  자");
		rdMale.setFont(new Font("굴림", Font.PLAIN, 16));
		rdMale.setBounds(16, 60, 72, 23);
		gednerGroup.add(rdMale);
		pn3.add(rdMale);
		
		JButton btnGenderSearch = new JButton("성별검색");
		btnGenderSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		btnGenderSearch.setBounds(106, 30, 109, 41);
		pn3.add(btnGenderSearch);
		
		/*<JTable 설계하기> */
		// - '부제목'과 '데이터'를 Vector 타입으로 준비한다. 
		 
		//1. '부제목(subtitle)'을 Vector 타입으로 준비
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
	
		
		//2. '데이터'를 Vector타입으로 준비한다. -데이터는 Database에서 가져온다.
		vData = dao.getInsaList();
		
		
		//3. DB에서 가져온 자료를 DefaultTableModel을 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title); 
	
		//4. DefaultTableModel에 담긴 Vector 형식의 자료와 title로 JTable을 생성시켜준다.
		tbl = new JTable(dtm);
		
		//5. 자료가 담긴 table을 JScrollPane생성시에 함께 담아서 생성한다.
		sp = new JScrollPane(tbl);
		sp.setBounds(12, 10, 760, 354);
		
		//6.JScrollPane을 패널에 올려준다.
		pn2.add(sp);
		
		
		//JTable 안의 셀의 내용을 가운데 정렬하기
		tableCellAlign(tbl); //jtable 내용을 넘겨서 셀에 정렬을 해주세요.
		
		// 0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
		
		/* ======================================================================================*/
		
		/*성별버튼 클릭시 성별별로 조회하기*/
/*
		//남자 라디오 버튼 클릭시 남자만 검색처리
		rdMale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vData = dao.getGender("남자");
				dtm.setDataVector(vData, title);
				
			}
		});
		
	//여자 라디오 버튼 클릭시 남자만 검색처리
		rdFemale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vData = dao.getGender("여자");
				dtm.setDataVector(vData, title);
				
			}
		});
*/
		
		//성별 라디오버튼으로 성별을 선택후 '성별버튼'클릭시 해당 자료만 검색처리후 출력하기
		btnGenderSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdMale.isSelected()) gender = "남자";
				else gender = "여자";
				
				vData = dao.getGender(gender);
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl); 
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});

		//성명 내림차순
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name", "d"); // 내림차순
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl); 
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//성명 오름차순
		btnNameAssending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name", "a"); // 오름차순 assending = a
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl); 
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//입사일 오름차순
		btnIpsailAssending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail", "a");
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl); 
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//입사일 내림차순
		btnIpsailAssending_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail", "d");
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl); 
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});

		//table 안의 셀을 클릭할 때, 입력된 정보 가져오기.
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int row	= tbl.getSelectedRow(); //행의 번호를 가져온다.
			int col = tbl.getSelectedColumn(); //열의 번호를 가져온다.
			
			Object value = tbl.getValueAt(row, col); //object타입으로 반환한다.
			
			//lblMsg.setText("row : " + row + ", col : " + col + ", value : " + value);
			}
		});
		
		//조건별 검색처리하기(조건버튼 클릭시 처리할 내용들)
		btnCondition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			getConditionProcess();
			}
		});
		
		//조건검색항목 선택후, 조건에 필요한 검색어를 입력후 '엔터키'를 누르면 바로 검색실행 처리하고자 한다.
		txtCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getConditionProcess(); //바깥쪽에 메소드 생성돼있음
			}
		});
		
		
		//전체검색 버튼 실행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList();
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl); 
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//조건검색 콤보박스 안의 항목을 변경할 때마다 자동으로 커서를 입력 텍스트필드로 이동시키고자할 경우...
		cbCondition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
			}
		});
		
		//종료버튼 버튼 실행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private void tableCellAlign(JTable tbl2) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);//가운데 정렬?
		
		TableColumnModel tcm = tbl.getColumnModel();
		
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	//조건검색 항목 선택후, 조건 입력필드에서 조건 입력후 엔터키를 누르거나, 또는 '조건버튼'을 클릭하면 수행처리할 내용
	protected void getConditionProcess() {
		String cbCondi = cbCondition.getSelectedItem().toString(); //콤보상자에서 고른 필드명 이름이 나온다.
		String txtCondi = txtCondition.getText();
		
		if(txtCondi.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			txtCondition.requestFocus();
			return; //리턴 쓴 이유 : 
		}
		if(cbCondi.equals("성명")) vData = dao.getConditionSearch("name", txtCondi);
		
		else if(cbCondi.equals("나이")) {
			if(!Pattern.matches("^[0-9]*$", txtCondi)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력하세요.");
				txtCondition.requestFocus();
			}
			else vData = dao.getConditionSearch("age", txtCondi);
		}
		
		else if(cbCondi.equals("성별")) vData = dao.getConditionSearch("gender", txtCondi);
		else if(cbCondi.equals("입사일")) vData = dao.getConditionSearch("ipsail", txtCondi); //추가 + 날짜비교하기
		
		dtm.setDataVector(vData, title);
		
		// 셀을 중앙정렬하고 0열의 크기를 50픽셀로 조정한다.
		tableCellAlign(tbl); 
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
	}
}
