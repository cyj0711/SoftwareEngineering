import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sell extends JFrame implements ActionListener {

	private final int S_WIDTH = 640;
	private final int S_HEIGHT = 450;
	
	private String col[] = {"상품명", "수량", "금액", "할인액"};
	private String row[][]= {};
	
	public Sell() {
		
		//frame setting
		super("판매 화면");
		setSize(Demo.WIDTH, Demo.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//주문할 상품 리스트를 띄워줄 table을 scrollpane에 넣음
		DefaultTableModel dtm = new DefaultTableModel(row,col);
		JTable table = new JTable(dtm);
		table.setFillsViewportHeight(true);
		
		JScrollPane list = new JScrollPane(table);
	
		list.setBounds(0,0,S_WIDTH,S_HEIGHT);
		add(list);
		
		makeCountPanel(S_WIDTH,0,90,S_HEIGHT+180);
		//makeSortPanel(730,0,550,90);
		makeItemPanel(730,0,550,450);
		
		setVisible(true);
	}
	
	public void makeCountPanel(int row, int col, int width, int height) {
		//상품 수량 조절하는 패널 만들기
		JPanel pmid = new JPanel();
		pmid.setLayout(new GridLayout(7,1));
		
		JButton badd = new JButton("+");
		JButton bsub = new JButton("-");
		JButton bcancel = new JButton("지정취소");
		JButton bup = new JButton("↑");
		JButton bdown = new JButton("↓");
		JButton bIdc = new JButton("상품할인");
		JButton bdc = new JButton("전체할인");
		
		pmid.add(badd);
		pmid.add(bsub);
		pmid.add(bcancel);
		pmid.add(bup);
		pmid.add(bdown);
		pmid.add(bIdc);
		pmid.add(bdc);
		
		pmid.setBounds(row, col, width, height);
		add(pmid);
		
	}
	
	/*public void makeSortPanel(int row, int col, int width, int height) {
		//상품 종류 보여주는 패널 만들기
		JPanel psort = new JPanel();
		psort.setLayout(new GridLayout(2,4));
		
		JButton s1 = new JButton("1");
		JButton s2 = new JButton("2");
		JButton s3 = new JButton("3");
		JButton s4 = new JButton("4");
		JButton s5 = new JButton("5");
		JButton s6 = new JButton("6");
		JButton s7 = new JButton("7");
		JButton s8 = new JButton("8");
		
		psort.add(s1);
		psort.add(s2);
		psort.add(s3);
		psort.add(s4);
		psort.add(s5);
		psort.add(s6);
		psort.add(s7);
		psort.add(s8);
		
		psort.setBounds(row, col, width, height);
		add(psort);
	}*/
	
	public void makeItemPanel(int row, int col, int width, int height) {
		//상품 보여주는 패널
		JPanel pitem = new JPanel();
		pitem.setLayout(new GridLayout(5,4));
		
		JButton i1 = new JButton();
		JButton i2 = new JButton();
		JButton i3 = new JButton();
		JButton i4 = new JButton();
		JButton i5 = new JButton();
		JButton i6 = new JButton();
		JButton i7 = new JButton();
		JButton i8 = new JButton();
		JButton i9 = new JButton();
		JButton i10 = new JButton();
		JButton i11 = new JButton();
		JButton i12 = new JButton();
		JButton i13 = new JButton();
		JButton i14 = new JButton();
		JButton i15 = new JButton();
		JButton i16 = new JButton();
		JButton i17 = new JButton();
		JButton i18 = new JButton();
		JButton i19 = new JButton();
		JButton i20 = new JButton();
		
		pitem.add(i1);
		pitem.add(i2);
		pitem.add(i3);
		pitem.add(i4);
		pitem.add(i5);
		pitem.add(i6);
		pitem.add(i7);
		pitem.add(i8);
		pitem.add(i9);
		pitem.add(i10);
		pitem.add(i11);
		pitem.add(i12);
		pitem.add(i13);
		pitem.add(i14);
		pitem.add(i15);
		pitem.add(i16);
		pitem.add(i17);
		pitem.add(i18);
		pitem.add(i19);
		pitem.add(i20);
		
		pitem.setBounds(row, col, width, height);
		add(pitem);
		
	}
	
	public void bottomPanel(int row, int col, int width, int height) {
		
		//JPanel pleft
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
