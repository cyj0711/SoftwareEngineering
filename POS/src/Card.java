
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Card extends JFrame implements ActionListener { //카드 결제창을 구현

	private final int WIDTH = 900; // frame 창 가로
	private final int HEIGHT = 600; // frame 창 세로
	
	private final int P_WIDTH = 400; // panel 가로
	private final int P_HEIGHT = 50; // panel 세로
	
	private final int K_WIDTH = 200; // key panel 가로
	private final int K_HEIGHT = 250; // key panel 세로
	
	private JTextField t1; // 계산 금액 출력을 위한 textfield
	private JTextField t2; // 결제 금액 출력을 위한 textfield
	private JTextField cardNum; // 카드 번호 출력을 위한 textfield
	public static JTextField fMonth; // 할부 개월 출력을 위한 textfield
	
	private JPanel cal1; // 계산 금액 패널
	private JPanel cal2; // 결제 금액 패널
	private JPanel pcard; // 카드 번호 패널
	private JPanel pnum; // 숫자패드 출력을 위한 패널
	private JPanel pMonth; // 할부 표시를 위한 패널
	
	private JLabel l2; 
	
	private int total; // 결제 금액
	private int change; // 거스름돈
	public static String payMonth; //할부개월
	
	private DBconnector db;

	
	public Card(String total) {
		
		super("카드 결제");
		this.total = Integer.parseInt(total); // 생성자로 받은 string type의 결제 금액을 int로 바꿔준다
		
		try {
			db = new DBconnector();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//frame 세팅
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//결제 금액, 카드 번호 textfield
		moneyPanel(50, 100, P_WIDTH, P_HEIGHT);
		
		//숫자 입력 버튼
		makeKeypad(450, 100, K_WIDTH, K_HEIGHT);
		
		//그 외 버튼
		makeButton(670, 110, 150, 70);
		
		setVisible(true);
	}
	
	public void moneyPanel(int row, int col, int width, int height) {
		//총 금액 출력을 위한 panel 생성
		cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("받을금액"); 
		t1 = new JTextField(Integer.toString(this.total), 20); //결제해야할 총 금액
		t1.setHorizontalAlignment(JTextField.RIGHT);
		t1.setEditable(false);
		
		JLabel won1= new JLabel("원");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		
		//결제 금액 출력을 위한 panel 생성
		cal2 = new JPanel();
		cal2.setLayout(new FlowLayout());
		
		l2 = new JLabel("결제금액");
		t2 = new JTextField(Integer.toString(this.total), 20); //카드결제해야할 금액
		t2.setHorizontalAlignment(JTextField.RIGHT);
		JLabel won2= new JLabel("원");
		
		cal2.add(l2);
		cal2.add(t2);
		cal2.add(won2);
		
		//카드 번호 표시를 위한 panel 생성
		pcard = new JPanel();
		pcard.setLayout(new FlowLayout());
		
		JLabel l3 = new JLabel("카드번호");
		cardNum = new JTextField(22); //카드번호 입력을 위한 textfield
		cardNum.setHorizontalAlignment(JTextField.LEFT);
		
		pcard.add(l3);
		pcard.add(cardNum);
		
		//할부 표시를 위한 panel 생성
		pMonth = new JPanel();
		pMonth.setLayout(new FlowLayout());
		
		JLabel l4 = new JLabel("할부개월");
		fMonth = new JTextField("일시불", 10); //할부개월 선택하지 않으면 일시불로 표시
		fMonth.setHorizontalAlignment(JTextField.CENTER);
		
		pMonth.add(l4);
		pMonth.add(fMonth);
		
		//panel을 붙일 위치와 사이즈 설정
		cal1.setBounds(row, col, width, height);
		cal2.setBounds(row, col+50, width, height);
		pcard.setBounds(row, col+100, width, height);
		pMonth.setBounds(row, col+150, width, height);
		
		//panel을 frame에 붙이기
		add(cal1);
		add(cal2);
		add(pcard);
		add(pMonth);

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
		
		JButton bcash = new JButton("할부 개월");
		bcash.addActionListener(this);
		
		//승인 요청을 위한 버튼 생성
		JButton bapprove = new JButton("승인 요청");
		bapprove.addActionListener(this);
		
		//닫기 버튼 생성
		JButton bclose = new JButton("닫기");
		bclose.addActionListener(this);
				
		
		//button을 붙일 위치와 사이즈 설정
		bcash.setBounds(row, col, width, height);
		bapprove.setBounds(row, col+80, width, height);
		bclose.setBounds(row, col+160, width, height);
		
		//button을 frame에 붙이기
		add(bcash);
		add(bapprove);
		add(bclose);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = e.getActionCommand(); //숫자 버튼 눌렀을 때
		String getText = cardNum.getText(); //카드 번호를 받아온다
		
		int getMoney; //받은 돈
		
		if(result.equals("할부 개월"))
		{
			new PayMonth(); //할부 창 띄우기
		}
		
		else if(result.equals("승인 요청"))
		{
			if(getText.length()==0)
			{
				JOptionPane.showMessageDialog(null, "카드를 리더기에 꽂아주세요.", "결제 취소", JOptionPane.WARNING_MESSAGE);
			}
			
			else if(getText.length() != 16)
			{
				JOptionPane.showMessageDialog(null, "유효하지 않은 카드입니다.", "결제 취소", JOptionPane.WARNING_MESSAGE);
			}
			
			else {
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.", "결제 완료", JOptionPane.INFORMATION_MESSAGE);
				try {
					db.sellItem(Sell.dtm);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}			
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
				cardNum.setText(getText);
				
			}
			
			else
			{
				getText = getText.substring(0,getText.length()-1);
				cardNum.setText(getText);
			}
		}
		
		else //숫자 버튼 클릭했을 때
		{
			getText=getText+result;
			cardNum.setText(getText);
			
		}
	}

}
