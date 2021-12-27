package jdbc01;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MemberDriver {

	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf(" 1. 데이터열람.");    		System.out.printf(" 2. 데이터추가.");
			System.out.printf(" 3. 데이터수정.");		System.out.printf(" 4. 데이터삭제.");
			System.out.println(" 5. 상세 데이터 열람.");
			System.out.print(">>메뉴 선택 : ");
			String choice = sc.nextLine();
			if( choice.equals("5")) break;
			switch( choice ) {
				case "1": 
					select(); break;
				case "2": 
					insert(); break;
				case "3": 
					update(); break;
				case "4": 
					delete(); break;
				default : System.out.println("메뉴 선택이 잘못되었습니다");
			}
		}
		System.out.println("프로그램을 종료합니다");
	}

	
	private static void delete() {
		MemberDao mdao = MemberDao.getInstance();
		Scanner sc = new Scanner(System.in);
		MemberDto mdto = null;
		
		System.out.printf("삭제할 회원의 회원번호를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		mdto = mdao.selectOne(num);
		
		if(mdto == null) {
			System.out.println("입력한 회원번호의 회원이 존재하지 않습니다.");
			return;
		}
		mdao.delete(num);
	}


	private static void update() {
		MemberDao mdao = MemberDao.getInstance();
		Scanner sc = new Scanner(System.in);
		MemberDto mdto = null;
		
		System.out.print("수정할 회원번호를 입력하세요 : ");
		String membernum = sc.nextLine();		// 회원번호는 필수입니다 <- 기능 생략
		mdto = mdao.selectOne(Integer.parseInt(membernum));
		
		if(mdto == null) {
			System.out.println("입력한 회원번호의 회원이 존재하지 않습니다.");
			return;
		}
		
		// 이름 입력
		System.out.printf("성명 : %s\t성명을 입력하세요 : ",mdto.getName());
		String name = sc.nextLine();
		if(!name.equals("")) {
			mdto.setName(name);
		}
		
		// 전화번호 입력
		System.out.printf("전화번호 : %s\t전화번호를 입력하세요 : ",mdto.getPhone());
		String phone = sc.nextLine();
		if(!phone.equals("")) {
			mdto.setPhone(phone);
		}
		
		// 생일 입력 및 나이 계산
		System.out.printf("생일 : %s\t생일을 입력하세요 (YYYY-MM-DD) : ",mdto.getBirth());
		String birth = sc.nextLine();
		if(!birth.equals("")) {
			mdto.setBirth(birth);
			Calendar today = Calendar.getInstance();
			int age = today.get(Calendar.YEAR) - Integer.parseInt(birth.substring(0,4)) + 1; 
			mdto.setAge(age);
		}
		
		// 성별 입력
		System.out.printf("성별을 입력하세요 : ");
		String gender = sc.nextLine();
		if(!gender.equals("")) {
			mdto.setGender(gender);
		}
		
		// 포인트 입력
		System.out.printf("포인트 : %s\t포인트를 입력하세요 : ",mdto.getBpoint());
		String bpoint = sc.nextLine();
		if(!bpoint.equals("")) {
			mdto.setBpoint(Integer.parseInt(bpoint));
		}
		
		// 가입일 입력
		System.out.printf("가입일 : %s\t가입일을 입력하세요 : ",mdto.getJoindate());
		String joindate = sc.nextLine();
		if(!joindate.equals("")) {
			mdto.setJoindate(joindate);
		}
		
		int result = mdao.update(mdto);
		if(result == 1) {
			System.out.println("레코드 수정 성공");
		} else {
			System.out.println("레코드 수정 실패");
		}
		
	}


	private static void insert() {
		MemberDao mdao = MemberDao.getInstance();
		Scanner sc = new Scanner(System.in);
		MemberDto mdto = new MemberDto();
		
		System.out.print("이름을 입력하세요 : ");
		mdto.setName(sc.nextLine());

		System.out.print("전화번호를 입력하세요 : ");
		mdto.setPhone(sc.nextLine());
		
		System.out.print("생일을 입력하세요 (YYYY-MM-DD) : ");
		String birth = sc.nextLine();		// 나이를 계산하기 위해서 변수에 따로 넣는다.
		mdto.setBirth(birth);
		
		// 나이 계산
		String year = birth.substring(0,4);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - Integer.parseInt(year) + 1;
		mdto.setAge(age);
		
		System.out.print("성별을 입력하세요 : ");
		mdto.setGender(sc.nextLine());
		
		int result = mdao.insert(mdto);
		if(result == 1) {
			System.out.println("레코드 추가 성공");
		}else {
			System.out.println("레코드 추가 실패");
		}
	}


	private static void select() {
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.selectAll();
		System.out.println("번호\t이름\t\t\t전화\t\t\t생일\t\t포인트\t\t나이\t성별\t가입일");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(MemberDto dto : list) {
			System.out.printf("%d \t %s \t %s \t %s \t %6d \t %3d \t %s \t %s\n", dto.getNum(), dto.getName(), dto.getPhone(), dto.getBirth(), dto.getBpoint(), dto.getAge(), dto.getGender(), dto.getJoindate());
		}
	}

}
