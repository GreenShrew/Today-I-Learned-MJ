package days21;	// 콤보상자, 체크박스, 라디오버튼 등등

import java.awt.Container;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class JTextFieldTextArea extends JFrame implements ActionListener{

	JTextField jtf;
	JTextArea jta;
	
	JTextFieldTextArea(){
		jtf = new JTextField(10);	// 최대 표시 10글자(가로크기)....텍스트 필드
		jta = new JTextArea(7,20);	// 7행 20열
		
		Font f = new Font("굴림", Font.BOLD,20);

		
		JButton k = new JButton("확인");

		jtf.setFont(f);
		jta.setFont(f);
		k.setFont(f);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		k.addActionListener(this);
		
		con.add(jtf);
		con.add(jta);
		con.add(k);
		
		setTitle("텍스트 필드 텍스트 에어리어");
		setSize(400,300);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

public class Swing15 {

	public static void main(String[] args) {
		new JTextFieldTextArea();
	}

}
