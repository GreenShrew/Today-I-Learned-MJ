package days19;

import java.util.ArrayList;

class Point{
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "x:"+x+", y:"+y;
	}
	
	public boolean equals(Object obj) {	// equals를 오버라이딩
		// obj가 담고있는 데이터가 Point가 아니면 실행 차단
		if(!(obj instanceof Point)) {
			return false;
		}
		// obj를 Point로 형변환
		Point p = (Point)obj;
		
		boolean result = (this.x==p.x)&&(this.y==p.y);
		
		return result;
	}
}
public class Collection08 {

	public static void main(String[] args) {
		ArrayList<Point> list = new ArrayList<Point>();	// Point 객체만 넣을 수 있다.
		Point p1 = new Point(10,10);
		list.add(p1);
		list.add(new Point(20,30));
		list.add(new Point(30,30));
		for(Point p : list) {	// 출력해보기
			System.out.println(p.toString());
		}
		
		int index = list.indexOf(new Point(30, 30));
		System.out.printf("(30,30)의 위치 : %d\n",index);	// 같은 객체인데 왜 Collection07과 다르게 -1, false가 나오는가?
		boolean con = list.contains(new Point(30,30));		// 왜냐하면 Integer에는 equals가 이미 오버라이딩 되어있다.
		System.out.printf("(30,30)의 저장 유무 : %b\n",con);	// Point에도 equals를 오버라이딩 해야한다.
		// 사용자 정의 클래스에 equals 메소드가 오버라이딩 되어있지 않은 경우 주소값을 비교한다.
	}

}
