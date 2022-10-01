package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.memberContent(num);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		if(vo!=null) {
			out.println("<tr>");
			out.println("<td>번호</td>");
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>아이디</td>");
			out.println("<td>"+vo.getId()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>비밀번호</td>");
			out.println("<td>"+vo.getPass()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이름</td>");
			out.println("<td>"+vo.getName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>나이</td>");
			out.println("<td><input type='text' name='age' value='"+vo.getAge()+"'/> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이메일</td>");
			out.println("<td><input type='text' name='age' value='"+vo.getEmail()+"'/> </td>");
			out.println("</tr>");
			out.println("<td>전화번호</td>");
			out.println("<td><input type='text' name='age' value='"+vo.getPhone()+"'/> </td>");
			out.println("</tr>");
		}else {
			out.println("<tr>");
			out.println("<td>일치하는 번호 없다 </td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
