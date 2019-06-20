
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

public class Card extends JFrame implements ActionListener { //ī�� ����â�� ����

	private final int WIDTH = 900; // frame â ����
	private final int HEIGHT = 600; // frame â ����
	
	private final int P_WIDTH = 400; // panel ����
	private final int P_HEIGHT = 50; // panel ����
	
	private final int K_WIDTH = 200; // key panel ����
	private final int K_HEIGHT = 250; // key panel ����
	
	private JTextField t1; // ��� �ݾ� ����� ���� textfield
	private JTextField t2; // ���� �ݾ� ����� ���� textfield
	private JTextField cardNum; // ī�� ��ȣ ����� ���� textfield
	public static JTextField fMonth; // �Һ� ���� ����� ���� textfield
	
	private JPanel cal1; // ��� �ݾ� �г�
	private JPanel cal2; // ���� �ݾ� �г�
	private JPanel pcard; // ī�� ��ȣ �г�
	private JPanel pnum; // �����е� ����� ���� �г�
	private JPanel pMonth; // �Һ� ǥ�ø� ���� �г�
	
	private JLabel l2; 
	
	private int total; // ���� �ݾ�
	private int change; // �Ž�����
	public static String payMonth; //�Һΰ���
	
	private DBconnector db;

	
	public Card(String total) {
		
		super("ī�� ����");
		this.total = Integer.parseInt(total); // �����ڷ� ���� string type�� ���� �ݾ��� int�� �ٲ��ش�
		
		try {
			db = new DBconnector();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//frame ����
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//���� �ݾ�, ī�� ��ȣ textfield
		moneyPanel(50, 100, P_WIDTH, P_HEIGHT);
		
		//���� �Է� ��ư
		makeKeypad(450, 100, K_WIDTH, K_HEIGHT);
		
		//�� �� ��ư
		makeButton(670, 110, 150, 70);
		
		setVisible(true);
	}
	
	public void moneyPanel(int row, int col, int width, int height) {
		//�� �ݾ� ����� ���� panel ����
		cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("�����ݾ�"); 
		t1 = new JTextField(Integer.toString(this.total), 20); //�����ؾ��� �� �ݾ�
		t1.setHorizontalAlignment(JTextField.RIGHT);
		t1.setEditable(false);
		
		JLabel won1= new JLabel("��");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		
		//���� �ݾ� ����� ���� panel ����
		cal2 = new JPanel();
		cal2.setLayout(new FlowLayout());
		
		l2 = new JLabel("�����ݾ�");
		t2 = new JTextField(Integer.toString(this.total), 20); //ī������ؾ��� �ݾ�
		t2.setHorizontalAlignment(JTextField.RIGHT);
		JLabel won2= new JLabel("��");
		
		cal2.add(l2);
		cal2.add(t2);
		cal2.add(won2);
		
		//ī�� ��ȣ ǥ�ø� ���� panel ����
		pcard = new JPanel();
		pcard.setLayout(new FlowLayout());
		
		JLabel l3 = new JLabel("ī���ȣ");
		cardNum = new JTextField(22); //ī���ȣ �Է��� ���� textfield
		cardNum.setHorizontalAlignment(JTextField.LEFT);
		
		pcard.add(l3);
		pcard.add(cardNum);
		
		//�Һ� ǥ�ø� ���� panel ����
		pMonth = new JPanel();
		pMonth.setLayout(new FlowLayout());
		
		JLabel l4 = new JLabel("�Һΰ���");
		fMonth = new JTextField("�Ͻú�", 10); //�Һΰ��� �������� ������ �Ͻúҷ� ǥ��
		fMonth.setHorizontalAlignment(JTextField.CENTER);
		
		pMonth.add(l4);
		pMonth.add(fMonth);
		
		//panel�� ���� ��ġ�� ������ ����
		cal1.setBounds(row, col, width, height);
		cal2.setBounds(row, col+50, width, height);
		pcard.setBounds(row, col+100, width, height);
		pMonth.setBounds(row, col+150, width, height);
		
		//panel�� frame�� ���̱�
		add(cal1);
		add(cal2);
		add(pcard);
		add(pMonth);

	}
	
	public void makeKeypad(int row, int col, int width, int height) {
		//����Ű�� ���� panel ����
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
	
	public void makeButton(int row, int col, int width, int height) {
		
		JButton bcash = new JButton("�Һ� ����");
		bcash.addActionListener(this);
		
		//���� ��û�� ���� ��ư ����
		JButton bapprove = new JButton("���� ��û");
		bapprove.addActionListener(this);
		
		//�ݱ� ��ư ����
		JButton bclose = new JButton("�ݱ�");
		bclose.addActionListener(this);
				
		
		//button�� ���� ��ġ�� ������ ����
		bcash.setBounds(row, col, width, height);
		bapprove.setBounds(row, col+80, width, height);
		bclose.setBounds(row, col+160, width, height);
		
		//button�� frame�� ���̱�
		add(bcash);
		add(bapprove);
		add(bclose);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = e.getActionCommand(); //���� ��ư ������ ��
		String getText = cardNum.getText(); //ī�� ��ȣ�� �޾ƿ´�
		
		int getMoney; //���� ��
		
		if(result.equals("�Һ� ����"))
		{
			new PayMonth(); //�Һ� â ����
		}
		
		else if(result.equals("���� ��û"))
		{
			if(getText.length()==0)
			{
				JOptionPane.showMessageDialog(null, "ī�带 �����⿡ �Ⱦ��ּ���.", "���� ���", JOptionPane.WARNING_MESSAGE);
			}
			
			else if(getText.length() != 16)
			{
				JOptionPane.showMessageDialog(null, "��ȿ���� ���� ī���Դϴ�.", "���� ���", JOptionPane.WARNING_MESSAGE);
			}
			
			else {
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
				try {
					db.sellItem(Sell.dtm);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}			
		}
		
		else if(result.equals("�ݱ�"))
		{
			dispose();
		}
		
		else if(result.equals("��")) //����� ��ư Ŭ������ ��
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
		
		else //���� ��ư Ŭ������ ��
		{
			getText=getText+result;
			cardNum.setText(getText);
			
		}
	}

}
