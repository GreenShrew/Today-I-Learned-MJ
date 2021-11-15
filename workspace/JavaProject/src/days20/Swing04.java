package days20;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JImageTest extends JFrame implements ActionListener{
	JLabel result;
	
	JImageTest(){
		// 이미지 파일을 아이콘으로 변환하여 사용하게 하는 클래스(ImageIcon)
		ImageIcon ii1 = new ImageIcon("images/korea.gif");
		ImageIcon ii2 = new ImageIcon("images/germany9060.gif");
		ImageIcon ii3 = new ImageIcon("images/usa9060.gif");
		
		// 이미지를 이용하여 버튼을 생성
		JButton korea = new JButton("대한민국",ii1);
		JButton germany = new JButton("독일",ii2);
		JButton usa = new JButton("미국", ii3);
		result = new JLabel("");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(korea);
		con.add(germany);
		con.add(usa);
		con.add(result);

		korea.addActionListener(this);
		germany.addActionListener(this);
		usa.addActionListener(this);
		
		setTitle("이미지 아이콘 실습");
		setSize(600,180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		result.setText(e.getActionCommand()+"을 선택하셨습니다.");
	}
	
}
public class Swing04 {

	public static void main(String[] args) {
		new JImageTest();
	}

}
