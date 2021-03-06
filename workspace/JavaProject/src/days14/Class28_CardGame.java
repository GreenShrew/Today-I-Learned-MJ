package days14;
class CardDeck{	// Card.java의 Card 클래스를 사용할거야.
	private Card [] cards = new Card[52];	// 배열로 52장의 카드의 공간을 만들었는데, 배열을 만든거지 객체를 만든게 아니다.
//	cards[0] = new Card(spade,1);
//	cards[1] = new Card(spade,1);
//	cards[2] = new Card(spade,1);
	//... 이런 동작들을 생성자에서 해준다.
	CardDeck() {
//		cards[0] = new Card(Card.spade,1);
//		cards[1] = new Card(Card.spade,1);
//		cards[2] = new Card(Card.spade,1);
		//... 52번 다 쓰는 대신 반복 실행문으로 만들자.
		int i=0;
		for(int k=1; k<=4; k++) {	// 카드무늬 1~4 반복
			for(int n=1; n<=13; n++) {	// 카드번호 1~13 반복
				cards[i]=new Card(k,n);	// 카드 장수 i는 0~51
				i++;
			}
		}
	}
	public Card pick(int i) {
		return cards[i];	// cards[i] 객체가 리턴
	}
	
	public void shuffle() {	// 카드 섞는 메소드
		// n번째 카드와 random으로 발생한 숫자번째의 카드를 서로 자리 바꿈
		// 이 동작을 0~51의 카드를 대상으로 한번씩, 총 52번 반복하는 메소드.
		for(int i=0;i<52;i++) {
			int r = (int)(Math.random()*52);
			Card temp = cards[i];
			cards[i] = cards[r];
			cards[r] = temp;
		}
	}
}
public class Class28_CardGame {

	public static void main(String[] args) {
		CardDeck d = new CardDeck();
		
		// 카드를 섞는 건 메소드를 만든다.
		d.shuffle();
		
/*		System.out.printf("%s ", d.pick(0).toString());
		System.out.printf("%s ", d.pick(1));
		System.out.printf("%s ", d.pick(2));
		System.out.printf("%s ", d.pick(3));
		System.out.printf("%s ", d.pick(4));	// 카드 5장 뽑기
		// shuffle 없이 이대로만 출력하면 클로버 A,2,3,4,5가 주르륵 나온다
*/

		Card [] player1 = new Card[5];
		Card [] player2 = new Card[5];
		Card [] player3 = new Card[5];
		Card [] player4 = new Card[5];

		// 카드를 1명당 5장씩 분배하고, 1줄에 보유카드를 출력해서 네줄을 출력해보자.
		int k=0;
		for(int i=0;i<5;i++) {
			player1[i]=d.pick(k++);	//1,5,9,13,17번째 카드를 가져간다.
			player2[i]=d.pick(k++);
			player3[i]=d.pick(k++);
			player4[i]=d.pick(k++);
		}
		
		for(int i=0;i<5;i++) {
			System.out.printf("%s ",player1[i]);
		}
		System.out.println();
		for(int i=0;i<5;i++) {
			System.out.printf("%s ",player2[i]);
		}
		System.out.println();
		for(int i=0;i<5;i++) {
			System.out.printf("%s ",player3[i]);
		}
		System.out.println();
		for(int i=0;i<5;i++) {
			System.out.printf("%s ",player4[i]);
		}
		System.out.println();
		
	}
}
