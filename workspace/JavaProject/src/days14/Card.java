package days14;

public class Card {	// 카드 한장에 담긴 정보(숫자, 무늬)가 담긴 클래스
	// 이 넷은 절대적으로 변경되지 않아야 한다. 그 경우 사용하는 문법인 final이 있다.
	final static int spade = 4;
	final static int diamon = 3;
	final static int heart = 2;
	final static int clover = 1;
	// final : 변수값을 변경하지 못 하도록 만드는 키워드이다.
	
	private int kind;	// 4:Spade 3:Diamond 2:Heart 1:Clover
	private int number;
	
	Card(int kind, int number){
		this.kind=kind;
		this.number=number;
	}
	Card(){	// 디폴트 생성자. 호출되면 4와 1을 위의 멤버메소드로 넣는다.
		this(spade,1);
	}
	
	// 아래는 호출되면 호출객체의 무늬와 숫자를 String으로 리턴해주는 멤버메소드.
	// kind : 4, number : 13 이라면 문자열 "[Spade:K]"라고 리턴되는 메소드
	public String toString() {
		String[] kinds = {"","Clover","Heart","Diamond","Spade"};
		String[] numbers = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String result = "["+kinds[this.kind]+":"+numbers[this.number]+"]";
		return result;
	}
	// 여기서 toString은 다소 특별한 메소드이다. (이 부분은 나중의 진도에서 나올 것...이런게 있다고 알고 넘어가자.)
	// toString 메소드가 포함된 클래스로 만든 객체를 System.out.println(객체이름(잠조변수이름));으로 출력하면
	// 이전에 봤던 것처럼 '패키지.클래스이름@해쉬코드'가 출력되는것이 아니라
	// toString 메소드에서 리턴해주는 값이 출력된다.
	// 이는 System.out.println(객체이름(참조변수이름).toString());라고 한것과 같은 출력이 있다는 뜻이다.
	
	// 아래와 같이 된다.
//	Class28_Card c = new Class28_Card(4,13);
//	System.out.println(c);   ->   출력 : [Spade:K]
//	System.out.println(c.toString());   ->   출력 : [Spade:K]
//	String result = "카드 1 : " + c;
//	String result = "카드 1 : " + c.toString();
	
}
