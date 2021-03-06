package days22;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
// 6행 1열
class Resume extends JFrame implements ActionListener{

	JTextField jt;
	JRadioButton jr1;
	JRadioButton jr2;
	JCheckBox jc1;
	JCheckBox jc2;
	JCheckBox jc3;
	JCheckBox jc4;
	JTextField jt_name; 
	JComboBox<String> jcb;
	JTextField jt_phone2;
	JTextField jt_phone3;
	JComboBox<String> jcb2;
	
	Resume(){
		Font f = new Font("굴림",Font.BOLD,20);
		
		Container con = getContentPane();	// 메인 컨테이너
		con.setLayout(new BorderLayout());

		JPanel jp1 = new JPanel();	// 메인 컨테이너에 올라갈 패널 1
		JPanel jp2 = new JPanel();	// 메인 컨테이너에 올라갈 패널 2
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));

		// 왼쪽 부분
		JLabel lb1 = new JLabel(" 성 명 : ");
		JLabel lb2 = new JLabel(" 성 별 : ");
		JLabel lb3 = new JLabel(" 취 미 : ");
		JLabel lb4 = new JLabel(" 전 화 번 호 : ");
		JLabel lb5 = new JLabel(" 거 주 지 역 : ");

		lb1.setFont(f);
		lb2.setFont(f);
		lb3.setFont(f);
		lb4.setFont(f);
		lb5.setFont(f);

		jp1.add(lb1);
		jp1.add(lb2);
		jp1.add(lb3);
		jp1.add(lb4);
		jp1.add(lb5);
		con.add(jp1,BorderLayout.WEST);

		
		// 오른쪽 부분
		JPanel jp21 = new JPanel();
		JPanel jp22 = new JPanel();
		JPanel jp23 = new JPanel();
		JPanel jp24 = new JPanel();
		JPanel jp25 = new JPanel();
		JPanel jp26 = new JPanel();

		jp21.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		jp21.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		jp21.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		jp21.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		jp21.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		jp21.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		jt_name = new JTextField(10);
		jt_name.setFont(f);
		jp21.add(jt_name);
		jp2.add(jp21);
		
		ButtonGroup bg = new ButtonGroup();
		jr1 = new JRadioButton("남성");
		jr2 = new JRadioButton("여성");
		jr1.setFont(f);
		
		

		
		
		jt = new JTextField(5);
		jp2.add(jt);
		
		

		con.add(jp1);
		
		setTitle("구성 실습");
		setSize(650,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s;
		
		System.out.println("성명 : "+jt_name.getText());
		
		if(jr1.isSelected()) {
			s = "남성";
		}else {
			s = "여성";
		}
		System.out.println("성별 : "+s);
		
		s="";
		if(jc1.isSelected()) {
			s = s+jc1.getText()+" ";
		}
		if(jc2.isSelected()) {
			s = s+jc2.getText()+" ";
		}
		if(jc3.isSelected()) {
			s = s+jc3.getText()+" ";
		}
		if(jc4.isSelected()) {
			s = s+jc4.getText()+" ";
		}
		System.out.println("취미 : "+s);
		
		s = (String)jcb.getSelectedItem();
		s = s+"-"+jt_phone2.getText();
		s = s+"-"+jt_phone3.getText();
		System.out.println("전화번호 : "+s);
		
		System.out.println("거주지역 : "+jcb2.getSelectedItem());
	}
}
public class Swing19 {

	public static void main(String[] args) {
		new Resume();
	}

}
