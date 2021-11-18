package days23;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IO20 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir,"2021_11_17_13_49.dat");		// 이 파일을 불러올 것이다.
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		
		ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>)ois.readObject();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.printf("%d. %s\n",i+1,list.get(i));
		}
		ois.close();
	}

}
