package days19;	// 윈도우(창) 만들기

import javax.swing.JFrame;

class WindowTest extends JFrame{
	WindowTest(){	// 화면이 시작되자마자 생성되는 객체들
		setTitle("윈도우 테스트");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 창닫기 버튼을 누르면 프로그램이 종료된다.
		setVisible(true);	// 생성된 윈도우의 화면 표시
	}
}

public class SwingEx {

	public static void main(String[] args) {
		new WindowTest();		// 객체가 생성됨과 동시에 WindowTest의 생성자가 실행된다. 프로그램 실행시 생성자에 설정된 윈도우(창)이 출력된다.
	}

}
