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

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
		// 핸들러매핑 -> HandlerMapping
		HandlerMapping mapping=new  HandlerMapping();
		controller=mapping.getController(command);
		nextPage=controller.requestHandler(request, response);
		// forward, redirect
		if(nextPage!=null) {
			if(nextPage.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextPage.split(":")[1]);  // redirect
			}else {
				RequestDispatcher rd=request.getRequestDispatcher(viewResolver.makeView(nextPage)); // forward
				rd.forward(request, response);
			}
		}
	}

}
