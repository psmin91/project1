


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{

	public SwingTest() {
		setTitle("swing 연습");
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//닫기버튼, 메모리를 사라지게 하므로 반드시 처리하자//
		
		
		
		//컨텐츠팬으로 사용하는 방법
		/*Container container = getContentPane();
		container.setLayout(null);
		JButton button = new JButton("test");
		button.setSize(70,20);
		button.setLocation(50, 10);
		container.add(button);*/
		
		//jframe을 통해서 버튼을 추가하는 코드//간결하나 컨텐츠팬이 사용된다.
		/*setLayout(null);	
		JButton button = new JButton("test");
		button.setSize(70,20);
		button.setLocation(50, 10);
		add(button);
		*/
		
		setLayout(new FlowLayout());
		JButton button1 = new JButton("play");
		button1.addActionListener(new myActionListener());
		add(button1);
		
		
	}
	
	public class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button  = (JButton)e.getSource();
					if (button.getText().equals("play")) {
						button.setText("stop");
					}else {
						button.setText("play");
					}
			
			
			
		}
		
		
	}
	
	
	
	
	//1.1단계 : 프레임 생성
	//JFrame = Frame +메뉴 +컨텐트 팬(컨테이너 클래스)
	//2.2단계 :컴포넌트 연결// 컨텐트 팬에 컴포넌트 추가 
	
	//3.3단계 : 이벤트 처리
	//이벤트 처리 => 리스너
	//리스너의 실체 => 인터페이스( 이벤트 처리를 위한 메소드 정의)
	
	//레이아웃
	//Flowlayout,Borderlayout,Gridlayout,Cardlayout
	//Borderlayout.NORTH(5개영역)
	//setLayout(new BorderLayout(수평(간격),수직(간격)));
	//add(new Button("NORTH"),BorderLayout.NORTH);
	
	
	//이벤트 소스:이벤트를 발생시킨 컴포넌트 JButton, JList, JTextField
	//이벤트 객체 : 이벤트 소스에 대한 모든 정보를 가지는 객체 ActionEvent,ItemEvent
	//이벤트 리스너 : 이벤트에따라 호출될 메소드와 인터페이스 ActionListener, ItemListener
	
	
	
	
	
	
	public static void main(String[] args) {
		
		SwingTest stest = new SwingTest();
	
	}
}
