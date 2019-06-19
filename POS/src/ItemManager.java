import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ItemManager extends JFrame implements ActionListener {

	private final int S_WIDTH = 680;
	private final int S_HEIGHT = 450;
	
	private String col[] = {"상품명", "가격"};
	private String row[][]= {};
	
	public ItemManager() {
		super("상품 관리");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		JButton add = new JButton("상품 추가");
		JButton delete = new JButton("상품 삭제");
		JButton close = new JButton("닫기");
		
		add.addActionListener(this);
		delete.addActionListener(this);
		close.addActionListener(this);
		
		add.setBounds(750,50,150,90);
		delete.setBounds(910, 50, 150, 90);
		close.setBounds(1070, 50, 150, 90);
		
		add(add);
		add(delete);
		add(close);
		
		//상품 목록을 띄워줌
		DefaultTableModel dtm = new DefaultTableModel(row,col);
		JTable table = new JTable(dtm);
		table.setFillsViewportHeight(true);
		
		JScrollPane list = new JScrollPane(table);
	
		list.setBounds(300,150,S_WIDTH,S_HEIGHT);
		add(list);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = e.getActionCommand();
		
		if(result.equals("상품 추가"))
		{
			new AddItem();
		}
		
		else if(result.equals("상품 삭제"))
		{
			new DeleteItem();
		}
		
		else if(result.equals("닫기"))
		{
			dispose();
		}
	}

}
