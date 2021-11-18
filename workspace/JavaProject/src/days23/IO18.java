package days23;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IO18 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir,"Point.dat");
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		ArrayList<Point> list;
		list = (ArrayList<Point>)ois.readObject();
		
		for(int i=0;i<list.size();i++) {
			System.out.printf("%s	",list.get(i).toString());
			if((i+1)%8==0) {		// 8칸마다 엔터
				System.out.println();
			}
		}
	}

}
