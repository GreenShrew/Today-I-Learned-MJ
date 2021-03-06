package days20;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// FlowLayout : 가장 단순하고 쉽게 쓸 수 있는 Layout이다.

// 배치 관리자
class JFlowLayout extends JFrame{
	JFlowLayout(){
		// 배치관리자 없이 버튼을 컨테이너에 무작정 올린 상태
		// 버튼이 겹쳐서 결과적으로 '버튼3'만 보인다.
/*
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		Container con = getContentPane();
		con.add(btn1);
		con.add(btn2);
		con.add(new JButton("버튼3"));	// btn1, 2처럼 레퍼런스 변수를 쓰지 않고 바로 넣은 모습이다.
*/
		Container con = getContentPane();
		con.setLayout(new FlowLayout( FlowLayout.RIGHT,50,10 ));
		// 50 : 콘트롤끼리의 가로 방향 간격, 10 : 콘트롤끼리의 세로 방향 간격
		// FlowLayout.RIGHT : 정렬방식
		for(int i=1;i<=15;i++) {
			con.add(new JButton("버튼"+i));
			// 버튼 생성과 동시에 바로 적재
			// 버튼을 위한 레퍼런스 변수(위의 btn1, 2)가 없어서 이후 제어는 불가능하다.
			// 적재 모습만 보여주기 위한 예제이다.
		}
		setTitle("배치관리자 실습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Swing06 {

	public static void main(String[] args) {
		new JFlowLayout();
	}

}
