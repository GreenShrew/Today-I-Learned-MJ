<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
// addMember_do.jsp
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "scott";
String pass = "tiger";

String sql = "insert into mem(id, name, pwd, phone) values(?,?,?,?)";

String name = request.getParameter("name");
String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
String phone = request.getParameter("phone");
// DB 연결하고 insert 준비 완료

// try catch 구문을 JDBC에서 사용했던 것처럼 레코드를 추가하자.
try{
	Class.forName(driver);
	con = DriverManager.getConnection(url,uid,pass);

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, userid);
	pstmt.setString(3, pwd);
	pstmt.setString(4, phone);
	
	pstmt.executeUpdate();
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}

response.sendRedirect("MemberMGR.jsp");
%>