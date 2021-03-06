package days22;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JComboBoxTest extends JFrame implements ItemListener{
	
	JLabel jl;
	ImageIcon ii;
	JComboBoxTest(){
		JComboBox<String> jcb = new JComboBox<String>();	// 콤보상자에 목록을 추가해주어야 한다.
		// 콤보상자는 목록으로 들어갈 데이터가 정해지지 않은 상태이다.
		// 서로 다른 자료형도 입력 가능하지만, 실제 사용 시점에서 목록으로 사용할 데이터 형식을 결정한다.
		//(String, double, int 등... 객체도 사용 가능하다)
		// <>(제네릭 문법)에 자료형을 써넣어서 현재 사용할 콤보상자 목록의 데이터 형식을 결정한다.
		
		jcb.addItem("banana");
		jcb.addItem("apple");
		jcb.addItem("pear");
		jcb.addItem("cherry");
		jcb.addItem("grape");	// .addItem(); 콤보상자의 목록 추가
//		jcb.addItem(123);
//		jcb.addItem(123.456);
//		jcb.addItem('A');
		// String 뿐만 아니라 실수, 정수, char, 심지어 객체도 들어갈 수 있다!
		// 하나의 자료형만 쓰고싶다면 제네릭 문법< >을 사용하면 된다.
		
		Font f = new Font("굴림", Font.BOLD, 20);
		jcb.setFont(f);
		
		ii = new ImageIcon("images/banana.jpg");
		jl = new JLabel(ii);		// 라벨의 최초 이미지는 바나나로 설정한다.
		
		jcb.addItemListener(this);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jcb);
		con.add(jl);
		
		setTitle("콤보 박스 실습");
		setSize(500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {	// e로 jcb가 전달되었을 것이다.
		String jcb1 = (String)e.getItem();	// 상태가 변한 컨트롤의 현재 선택값 추출
		ImageIcon ni = new ImageIcon("images/"+jcb1+".jpg");
		jl.setIcon(ni);	// 라벨에 setIcon으로 이미지 아이콘을 교체한다.
	}
}
public class Swing18 {

	public static void main(String[] args) {
		new JComboBoxTest();
	}

}
