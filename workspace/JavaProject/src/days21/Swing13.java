package days21;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// 컨테이너의 레이아웃 : 5행 1열의 GridLayout
// 1 행 : JPanel p1 배치 -> p1에는 FlowLayout으로 TextField 한개 배치(가로크기 적당히)
// 2 행 : JPanel p2 배치 -> p2에는 GridLayout으로 버튼 4개 배치 (7,8,9,+)
// 3 행 : JPanel p2 배치 -> p2에는 GridLayout으로 버튼 4개 배치 (4,5,6,-)
// 4 행 : JPanel p2 배치 -> p2에는 GridLayout으로 버튼 4개 배치 (1,2,3,×)
// 5 행 : JPanel p2 배치 -> p2에는 GridLayout으로 버튼 4개 배치 (C,0,=,÷)

class Calculator extends JFrame implements ActionListener{

	JTextField jt;	// 1행!
	
	// +,-,*,/ 연산에 필요한 변수들을 미리 전역변수로 만들었다!
	int firstNumber;
	int secondNumber;
	int result1;
	double result2;
	int operator = 0;
	
	Calculator(){
		jt = new JTextField(15);
		Font f = new Font("굴림", Font.BOLD,20);	// 폰트 객체 생성.
		jt.setFont(f);
		// JButton b = new JButton("폰트");
		// b.setFont(f);	버튼에 폰트 적용
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(6,1));	// 0~9와 연산기호를 담은 버튼을 bx로 저장해서 JPanel의 px에 저장하고,
		// 각각의 px를 container에 저장한다.
	
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();

		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jt.setText("0");
		jt.setHorizontalAlignment(SwingConstants.RIGHT);	// 텍스트필드 오른쪽 정렬
		jt.setEditable(false);	// 마우스 키보드로 편집 할 수 없게 설정
		p1.add(jt);
		con.add(p1);

		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bp = new JButton("+");
		b7.setFont(f);
		b8.setFont(f);
		b9.setFont(f);
		bp.setFont(f);
		p2.setLayout(new GridLayout(1,4));
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(bp);
		con.add(p2);
		
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bm = new JButton("-");
		b4.setFont(f);
		b5.setFont(f);
		b6.setFont(f);
		bm.setFont(f);
		p3.setLayout(new GridLayout(1,4));
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(bm);
		con.add(p3);
		
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bmulty = new JButton("×");
		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		bmulty.setFont(f);
		p4.setLayout(new GridLayout(1,4));
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(bmulty);
		con.add(p4);
		
		JButton bc = new JButton("C");
		JButton b0 = new JButton("0");
		JButton be = new JButton("=");
		JButton bd = new JButton("÷");
		bc.setFont(f);
		b0.setFont(f);
		be.setFont(f);
		bd.setFont(f);
		p5.setLayout(new GridLayout(1,4));
		p5.add(bc);
		p5.add(b0);
		p5.add(be);
		p5.add(bd);
		con.add(p5);
		
		JButton back = new JButton("◀");
		JButton sqr = new JButton("sqr");
		JButton divide1 = new JButton("1/x");
		JButton bn = new JButton("%");
		back.setFont(f);
		sqr.setFont(f);
		divide1.setFont(f);
		bn.setFont(f);
		p6.setLayout(new GridLayout(1,4));
		p6.add(back);
		p6.add(sqr);
		p6.add(divide1);
		p6.add(bn);
		con.add(p6);

		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bp.addActionListener(this);
		bm.addActionListener(this);
		bmulty.addActionListener(this);
		bd.addActionListener(this);
		bc.addActionListener(this);
		be.addActionListener(this);
		back.addActionListener(this);
		sqr.addActionListener(this);
		divide1.addActionListener(this);
		bn.addActionListener(this);
		
		
		setTitle("계산기 실습");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String oldText = jt.getText();
//		jt.setText(oldText+s);	이렇게 쓰면 간단하게 끝나지만 확장성이 없다! +.- 등, 연산자들도 텍스트상자에 들어가는 기능밖에 못 한다.
		// 그러므로 번거롭지만 하나하나 설정해주는게 좋다.
		String newText;
		switch(s) {
		case "+":
			operator = 1;
			firstNumber = Integer.parseInt(jt.getText());	// 텍스트를 숫자로 바꿈
			jt.setText("0");
			break;
		case "-":
			operator = 2;
			firstNumber = Integer.parseInt(jt.getText());
			jt.setText("0");
			break;
		case "×":
			operator = 3;
			firstNumber = Integer.parseInt(jt.getText());
			jt.setText("0");
			break;

		case "÷":
			operator = 4;
			firstNumber = Integer.parseInt(jt.getText());
			jt.setText("0");
			break;
		case "%":
			operator = 5;
			firstNumber = Integer.parseInt(jt.getText());
			jt.setText("0");
			break;
		case "=":
			switch(operator) {
			case 1:
				secondNumber = Integer.parseInt(jt.getText());
				result1 = firstNumber + secondNumber;
				jt.setText(String.valueOf(result1));	// 숫자를 string으로
				break;
			case 2:
				secondNumber = Integer.parseInt(jt.getText());
				result1 = firstNumber - secondNumber;
				jt.setText(String.valueOf(result1));
				break;
			case 3:
				secondNumber = Integer.parseInt(jt.getText());
				result1 = firstNumber * secondNumber;
				jt.setText(String.valueOf(result1));
				break;
			case 4:
				secondNumber = Integer.parseInt(jt.getText());
				result2 = firstNumber / (double)secondNumber;
				jt.setText(String.valueOf(result2));
				break;
			case 5:
				secondNumber = Integer.parseInt(jt.getText());
				result1 = firstNumber % secondNumber;
				jt.setText(String.valueOf(result1));
				break;
			}
			break;
		case "C":
			jt.setText("0");
			break;
		case "◀":
			// 힌트 (String 클래스에 내장된 substring을 이용한다. Day 17에서 정리한적이 있다.)
			// substring과 length를 활용하여 백스페이스 키를 완성하자.
			// 총 글자수 - 1 만큼 왼쪽부터 substring으로 취한다. 그리고 다시 setText한다.
			// jt.getText().length() : 텍스트 필드에 있는 글자의 총 갯수
			// 98765가 있다면 총 글자갯수 5, 인덱스는 0번부터 4번까지이다.
			// 이중 9876만 취하고싶다면, substring에 0,4라고 써야 0번부터 3번 글자까지 추출된다.
			// 그 말은 곧, length() 메소드를 사용했다면 문자열.substring(0,문자열.length()-1);
			if(jt.getText().length() == 1) {	// 한글자 남았을때는 지우는게 아니라 0으로 바꾼다.
				jt.setText("0");
			}else {
				String t = oldText.substring(0,oldText.length()-1);
				jt.setText(t);
			}
			break;
		case "sqr":
			if(jt.getText().equals("0")) {
				jt.setText("0은 계산할 수 없습니다.");
				break;
			}else {
				double t = Math.sqrt(Integer.parseInt(oldText));
				jt.setText(String.valueOf(t));
			}
			break;
		case "1/x":
			if(jt.getText().equals("0")) {
				jt.setText("0은 계산할 수 없습니다.");
				break;
			}else {
				double t = 1/(double)Integer.parseInt(oldText);
				jt.setText(String.valueOf(t));
			}
			break;
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":	// 실행되는 case 아랫쪽을 전부 실행하는 switch 특성을 이용하여 압축하였다.
			if(oldText.equals("0")) {	// 만약 oldText가 0이라면 oldText(텍스트상자)를 비워라.
				oldText="";		// 이렇게 하면 처음의 0이 사라진다!
			}
			jt.setText(oldText+s);
			break;
		}
	}
}
public class Swing13 {

	public static void main(String[] args) {
		new Calculator();
	}

}
// 기존의 계산기와는 조금 다른 점
// 1. 원래는 연산자를 누르고 다음 숫자를 누를 때 숫자가 초기화됨과 동시에 숫자가 입력되지만, 이 계산기는 연산자를 누르는 순간 0으로 초기화된다.
// 원래 계산기처럼 만들고싶다면 변수를 더 만들고 뭐 그래야 한다고 한다. 연구해봐.
// 2. 이 계산기는 2개의 숫자만을 비교할 수 있다. 즉, 1+2=3 가 되지만, 1+2+3=5로, 앞의 1은 사라지고 2+3 만 연산되어버린다.