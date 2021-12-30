<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberMGR</title>
<%!
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	
	String sql = "select * from mem";
%>
</head>
<body>
<table width="800" border="1">
	<tr><th>이름</th><th>아이디</th><th>암호</th><th>전화번호</th><th>수정</th><th>삭제</th></tr>
	<%
		try{	// 얘는 자동으로 try~ catch~ 문구를 만들어주지 않는다..
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pass);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while(rs.next()){		// while문의 1회 반복 실행을 1행 출력과 같도록 구성한다.
					out.println("<tr>");

					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("<td>" + rs.getString("id") + "</td>");
					out.println("<td>" + rs.getString("pwd") + "</td>");
					out.println("<td>" + rs.getString("phone") + "</td>");
					out.println("<td><a href='updateMemberForm.jsp?userid=" + rs.getString("id") + "'>수정</a></td>");
					out.println("<td><a href='deleteMember.jsp?userid=" + rs.getString("id") + "'>삭제</a></td>");	// 여기는 삭제 버튼의 자리
					// id를 건내줘야 삭제할 멤버가 누구인지 특정지을 수 있다.
					// while이 반복될 때 마다 각기 다른 

					out.println("</tr>");
				}
		} catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</table>
<a href="addMemberForm.jsp">멤버 추가</a>


</body>
</html>











