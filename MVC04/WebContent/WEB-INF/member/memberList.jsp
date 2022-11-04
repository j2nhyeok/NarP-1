<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="ctx" value="${pageContext.request.contextPath}"
<%
	//ArrayList<MemberVO> list=(ArrayList<MemberVO>)request.getAttribute("list"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteFn(num){
		location.href="memberDelete.do?num="+num;
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
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.num }</td>
					<td><a href="memberContent.do?num=${vo.num }">${vo.id}</a></td>
					<td>${vo.pass}</td>
					<td>${vo.name}</td>
					<td>${vo.age}</td>
					<td>${vo.email}</td>
					<td>${vo.phone}</td>
					<td><input type="button" value="삭제" onclick="deleteFn(${vo.num })" ></td>
				</tr>
			</c:forEach>
		<tr>
			<td colspan='8' align='right'><input type="button" value="회원가입" onclick="location.href='${ctx}/memberRegister.do'"/> </a></td>
		</tr>
	</table>

</body>
</html>