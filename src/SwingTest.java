


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{

	public SwingTest() {
		setTitle("swing ����");
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�ݱ��ư, �޸𸮸� ������� �ϹǷ� �ݵ�� ó������//
		
		
		
		//������������ ����ϴ� ���
		/*Container container = getContentPane();
		container.setLayout(null);
		JButton button = new JButton("test");
		button.setSize(70,20);
		button.setLocation(50, 10);
		container.add(button);*/
		
		//jframe�� ���ؼ� ��ư�� �߰��ϴ� �ڵ�//�����ϳ� ���������� ���ȴ�.
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
	
	
	
	
	//1.1�ܰ� : ������ ����
	//JFrame = Frame +�޴� +����Ʈ ��(�����̳� Ŭ����)
	//2.2�ܰ� :������Ʈ ����// ����Ʈ �ҿ� ������Ʈ �߰� 
	
	//3.3�ܰ� : �̺�Ʈ ó��
	//�̺�Ʈ ó�� => ������
	//�������� ��ü => �������̽�( �̺�Ʈ ó���� ���� �޼ҵ� ����)
	
	//���̾ƿ�
	//Flowlayout,Borderlayout,Gridlayout,Cardlayout
	//Borderlayout.NORTH(5������)
	//setLayout(new BorderLayout(����(����),����(����)));
	//add(new Button("NORTH"),BorderLayout.NORTH);
	
	
	//�̺�Ʈ �ҽ�:�̺�Ʈ�� �߻���Ų ������Ʈ JButton, JList, JTextField
	//�̺�Ʈ ��ü : �̺�Ʈ �ҽ��� ���� ��� ������ ������ ��ü ActionEvent,ItemEvent
	//�̺�Ʈ ������ : �̺�Ʈ������ ȣ��� �޼ҵ�� �������̽� ActionListener, ItemListener
	
	
	
	
	
	
	public static void main(String[] args) {
		
		SwingTest stest = new SwingTest();
	
	}
}
