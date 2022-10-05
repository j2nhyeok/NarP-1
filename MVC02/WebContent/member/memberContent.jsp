 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	int num=Integer.parseInt(request.getParameter("num"));
	
	MemberDAO dao=new MemberDAO();
	MemberVO vo=dao.memberContent(num);
 
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>