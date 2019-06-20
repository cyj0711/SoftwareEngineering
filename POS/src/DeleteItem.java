import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteItem extends JFrame implements ActionListener {

	private final int WIDTH = 700;
	private final int HEIGHT = 400;
	
	private JTextField tname;
	
	private String itemName;

	public DBconnector db;
	
	public DeleteItem() {
		super("상품 이름 입력");
		
		setSize(this.WIDTH, this.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//상품 이름 받기
		JPanel iname = new JPanel();
		iname.setLayout(new FlowLayout());
		
		JLabel name = new JLabel("상품 이름: ");
		tname = new JTextField(30);
		
		iname.add(name);
		iname.add(tname);
		
		iname.setBounds(100,100,500,100);
		
		add(iname);
		
		JButton check = new JButton("확인");
		check.addActionListener(this);
		
		check.setBounds(300,250,100,50);
		add(check);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand();
		
		try {
			db = new DBconnector();
		} 
		
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(result.equals("확인"))
		{
			itemName = tname.getText();
			try {
				int tcnt = ItemManager.dtm.getRowCount();
				int i;
				for(i=0; i<tcnt; i++) {
					if(ItemManager.dtm.getValueAt(i, 0).equals(itemName))
					{
						ItemManager.dtm.removeRow(i);
						break;
					}
				}
				
				if(i==tcnt)
				{
					JOptionPane.showMessageDialog(null, "일치하는 메뉴가 없습니다.", "메뉴 삭제 취소", JOptionPane.WARNING_MESSAGE);
				}
				
				db.deleteItem(itemName);
				
			} 
			
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}
		
	}
}
