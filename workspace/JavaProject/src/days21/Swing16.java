package days21;

import java.awt.Container;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JCheckBoxTest extends JFrame implements ItemListener{
	
	JTextField jtf;
	JCheckBox jcb1;
	JCheckBox jcb2;
	JCheckBox jcb3;
	JCheckBox jcb4;
	
	JCheckBoxTest(){
		jcb1 = new JCheckBox("JSP");
		jcb2 = new JCheckBox("PHP");
		jcb3 = new JCheckBox("ASP");
		jcb4 = new JCheckBox("SEREVLET");
		jtf = new JTextField(30);
		jtf.setEditable(false);
		
		Font f = new Font("굴림", Font.BOLD, 20);
		jcb1.setFont(f);
		jcb2.setFont(f);
		jcb3.setFont(f);
		jcb4.setFont(f);
		jtf.setFont(f);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());

		con.add(jcb1);
		con.add(jcb2);
		con.add(jcb3);
		con.add(jcb4);
		con.add(jtf);
		
		setTitle("체크박스 실습");
		setSize(800,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		jcb1.addItemListener(this);	// 체크박스가 체크되면 itemStateChanged 메소드를 실행시킨다!
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		jcb4.addItemListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {	// 체크박스의 체크 상태 여부를 판단한다.
		String s = "";

		if(jcb1.isSelected()) {
			s = s + "JSP ";
		}
		if(jcb2.isSelected()) {
			s = s + jcb2.getActionCommand()+" ";
		}
		if(jcb3.isSelected()) {
			s = s + "ASP ";
		}
		if(jcb4.isSelected()) {
			s = s + jcb4.getActionCommand()+" ";
		}
		
		jtf.setText("현재 선택 항목 : "+s);
	}
}
public class Swing16 {

	public static void main(String[] args) {
		new JCheckBoxTest();
	}

}
