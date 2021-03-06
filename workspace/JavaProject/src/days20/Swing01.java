package days20;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;	// swing 패키지 안에는 윈도우 프로그래밍에 필요한 여러 클래스들이 있다.
import javax.swing.JFrame;
import javax.swing.JLabel;

// 윈도우 프로그래밍에 필요한 윈도우 구성요소를 보유한 클래스(JFrame)를 상속받아
// 추가기능 탑재 형식의 개발을 진행한다.
class ButtonTest extends JFrame{
	// 윈도우 최초 화면의 구성은 대부분 생성자 메소드에서 구성한다.
	ButtonTest(){
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		// 생성자에 입력된 텍스트를 한가운데 표시한 버튼을 생성한다.
		// 아직 화면에 버튼이 보이는 상태는 아니다. 생성만 해서 아직 배치하거나 보여주는
		// 단계는 아니다.
		// 버튼 또는 그 외 컨트롤들은 윈도우에 배치되고 위치를 잡아 올라가고, 윈도우가 화면에 보일때 같이 표시된다.

		// 안내문구 표시용 텍스트 도구
		JLabel label = new JLabel("당신의 성별은?");
		
		// 윈도우 위에 생성된 컨트롤 객체들을 올려놓을 수 있게 해주는 객체
		Container con = getContentPane();	// 싱글톤 방식. 객체 생성이 아니라 클래스 내부에서 만들어진 단 하나의 객체를 가져오는 방식.
		// 윈도우 위에 올라갈 컨트롤들을 담을 바구니 - 담으면 윈도우에 표시될 준비가 완료된다.
		// 컨테이너에 add 되어지는 순서를 한줄로 화면에 구성
		con.setLayout(new FlowLayout());
		// 줄맞춤 설정
		
		// 컨테이너에 생성된 컨트롤을 순서에 맞춰 올려놓으면 화면에 표시될 준비가 끝난다.
		con.add(label);
		con.add(male);
		con.add(female);	// 위에서 만든 객체들을 화면에 올린다.

		setTitle("버튼 컴퍼넌트 테스트");	// 윈도우 좌측 상단에 표시된 타이틀 내용 설정
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		// 현재 윈도우를 종료하면 프로그램이 종료된다.
		setVisible(true);	// 화면에 윈도우를 출현시키는 메소드
	}
}
public class Swing01 {

	public static void main(String[] args) {
		new ButtonTest();
	}

}

// 순서는
// 1. 필요한 컴퍼넌트를 객체로 생성하고
// 2. 객체를 올릴 container를 만들고
// 3. container에 객체를 올려 윈도우에 나타나게 한다.