<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %> <!-- jsp에서 import -->
<%
	MyCalc c = new MyCalc();
	int v = c.hap(1,300);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>1부터 300까지의 총합</td>
		<td><%=v%></td>
	</tr>
</table>
</body>
</html>