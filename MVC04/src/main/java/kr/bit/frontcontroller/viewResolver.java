package kr.bit.frontcontroller;

public class viewResolver {
	public static String makeView(String nextPage) {
		return "WEB-INF/member/"+nextPage+".jsp";
	}
}
