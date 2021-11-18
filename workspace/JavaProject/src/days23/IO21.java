package days23;

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

public class IO21 {

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
				inputDate = String.valueOf(in.readLine());
				iDate = sdf1.parse(inputDate);
				break;
			}catch(Exception e){
				System.out.print("예와 같이 다시 입력해주세요. (입력예:2020-01-01)");
			}
		}
		// 읽어올 파일 경로 설정
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		// 폴더에서 모든 파일 목록 불러옴
		String [] f = dir.list();
		for(String fn : f) {		// 파일 이름은 f에 있다.
			System.out.println(fn);
		}
		for(int i=0;i<f.length;i++) {
			// 파일 이름과 입력한 날짜와 비교해서 같은 것만 출력하자
			// f[i]의 일부와 inputDate와 비교해서 출력..
			if(f[i].contains(inputDate)) {
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
