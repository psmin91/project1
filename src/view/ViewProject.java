package view;
 
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import food.FoodBiz;
import food.FoodVO;

public class ViewProject extends JFrame{
	JFrame frame;
	JTable table;
	JPanel p1, p2;
	FoodBiz foodbiz;
	JLabel label1, label2, label3, label4;
	ArrayList<FoodVO> foodList;
	DefaultTableModel table_default;
	Font font = new Font("asd", 1, 15);

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

	private Image screenImage;
	private Graphics screenGraphic;

	private Image introBackground = new ImageIcon(ViewProject.class.getResource("" + "../images/image.jpg")).getImage();
	private JLabel menu = new JLabel(new ImageIcon(ViewProject.class.getResource("" + "../images/main.png")));

	private ImageIcon price_sort_b = new ImageIcon(ViewProject.class.getResource("" + "../images/price1.png"));
	private ImageIcon price_sort_f = new ImageIcon(ViewProject.class.getResource("" + "../images/price2.png"));

	private ImageIcon distnace_sort_b = new ImageIcon(ViewProject.class.getResource("" + "../images/distance1.png"));
	private ImageIcon distnace_sort_f = new ImageIcon(ViewProject.class.getResource("" + "../images/distance2.png"));

	private ImageIcon review_sort_b = new ImageIcon(ViewProject.class.getResource("" + "../images/review1.png"));
	private ImageIcon review_sort_f = new ImageIcon(ViewProject.class.getResource("" + "../images/review2.png"));

	private ImageIcon exit_basic = new ImageIcon(ViewProject.class.getResource("" + "../images/x1.png"));
	private ImageIcon exit_entered = new ImageIcon(ViewProject.class.getResource("" + "../images/x2.png"));

	private ImageIcon koreabutton = new ImageIcon(ViewProject.class.getResource("" + "../images/korea1.png"));
	private ImageIcon koreabutton_pressed = new ImageIcon(ViewProject.class.getResource("" + "../images/korea2.png"));

	private ImageIcon chinabutton = new ImageIcon(ViewProject.class.getResource("" + "../images/china1.png"));
	private ImageIcon chinabutton_pressed = new ImageIcon(ViewProject.class.getResource("" + "../images/china2.png"));

	private ImageIcon japanbutton = new ImageIcon(ViewProject.class.getResource("" + "../images/japan1.png"));
	private ImageIcon japanbutton_pressed = new ImageIcon(ViewProject.class.getResource("" + "../images/japan2.png"));

	private ImageIcon foriegnbutton = new ImageIcon(ViewProject.class.getResource("" + "../images/foreign1.png"));
	private ImageIcon foriegnbutton_pressed = new ImageIcon(ViewProject.class.getResource("" + "../images/foreign2.png"));

	private ImageIcon allButton = new ImageIcon(ViewProject.class.getResource("" + "../images/all1.png"));
	private ImageIcon allButton_pressed = new ImageIcon(ViewProject.class.getResource("" + "../images/all2.png"));
	
	private JButton exitbutton = new JButton(exit_basic);
	
	private JButton all= new JButton(allButton);

	private JButton korea = new JButton(koreabutton);
	private JButton china = new JButton(chinabutton);
	private JButton japan = new JButton(japanbutton);
	private JButton foreign = new JButton(foriegnbutton);

	private JButton priceSort = new JButton(price_sort_b);
	private JButton distanceSort = new JButton(distnace_sort_b);
	private JButton reviewSort = new JButton(review_sort_b);

	private int mouseX, mouseY;
	String sort,kind;
	
	public void setsort(String sort) {
		this.sort = sort;
	}
	public void setkind(String kind) {
		this.kind = kind;
	}
	public String getsort() {
		return sort;
		
	}
	public String gettkind() {
		return kind;
		
	}
	
	public ViewProject() {
		setkind("all");
		setsort("price");
		table = new JTable();
		foodbiz = new FoodBiz();
		p1 = new JPanel();
		p2 = new JPanel();


		setUndecorated(true);
		setTitle("멀티캠퍼스 점심 맞춤추천");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		////////////////////////// 버튼과 메뉴바메서드/////////////////////////
		
		
		
		
		
		exitbutton.setBounds(1260, 0, 20, 20);
		exitbutton.setBorderPainted(false);
		exitbutton.setContentAreaFilled(false);
		exitbutton.setFocusPainted(false);
		exitbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitbutton.setIcon(exit_entered);
				exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				exitbutton.setIcon(exit_basic);
				exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitbutton);
		
		all.setBounds(10, 50, 100, 100);
		all.setBorderPainted(false);
		all.setContentAreaFilled(false);
		all.setFocusPainted(false);
		all.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				all.setIcon(allButton_pressed);
				all.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				all.setIcon(allButton);
				all.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
			setkind("all");
				
			getData(kind,sort);
			}

		});
		add(all);
		

		korea.setBounds(10, 180, 100, 100);
		korea.setBorderPainted(false);
		korea.setContentAreaFilled(false);
		korea.setFocusPainted(false);
		korea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				korea.setIcon(koreabutton_pressed);
				korea.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				korea.setIcon(koreabutton);
				korea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setkind("한식");
				getData(kind,sort);
			}

		});
		add(korea);

		china.setBounds(10, 310, 100, 100);
		china.setBorderPainted(false);
		china.setContentAreaFilled(false);
		china.setFocusPainted(false);
		china.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				china.setIcon(chinabutton_pressed);
				china.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				china.setIcon(chinabutton);
				china.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setkind("중식");
				getData(kind,sort);
			}

		});
		add(china);

		japan.setBounds(10, 440, 100, 100);
		japan.setBorderPainted(false);
		japan.setContentAreaFilled(false);
		japan.setFocusPainted(false);
		japan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				japan.setIcon(japanbutton_pressed);
				japan.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				japan.setIcon(japanbutton);
				japan.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setkind("일식");
				getData(kind,sort);
			}

		});
		add(japan);

		foreign.setBounds(10, 570, 100, 100);
		foreign.setBorderPainted(false);
		foreign.setContentAreaFilled(false);
		foreign.setFocusPainted(false);
		foreign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				foreign.setIcon(foriegnbutton_pressed);
				foreign.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				foreign.setIcon(foriegnbutton);
				foreign.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setkind("양식");
				getData(kind,sort);
			}

		});
		add(foreign);

		menu.setBounds(0, 0, 1280, 20);
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				mouseX = e.getX();
				mouseY = e.getY();

			}
		});
		menu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);

			}

		});

		add(menu);

		priceSort.setBounds(700, 50, 50, 50);
		priceSort.setBorderPainted(false);
		priceSort.setContentAreaFilled(false);
		priceSort.setFocusPainted(false);
		priceSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				priceSort.setIcon(price_sort_f);
				priceSort.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				priceSort.setIcon(price_sort_b);
				priceSort.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setsort("price");
				getData(kind,sort);
			}

		});
		add(priceSort);
		distanceSort.setBounds(750, 50, 50, 50);
		distanceSort.setBorderPainted(false);
		distanceSort.setContentAreaFilled(false);
		distanceSort.setFocusPainted(false);
		distanceSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				distanceSort.setIcon(distnace_sort_f);
				distanceSort.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				distanceSort.setIcon(distnace_sort_b);
				distanceSort.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setsort("distance");
				getData(kind,sort);
			}

		});
		add(distanceSort);

		add(reviewSort);
		reviewSort.setBounds(800, 50, 50, 50);
		reviewSort.setBorderPainted(false);
		reviewSort.setContentAreaFilled(false);
		reviewSort.setFocusPainted(false);
		reviewSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				reviewSort.setIcon(review_sort_f);
				reviewSort.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				reviewSort.setIcon(review_sort_b);
				reviewSort.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			public void mousePressed(MouseEvent e) {
				setsort("review");
				getData(kind,sort);
			}

		});
		add(reviewSort);

		////////////////////////// 버튼과 메뉴바메서드/////////////////////////

		p1.setBounds(150, 50, 500, 620);
		p1.setLayout(new GridLayout());

		DefaultTableModel table_default=null; 
		String[] title = { "종류","가게이름", "가격","거리", "리뷰수","자세히" };
		table_default = new DefaultTableModel(title,0);
		table = new JTable(table_default);
	    table.getTableHeader().setBackground(new Color(0,0,0,0));
	    table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setGridColor(Color.BLUE);
		table.setFont(font);
		
		table.addMouseListener(new MouseAdapter() {
			
			JButton menu1= new JButton("메뉴");
			public void mouseEntered(MouseEvent e) {
				table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				System.out.println(1);
				JTable jt = (JTable)e.getSource();
				int rowNum = jt.getSelectedRow();
				String name=(String)jt.getValueAt(rowNum, 5);
				ImageIcon menu = new ImageIcon(ViewProject.class.getResource("" + "../menus/"+name+".png"));
				menu1= new JButton(menu);
				menu1.setBounds(700,150,550, 520);
				
				add(menu1);
			}
			public void mouseExited(MouseEvent e) {
				table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				remove(menu1);

			}

		});
		JScrollPane tablepane = new JScrollPane(table);
	    p1.add(tablepane);
		add(p1);
		/*
		 * p2.setBounds(200, 150, 700, 100);
		 * 
		 * p2.setLayout(new FlowLayout());
		 */
		/*
		 * p2.add(label1);label1.setFont(font1); p2.add(label2);label2.setFont(font1);
		 * p2.add(label3);label3.setFont(font1); p2.add(label4);label4.setFont(font1);
		 */
		/*
		 * add(p2);
		 */

	}

	public void paint(Graphics g) {
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		repaint();
	}

	/*
	 * public void buttonMaker(JButton button, ImageIcon pressed,String state) {
	 * button.setBorderPainted(false); button.setContentAreaFilled(false);
	 * button.setFocusPainted(false); button.addMouseListener(new MouseAdapter() {
	 * 
	 * @Override public void mouseEntered(MouseEvent e) { button.setIcon(pressed);
	 * button.setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	 * 
	 * public void mouseExited(MouseEvent e) { button.setIcon(pressed);
	 * button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	 * 
	 * }
	 * 
	 * public void mousePressed(MouseEvent e) { getData(state); }
	 * 
	 * }); add(button);
	 * 
	 * }
	 */

	public void getData(String kind,String sort) {
		p1.removeAll();
		table.removeAll();
		
		
		DefaultTableModel table_default=null; 
		boolean all =false;
		String[] title = { "종류","가게이름", "가격","거리", "리뷰수","자세히" };

		table_default = new DefaultTableModel(title,0);
		
		
		
		if(kind =="all")  all= true;
		
		System.out.println("실행");
		System.out.println(kind);
		System.out.println(sort);
		
		if (sort == "price") {
			try {
				if(all ==true) {
					foodList = foodbiz.getAll();
					
				}else {				
				foodList = foodbiz.get(kind);
				}
			} catch (Exception e) {
				System.out.println("get이 안되요");
				e.printStackTrace();
			}
		} else if(sort == "distance"){
			try {
				if(all ==true) {
					foodList = foodbiz.getAll_d();
					
				}else {	
				foodList = foodbiz.get_d(kind);
				}
			} catch (Exception e) {
				System.out.println("get이 안되요");
				e.printStackTrace();
			}

		}else {
			try {if(all ==true) {
				foodList = foodbiz.getAll_r();
				
			}else {	
				foodList = foodbiz.get_r(kind);
			}
			} catch (Exception e) {
				System.out.println("get이 안되요");
				e.printStackTrace();
			}
			
			
			
		}
		String [][]data1 = new String[foodList.size()][6];
		int i =0;
		for (FoodVO x : foodList) {
			
			String kind1 = x.getKind();
			String name1 = x.getName();
			String price1 =String.valueOf(x.getPrice());
			String distance1 =String.valueOf(x.getDistance());
			String review1 =String.valueOf(x.getReview());
			String map1 = x.getMap();
			 data1[i]= new String[]{kind1,name1,price1,distance1,review1,map1};
			
			i++;
			
		}
		
		
		
		JTable table = new JTable(data1,title);
		table.getTableHeader().setBackground(new Color(0,0,0,0));
	    table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setGridColor(Color.BLUE);
		table.setFont(font);
		table.addMouseListener(new MouseAdapter() {
			
			JButton menu1= new JButton("메뉴");
			
			
			public void mouseEntered(MouseEvent e) {
				table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				System.out.println(1);
				JTable jt = (JTable)e.getSource();
				int rowNum = jt.getSelectedRow();
				String name=(String)jt.getValueAt(rowNum, 5);
				ImageIcon menu = new ImageIcon(ViewProject.class.getResource("../menus/"+name+".png"));
				menu1= new JButton(menu);
				menu1.setBounds(700,150,550, 520);
				
				add(menu1);
			}
			public void mouseExited(MouseEvent e) {
				table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				remove(menu1);

			}

		});
		
		
		JScrollPane tablepane = new JScrollPane(table);
	    p1.add(tablepane);
		add(p1);
	}


	public static void main(String[] args) {
		new ViewProject();

	}

}
