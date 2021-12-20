package jdbc03;

import java.util.Scanner;

public class Book_Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- 메뉴 선택 ---");
			System.out.printf("1. 데이터열람. 2. 데이터추가. 3. 데이터수정. 4. 데이서삭제.");
			System.out.println(" 5. 프로그램 종료. >>메뉴 선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5"))break;
			
			Book_Dao bdao = new Book_Dao();
			switch(choice) {
			case "1" :
				bdao.select();
				break;
			case "2" :
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
				bdto.setSubject(subject);
				bdto.setMakeyear(makeyear);
				bdto.setInprice(inprice);
				bdto.setRentprice(rentprice);
				bdto.setGrade(grade);
				bdao.insert(bdto);	// 각 멤버변수에 데이터를 저장해서 객체로 만들어 객체를 전달인자로 전달한다.
				break;
			case "3" :	
				bdao.update();
				break;
			case "4" :	
				bdao.delete();
				break;
			default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
