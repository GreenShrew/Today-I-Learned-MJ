package days23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO14 {

	public static void main(String[] args) throws IOException {
		// 이진 형식, text 형식 모두 가능하지만 가능하다면 이진 형식으로 만들어보자.
		
		// "D:\\JAVA01\\Java_se\\temp" 폴더안의 "eclipse-inst-jre-win64.exe" 파일을
		// "D:\\JAVA01\\Java_se\\copy" 폴더로 복사
		// 이진 형식으로 읽어서 바로 써넣는 형식!
		
		/*		여긴 내가 고민한 부분
		File dir1 = new File("D:\\JAVA01\\Java_se\\temp");
		if(!dir1.exists()) {
			dir1.mkdirs();
		}
		File dir2 = new File("D:\\JAVA01\\Java_se\\copy\\");
		if(!dir2.exists()) {
			dir2.mkdirs();
		}
		
		File ec1 = new File(dir1,"eclipse-inst-jre-win64.exe");
		
		BufferedInputStream b = new BufferedInputStream(new FileInputStream(ec1));
		*/
		

		String CopyPath = "D:\\JAVA01\\Java_se\\copy";		// 사본 파일 경로, 파밀명을 String으로 만들었다.
		String OriginalPath = "D:\\JAVA01\\Java_se\\temp";	// 원본 파일 경로
		String Filename = "eclipse-inst-jre-win64.exe";
		
		File originDir = new File(OriginalPath);	// 읽어올 파일 경로 설정
		File fileOriginal = new File(originDir, Filename);	// 읽어올 파일 설정
		// 여기까지 내가 고민했던 맥락은 비슷하다.
		
		File copyDir = new File(CopyPath);	// 경로설정
		if(!copyDir.exists()) {		// 폴더 없으면 써넣을 경로 생성
			copyDir.mkdirs();
		}
		File fileCopy = new File(copyDir, Filename);	// 써넣을 파일 설정
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileOriginal));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileCopy));
		
		/*		1바이트씩 읽고 쓰고를 반복, 오래걸려!
		int data;
		while((data = bis.read()) != -1){
			bos.write(data);
		}
		*/
		byte [] data = new byte[1024];	// 그래서 1024 byte 단위로 쪼개서 복사 붙여넣기를 하도록 명령했다.
		int size;
		while((size = bis.read(data)) != -1){
			bos.write(data,0,size);
		}
		bis.close();
		bos.close();
	}

}
