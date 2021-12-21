package jdbc04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MemberDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람. 2. 데이터추가. 3. 데이터수정. 4. 데이서삭제.");
			System.out.printf(" 5. 프로그램 종료. >>메뉴 선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5"))break;
			

			switch(choice) {
			case "1" :
				select(sc);
				break;
			case "2" :
				insert(sc);
				break;
			case "3" :
				update(sc);
				break;
			case "4" :
				break;
			default : System.out.println("메뉴 선택이 잘못 되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void update(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = null;
		
		int num;
		String input;
		while(true) {
			System.out.printf("수정할 회원번호를 입력하세요");
			input = sc.nextLine();
			if(input.equals("")) System.out.println("회원번호 입력은 필수입니다.");
			else break;
		}
		num = Integer.parseInt(input);
		

		if(mdto==null) {
			System.out.println("해당 회원이 없습니다.");
			return;
		}
		
		// 이름 입력 후 빈칸이 아니라면 mdto에 저장
		System.out.printf("이름을 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String name = sc.nextLine();
		if(!name.equals("")) mdto.setName(name);
		// 전화번호 입력 후 빈칸이 아니라면 mdto에 저장
		System.out.printf("전화번호를 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String phone = sc.nextLine();
		if(!phone.equals("")) mdto.setPhone(phone);
		// 성별 입력 후 빈칸이 아니라면 mdto에 저장
		System.out.printf("성별을 입력하세요.(M/F) 수정하지 않으려면 엔터를 누르세요. : ");
		String gender = sc.nextLine();
		if(!gender.equals("")) mdto.setGender(gender);
		// bpoint 입력 후 빈칸이 아니라면 mdto에 저장
		System.out.printf("포인트를 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String bpoint = sc.nextLine();
		if(!bpoint.equals("")) mdto.setBpoint(Integer.parseInt(bpoint));
		// 생일 입력 후 빈칸이 아니라면 mdto에 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				System.out.printf("생일을 입력하세요.(YYYY-MM-DD) 수정하지 않으려면 엔터를 누르세요. : ");
				d = sdf.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예 : 2015-12-31");
			}
		}
		
		// 나이 계산 후 mdto에 저장
		Calendar c = Calendar.getInstance();
		Calendar today= Calendar.getInstance();
		c.setTime(d);	// c.setTime(birth); Date 자료를 Calendar 자료로 변환한다.
		int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR) +1;
		mdto.setAge(age);
		
		int result = mdao.insert(mdto);
		if(result==1)System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
	}

	private static void insert(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		
		// 회원번호는 시퀀스 이용
		System.out.print("이름을 입력하세요 : ");
		mdto.setName(sc.nextLine());
		
		System.out.print("전화번호를 입력하세요 : ");
		mdto.setPhone(sc.nextLine());
		
		System.out.print("성별을 입력하세요(M/F) : ");
		mdto.setGender(sc.nextLine());
		
		// 생일 입력 - java.util.Date() 형식의 입력 후 java.sql.Date()로의 변환이 필요하다.
		// java.util.Date()의 입력을 위해선 SimpleDateFromat의 parse 동작이 필요하다.
		
		System.out.printf("생일을 입력하세요(YYYY-MM-DD)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				d = sdf.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예 : 2015-12-31");
			}
		}
		// java.util.Date를 java.sql.Date로 변환
		java.sql.Date birth = new java.sql.Date(d.getTime());
		// 이를 dto에 입력
		mdto.setBirth(birth);
		
		Calendar c = Calendar.getInstance();
		Calendar today= Calendar.getInstance();
		c.setTime(d);	// c.setTime(birth); Date 자료를 Calendar 자료로 변환한다.
		int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR) +1;
		mdto.setAge(age);	// 나이를 계산해서 집어넣었다. 어차피 위에서 생일을 입력하면 이걸 기준으로 나이가 나오므로 따로 입력 x
		
		int result = mdao.insert(mdto);
		if(result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}

	private static void select(Scanner sc) {
//		MemberDao bdao = new MemberDao();	<- MemberDao가 싱글톤 패턴을 가지므로 이런식으로 인스턴스를 생성할 수 없다.
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.select();
		System.out.println("번호\t이름\t\t전화\t\t\t생일\t\t\t포인트\t\t\t나이\t성별\t가입일");
		System.out.println("---------------------------------------------------------------------------------");
		for(MemberDto dto : list) {
			System.out.printf("%d \t %s \t %s \t %s \t %6d \t %3d \t %s \t %s\n", dto.getMembernum(), dto.getName(), dto.getPhone(), dto.getBirth(), dto.getBpoint(), dto.getAge(), dto.getGender(), dto.getJoindate());
		}
		
	}
}

