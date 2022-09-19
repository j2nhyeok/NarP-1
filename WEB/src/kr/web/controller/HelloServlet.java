package kr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.web.util.MyUtil;
// JavaEE -> Servlet(서블릿)의 골격

@WebServlet("/hs.do") // <- web.xml
public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1~100까지 총 합이 얼마냐?
		 MyUtil my = new MyUtil();
		 int sum = my.hap();
		 
		 //요청한 클라이언트에게 응답하기
		 PrintWriter out = resp.getWriter(); // 출력스트림
		 out.println("<html>");
		 out.println("<body>");
		 out.println(sum);
		 out.println("</body>");
		 out.println("</html>");
	}
}
