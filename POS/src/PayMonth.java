import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PayMonth extends JFrame implements ActionListener { //할부 창

	private final int WIDTH = 280;
	private final int HEIGHT = 150;
	
	private JPanel pay;
	
	public PayMonth() {
		super("할부 입력");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//할부 개월 선택하기
		pay = new JPanel();
		pay.setLayout(new FlowLayout());
		
		String[] option = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "18", "24"};
		
		JLabel opt = new JLabel("할부 개월");
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
		
		JButton b1 = new JButton("확인");
		b1.addActionListener(this);
		
		b1.setBounds(100, 50, 80, 40);
		add(b1);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand();
		
		if(result.equals("확인")) 
		{
			Card.fMonth.setText(Card.payMonth + " 개월");
			dispose();
		}
		
	}

}
