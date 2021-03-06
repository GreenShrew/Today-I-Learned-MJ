package days20;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

// 윈도우에 텍스트필드1, 버튼1, 버튼2, 텍스트필드2 순서로 배치한다.
// 버튼 1의 표면에는 ">" 글자 표시, 버튼 2의 표면에는 "<" 글자를 표시하게 한다.
// 버튼 1을 클릭하면 텍스트필드1의 글자가 텍스트필드2로 옮겨지게 된다.
// 버튼 2를 클릭하면 텍스트필드2의 글자가 텍스트필드 1로 옮겨지게 된다.
// 글자가 없는 상태에서 버튼을 클릭하면 아무일도 안 일어나게 된다.
// 윈도우의 클래스 이름은 TextFieldEX로 제작한다.
// 윈도우의 가로세로 크기는 적절히 조절한다.

class TextFieldEX extends JFrame implements ActionListener{
	JTextField t1;
	JTextField t2;
	TextFieldEX(){
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		JButton b1 = new JButton(">");
		JButton b2 = new JButton("<");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(t1);
		con.add(b1);
		con.add(b2);
		con.add(t2);
		
		setTitle("텍스트 필드 테스트");
		setSize(600,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals(">")) {
			if (!t1.getText().equals("")) {
				String s2 = t1.getText();
				t2.setText(s2);
				t1.setText("");
			}
		}else {
			if (!t2.getText().equals("")) {
				t1.setText(t2.getText());
				t2.setText("");
			}
		}
	}
}
public class Swing11 {

	public static void main(String[] args) {
		new TextFieldEX();
	}

}
