package days20;
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
	
	Calculator(){
		jt = new JTextField(15);
		Font f = new Font("굴림", Font.BOLD,20);	// 폰트 객체 생성.
		jt.setFont(f);
		// JButton b = new JButton("폰트");
		// b.setFont(f);	버튼에 폰트 적용
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(5,1));	// 0~9와 연산기호를 담은 버튼을 bx로 저장해서 JPanel의 px에 저장하고,
		// 각각의 px를 container에 저장한다.
	
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

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
		
		setTitle("계산기 실습");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String s1 = jt.getText();
		jt.setText(s1+s);
		
	}
}
public class Swing13 {

	public static void main(String[] args) {
		new Calculator();
	}

}
