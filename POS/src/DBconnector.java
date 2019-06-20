import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class DBconnector {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC";
	String user = "root";
	String pw = "wndwjs0327";

	public DBconnector() throws SQLException {

	}

	public ArrayList<ItemBean> searchItems() throws SQLException {
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("������ ���̽� ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		try {
			stmt = conn.createStatement();
			System.out.println("Statement ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		try {
			rs = stmt.executeQuery("SELECT * FROM pos_item");
			System.out.println("Result ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		ArrayList<ItemBean> list = new ArrayList<ItemBean>();

		while (rs.next()) {
			ItemBean bean = new ItemBean();
			bean.setId(rs.getInt("_id"));
			bean.setName(rs.getString("name"));
			bean.setCost(rs.getInt("cost"));
			bean.setCount(rs.getInt("count"));
			bean.showInfo();
			list.add(bean);
		}

		System.out.println("search �Ϸ�");

		if (rs != null)
			try {
				rs.close();
				System.out.println("rs ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Statement ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		if (conn != null)
			try {
				conn.close();
				System.out.println("������ ���̽� ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		return list;
	}

	public void addItem(String name, int cost) throws SQLException {
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("������ ���̽� ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		try {
			pstmt = conn.prepareStatement("insert into pos_item(name,cost) values(?,?)");
			System.out.println("pstmt ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		pstmt.setString(1, name);
		pstmt.setInt(2, cost);

		int r = pstmt.executeUpdate();

		System.out.println("����� row : " + r);

		if (pstmt != null)
			try {
				pstmt.close();
				System.out.println("pStatement ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		if (conn != null)
			try {
				conn.close();
				System.out.println("������ ���̽� ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

	}

	public void deleteItem(String name) throws SQLException {
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("������ ���̽� ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		try {
			pstmt = conn.prepareStatement("delete from pos_item where name=?");
			System.out.println("pstmt ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}

		pstmt.setString(1, name);

		int r = pstmt.executeUpdate();

		System.out.println("����� row : " + r);

		if (pstmt != null)
			try {
				pstmt.close();
				System.out.println("pStatement ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		if (conn != null)
			try {
				conn.close();
				System.out.println("������ ���̽� ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
	}

	public void sellItem(DefaultTableModel table) throws SQLException {
		int kind;
		int buy_count;
		int count=0;
		String name;
		kind = table.getRowCount();

		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("������ ���̽� ���� ����");
		} catch (Exception e) {
			System.out.println("����:" + e);
		}


		for (int i = 0; i < kind; i++) {
			
			name=(String) table.getValueAt(i, 0);
			buy_count=(int)table.getValueAt(i, 1);

			try {
				pstmt = conn.prepareStatement("SELECT * FROM pos_item where name=?");
				System.out.println("Statement ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
			
			pstmt.setString(1,name);

			try {
				rs = pstmt.executeQuery();
				System.out.println("Result ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
			
			if(rs.next()) {
			count = rs.getInt("count");
			}
			
			try {
				pstmt = conn.prepareStatement("update pos_item set count=? where name=?");
				System.out.println("Statement ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
			
			pstmt.setInt(1, count+buy_count);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
			

			System.out.println("count �Ϸ�");

		}

		if (rs != null)
			try {
				rs.close();
				System.out.println("rs ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Statement ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

		if (conn != null)
			try {
				conn.close();
				System.out.println("������ ���̽� ���� ����");
			} catch (Exception e) {
				System.out.println("����:" + e);
			}

	}
}
