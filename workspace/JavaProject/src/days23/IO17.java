package days23;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Point implements Serializable{
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x : "+this.x+", y : "+this.y;
	}
}
public class IO17 {

	public static void main(String[] args) throws IOException {
		// Math.random()을 이용해서 0~99 사이의 값을 x와 y값으로 넣고,
		// 이들을 값으로 가지는 객체 100개를 생성해서 파일에 저장한다.
		ArrayList<Point> list = new ArrayList<Point>();
		
		for(int i=0;i<100;i++) {
			Point p = new Point((int)(Math.random()*100),(int)(Math.random()*100));
			list.add(p);
		}
		
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir,"Point.dat");
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(list);
		oos.close();
	}

}
