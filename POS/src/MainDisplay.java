import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainDisplay extends JFrame implements ActionListener {

	private final int B_WIDTH = 260;
	private final int B_HEIGHT=160;
	
	public MainDisplay() {
	
		super("메인 화면");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//label 붙이기 위한 panel 생성
		JPanel plabel = new JPanel();
		plabel.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("메인 화면", JLabel.CENTER);
		l1.setFont(new Font("굴림", Font.BOLD, 50));
		
		plabel.add(l1);
		plabel.setBounds(0,100,Demo.WIDTH, 170);
		add(plabel);
		
		//버튼 붙이기 위한 panel 생성
		JPanel pbutton = new JPanel();
		pbutton.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("상품판매");
		b1.setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
		JButton b2 = new JButton("포스관리");
		b2.setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
		JButton b3 = new JButton("나가기");
		b3.setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
		
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
		
		if(result.equals("상품판매")) //판매 화면 생성
		{
			new Sell();
		}
		
		else if(result.equals("포스관리")) //관리 화면 생성
		{
			new Login();
		}
		
		else if(result.equals("나가기")) //프로그램 종료
		{
			System.exit(0);
		}
	}

}
