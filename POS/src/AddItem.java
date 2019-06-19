import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItem extends JFrame implements ActionListener {

	private final int WIDTH = 700;
	private final int HEIGHT = 400;
	
	public AddItem() {
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
		JTextField tname = new JTextField(30);
		
		iname.add(name);
		iname.add(tname);
		
		//상품 가격 받기
		JPanel iprice = new JPanel();
		iprice.setLayout(new FlowLayout());
		
		JLabel price = new JLabel("상품 가격: ");
		JTextField tprice = new JTextField(30);
		
		iprice.add(price);
		iprice.add(tprice);
		
		iname.setBounds(100,70,500,100);
		iprice.setBounds(100,170,500,50);
		
		add(iname);
		add(iprice);
		
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
		
		if(result.equals("확인"))
		{
			dispose();
		}
		
	}
}
