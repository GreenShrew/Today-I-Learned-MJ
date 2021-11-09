package days17;

import java.util.Calendar;

public class CalendarClass04 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2021, 10, 30);
		System.out.println(toDate(date));
		
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1);
		System.out.println(toDate(date));
		// add 메소드의 증감은 하나의 요소를 변경하지만, 그로 인해 다른 필드에 영향을 줄 수 있다.
		// 일을 변경하여 달이 바뀌거나, 월을 변경하여 년도가 바뀌는 변경 등을 말 한다.
		
		System.out.println("= 6달 후 =");
		date.add(Calendar.MONTH, 6);
		System.out.println(toDate(date));
		
		System.out.println("= 40일 후(roll) =");
		date.roll(Calendar.DATE, 40);
		// 다른 필드에 영향을 주지 않고 해당 필드만으로 더하고 빼는 메소드
		// 3월 1일에서 30을 더하면 3월 31일(30일)이 되고, 이후 10일이 더해져 다시 10이 나온다.
		// 월에는 영향을 주지 않기 때문에 결과는 3월 10일이 된다.
		System.out.println(toDate(date));
	}
	public static String toDate(Calendar c) {	// 날짜를 문자열로 만들어서 리턴해주는 메소드
		String cDate = c.get(Calendar.YEAR)+"년 "+(c.get(Calendar.MONTH)+1)+"월 "+c.get(Calendar.DATE)+"일 ";
		return cDate;
	}
}
