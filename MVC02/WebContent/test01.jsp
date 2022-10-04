<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> <!-- jsp문서임을 선언하는 '지시자' -->
<%-- jsp 주석 --%>
<%!
	public int hap(int s, int e){
		int sum=0;
		for(int i=s;i<=e;i++){
			sum+=i;
		}
		
		return sum;
	}
%> <!-- jsp에서 자바함수 사용하기 위한 '선언문' -->
<%     
	int sum=0;
	for(int i=1;i<=100;i++){
		sum+=i;
	}
	
	//session, out, config, application, page, pageContext, request, response : jsp의 내장객체( 이미 만들어진 객체 )
	
%> <!-- 자바 코드를 사용하기 위한 '스크립트릿'    -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
55부터 350까지의 총합=<%= hap(55,350) %>  <!-- 자바의 변수를 출력하기 위한 '출력식'  -->
</body>
</html>