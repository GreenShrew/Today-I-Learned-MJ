package days19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exception06 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		
		Date inDate = null;
		System.out.print("날짜를 예와 같이 입력해주세요.(입력예:2015-12-31)");
		
		while(true) {		// 제대로 입력할 떄 까지 반복
			try {
				String s = sc.nextLine();
				inDate = sdf.parse(s);	// 입력한 s를 sdf의 양식과 같이 변경. 근데 입력된 s가 양식과 다르면 에러가 발생한다.
				break;	// 만약 위 코드에서 에러가 발생하면 catch로 넘어가기 때문에 break는 발생하지 않을 것이다.
			} catch (ParseException e) {
				System.out.print("예와 같이 다시 입력해주세요. (입력예:YYYY-MM-DD)");
			}
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf2.format(inDate));		// 알맞게 입력되어 나온 inDate의 값을 sdf2의 양식으로 바꾸어 출력!
	}

}
