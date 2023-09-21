package Swing3_Layout;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_FlowLayout extends JFrame {
	private JButton btnOk, btnExit, btnAnswer1, btnAnswer2, btnAnswer3, btnInput; 
	private JLabel lblName;

	public T01_FlowLayout() { //처음부터 차곡차곡 쌓는 레이아웃, 가운데에서 ->-<-
		setTitle("FlowLayout연습");
		setSize(400,300); //setSize 크기만 주는 것(무조건 가운데 띄우기 위해서) / setB 위치를 줌. 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 창 닫기
		setLocationRelativeTo(null); // 프레임을 가운데 정렬하기
		setResizable(false); // 프레임의 크기 고정하기. 처음에 설계한대로 고정시키기 위해서 
		
		setLayout(new FlowLayout()); //contentpane에 올라감 
		//this.getContainerListeners().add(getBtnOk()); //콘텐트팬에 부착되어 있어서 생략가능
	
		
		add(getBtnOk()); //ok버튼 생성하면서 바로 올려짐
		add(getBtnExit());
		add(getBtnAnswer1());
		add(getBtnAnswer2());
		add(getBtnAnswer3());
		add(getBtnInput());
		
		
		add(getLblName());
		
		//디자인
		/*-----------------------------------------------------------------------------------------------------------*/
		//코드
		
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String name	= JOptionPane.showInputDialog("성명을 입력하세요", "성명 입력란...");
				JOptionPane.showMessageDialog(null, "성명 : " + name);
				lblName.setText("성명 : " + name);
				System.out.println("name : " + name);
			}
		});

		
		
		btnAnswer3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 'YES_NO_CANCEL_OPTION'인 경우는 '확인(0)/아니오(1)/취소(2)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속하시겠습니까?", "선택박스", JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans == 0) JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
				else if(ans ==1) {
					JOptionPane.showMessageDialog(null, "작업을 마치겠습니다.", "종료창", JOptionPane.WARNING_MESSAGE);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "취소합니다.", "취소창", JOptionPane.WARNING_MESSAGE);
				}
			}
		);
		
		btnAnswer2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 'OK_CANCEL_OPTION'인 경우는 '확인(0)/아니오(1)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속하시겠습니까?", "선택박스", JOptionPane.YES_NO_OPTION);
				if(ans == 0) JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
				else {
					JOptionPane.showMessageDialog(null, "작업을 마치겠습니다.", "취소창", JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});
		
		btnAnswer1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 'OK_CANCEL_OPTION'인 경우는 '확인(0)/취소(2)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "버튼을 선택하세요?", "선택박스", JOptionPane.OK_CANCEL_OPTION);
				if(ans == 0) JOptionPane.showMessageDialog(null, "확인버튼을 누르셨습니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
				else JOptionPane.showMessageDialog(null, "취소버튼을 누르셨습니다.", "취소창", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "확인버튼을 누르셨습니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);//INFORMATION_MESSAGE 느낌표
				
			}
		});
						
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "작업을 종료합니다."); // 메세지 띄울 때 사용한다. 메세지 종류 많아서 option
				//JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.PLAIN_MESSAGE); //PLAIN_MESSAGE 아무것도 없음
				JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.YES_OPTION); // YES_OPTION 엑스
				//JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.WARNING_MESSAGE); // WARNING_MESSAGE 물음표
				System.exit(0); //이 명령 때문에 종료 버튼 누르면 닫힘.
			}
		});
	}
	
	
	private JLabel getLblName() {
		lblName = new JLabel();
		return lblName;
	}


	private JButton getBtnInput() {
		btnInput = new JButton("입력");
		return btnInput;
	}


	private JButton getBtnAnswer1() {
		btnAnswer1 = new JButton("선택1");
		return btnAnswer1;
	}
	
	private JButton getBtnAnswer2() {
		btnAnswer2 = new JButton("선택2");
		return btnAnswer2;
	}
	
	private JButton getBtnAnswer3() {
		btnAnswer3 = new JButton("선택3");
		return btnAnswer3;
	}

	private JButton getBtnExit() {
		btnExit = new JButton("종료");
		return btnExit;
	}

	private JButton getBtnOk() { //타입을 (부모)Component 타입에서 -> JButton바꿈 
		if(btnOk == null) { // ok버튼이 없으면 만들어라
			//btnOk = new JButton("확인");
			btnOk = new JButton();
			btnOk.setText("확인");		
		}
		return btnOk;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T01_FlowLayout t01 = new T01_FlowLayout();
				t01.setVisible(true);
			}
		});
	}
}
