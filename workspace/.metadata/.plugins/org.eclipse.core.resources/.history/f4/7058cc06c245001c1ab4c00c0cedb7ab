package days20;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

class JBorderLayout extends JFrame{
	JBorderLayout(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout(10,10));
		// 각 지역(동서남북중앙)간의 간격 가로세로 10px
		JButton b1 = new JButton("동쪽 버튼");
		con.add(b1,BorderLayout.EAST);
//		con.add(new JButton("서쪽 버튼"), BorderLayout.WEST);
		con.add(new JButton("남쪽 버튼"), BorderLayout.SOUTH);
		con.add(new JButton("북쪽 버튼"), BorderLayout.NORTH);
		con.add(new JButton("중앙 버튼"), BorderLayout.CENTER);
		// Center는 정의하지 않으면 빈 자리로 남지만, 이외의 영역(동서남북)은 정의하지 않으면 다른 영역으로 포함되어 표시된다.
		// ex) 서쪽을 비우면 북쪽, 중앙, 남쪽 버튼이 그 자리를 차지한다.
		
		setTitle("보더레이아웃 실습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
}
public class Swing07 {

	public static void main(String[] args) {
		new JBorderLayout();
	}

}
