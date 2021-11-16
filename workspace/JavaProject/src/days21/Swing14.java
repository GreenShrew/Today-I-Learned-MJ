package days21;	// 이번에도 달력을 만들어볼 것.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Calendars extends JFrame implements ActionListener{	// Java에 내장된 Calendar 클래스가 아니다! Calendars이다!
	
	static int year=0;
	static int month=0;
	static JTextField [] jt = new JTextField[42];	// 달력의 공간은 최대 42개. jt는 42칸의 JTextField를 가지는 공간의 주소를 가지는 레퍼런스 변수.
	
	JTextField y;		// 화면에 표시할 텍스트필드의 변수
	JTextField m;
	
	Calendars(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel jp1 = new JPanel();	// 요일 이름
		JPanel jp2 = new JPanel();	// 6행 7열짜리 날짜들
		JPanel jp3 = new JPanel();	// 이전달, 다음달

		jp1.setLayout(new GridLayout(1,7));
		jp2.setLayout(new GridLayout(6,7));
		jp3.setLayout(new FlowLayout());

		// 월화수목금토일
		jp1.add(new JButton("일")).setForeground(Color.RED);		// 라벨로 해도 되고 텍스트 필드로 해도 좋지만, 입체적으로 보이는 버튼으로 만들었다.
		jp1.add(new JButton("월"));
		jp1.add(new JButton("화"));
		jp1.add(new JButton("수"));
		jp1.add(new JButton("목"));
		jp1.add(new JButton("금"));	// 요일 버튼들은 따로 레퍼런스 주소가 없다. 그래서 나중에 수정할 수 없다.
		jp1.add(new JButton("토")).setForeground(Color.BLUE);	// 따라서 여기를 수정해서 일요일은 빨간색, 토요일은 파란색으로 칠했다.
		
		// 날짜들 들어가는 부분
		Font f = new Font("굴림",Font.BOLD,20);
		
		for(int i=0;i<42;i++) {
			jt[i] = new JTextField();
			jt[i].setFont(f);
			jt[i].setHorizontalAlignment(SwingConstants.RIGHT);
			jt[i].setEditable(false);	// 직접 편집 금지
			jt[i].setBackground(Color.WHITE);	// 배경 하얀색
			if(i%7==6) {	// 토요일이라면 숫자를 파랗게 만든다.
				jt[i].setForeground(Color.BLUE);
			}else if(i%7==0) {	// 일요일이라면 숫자를 빨갛게 만든다.
				jt[i].setForeground(Color.RED);
			}else {	// 평일은 검은색.
				jt[i].setForeground(Color.BLACK);
			}
			jp2.add(jt[i]);
		}
		
		// 맨 아랫쪽 이전달 다음달 그리고 년월일 표시
		y = new JTextField(4);
		y.setFont(f);
		y.setHorizontalAlignment(SwingConstants.CENTER);
//		y.setEditable(false);
		y.setBackground(Color.WHITE);
		
		m = new JTextField(4);
		m.setFont(f);
		m.setHorizontalAlignment(SwingConstants.CENTER);
//		m.setEditable(false);
		m.setBackground(Color.WHITE);

		Calendar today = Calendar.getInstance();	// Java의 Calendar 클래스로 날짜 가져오기.
		y.setText(String.valueOf(today.get(Calendar.YEAR)));
		m.setText(String.valueOf(today.get(Calendar.MONTH)+1));

		JButton b = new JButton("확인");
		JButton b1 = new JButton("이전달");
		JButton b2 = new JButton("다음달");

		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);

		jp3.add(b1);
		jp3.add(y);
		jp3.add(new JLabel("년 "));
		jp3.add(m);
		jp3.add(new JLabel("월"));
		jp3.add(b);
		jp3.add(b2);
		
		con.add(jp1,BorderLayout.NORTH);
		con.add(jp2,BorderLayout.CENTER);
		con.add(jp3,BorderLayout.SOUTH);
		
		setTitle("스윙 캘린더");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// year, month 변수에 년, 월 을 넣고 달력에 알맞게 표시하기.
		year = Integer.parseInt(y.getText());
		month = Integer.parseInt(m.getText());
		drawCalendar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼에 따라서 year 변수와 month 변수 계산하고 drawCalender() 호출!
		String s = e.getActionCommand();
		switch(s){
			case "이전달":
				if(month==12) {
					year--;
					month=1;
				}else {
					month--;
				}
				break;
			case "다음달":
				if(month==12) {
					year++;
					month=1;
				}else {
					month++;
				}
				break;
			case "확인":	// 맨 아랫줄의 년, 월을 수정하고 확인 버튼을 누르면 해당 년, 월의 달력이 출력되도록 만든다.
				int tempy = Integer.parseInt(y.getText());
				int tempm = Integer.parseInt(m.getText());
				if(tempy>=1&&tempy<=3000) {
					year=Integer.parseInt(y.getText());
				}else {
					JOptionPane.showMessageDialog(null, "유효한 숫자는 1~3000입니다.");	// 내가 찾아서 써본것
					return;
				}
				if(tempm>=1&&tempm<=12) {
					month=Integer.parseInt(m.getText());
				}else {
					JOptionPane.showMessageDialog(null, "유효한 숫자는 1~12입니다.");	// 내가 찾아서 써본것
					return;
				}
		}

		y.setText(String.valueOf(year));
		m.setText(String.valueOf(month));	// 바뀐 조건에 맞게 제목 표시
		
		for(int i=0;i<jt.length;i++) {	// 쓰여있던 42칸을 다 밀어버리고 조건에 맞게 다시 캘린더를 작성한다.
			jt[i].setText("");
		}
		drawCalendar();
	}
	private void drawCalendar() {
		// 해당 년월의 달력을 화면에 표시!
		Calendar sDay = Calendar.getInstance();	// 오늘 날짜 입력
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year, month-1,1);	// 오늘 날짜 월의 1일로
		eDay.set(year, month,1);
		eDay.add(Calendar.DATE, -1);		// 오늘 날짜 월의 말일로
		
		int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK);		// sDay의 요일 계산
		// 21년 11월 기준 1일은 월요일, 2가 나온다.
		
		// TextField가 다 비워져있는 상태에서 1일자의 요일 (1,2,3,4...)번째(k-1)의 TextField 부터 날짜 표시
		// 이전 칸들은 비워둔채로 시작
		// sDay의 값들을 표시 -> 날짜만 표시, 한번 반복마다 날짜는 1일씩 늘어난다.
		// eDay보다 sDay가 작거나 같을때까지 반복한다.
		for(int i=START_WEEK-1;sDay.before(eDay)||sDay.equals(eDay);sDay.add(Calendar.DATE,1)) {	// START_WEEK가 2라서 i는 1부터 시작, jt[0]은 공백이 된다.
			int day = sDay.get(Calendar.DATE);
			jt[i++].setText(String.valueOf(day));
		}
	}
}

public class Swing14 {

	public static void main(String[] args) {
		new Calendars();
	}

}
