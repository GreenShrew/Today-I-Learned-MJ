<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%
request.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement pstmt = null;

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";

String id = request.getParameter("id");
String name = request.getParameter("name");
String pwd = request.getParameter("pwd");
String phone = request.getParameter("phone");
String sql = "update mem set name=?, pwd=?, phone=? where id=?";

try{
	Class.forName(driver);
	con = DriverManager.getConnection(url,"scott","tiger");
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, pwd);
	pstmt.setString(3, phone);
	pstmt.setString(4, id);
	
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