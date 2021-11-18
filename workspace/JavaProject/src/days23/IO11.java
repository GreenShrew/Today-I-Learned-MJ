package days23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO11 {

	public static void main(String[] args) throws IOException {
		File f = new File("D:\\JAVA01\\Java_se\\temp");
		if(!f.exists()) {
			f.mkdirs();
		}
		
		File f1 = new File(f,"abc.txt");
		FileReader f2 = new FileReader(f1);
		
		int data_text;
		while((data_text = f2.read())!=-1) {
			System.out.print((char)data_text);
		}
		
		
		f2.close();
		
	}

}
