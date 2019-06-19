import java.sql.SQLException;

public class Demo {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		DBconnector db = new DBconnector();
		db.addItem("good", 7000);
		//db.deleteItem("letsgo", 0);
		db.searchItems();
		

		//new MainDisplay();
		//new Login();
		//new Cash("3000");
		//new Card("5000");
		//new CashReceipt("3000");
		//new PayMonth();
		//new Point("3000");
		//new Sell();
		//new Sell();
		
	}

	
}
