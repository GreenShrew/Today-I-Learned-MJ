package days22;

import java.io.File;
import java.io.IOException;

public class IO07 {

	public static void main(String[] args) throws IOException {
		// 파일 처리
		// File 클래스 : 파일 또는 디렉토리에 관련된 메타정보를 제공하는 클래스
		// 파일을 생성, 디렉토리를 생성 등의 추가적인 기능을 제공
		
		// D:\heejoonk\Java_se\temp 폴더를 참조하는 File 객체 생성
		File d = new File("C:\\Users\\Onion\\Desktop\\TIL\\Today-I-Learned-MJ\\Java_se\\temp");
		System.out.println("C:\\Users\\Onion\\Desktop\\TIL\\Today-I-Learned-MJ\\Java_se\\temp");
		// 집에서 만들어서 다른 경로
		
		// exists() : 생성자에 입력한 경로가 실제로 있는지 검사 후 있으면 true, 없으면 false 리턴
		if(d.exists()) {
			System.out.println("temp 디렉토리 발견!");
		}else {
			System.out.println("temp 디렉토리가 없어서 새로 생성합니다.");
			d.mkdirs();	// 디렉토리를 생성하는 메소드
			// mkdir : 최종 타겟 이전의 경로가 존재해야만 동작
			// mkdirs : 최종 타겟 이전의 경로가 존재하지 않아도 전체 경로를 생성
		}
		
		File f = new File(d,"msg.txt");
		// File f = new File("D:\\JAVA01\\Java_se\\temp\\msg.txt")
		// 이와 같이 한번에 폴더와 파일명을 설정할 수 있으나, 폴더가 없을 수 있기 때문에 폴더 확인 절차를 거치고 파일을 생성한다.
		
		if(!f.exists()) {
			f.createNewFile();	// 파일 생성 메소드 - 예외처리 add throw dec...
			System.out.printf("파일명 : %s\n",f.getName());
			System.out.printf("파일의 전체 경로 : %s\n",f.getAbsolutePath());
			System.out.printf("파일의 크기 : %d\n",f.length());
		}
	}

}
