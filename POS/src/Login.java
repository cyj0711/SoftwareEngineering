import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	private final int P_WIDTH = 420;
	private final int P_HEIGHT = 280;
	
	private JTextField text;
	private String pwd="";
	private String upwd="12345";
	
	public Login() {
		super("Login");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//title 만들기
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("관리자 인증", JLabel.CENTER);
		l1.setFont(new Font("굴림", Font.BOLD, 40));
		
		title.add(l1, BorderLayout.CENTER);
		title.setBounds(0, 0, Demo.WIDTH, 270);
		add(title);
		
		//비밀번호 입력창
		JPanel ptext = new JPanel();
		ptext.setLayout(null);
		
		text = new JTextField();
		text.setEditable(false);
		
		text.setBounds(430, 270, P_WIDTH, 40);
		ptext.add(text);
		text.setHorizontalAlignment(JTextField.CENTER);
		
		ptext.setBounds(0, 270, Demo.WIDTH, 40);
		add(text);
		
		
		//login 숫자패널 만들기
		JPanel lgin = new JPanel();
		lgin.setLayout(new GridLayout(4,3));
		
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
		
		lgin.add(b7);
		lgin.add(b8);
		lgin.add(b9);
		lgin.add(b4);
		lgin.add(b5);
		lgin.add(b6);
		lgin.add(b1);
		lgin.add(b2);
		lgin.add(b3);
		lgin.add(b0);
		lgin.add(bc);
		lgin.add(be);
		
		lgin.setBounds(430, 330, P_WIDTH, P_HEIGHT);
		add(lgin);
		
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String num = e.getActionCommand();
		String result = text.getText();
		
		if(num.equals("←"))
		{
			if(result.equals(""))
			{
				text.setText("");
			}
			
			else
			{
				text.setText(result.substring(0,result.length()-1));
				pwd=result.substring(0,result.length()-1);
			}
			
		}
		
		else if(num.equals("Enter"))
		{
			if(pwd.equals(upwd))
			{
				JOptionPane.showMessageDialog(null, "관리자 계정으로 로그인하셨습니다.", "WARNING", JOptionPane.INFORMATION_MESSAGE);
				new Manager();
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "틀린 비밀번호입니다. 다시 입력하세요.", "WARNING", JOptionPane.INFORMATION_MESSAGE);
				text.setText("");
				pwd="";
			}
		}
		
		else
		{
			if(pwd.equals(""))
			{
				pwd=num;
			}
			
			else
			{
				pwd=pwd+num;
			}
			text.setText(result+"*");
			
		}
		
	}

}
