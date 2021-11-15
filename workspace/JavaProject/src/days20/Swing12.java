package days20;
import java.awt.BorderLayout;
//지금까지 배운 Layout은 한 장소에 여러 버튼을 놓으면 버튼들이 겹쳐서 마지막 버튼만이 보인다.
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class JPanelTest extends JFrame{
	JPanelTest(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		// 패널 = 새끼 컨테이너
		
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(4,1));
//		con.add(new JButton("JAVA"),BorderLayout.WEST);		이렇게 하면 서쪽에 3개의 버튼이 겹쳐버린다.
//		con.add(new JButton("ASP"),BorderLayout.WEST);
//		con.add(new JButton("JSP"),BorderLayout.WEST);
		
		// jp1에는 5개, jp2에는 4개의 버튼을 넣었다.
		jp1.add(new JButton("JAVA"));
		jp1.add(new JButton("C++"));
		jp1.add(new JButton("ASP"));
		jp1.add(new JButton("JSP"));
		jp1.add(new JButton("PHP"));
		

		jp2.add(new JRadioButton("JAVA"));
		jp2.add(new JRadioButton("C++"));
		jp2.add(new JRadioButton("ASP"));
		jp2.add(new JRadioButton("JSP"));

		con.add(jp1, BorderLayout.WEST);
		con.add(jp2, BorderLayout.EAST);
		// 버튼이 서로 겹쳐지지 않고 5개, 4개가 주르륵 나열된다!
		
		setTitle("패널 실습");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Swing12 {

	public static void main(String[] args) {
		new JPanelTest();
	}

}
