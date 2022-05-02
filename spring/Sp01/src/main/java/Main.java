import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 값을 charAt으로 char형 문자로 잘라준다.
		int result = br.readLine().charAt(0);
		
		System.out.println(result);
	}
}