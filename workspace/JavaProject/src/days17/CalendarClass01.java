package days17;

import java.util.Calendar;

public class CalendarClass01 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();	// 이미 만들어진 calender 클래스를 얻어다 쓰는 getInstance
		// 싱글톤 방식의 클래스.
		// 생성자가 private으로 접근 차단되어있다.(외부에서 접근 금지 -> 외부에서 new Calendar() 사용 안됨)
		// 유일하게 실행된 new Calandar()는 클래스 내부에서 실행되어 클래스 내부에 단 하나만 존재하게끔 생성된 레퍼런스 주소에 저장한다.
		// 그리고 그 레퍼런스 변수가 갖고 있는 주소를 리턴하는 public static 형태의 getInstance 메소드로 인스턴스의 주소를 리턴 받아 쓴다.
		// 이후 다시 getInstance() 메소드가 실행되도 현재 HEAP에 이미 있는 인스턴스의 주소가 리턴된다.
		Calendar tomarrow = Calendar.getInstance();
		
		// 캘린더 클래스에는 스태틱 파이널(static final) 변수들이 다수 있다.
		System.out.println(Calendar.YEAR);
		// get 메소드는 스태틱 파이널 변수에 해당하는 날짜요소를 얻어주는 메소드이다.
		System.out.println("년도 : "+today.get(Calendar.YEAR));
		System.out.println("년도 : "+today.get(1));
		
		int i = today.get(Calendar.MONTH);
		System.out.println("월 : (0~11) : "+i+"월");
		// MONTH로 얻어낸 월의 값은 1월이 0, 2월이 1 ... 12월이 11로 얻어진다.
		System.out.println("월 : (1~12) : "+(i+1)+"월");
		
		i = today.get(Calendar.DATE);
		System.out.println("이 달의 몇 일 : "+i);
		i = today.get(Calendar.WEEK_OF_YEAR);
		System.out.println("금년의 몇쨰주 : "+i);
		i = today.get(Calendar.WEEK_OF_MONTH);
		System.out.println("이 달의 몇 째 주 : "+i);
		i = today.get(Calendar.DAY_OF_YEAR);
		System.out.println("이 해의 몇 일 : "+i);
		
		// 1. 일요일, 2. 월요일, 3. 화요일...
		i = today.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일(1~7, 1:일요일) : "+i);
		i = today.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("이 달의 몇 쨰 요일 : "+i);
		System.out.println("이 달의 마지막 날 : "+today.getActualMaximum(Calendar.DATE));
		
		System.out.println("오전_오후(0:오전, 1:오후) : "+today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : "+today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : "+today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : "+today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : "+today.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999) : "+today.get(Calendar.MILLISECOND));
		// 프로그램이 시작되어 Calendar 인스턴스가 만들어진 시점
		// 시:분:초:1/1000초
	}

}
