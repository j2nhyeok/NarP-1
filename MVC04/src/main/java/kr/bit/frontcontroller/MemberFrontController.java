package kr.bit.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트가 어떤 요청을 했는지 파악하기
		String url=request.getRequestURI();
		
		String ctx=request.getContextPath(); //context경로
		
		
		// 실제로 요청한 명령
		String command=url.substring(ctx.length());
		System.out.println(command); //memberInsert.do
		// 요청에 따른 분기작업
		if(command.equals("/memberList.do")) { // 회원 리스트 보기
			MemberDAO dao=new MemberDAO();
			List<MemberVO> list=dao.memberList();
			
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
				
		}else if(command.equals("/memberInsert.do")) { // 회원가입
			
		}else if(command.equals("/memberRegister.do")) { // 회원가입 화면
			
		}else if(command.equals("/memberContent.do")) {
			
		}else if(command.equals("/memberUpdate.do")) {
			
		}else if(command.equals("/memberDelete.do")) {
			
		}// if_ end
	}

}
