package days17;

import java.util.Calendar;

public class CalendarClass02 {
	
	static String[] weekday = {"", "일", "월", "화", "수", "목", "금", "토"};	//	메소드에서도 사용 가능하도록 만들어주는 것.
	
	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		// date1 달력객체의 오늘 날짜는 2015년 8월 15일로 설정할 수 있다(특정 날짜로 설정할 수 있다)
		date1.set(2015, 7, 15);
		// set : 원하는 특정 날짜로 객체내 날짜구성을 재설정, date2는 아직 오늘 날짜인 상태
		
		// set 메서드에 필드명과 값을 넣어주면 해당 필드값만 변경된다.
		date2.set(Calendar.MONTH, 6);	// 월만 7월로 바뀜!
		// 여기까지 코드블록
		
		// 위 date1과 date2에 설정된 날짜를 "0000년 0월 0일 0요일" 형식으로 출력하자.
		// System.out.println(); 안에 한번에 구성해서 출력하자.
		// date1
		prnDate(date1);
//		System.out.println(date1.get(Calendar.YEAR)+"년 "+(date1.get(Calendar.MONTH)+1)+"월 "+date1.get(Calendar.DATE)+"일 "+weekday[date1.get(Calendar.DAY_OF_WEEK)]+"요일");
		// date2
		prnDate(date2);
//		System.out.println(date2.get(Calendar.YEAR)+"년 "+(date2.get(Calendar.MONTH)+1)+"월 "+date2.get(Calendar.DATE)+"일 "+weekday[date2.get(Calendar.DAY_OF_WEEK)]+"요일");		
	}

	private static void prnDate(Calendar c) {
		System.out.println(c.get(Calendar.YEAR)+"년 "+(c.get(Calendar.MONTH)+1)+"월 "+c.get(Calendar.DATE)+"일 "+weekday[c.get(Calendar.DAY_OF_WEEK)]+"요일");
	}

}
