package xDataBase;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class insaMain extends JFrame {

	private JPanel contentPane;
	private JButton btnInput, btnSearch, btnList, btnExit;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insaMain frame = new insaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public insaMain() {
		setTitle("인사관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); //창이 가운데 뜨게 한다.
		setResizable(false); //false는 0으로서, 창을 사용자 마음대로 조절하지 못 하게 한다. 가로 혹은 세로로 늘리거나 줄일 수 없음. setSize()와 함께 쓰기 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 81);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLable = new JLabel("인사관리 프로그램(v1.0)");
		lblNewLable.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLable.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLable.setBounds(12, 10, 732, 61);
		pn1.add(lblNewLable);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 97, 760, 374);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lbMain = new JLabel("");
		lbMain.setHorizontalAlignment(SwingConstants.CENTER);
		lbMain.setIcon(new ImageIcon(insaMain.class.getResource("/xDataBase/images/01.jpg")));
		lbMain.setBounds(20, 20, 715, 325);
		pn2.add(lbMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 480, 760, 81);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
		btnInput.setBounds(32, 10, 150, 61);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSearch.setBounds(214, 10, 150, 61);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.PLAIN, 18));
		btnList.setBounds(396, 10, 150, 61);
		pn3.add(btnList);
		
		btnExit = new JButton("종  료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(578, 10, 150, 61);
		pn3.add(btnExit);
		
		/*========================================================================================*/
		
		// 사원등록 버튼을 마우스로 클릭했을 때 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
		
		// 사원등록 버튼을 키보드 Enter키를 누르면 수행
		btnInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					new InsaInput();
				}
			}
		});
		
		// 개별조회 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요?");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null ) JOptionPane.showMessageDialog(null, "검색할 회원이 없습니다.");
				else new InsaSearch(vo);
			}
		});	
		
		// 전체조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//new InsaList();
				new InsaList();

			}
		});
		
		// 종료 버튼을 마우스로 클릭했을 때 수행처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 종료버튼을 키보드 엔터키를 눌렀을때 수행처리
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
		});
		
	}
}	