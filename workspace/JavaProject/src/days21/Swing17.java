package days21;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class JRadioButtonTest extends JFrame implements ActionListener{

	JRadioButton jrb1;
	JRadioButton jrb2;
	JRadioButton jrb3;
	JRadioButton jrb4;
	
	ButtonGroup bg;
	JTextField jtf;	// 뭘 선택했는지 확인하려고 넣음
	
	JRadioButtonTest(){
		jrb1 = new JRadioButton("승마");
		jrb2 = new JRadioButton("골프");
		jrb3 = new JRadioButton("글라이딩");
		jrb4 = new JRadioButton("스쿠버");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		Font f = new Font("굴림", Font.BOLD, 20);	// 글씨 작아서 추가함
		jrb1.setFont(f);
		jrb2.setFont(f);
		jrb3.setFont(f);
		jrb4.setFont(f);
		
		bg = new ButtonGroup();	// 버튼 그룹으로 추가시켜야 하나 클릭하면 나머지가 해제된다!
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		jtf = new JTextField(30);
		jtf.setFont(f);

		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
		jrb4.addActionListener(this);
		
		con.add(jrb1);
		con.add(jrb2);
		con.add(jrb3);
		con.add(jrb4);
		con.add(jtf);
		
		setTitle("라디오박스 실습");
		setSize(700,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(jrb1.isSelected()) {
			jtf.setText(jrb1.getActionCommand()+" 이(가) 선택되었습니다.");
		}else if(jrb2.isSelected()) {
			jtf.setText(jrb2.getActionCommand()+" 이(가) 선택되었습니다.");
		}else if(jrb3.isSelected()) {
			jtf.setText(jrb3.getActionCommand()+" 이(가) 선택되었습니다.");
		}else {
			jtf.setText(jrb4.getActionCommand()+" 이(가) 선택되었습니다.");
		}
	}
}
public class Swing17 {

	public static void main(String[] args) {
		new JRadioButtonTest();
	}

}
