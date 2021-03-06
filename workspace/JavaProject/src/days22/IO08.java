package days22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IO08 {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\Users\\Onion\\Desktop\\TIL\\Today-I-Learned-MJ\\Java_se\\temp");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file_binary = new File(dir,"binary_data.dat");
		File file_text = new File(dir,"text_data.txt");
		
		// 파일 처리
		// File에 데이터를 출력하는 클래스 FileOutputStream(이진 데이터 파일 객체), FileWriter(문자 데이터 파일 객체)
		// 파일 출력 스트림 객체는 해당 파일이 존재하지 않는 경우, 파일을 생성하여 스트림을 구성한다. (createNewFile이 없어도 생성된다.)
		// 파일에 이진 데이터를 출력할 수 있는 객체 생성 + 해당 파일 생성
		FileOutputStream fos_binary = new FileOutputStream(file_binary);
		// 파일에 문자 데이터를 출력할 수 있는 객체 생성 + 해당 파일 생성
		FileWriter fos_text = new FileWriter(file_text);
		
		// 파일에 내용을 출력
		fos_binary.write(11);
		fos_binary.write(22);
		fos_text.write("Hello ");
		fos_text.write("World!");
		fos_binary.close();
		fos_text.close();
	}

}
