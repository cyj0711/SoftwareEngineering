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
		super("���� ����");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//�� �ݾ� ����� ���� panel ����
		JPanel cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("�����ݾ�");
		t1 = new JTextField(20);
		t1.setHorizontalAlignment(JTextField.RIGHT);
		t1.setEditable(false);
		t1.setText(total);
		
		JLabel won1= new JLabel("��");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		
		//���� �ݾ� ����� ���� panel ����
		JPanel cal2 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l2 = new JLabel("�����ݾ�");
		t2 = new JTextField(20);
		t2.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel won2= new JLabel("��");
		
		cal2.add(l2);
		cal2.add(t2);
		cal2.add(won2);
		
		//�Ž����� ����� ���� panel ����
		JPanel cal3 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l3 = new JLabel("�Ž�����");
		t3 = new JTextField(20);
		t3.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel won3= new JLabel("��");
		
		cal3.add(l3);
		cal3.add(t3);
		cal3.add(won3);
		
		//����Ű�� ���� panel ����
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
		JButton bc = new JButton("��");
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
		
		//���ݿ����� ��û�� ���� ��ư ����
		JButton bcash = new JButton("���ݿ�����");
		bcash.addActionListener(this);
		
		//���� ��û�� ���� ��ư ����
		JButton bapprove = new JButton("���� ��û");
		bapprove.addActionListener(this);
		
		//�ݱ� ��ư ����
		JButton bclose = new JButton("�ݱ�");
		bclose.addActionListener(this);
				
		
		//panel�� ���� ��ġ�� ������ ����
		cal1.setBounds(0, 70, WIDTH, 50);
		cal2.setBounds(0, 170, WIDTH, 50);
		cal3.setBounds(0, 270, WIDTH, 50);
		pnum.setBounds(100, 350, 200, 250);
		
		//button�� ���� ��ġ�� ������ ����
		bcash.setBounds(330, 350, 150, 50);
		bapprove.setBounds(330, 450, 150, 50);
		bclose.setBounds(330, 550, 150, 50);
		
		
		//panel�� button�� frame�� ���̱�
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
		
		int total; //�� �ݾ�
		int getMoney; //���� ��
		int change; //�Ž�����
		
		if(result.equals("���ݿ�����"))
		{
			new CashReceipt();
		}
		
		else if(result.equals("���� ��û"))
		{
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.\n�Ž������� Ȯ�����ּ���.", "���� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		
		else if(result.equals("�ݱ�"))
		{
			dispose();
		}
		
		else if(result.equals("��")) //����� ��ư Ŭ������ ��
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
		
		else if(result.equals("Enter")) //enter ��ư Ŭ������ ��
		{
			total=Integer.parseInt(getText1);
			getMoney=Integer.parseInt(getText2);
			change = getMoney-total;
			t3.setText(Integer.toString(change));
		}
		
		else //���� ��ư Ŭ������ ��
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
