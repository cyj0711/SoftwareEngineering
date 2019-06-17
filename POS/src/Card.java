import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Card extends JFrame implements ActionListener { //카드 결제창을 구현

	private final int WIDTH = 900;
	private final int HEIGHT = 600;
	
	private final int P_WIDTH = 400;
	private final int P_HEIGHT = 50;
	
	private final int K_WIDTH = 200;
	private final int K_HEIGHT = 250;
	
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	
	private JPanel cal1;
	private JPanel cal2;
	private JPanel pnum;
	
	private JLabel l2;
	
	private int total;
	
	public Card(String total) {
		
		super("카드 결제");
		this.total = Integer.parseInt(total);
		
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		moneyPanel(50, 100, P_WIDTH, P_HEIGHT);
		
		makeKeypad(450, 100, K_WIDTH, K_HEIGHT);
		
		makeButton(670, 110, 150, 70);
		
		setVisible(true);
	}
	
	public void moneyPanel(int row, int col, int width, int height) {
		//총 금액 출력을 위한 panel 생성
		cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("받을금액");
		t1 = new JTextField(20);
		t1.setHorizontalAlignment(JTextField.RIGHT);
		t1.setEditable(false);
		t1.setText(Integer.toString(this.total));
		
		JLabel won1= new JLabel("원");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		
		//현금영수증 번호를 위한 panel 생성
		cal2 = new JPanel();
		cal2.setLayout(new FlowLayout());
		
		l2 = new JLabel("결제금액");
		t2 = new JTextField(20);
		t2.setHorizontalAlignment(JTextField.RIGHT);
		JLabel won2= new JLabel("원");
		
		cal2.add(l2);
		cal2.add(t2);
		cal2.add(won2);
		
		
		//panel을 붙일 위치와 사이즈 설정
		cal1.setBounds(row, col, width, height);
		cal2.setBounds(row, col+50, width, height);
		
		//panel을 frame에 붙이기
		add(cal1);
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
		String getText1 = t1.getText(); //결제 금액을 받아온다
		String getText2 = t2.getText(); //받은 금액을 받아온다
		
		int getMoney; //받은 돈
		int change; //거스름돈
		
		if(result.equals("현금영수증"))
		{
			new CashReceipt(Integer.toString(this.total));
		}
		
		else if(result.equals("승인 요청"))
		{
			JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.\n거스름돈을 확인해주세요.", "결제 완료", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		
		else if(result.equals("닫기"))
		{
			dispose();
		}
		
		else if(result.equals("←")) //지우기 버튼 클릭했을 때
		{
			if(getText2.length()==1)
			{
				getText2 = "0";
				t2.setText(getText2);
				t3.setText(getText2);
				
			}
			
			else
			{
				getText2 = getText2.substring(0,getText2.length()-1);
				t2.setText(getText2);
				change = Integer.parseInt(getText2) - this.total;
				
				if(change < 0) // 만약 거스름돈이 음수이면
				{
					t3.setText("0"); 
				}
				
				else //그렇지 않으면
				{
					t3.setText(Integer.toString(change));
				}
				
			}
		}
		
		else //숫자 버튼 클릭했을 때
		{
			if(getText2.equals("0"))
			{
				getText2=result;
				
			}
			
			else 
			{
				getText2=getText2+result;
				
			}
			
			t2.setText(getText2);
			
			change = Integer.parseInt(getText2) - this.total;
			
			if(change < 0) // 만약 거스름돈이 음수이면
			{
				t3.setText("0"); 
			}
			
			else // 그렇지 않으면
			{
				t3.setText(Integer.toString(change));
			}
		}
	}

}
