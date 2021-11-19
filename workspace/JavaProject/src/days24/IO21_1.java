package days24;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IO21_1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		// 특정 날짜를 입력받아서 그 날짜 파일만 출력하자
		// 날짜 입력 양식을 정해서 잘못된 입력은 다시 입력 받게 설정하자
		System.out.print("출력할 날짜를 입력하세요.(2020-01-01)");
		String inputDate;
		Date iDate;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		// day17의 FormatterClass02 참고하면서 계속 작성하자
		
		while(true) {
			try {
				inputDate = in.readLine();
/*				if(inputDate.length()!=10) {
					throw new Exception();		여기 부분은 이렇게도 추가하면 더 좋았다는 예시
				} */
				iDate = sdf1.parse(inputDate);
				break;
			}catch (ParseException e) {
				System.out.print("예와 같이 다시 입력해주세요. (입력예:2020-01-01)");
			}catch (Exception e) {
				System.out.print("예와 같이 다시 입력해주세요. (입력예:2020-01-01)");
			}
		}
		// 읽어올 파일 경로 설정
		File dir = new File("C:\\Users\\Onion\\Desktop\\TIL\\Today-I-Learned-MJ\\Java_se\\temp");
		// 폴더에서 모든 파일 목록 불러옴
		String [] f = dir.list();
/*		for(String fn : f) {		// 파일 이름은 f에 있다.
			System.out.println(fn);		이 부분은 파일 이름을 모두 나열하는 부분이였다. 그냥 확인하는 동작이라 필요없었던 부분.
		} */
		for(int i=0;i<f.length;i++) {
			// 파일 이름과 입력한 날짜와 비교해서 같은 것만 출력하자
			// f[i]의 일부와 inputDate와 비교해서 출력..
			if(f[i].length()>10) {
				// 앞으로 사용할 메소드가 f[i].substring(0,10); 인데,f[i]에 있는 String 글자 갯수가10개가 안 되면 에러가 발생한다.
				// 따라서 10글자 이상 파일 이름을 선별하여 실행한다.
				String s1 = f[i].substring(0,10);
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy_MM_dd");	// 파일 이름과 같은 format으로 변경
				String s2 = sdf2.format(iDate)+"";	// 의미없는 String 하나 ( "" ) 를 넣어줌으로서 s2는 날짜가 아니라 String이 된다.
				if(s1.equals(s2)) {
					File file = new File(dir,f[i]);
					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
					ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>)ois.readObject();
					for(int j = 0; j<list.size(); j++) {
						System.out.printf("%d. %s\n",j+1,list.get(j));
					}
					ois.close();
				}
			}
		}
	}

}
