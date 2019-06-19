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
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;import java.sql.PreparedStatement;

import java.util.ArrayList;

public class DBconnector extends JFrame implements ActionListener{

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	
	String url =  "jdbc:mysql://localhost:3306/pos_db?serverTimezone=UTC";
	String user = "root";
	String pw = "0711";
	
	
	public DBconnector() throws SQLException {
	
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<ItemBean> searchItems() throws SQLException
	{
		try
		{
			conn=DriverManager.getConnection(url,user,pw);
			System.out.println("������ ���̽� ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		try
		{
			stmt=conn.createStatement();
			System.out.println("Statement ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		try
		{
			rs=stmt.executeQuery("SELECT * FROM pos_item");
			System.out.println("Result ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		ArrayList<ItemBean> list = new ArrayList<ItemBean>();
		
		while(rs.next()) {
			ItemBean bean = new ItemBean();
			bean.setId(rs.getInt("_id"));
			bean.setName(rs.getString("name"));
			bean.setCost(rs.getInt("cost"));
			bean.setCount(rs.getInt("count"));
			bean.showInfo();
			list.add(bean);
		}
	
		System.out.println("search �Ϸ�");
		
		 if (rs != null) try { rs.close();System.out.println("rs ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
			
		 if (stmt != null) try { stmt.close();System.out.println("Statement ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
			
		 if (conn != null) try { conn.close();System.out.println("������ ���̽� ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
		
		 return list;
	}
		
	public void addItem(String name, int cost) throws SQLException
	{
		try
		{
			conn=DriverManager.getConnection(url, user,pw);
			System.out.println("������ ���̽� ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		try
		{
			pstmt=conn.prepareStatement("insert into pos_item(name,cost) values(?,?)");
			System.out.println("pstmt ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		pstmt.setString(1,name);
		pstmt.setInt(2, cost);
		
		int r = pstmt.executeUpdate();
		
		System.out.println("����� row : "+r);
		
		if (pstmt != null) try { pstmt.close();System.out.println("pStatement ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
			
		if (conn != null) try { conn.close();System.out.println("������ ���̽� ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
		
	}
	
	public void deleteItem(String name, int cost) throws SQLException
	{
		try
		{
			conn=DriverManager.getConnection(url, user,pw);
			System.out.println("������ ���̽� ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		try
		{
			pstmt=conn.prepareStatement("delete from pos_item where name=?");
			System.out.println("pstmt ���� ����");
		}
		catch(Exception e)
		{
			System.out.println("����:"+e);
		}
		
		pstmt.setString(1,name);
		
		int r = pstmt.executeUpdate();
		
		System.out.println("����� row : "+r);
		
		if (pstmt != null) try { pstmt.close();System.out.println("pStatement ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
			
		if (conn != null) try { conn.close();System.out.println("������ ���̽� ���� ����"); } catch(Exception e) {System.out.println("����:"+e);}
	}
	}

