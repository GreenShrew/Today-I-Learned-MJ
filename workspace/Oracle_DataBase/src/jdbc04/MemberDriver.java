package jdbc04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import jdbc03.Book_Dao;

public class MemberDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while( true ) {
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람.  2. 데이터추가.  3. 데이터수정. ");
			System.out.printf("4. 데이터삭제.  5. 프로그램 종료.  >>메뉴 선택 : ");			
			String choice = sc.nextLine();
			if( choice.equals("5")) break;
			Book_Dao bdao = new Book_Dao();
			switch( choice ) {
				case "1": 
					select(sc); break;	
				case "2": 
					insert(sc); break;
				case "3": 
					update(sc); break;
				case "4": 
					delete(sc); break;
				default : System.out.println("메뉴 선택이 잘못되었습니다");
			}
		}
		System.out.println("프로그램을 종료합니다");
	}

	private static void delete(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = null;
		int result, num;
		String input;
		while(true) {
			System.out.printf("삭제할 회원번호를 입력하세요");
			input = sc.nextLine();
			if( input.equals("") ) System.out.println("회원번호 입력은 필수 입니다");
			else break;
		}
		num = Integer.parseInt( input );
		// 회원번호 조회 - 조회된 회원이 없으면, 회원이 없습니다 출력후 종료 - 조회된 회원이 있으면 삭제후 종료
		mdto = mdao.getMember(num);
		if( mdto==null) {
			System.out.println("해당 회원이 없습니다");
			return;
		}else {
			result = mdao.delete(num);
		}
		if( result == 1) System.out.println("레코드 삭제 성공");
		else System.out.println("레코드 삭제 실패");				
	}

	private static void update(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = null;
		
		int num;
		String input;
		while(true) {
			System.out.printf("수정할 회원번호를 입력하세요");
			input = sc.nextLine();
			if( input.equals("") ) System.out.println("회원번호 입력은 필수 입니다");
			else break;
		}
		num = Integer.parseInt( input );

		mdto = mdao.getMember(num);
		if( mdto==null) {
			System.out.println("해당 회원이 없습니다");
			return;
		}
		// 이름입력 후  빈칸이 아니라면 mdto 에 저장
		System.out.printf("성명:%s - 수정하려면 수정할 성명을 입력하세요 ", mdto.getName());
		System.out.printf("수정하지 않으려면 엔터만 입력하세요 -> ");
		String name = sc.nextLine();
		if( !name.equals("") ) mdto.setName(name);
		
		// 전화번호 입력 후  빈칸이 아니라면 mdto 에 저장
		System.out.printf("전화번호:%s - 수정할 전화번호를 입력하세요 -> ", mdto.getPhone());
		String phone = sc.nextLine();
		if( !phone.equals("") ) mdto.setPhone(phone);
		
		// 성별입력 후  빈칸이 아니라면 mdto 에 저장
		System.out.printf("성별:%s - 수정할 성별을 입력하세요 -> ", mdto.getGender());
		String gender = sc.nextLine();
		if( !gender.equals("") ) mdto.setGender(gender);
		
		// bpoint  입력후  빈칸이 아니라면  mdto  에 저장
		System.out.printf("포인트:%s - 수정할 포인트를 입력하세요 -> ", mdto.getBpoint());
		String bpoint = sc.nextLine();
		if( !bpoint.equals("") ) mdto.setBpoint( Integer.parseInt(bpoint) );
		
		// 생일입력 후  빈칸이 아니라면 mdto 에 저장
		System.out.printf("생년월일:%s - 수정할 생년월일을 입력하세요 -> ", mdto.getBirth());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				String b = sc.nextLine();  // String 으로 날짜입력
				if(b.equals("")) break;  // 엔터만 입력했으면 반복 멈춤
				d = sdf.parse( b );  // java.util.Date 로 변환
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예:2015-12-31)");
				e.printStackTrace();
			} 		
		}
		if( d != null ) {
			java.sql.Date birth = new java.sql.Date( d.getTime() );  // java.sql.Date 로번환
			mdto.setBirth( birth );
			// 나이 계산후  mdto  에 저장 Calendar로 변환후 년도끼리 뺄셈
			Calendar c = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			c.setTime( d );   
			int age = today.get( Calendar.YEAR ) - c.get( Calendar.YEAR ) + 1;
			mdto.setAge(age);
		}
		
		
		// 회원가입일 수정 - 가입일자 후  빈칸이 아니라면 mdto 에 저장
		System.out.printf("가입일자:%s - 수정할 가입일자를 입력하세요 -> ", mdto.getJoindate());
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		d = null;
		while(true) {
			try {
				String b = sc.nextLine();  // String 으로 날짜입력
				if(b.equals("")) break;  // 엔터만 입력했으면 반복 멈춤
				d = sdf.parse( b );  // java.util.Date 로 변환
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예:2015-12-31)");
			} 		
		}
		if( d != null ) {
			java.sql.Date joindate = new java.sql.Date( d.getTime() );  // java.sql.Date 로번환
			mdto.setBirth( joindate );
		}
		
		int result = mdao.update( mdto );
		if( result == 1) System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");		
		
	}

	private static void insert(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		
		// 회원번호는 Sequence 를 이용합니다
		
		System.out.print("이름을 입력하세요");
		mdto.setName(  sc.nextLine() );
		
		System.out.print("전화번호를 입력하세요");
		mdto.setPhone(  sc.nextLine() );
		
		System.out.print("성별을 입력하세요(M/F) : ");
		mdto.setGender(  sc.nextLine() );
		
		// 생일 입력 - java.util.Date()형식의 입력 후  java.sql.Date()로의 변환이 필요합니다
		// java.util.Date() 의 입력을 위해선  SimpleDateFormat 의 parse 동작이 필요합니다
		System.out.printf("생일을 입력하세요(YYYY-MM-DD");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				d = sdf.parse( sc.nextLine() );
				break;
			} catch (ParseException e) {
				System.out.print("날짜를 입력예로 맞춰 다시 입력하세요(입력예:2015-12-31)");		
			} 		
		}
		// java.util.Date 을  java.sql.Date 로 변환 
		java.sql.Date birth = new java.sql.Date( d.getTime() );
		// dto 에 입력
		mdto.setBirth(birth);
		
		Calendar c = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		c.setTime( d );   //c.setTime( birth );  Date 자료를 Calendar  자료로 변환
		int age = today.get( Calendar.YEAR ) - c.get( Calendar.YEAR ) + 1;
		mdto.setAge(age);
		
		int result = mdao.insert( mdto );
		if( result == 1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
				
		
	}

	private static void select(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.select();
		System.out.println("번호\t이름\t\t전화\t\t\t\t생일 \t\t\t포인트 \t나이\t성별 \t가입일");
		System.out.println("-----------------------------------------------------------");
		for(MemberDto dto : list) {
			System.out.printf("%d \t %s \t %s \t %s \t %6d \t %3d \t %s \t %s\n",	
					dto.getMembernum(),	dto.getName(), dto.getPhone(), 
					dto.getBirth(), dto.getBpoint(),	dto.getAge(), dto.getGender() , 
					dto.getJoindate() );
		}
	}

}
