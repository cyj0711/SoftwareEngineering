import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteItem extends JFrame implements ActionListener {

	private final int WIDTH = 700;
	private final int HEIGHT = 400;
	
	public DeleteItem() {
		super("��ǰ �̸� �Է�");
		setSize(this.WIDTH, this.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//��ǰ �̸� �ޱ�
		JPanel iname = new JPanel();
		iname.setLayout(new FlowLayout());
		
		JLabel name = new JLabel("��ǰ �̸�: ");
		JTextField tname = new JTextField(30);
		
		iname.add(name);
		iname.add(tname);
		
		iname.setBounds(100,100,500,100);
		
		add(iname);
		
		JButton check = new JButton("Ȯ��");
		check.addActionListener(this);
		
		check.setBounds(300,250,100,50);
		add(check);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String result = e.getActionCommand();
		
		if(result.equals("Ȯ��"))
		{
			dispose();
		}
		
	}
}
