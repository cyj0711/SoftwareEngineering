
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Sell extends JFrame implements ActionListener {

	private final int S_WIDTH = 640;
	private final int S_HEIGHT = 450;
	
	private int totalNum=0;
	private int totalPrice=0;
	
	public static int getMoney=0;
	public static int change=0;
	
	private String col[] = {"상품명", "수량", "금액", "할인액"};
	private String row[][] = {};
	
	public DBconnector db;
	
	public ArrayList<ItemBean> temp = null;
	private int count = 0;
	
	private JButton[] item =new JButton[20];
	
	private DefaultTableModel dtm;
	private JTable table;
	
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	
	public Sell() {
		
		//frame setting
		super("판매 화면");
		
		try {
			db = new DBconnector();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//주문할 상품 리스트를 띄워줄 table을 scrollpane에 넣음
		dtm = new DefaultTableModel(row, col);
		table = new JTable(dtm);
		table.setFillsViewportHeight(true);
		
		JScrollPane list = new JScrollPane(table);
	
		list.setBounds(0,0,S_WIDTH,S_HEIGHT);
		add(list);
		
		makePanel(S_WIDTH,0,50,S_HEIGHT+180);
		//makeSortPanel(730,0,550,90);
		makeItemPanel(690,0,590,450);
		bottomPanel(0,450,430,60);
		
		JPanel temp = new JPanel();
		temp.setBackground(Color.WHITE);
		temp.setBounds(0,630,Demo.WIDTH, 90);
		add(temp);
		setVisible(true);
	}
	
	public void makePanel(int row, int col, int width, int height) {
		
		JPanel pmid = new JPanel();
		
		pmid.setBackground(Color.WHITE);
		
		pmid.setBounds(row, col, width, height);
		add(pmid);
		
	}
	
	
	public void makeItemPanel(int row, int col, int width, int height) {
		//상품 보여주는 패널
		JPanel pitem = new JPanel();
		pitem.setLayout(new GridLayout(5,4));
		
		String itemName;
		String itemPrice;
		
		int i;
		
		try {
			temp = db.searchItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		for(i=0; i<20; i++) {
			item[i] = new JButton();
			item[i].addActionListener(this);
			pitem.add(item[i]);
		}
		
		i=0;
		for(ItemBean b : temp) {
			item[i].setText(b.getName());
			i++;
			count++;
		}
		

		pitem.setBounds(row, col, width, height);
		add(pitem);
		
	}
	
	public void bottomPanel(int row, int col, int width, int height) {
		
		JPanel bot1 = new JPanel();
		bot1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("결제금액: ");
		t1 = new JTextField("0", 30);
		t1.setEditable(false);
		
		bot1.add(l1);
		bot1.add(t1);
		
		bot1.setBounds(row, col, width, height);
		add(bot1);
		
		JPanel bot2 = new JPanel();
		bot2.setLayout(new FlowLayout());
		
		JLabel l2 = new JLabel("받은금액: ");
		t2 = new JTextField("0", 30);
		t2.setEditable(false);
		
		bot2.add(l2);
		bot2.add(t2);
		
		bot2.setBounds(row, col+60, width, height);
		add(bot2);
		
		JPanel bot3 = new JPanel();
		bot3.setLayout(new FlowLayout());
		
		JLabel l3 = new JLabel("거스름돈: ");
		t3 = new JTextField(30);
		t3.setEditable(false);
		
		bot3.add(l3);
		bot3.add(t3);
		
		bot3.setBounds(row, col+120, width, height);
		add(bot3);
		
		JPanel bot4 = new JPanel();
		bot4.setLayout(new FlowLayout());
		JLabel l4 = new JLabel("수량: ");
		t4 = new JTextField("0", 10);
		t4.setEditable(false);
		
		bot4.add(l4);
		bot4.add(t4);
		
		bot4.setBounds(row+width, col, 210, 90);
		add(bot4);
		
		JPanel bot5 = new JPanel();
		bot5.setLayout(new GridLayout(1,2));
		
		
		JButton b2 = new JButton("카드");
		JButton b3 = new JButton("현금");
		
		
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		bot5.add(b2);
		bot5.add(b3);
		
		bot5.setBounds(row+width, col+90, 210,90);
		add(bot5);
		
		JButton close = new JButton("닫기");
		close.addActionListener(this);
		close.setBounds(1130,540,150,90);
		add(close);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand();
		int j;
		
		
		if(result.equals("카드"))
		{
			new Card(Integer.toString(totalPrice));
			t2.setText(Integer.toString(totalPrice));
			t3.setText("0");
			
			try {
				db.sellItem(dtm);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dispose();
			
		}
		
		else if(result.equals("현금"))
		{
			Cash c1 = new Cash(Integer.toString(totalPrice));
			try {
				db.sellItem(dtm);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}
		
		else if(result.equals("닫기"))
		{
			dispose();
		}
		
		
		
		else 
		{
			//dtm: 테이블
			//temp: list
			//item: 버튼
			for(int i=0; i<count; i++) {
				if(result.equals(item[i].getText()))
				{
					
					for(j=0; j<dtm.getRowCount(); j++) {
						if(dtm.getValueAt(j, 0).equals(temp.get(i).getName()))
						{
							int ctemp = (int) dtm.getValueAt(j, 1);
							dtm.setValueAt(ctemp+1, j, 1);
							int ptemp = (int) dtm.getValueAt(j, 2);
							dtm.setValueAt((ctemp+1)*temp.get(i).getCost(), j, 2);
							totalPrice+=temp.get(i).getCost();
							break;
						}
										
					}
					
					if(j==dtm.getRowCount())
					{
						Object[] t = {temp.get(i).getName(), 1, temp.get(i).getCost(), "0"};
						dtm.addRow(t);
						totalPrice += temp.get(i).getCost();
					}
					
					
				}
			}
			
			t1.setText(Integer.toString(totalPrice));
			t4.setText(Integer.toString(++totalNum));
			
		}
	}

}
