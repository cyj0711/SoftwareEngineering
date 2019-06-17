import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Card extends JFrame implements ActionListener {

	private final int WIDTH = 600;
	private final int HEIGHT = 700;
	
	public Card(String total) {
		super("ī�� ����");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//�� �ݾ� ����� ���� panel ����
		JPanel cal1 = new JPanel();
		cal1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("�����ݾ�");
		JTextField t1 = new JTextField(20);
		t1.setEditable(false);
		t1.setText(total);
		
		JLabel won1= new JLabel("��");
		
		cal1.add(l1);
		cal1.add(t1);
		cal1.add(won1);
		 
		cal1.setBounds(0, 70, WIDTH, 50);
		add(cal1);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
