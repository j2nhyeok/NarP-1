 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="kr.bit.model.*" %>
 <%
 	MemberVO vo=(MemberVO)request.getAttribute("vo");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberUpdate.do" method="post">
<table>
<input type="hidden" name="num" value="<%=vo.getNum()%>"/>
<% if(vo!=null) {%>
	<tr>
		<td colspan="2"><%=vo.getName()%> 회원의 상세보기 </td>
	</tr>
	<tr>
		<td>번호</td>
		<td><%=vo.getNum()%></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=vo.getId()%></td>
	</tr>
	<tr>
		<td>비밀번호</td> 
		<td><%=vo.getPass()%></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=vo.getName()%></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type="text" name="age" value="<%=vo.getAge()%>"/></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" value="<%=vo.getEmail()%>"/></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="phone" value="<%=vo.getPhone()%>"/></td>
	</tr>
	<% } else { %>
	<tr>
		<td>일치하는 회원이 없습니다.</td>
	</tr>
	<% } %>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정하기"/>
			<input type="reset" value="취소"/>
			<input type="button" value="리스트" onclick="location.href='/MVC03/memberList.do'"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>