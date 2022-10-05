<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
<%@ page import="java.util.*"%>
<%
// 1. 클라이언트의 요청을 받기(memberList.do)
// 2. 회원 전체 리스트 가져오기 (Model 연동)
MemberDAO dao = new MemberDAO();
ArrayList<MemberVO> list = dao.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteFn(num){
		location.href="memberDelete.jsp?num="+num;
		 
	}
	

</script>
</head>
<body>

	<table border='1'>
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td>삭제</td>
			</tr>
			<% 
			for(MemberVO vo : list) {
				%>
				<tr>
					<td><%=vo.getNum() %></td>
					<td><a href="memberContent.jsp?num=<%=vo.getNum()%>"><%=vo.getId() %></a></td>
					<td><%=vo.getPass() %></td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getAge() %></td>
					<td><%=vo.getEmail() %></td>
					<td><%=vo.getPhone() %></td>
					<td><input type="button" value="삭제" onclick="deleteFn(<%= vo.getNum() %>)" ></td>
				</tr>
			<%}%>
		<tr>
			<td colspan='8' align='right'><input type="button" value="회원가입" onclick="location.href='memberRegister.html'"/> </a></td>
		</tr>
	</table>

</body>
</html>