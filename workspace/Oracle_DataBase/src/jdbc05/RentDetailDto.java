package jdbc05;

public class RentDetailDto {
	private String rentdate;
	private int rentnumber;
	private int membernumber;
	private String membername;
	private int rentprice2;
	private int booknumber;
	private String subject;
	
	public String getRentdate() {
		return rentdate;
	}
	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}
	public int getRentnumber() {
		return rentnumber;
	}
	public void setRentnumber(int rentnumber) {
		this.rentnumber = rentnumber;
	}
	public int getMembernumber() {
		return membernumber;
	}
	public void setMembernumber(int membernumber) {
		this.membernumber = membernumber;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public int getRentprice2() {
		return rentprice2;
	}
	public void setRentprice2(int rentprice2) {
		this.rentprice2 = rentprice2;
	}
	public int getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
