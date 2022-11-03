package kr.bit.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.controller.Controller;
import kr.bit.controller.MemberContentController;
import kr.bit.controller.MemberDeleteController;
import kr.bit.controller.MemberInsertController;
import kr.bit.controller.MemberListController;
import kr.bit.controller.MemberRegisterController;
import kr.bit.controller.MemberUpdateController;
import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		// 클라이언트가 어떤 요청을 했는지 파악하기
		String url=request.getRequestURI();
		
		String ctx=request.getContextPath(); //context경로
		
		
		// 실제로 요청한 명령
		String command=url.substring(ctx.length());
		System.out.println(command); //memberInsert.do
		// 요청에 따른 분기작업
		// POJO를 연결
		Controller controller=null;
		String nextPage=null;
		if(command.equals("/memberList.do")) { // 회원 리스트 보기 
		    controller=new MemberListController();
		    nextPage=controller.requestHandler(request, response);
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if(command.equals("/memberInsert.do")) { // 회원가입
			controller=new MemberInsertController();
			nextPage=controller.requestHandler(request, response);
			response.sendRedirect(nextPage); 
		}else if(command.equals("/memberRegister.do")) { // 회원가입 화면
			controller=new MemberRegisterController();
			nextPage=controller.requestHandler(request, response);
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if(command.equals("/memberContent.do")) {
			controller=new MemberContentController();
			nextPage=controller.requestHandler(request, response);
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if(command.equals("/memberUpdate.do")) {
			controller=new MemberUpdateController();
			nextPage=controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
		}else if(command.equals("/memberDelete.do")) {
			controller=new MemberDeleteController();
			nextPage=controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
		}// if_ end
	}

}
