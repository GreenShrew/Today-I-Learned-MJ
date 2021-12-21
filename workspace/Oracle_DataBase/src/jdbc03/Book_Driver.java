package jdbc03;

import java.util.ArrayList;
import java.util.Scanner;

public class Book_Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람. 2. 데이터추가. 3. 데이터수정. 4. 데이서삭제.");
			System.out.printf(" 5. 프로그램 종료. >>메뉴 선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5"))break;
			
			Book_Dao bdao = new Book_Dao();
			switch(choice) {
			case "1" :
				select(sc, bdao);
				break;
			case "2" :
				insert(sc, bdao);
				break;
			case "3" :	
				update(sc, bdao);
				break;
			case "4" :	
				delete(sc, bdao);
				break;
			default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	
	private static void delete(Scanner sc, Book_Dao bdao) {
		int num = 0;
		while(true) {
			System.out.printf("삭제할 도서번호를 입력하세요.(필수)");
			String input = sc.nextLine();
	
			if(input.equals("")) {
				System.out.println("도서번호 입력은 필수입니다.");
			}else {
				num = Integer.parseInt(input);
				break;
			}
		}
		int result = bdao.delete(num);
		if(result == 1) System.out.println("레코드 삭제 성공");
		else System.out.println("레코드 삭제 실패");
	}

	private static void update(Scanner sc, Book_Dao bdao) {
		// 수정할 도서번호를 입력받는다. (미입력시 재입력 화면으로 돌아가도록 만든다.)
		int num = 0;
		while(true) {
			System.out.printf("수정할 도서번호를 입력하세요.(필수)");
			String input = sc.nextLine();
	
			if(input.equals("")) {
				System.out.println("도서번호 입력은 필수입니다.");
			}else {
				num = Integer.parseInt(input);
				break;
			}
		}
		
		
		// 도서번호로 도서 '하나'를 조회해서 Book_Dto에 담아둔다.
		Book_Dto bdto = bdao.getBook(num);
		// 도서번호로 조회한 내역이 null이라면 '해당 도서가 없습니다.' 출력하고 종료
		if(bdto == null) {
			System.out.println("입력하신 도서번호로 조회된 도서가 없습니다.");
			return;
		}
		
		
		// 수정할 사항을 차례로 모두 입력할 화면을 제공하되, 수정하지 않을 항목은 엔터만 입력받아 지나간다.
		// 수정할 사항은 저장해둔 BookDto에 업데이트한다.
		
		// 도서제목 입력
		System.out.printf("도서의 제목을 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String subject = sc.nextLine();
		if(!subject.equals("")) bdto.setSubject(subject);	// 무언가 입력하게 되면 bdto 객체의 subject가 바뀌고, 엔터만 누르면 그냥 넘어간다.
		
		// 출판년도
		System.out.printf("출판년도를 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String makeyear = sc.nextLine();
		if(!makeyear.equals("")) bdto.setMakeyear(Integer.parseInt(makeyear));
		
		// 입고가격
		System.out.printf("입고가격을 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String inprice = sc.nextLine();
		if(!inprice.equals("")) bdto.setInprice(Integer.parseInt(inprice));
		
		// 대여가격
		System.out.printf("대여가격을 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String rentprice = sc.nextLine();
		if(!rentprice.equals("")) bdto.setRentprice(Integer.parseInt(rentprice));
		
		// 등급
		System.out.printf("등급을 입력하세요. 수정하지 않으려면 엔터를 누르세요. : ");
		String grade = sc.nextLine();
		if(!grade.equals("")) bdto.setGrade(grade);
		
		
		//Dao에 BookDto를 보내서 해당 레코드를 수정한다.
		int result = bdao.update(bdto);
		if(result == 1) System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
	}

	private static void select(Scanner sc, Book_Dao bdao) {
		System.out.println("도서번호\t출판년도\t입고가격\t대여가격\t등급\t제목");
		System.out.println("-------------------------------------------------------");
		
		ArrayList<Book_Dto> BookDto_list = bdao.select();
		for(Book_Dto bdto : BookDto_list) {		// 배열에 있는 내용을 순서대로 bdto에 넣는 방법. 옛날 '배열' 파트에서 배웠다.
			System.out.printf("%d\t\t%d\t\t%d\t%d\t\t%s\t%s\n", bdto.getNum(), bdto.getMakeyear(), bdto.getInprice(), bdto.getRentprice(), bdto.getGrade(), bdto.getSubject());
		}
	}

	private static void insert(Scanner sc, Book_Dao bdao) {	// 매개변수로 만들어서 잠깐 scanner와 book_dao를 사용할 수 있다.
		System.out.print("제목을 입력하세요");
		String subject = sc.nextLine();
		System.out.print("제작년도을 입력하세요");
		int makeyear = Integer.parseInt(sc.nextLine());
		System.out.print("가격을 입력하세요");
		int inprice = Integer.parseInt(sc.nextLine());
		System.out.print("대여료를 입력하세요");
		int rentprice = Integer.parseInt(sc.nextLine());
		System.out.print("등급을 입력하세요");
		String grade = sc.nextLine();
		Book_Dto bdto = new Book_Dto();
		bdto.setSubject(subject);		// 나중에는 따로 subject와 같은 변수를 만들지 않고 괄호 안에 모든것을 넣을 것이다.
		bdto.setMakeyear(makeyear);
		bdto.setInprice(inprice);
		bdto.setRentprice(rentprice);
		bdto.setGrade(grade);
		int result = bdao.insert(bdto);	// 각 멤버변수에 데이터를 저장해서 객체로 만들어 객체를 전달인자로 전달한다.
		if(result==1)System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}

}
