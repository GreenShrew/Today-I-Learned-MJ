package days19;

import java.io.File;
import java.io.IOException;

public class Exception08 {

	static int cnt = 0;
	public static void main(String[] args) {
		File f1 = createFile("");		// 아무것도 안 쓴 경우!
		File f2 = createFile("abc.txt");
		File f3 = createFile("");		// 이름이 같은 경우! 한번만 만들어진다! 이 경우에는 static 변수(cnt)를 만들어주고
		// catch 부분에 ++cnt를 넣어 '제목없음1', '제목없음2'와 같은 형태로 출력하게 만든다.
	}

	public static File createFile(String fileName) {
		File f = null;
		try {
			if(fileName==null || fileName.equals("")) {
				throw new IOException("파일 이름이 유효하지 않습니다.");	// 일부러 에러를 유도해서 catch를 실행시키려고 함
			}
			f = new File(fileName);
		}catch(IOException e) {	// 생성될 파일 이름을 아무것도 안 썼을 때 이 예외가 실행된다.
			fileName = "제목없음" + ++cnt+".txt";
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 예외처리가 생겼든 안 생겼든 반드시 실행하고 지나갈 영역 : finally
			f = new File(fileName);
			try {
				f.createNewFile();		// 실제 파일을 만들어주는 멤버메소드! workspace의 JavaProject에 생성된다.
			} catch (IOException e) {
				System.out.println(fileName+"파일 생성에 실패했습니다.");
			}
		}
		return f;
	}

}
