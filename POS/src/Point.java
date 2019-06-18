import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Point extends JFrame implements ActionListener {

	private final int WIDTH = 700;
	private final int HEIGHT = 400;
	
	private final int K_WIDTH = 200;
	private final int K_HEIGHT = 250;
	
	private JTextField fnum;
	private JTextField fname;
	
	private String num;
	
	public Point() { //����Ʈ �������� ī��, ���� ������� 5%�� ����
		super("����Ʈ ����");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		makePanel(50,50,300,50);
		makeKeypad(400, 50, K_WIDTH, K_HEIGHT);
		
		JButton check = new JButton("Ȯ��");
		check.addActionListener(this);
		check.setBounds(150, 210, 80, 40);
		add(check);		
		
		setVisible(true);
	}
	
	public void makePanel(int row, int col, int width, int height) {
		JPanel point = new JPanel();
		point.setLayout(new FlowLayout());
		
		JLabel lnum = new JLabel("ȸ����ȣ");
		fnum = new JTextField(14);
		JButton button = new JButton("�Է�");
		button.addActionListener(this);
		
		point.add(lnum);
		point.add(fnum);
		point.add(button);
		
		JPanel name = new JPanel();
		name.setLayout(new FlowLayout());
		
		JLabel lname = new JLabel("ȸ���̸�");
		fname = new JTextField(20);
		
		name.add(lname);
		name.add(fname);
		
		point.setBounds(row, col, width, height);
		name.setBounds(row, col+60, width, height);
		
		add(point);
		add(name);
		
	}
	
	public void makeKeypad(int row, int col, int width, int height) {
		//����Ű�� ���� panel ����
		JPanel pnum = new JPanel();
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
		JButton bc = new JButton("��");
		
		
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
		
		//panel�� ���� ��ġ�� ������ ����
		pnum.setBounds(row, col, width, height);
		
		//panel�� frame�� ���̱�
		add(pnum);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = e.getActionCommand(); // ��ư�� text �о����
		String getText = fnum.getText();
		
		if(result.equals("�Է�"))
		{
			
		}
		
		else if(result.equals("Ȯ��"))
		{
			dispose();
		}
		
		else if(result.equals("��")) //����� ��ư Ŭ������ ��
		{
			if(getText.length()==0)
			{
				getText = "";
				fnum.setText(getText);
				
			}
			
			else
			{
				getText = getText.substring(0,getText.length()-1);
				fnum.setText(getText);
			}
		}
		
		else //���� ��ư Ŭ������ ��
		{
			getText=getText+result;
			fnum.setText(getText);
			
		}
		
		
	}

}
