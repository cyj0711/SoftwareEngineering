import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sell extends JFrame implements ActionListener {

	private Vector col;
	
	public Sell() {
		super("Sell");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		
		JScrollPane scroll = new JScrollPane();
		
		col = new Vector();
		col.add("상품명");
		col.add("수량");
		col.add("금액");
		col.add("할인액");
		
		DefaultTableModel dtm = new DefaultTableModel();
		JTable table = new JTable();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
