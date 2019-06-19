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
	
	private String col[] = {"��ǰ��", "����"};
	private String row[][]= {};
	
	public ItemManager() {
		super("��ǰ ����");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		JButton add = new JButton("��ǰ �߰�");
		JButton delete = new JButton("��ǰ ����");
		JButton close = new JButton("�ݱ�");
		
		add.addActionListener(this);
		delete.addActionListener(this);
		close.addActionListener(this);
		
		add.setBounds(750,50,150,90);
		delete.setBounds(910, 50, 150, 90);
		close.setBounds(1070, 50, 150, 90);
		
		add(add);
		add(delete);
		add(close);
		
		//��ǰ ����� �����
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
		
		if(result.equals("��ǰ �߰�"))
		{
			new AddItem();
		}
		
		else if(result.equals("��ǰ ����"))
		{
			new DeleteItem();
		}
		
		else if(result.equals("�ݱ�"))
		{
			dispose();
		}
	}

}
