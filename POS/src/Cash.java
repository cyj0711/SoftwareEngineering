import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cash extends JFrame implements ActionListener {

	private final int WIDTH = 600;
	private final int HEIGHT = 700;
	
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	
	public Cash(String total) {
		super("현금 결제");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//총 금액 출력을 위한 panel 생성
		JPanel cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("결제금액");
		t1 = new JTextField(20);
		t1.setHorizontalAlignment(JTextField.RIGHT);
		t1.setEditable(false);
		t1.setText(total);
		
		JLabel won1= new JLabel("원");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		
		//받은 금액 출력을 위한 panel 생성
		JPanel cal2 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l2 = new JLabel("받은금액");
		t2 = new JTextField(20);
		t2.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel won2= new JLabel("원");
		
		cal2.add(l2);
		cal2.add(t2);
		cal2.add(won2);
		
		//거스름돈 출력을 위한 panel 생성
		JPanel cal3 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l3 = new JLabel("거스름돈");
		t3 = new JTextField(20);
		t3.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel won3= new JLabel("원");
		
		cal3.add(l3);
		cal3.add(t3);
		cal3.add(won3);
		
		//숫자키를 위한 panel 생성
		JPanel pnum = new JPanel();
		pnum.setLayout(new GridLayout(4,3));
		
		JButton b0 = new JButton("0");
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
		JButton be = new JButton("Enter");
		
		
		b0.addActionListener(this);
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
		be.addActionListener(this);
		
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
		pnum.add(bc);
		pnum.add(be);
		
		//현금영수증 요청을 위한 버튼 생성
		JButton bcash = new JButton("현금영수증");
		bcash.addActionListener(this);
		
		//승인 요청을 위한 버튼 생성
		JButton bapprove = new JButton("승인 요청");
		bapprove.addActionListener(this);
		
		//닫기 버튼 생성
		JButton bclose = new JButton("닫기");
		bclose.addActionListener(this);
				
		
		//panel을 붙일 위치와 사이즈 설정
		cal1.setBounds(0, 70, WIDTH, 50);
		cal2.setBounds(0, 170, WIDTH, 50);
		cal3.setBounds(0, 270, WIDTH, 50);
		pnum.setBounds(100, 350, 200, 250);
		
		//button을 붙일 위치와 사이즈 설정
		bcash.setBounds(330, 350, 150, 50);
		bapprove.setBounds(330, 450, 150, 50);
		bclose.setBounds(330, 550, 150, 50);
		
		
		//panel과 button을 frame에 붙이기
		add(cal1);
		add(cal2);
		add(cal3);
		add(pnum);
		add(bcash);
		add(bapprove);
		add(bclose);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand();
		String getText1 = t1.getText();
		String getText2 = t2.getText();
		
		int total; //총 금액
		int getMoney; //받은 돈
		int change; //거스름돈
		
		if(result.equals("현금영수증"))
		{
			new CashReceipt();
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
			if(getText2.equals(""))
			{
				t2.setText("");
			}
			
			else
			{
				t2.setText(getText2.substring(0,getText2.length()-1));
			}
			
		}
		
		else if(result.equals("Enter")) //enter 버튼 클릭했을 때
		{
			total=Integer.parseInt(getText1);
			getMoney=Integer.parseInt(getText2);
			change = getMoney-total;
			t3.setText(Integer.toString(change));
		}
		
		else //숫자 버튼 클릭했을 때
		{
			if(getText2.equals(""))
			{
				getText2=result;
			}
			
			else 
			{
				getText2=getText2+result;
			}
			t2.setText(getText2);
		}
			
	}

}
