<!-- 이  jsp는 Controller용 jsp 이므로 html 코드가 필요없다  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
<%
	// 파라메터 수집 (VO)
	request.setCharacterEncoding("UTF-8");
	// 1. 파라메터 수집(VO)
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
	
	//Model과 연동부분
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberInsert(vo);
	if(cnt > 0) {
		// 가입성공
		// 다시 회원리스트 보기로 가야된다.(/MVC01/memberList.do)
		response.sendRedirect("memberList.jsp");
	} else {
		// 가입실패-> 예외객체를 만들어서 WAS에게 던지자.
		throw new ServletException("not insert");
	}
%>
