package days08;

import java.util.Random;

public class ControlOpWhile05 {

	public static void main(String[] args) {
		
		// 랜덤한 숫자(난수)를 얻기 위해서는 랜덤한 숫자를 발행해주는 도구가 필요하다.
		Random rd = new Random();
		
		// Scanner의 sc 를 이용하여 외부에서 자료를 입력받듯이, Random의 rd를 이용해서 난수를 제공받는다.
		int num = rd.nextInt();
		// 약 -21억에서 21억까지 나온다.
//		System.out.println(num);

		// 0 ~ 약 21억까지 나온다.
//		if(num<0) {
//			num*=-1;
//		}
//		System.out.println(num);

		// 0 ~ 9 까지 나온다.
//		num%=10;
//		System.out.println(num);
		
		// 0 ~ 9 사이의 랜덤한 값을 10번 출력.
		int i=0;
		while(i<10) {
			num = rd.nextInt();
			if(num<0) {
			num*=-1;
		}
			num%=10;
			System.out.printf("%d ",num);
			i++;
		}
	}

}
