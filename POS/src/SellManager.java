import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SellManager extends JFrame implements ActionListener {

	private final int S_WIDTH = 800;
	private final int S_HEIGHT = 500;
	
	private String col[] = {"��ǰ��", "����", "�� �����"};
	private String row[][]= {};
	
	public SellManager() {
		super("���� ��Ȳ");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		JButton close = new JButton("�ݱ�");
		close.addActionListener(this);
		
		close.setBounds(1100, 30, 100, 50);
		add(close);
		
		//���� ��Ȳ �����ش�
		DefaultTableModel dtm = new DefaultTableModel(row,col);
		JTable table = new JTable(dtm);
		table.setFillsViewportHeight(true);
		
		JScrollPane list = new JScrollPane(table);
	
		list.setBounds(240,100,S_WIDTH,S_HEIGHT);
		add(list);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = e.getActionCommand();
		
		if(result.equals("�ݱ�"))
		{
			dispose();
		}
	}

}
