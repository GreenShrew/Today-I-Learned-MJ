package jdbc03;

// Dto : Data Transfer Object 다른 말로 JAVA Bean. 다수의 자료를 객체에 한번에 담아서 한번에 전송하기 위해 만들어진 클래스, 객체
// 이 클래스가 없었다면 Book_Driver과 Book_Dao의 매개변수/전달인자에 내용을 100개든 1000개든 일일히 다 넣고 있어야 한다.
public class Book_Dto {
	// 외부에서 함부로 수정할 수 없도록 private를 설정하고, getter/setter를 만든다.
	private int num;
	private String subject;
	private int makeyear;
	private int inprice;
	private int rentprice;
	private String grade;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMakeyear() {
		return makeyear;
	}
	public void setMakeyear(int makeyear) {
		this.makeyear = makeyear;
	}
	public int getInprice() {
		return inprice;
	}
	public void setInprice(int inprice) {
		this.inprice = inprice;
	}
	public int getRentprice() {
		return rentprice;
	}
	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
