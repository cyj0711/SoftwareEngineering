import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.DriverManager;

public class ItemManager extends JFrame implements ActionListener{

	Connection conn;
	
	public ItemManager() {
	
	try
	{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","0711");
		
		System.out.println("데이터 베이스 연결 성공");
	}
	catch(Exception e)
	{
		System.out.println("오류:"+e);
	}
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
