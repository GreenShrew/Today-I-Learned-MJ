package days17;

import java.util.Calendar;

public class CalendarClass03 {

	public static void main(String[] args) {
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 10);
		time1.set(Calendar.SECOND, 10);
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		printTime(time1);
		printTime(time2);
		System.out.println(time1.getTimeInMillis());	// 시간을 밀리세컨드로 환산하는 메소드
		System.out.println(time2.getTimeInMillis());
		long dif = (time2.getTimeInMillis() - time1.getTimeInMillis())/1000;	// 1000을 나누면 밀리세컨트 영역을 날려버릴 수 있다.
		System.out.println("time1과 time2의 차이는"+dif+"초 입니다.");
	}
	public static void printTime(Calendar c) {	// 시간을 출력하는 메소드
		System.out.println("time : "+c.get(Calendar.HOUR_OF_DAY)+"시 "+c.get(Calendar.MINUTE)+"분 "+c.get(Calendar.SECOND)+"초 "+c.get(Calendar.MILLISECOND)+"(1/1000 초)");
	}
}
