import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PayMonth extends JFrame implements ActionListener { //�Һ� â

	private final int WIDTH = 280;
	private final int HEIGHT = 150;
	
	private JPanel pay;
	
	public PayMonth() {
		super("�Һ� �Է�");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//�Һ� ���� �����ϱ�
		pay = new JPanel();
		pay.setLayout(new FlowLayout());
		
		String[] option = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "18", "24"};
		
		JLabel opt = new JLabel("�Һ� ����");
		JComboBox optionCombo = new JComboBox(option);
		optionCombo.setPreferredSize(new Dimension(140, 20));
		optionCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.payMonth = optionCombo.getSelectedItem().toString();
			}
		});
		
		pay.add(opt);
		pay.add(optionCombo);
		
		pay.setBounds(0, 0, 280, 50);
		add(pay);
		
		JButton b1 = new JButton("Ȯ��");
		b1.addActionListener(this);
		
		b1.setBounds(100, 50, 80, 40);
		add(b1);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand();
		
		if(result.equals("Ȯ��")) 
		{
			Card.fMonth.setText(Card.payMonth + " ����");
			dispose();
		}
		
	}

}
