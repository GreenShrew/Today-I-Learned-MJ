package days02;

public class JavaThird {

	public static void main(String[] args) {
		System.out.printf("\\n : new line\n");				// \n : new line
		System.out.printf("\\t : tab\n");						// \t : tab
		System.out.printf("\\b : 백스페이스\n");				// \b : 백스페이스
		System.out.printf("\\' : ' 출력\n");					// \' : ' 출력
		System.out.printf("\\\" : \" 출력\n");				// \" : " 출력
		System.out.printf("%%%% : %% 출력\n");		// %% : % 출력
		System.out.printf("\\\\ : 역슬래시 출력\n");		// \\ : 역슬래시 출력
	}

}
// 배운것을 활용한 간단한 문제 풀이

/*
 의문점들
 1. 9번 라인에 "\\\'  이런식으로 써야하는 것 같은데 왜 "\\' 으로 썼는데도 작동 하는가?
 답 : ' 정도는 \가 없어도 출력 되도록 만들어준다.
 2. JavaSecond 에서 50번 라인에 %%를 썼으니 %이 출력되어아 하는데 왜 %%이 출력되었을까?
*/