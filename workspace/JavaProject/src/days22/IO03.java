package days22;

import java.io.IOException;

public class IO03 {

	public static void main(String[] args) throws IOException {
		// System.in 객체를 사용하여 더하기 연산을 수행하는 프로그램을 작성하자.
		// 첫번째 정수 : 123, 두번째 정수 : 25	결과 : 123 + 25 = 148
		
		byte [] firstNumber = new byte[10];
		byte [] secondNumber = new byte[10];
		// 자료형이 Byte라는건 배열 한칸에 -128~127까지를 저장한다는 뜻이다.
		// 입력받은 하나의 숫자가 -128~127로 제한되는 것이 아니라
		// 입력 받은 아라비아 기호의 아스키코드 값이 -128~127까지 제한된다는 뜻이다.

		System.out.print("첫번째 정수 : ");
		int size_1 = System.in.read(firstNumber);
		System.out.print("두번째 정수 : ");
		int size_2 = System.in.read(secondNumber);
		// 입력한 글자들 외에 데이터의 끝을 표시하는 글자와 입력한 엔터까지 저장되어서
		// 배열에 저장된 데이터 갯수 +2개의 size가 출력된다.
		/*
		System.out.println(size_1);
		for(int i=0;i<firstNumber.length;i++) {
			System.out.printf("%c ",(char)firstNumber[i]);
		}
		System.out.println();
		System.out.println(size_2);
		for(int i=0;i<secondNumber.length;i++) {
			System.out.printf("%c ",(char)secondNumber[i]);
		}
		*/
		
		// 165를 입력했을 경우, firstNumber[0]='1', firstNumer[1]='6', firstNumer[2]='5'가 입력된다.
		// ('5'-'0')*1 + ('6'-'0')*10 + ('1'-'0')*100
		
		int i, m, n1=0, n2=0;		// i : 배열의 인덱스  m : 각 자리에 곱셈이 될 10의 자승
		for(i=size_1 - 3,m=1;i>=0;i--,m*=10) {
			n1 += (firstNumber[i] - '0')*m;
			System.out.printf("firstNumber[%d]-%d \t",i,firstNumber[i]-'0');
			System.out.printf(" %d x %d => %d \t",firstNumber[i]-'0',m,(firstNumber[i]-'0')*m);
			System.out.println(n1);
		}
		// i는 1의 자리 숫자가 있는 첨자부터 0번째(가장 큰자리수 숫자가 있는 곳)까지 반복한다.
		// 1234 입력시 size가 6이고, i 변수는 size-3번째(6-3 부터) 부터 0까지 반복한다.
		// 그 처음이 '4' 해당하는 배열 인덱스 3의 자리 글자이다.
		// 그렇게 지목된 일의 자리의 글자부터 '0' 글자를 뺄셈해서 아스키코드값의 차로 해당 숫자를 얻고,
		// 각 반복하다 10이 계속 곱해지는(1,10,100,1000, ... ) m 값을 곱해서 각 자리수를 만든다.
		// 또한 그것을 n1 변수에 누적한다.
		
		System.out.println();
		for(i=size_2 - 3,m=1;i>=0;i--,m*=10) {
			n1 += (secondNumber[i] - '0')*m;
			System.out.printf("firstNumber[%d]-%d \t",i,secondNumber[i]-'0');
			System.out.printf(" %d x %d => %d \t",secondNumber[i]-'0',m,(secondNumber[i]-'0')*m);
			System.out.println(n1);
		}
		
		System.out.println();
		System.out.printf("%d + ",n1);
		System.out.printf("%d = ",n2);
		System.out.println((n1+n2));
	}

}
