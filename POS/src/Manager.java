import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Manager extends JFrame implements ActionListener {

	private final int BWIDTH = 260;
	private final int BHEIGHT=160;
	public Manager() {
	
		super("Manager");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//label ���̱� ���� panel ����
		JPanel plabel = new JPanel();
		plabel.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("���� ����", JLabel.CENTER);
		l1.setFont(new Font("����", Font.BOLD, 50));
		
		plabel.add(l1);
		plabel.setBounds(0,100,Demo.WIDTH, 170);
		add(plabel);
		
		//��ư ���̱� ���� panel ����
		JPanel pbutton = new JPanel();
		pbutton.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("��ǰ����");
		b1.setPreferredSize(new Dimension(BWIDTH,BHEIGHT));
		JButton b2 = new JButton("�������");
		b2.setPreferredSize(new Dimension(BWIDTH,BHEIGHT));
		JButton b3 = new JButton("�α׾ƿ�");
		b3.setPreferredSize(new Dimension(BWIDTH,BHEIGHT));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		pbutton.add(b1);
		pbutton.add(b2);
		pbutton.add(b3);
		
		pbutton.setBounds(0, 270, Demo.WIDTH, 200);
		add(pbutton);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = e.getActionCommand();
		
		if(result.equals("��ǰ����"))
		{
			new ItemManager();
		}
		
		else if(result.equals("�������"))
		{
			
		}
		
		else if(result.equals("�α׾ƿ�"))
		{
			dispose();
		}
	}
}
