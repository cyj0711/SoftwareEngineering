
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CashReceipt extends JFrame implements ActionListener { // 현금영수증 창 구현

	private final int WIDTH = 600; //frame 가로 길이
	private final int HEIGHT = 700; //frame 세로 길이
	
	private JTextField t1; //결제금액 띄우는 textfield
	private JTextField t2; //현금영수증 번호 입력받는 textfield

	private JPanel cal1; //결제금액 textfield 붙이는 panel
	private JPanel cal2; //현금영수증 번호 textfield 붙이는 panel
	private JPanel pnum; //keypad 붙이는 panel
	
	private JLabel l2;
	
	private int total; //결제 금액을 받는 변수
	
	public CashReceipt(String total) { 
		
		super("현금 영수증");
		this.total = Integer.parseInt(total); //string으로 받은 결제금액을 int로 바꾸어서 저장
		
		//frame setting
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//결제 금액, 현금영수증 종류, 현금영수증 번호 
		moneyPanel(0, 70, WIDTH, 50);
		
		//숫자 패드
		makeKeypad(100, 350, 200, 250);
		
		//그 외 버튼
		makeButton(330, 350, 150, 120);
		
		setVisible(true);
	}

	public void moneyPanel(int row, int col, int width, int height) {
		//총 금액 출력을 위한 panel 생성
		cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("결제금액");
		t1 = new JTextField(20);
		t1.setHorizontalAlignment(JTextField.RIGHT);
		t1.setEditable(false);
		t1.setText(Integer.toString(this.total));
		
		JLabel won1= new JLabel("원");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		
		//현금영수증 종료(개인, 사업자) 선택을 위한 JComboBox 만들기
		pnum = new JPanel();
		pnum.setLayout(new FlowLayout());
		
		String[] option = {"개인", "사업자"};
		
		JLabel opt = new JLabel("종류");
		JComboBox optionCombo = new JComboBox(option);
		optionCombo.setPreferredSize(new Dimension(150, 20));
		optionCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //actionPerformed 메소드를 이너클래스로 구현
				String choice = optionCombo.getSelectedItem().toString();
				
				if(choice.equals("개인"))
				{
					l2.setText("개인 번호: ");
				}
				
				else if(choice.equals("사업자"))
				{
					l2.setText("사업자 번호: ");
				}
			}
		});
		
		pnum.add(opt);
		pnum.add(optionCombo);
		
		
		//현금영수증 번호를 위한 panel 생성
		cal2 = new JPanel();
		cal2.setLayout(new FlowLayout());
		
		l2 = new JLabel("발행번호");
		t2 = new JTextField(22);
		t2.setHorizontalAlignment(JTextField.LEFT);
		
		cal2.add(l2);
		cal2.add(t2);
		
		
		//panel을 붙일 위치와 사이즈 설정
		cal1.setBounds(row, col, width, height);
		pnum.setBounds(row, col+100, width, height);
		cal2.setBounds(row, col+200, width, height);
		
		//panel을 frame에 붙이기
		add(cal1);
		add(pnum);
		add(cal2);

	}
	
	public void makeKeypad(int row, int col, int width, int height) {
		//숫자키를 위한 panel 생성
		pnum = new JPanel();
		pnum.setLayout(new GridLayout(4,3));
		
		JButton b0 = new JButton("0");
		JButton b00 = new JButton("00");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bc = new JButton("←");
		
		
		b0.addActionListener(this);
		b00.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bc.addActionListener(this);
	
		pnum.add(b7);
		pnum.add(b8);
		pnum.add(b9);
		pnum.add(b4);
		pnum.add(b5);
		pnum.add(b6);
		pnum.add(b1);
		pnum.add(b2);
		pnum.add(b3);
		pnum.add(b0);
		pnum.add(b00);
		pnum.add(bc);
		
		//panel을 붙일 위치와 사이즈 설정
		pnum.setBounds(row, col, width, height);
		
		//panel을 frame에 붙이기
		add(pnum);
	}
	
	public void makeButton(int row, int col, int width, int height) {
		
		//승인 요청을 위한 버튼 생성
		JButton bapprove = new JButton("승인 요청");
		bapprove.addActionListener(this);
		
		//닫기 버튼 생성
		JButton bclose = new JButton("닫기");
		bclose.addActionListener(this);
				
		
		//button을 붙일 위치와 사이즈 설정
		bapprove.setBounds(row, col, width, height);
		bclose.setBounds(row, col+130, width, height);
		
		//button을 frame에 붙이기
		add(bapprove);
		add(bclose);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand(); //숫자 버튼 눌렀을 때
		String getText = t2.getText(); //받은 금액을 받아온다
		
		
		if(result.equals("승인 요청"))
		{
			JOptionPane.showMessageDialog(null, "현금 영수증이 발행되었습니다.", "현금영수증 완료", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		
		else if(result.equals("닫기"))
		{
			dispose();
		}
		
		else if(result.equals("←")) //지우기 버튼 클릭했을 때
		{
			if(getText.length()==0)
			{
				getText = "";
				t2.setText(getText);
				
			}
			
			else
			{
				getText = getText.substring(0,getText.length()-1);
				t2.setText(getText);
				
			}
		}
		
		else //숫자 버튼 클릭했을 때
		{
			getText=getText+result;
			t2.setText(getText);
		}
			
	}


}
