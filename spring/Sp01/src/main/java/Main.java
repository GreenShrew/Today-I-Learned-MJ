import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] a = new int[26];
		for(int i=0; i<26; i++) {
			a[i] = -1;
		}
		
		String S = br.readLine();
		
		for(int j=0; j<S.length(); j++) {
			char c = S.charAt(j);
			if(a[c-'a']==-1) {
				a[c-'a']=j;
			}
		}
	}
}