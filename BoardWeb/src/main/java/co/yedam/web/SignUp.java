package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.addMember(id, pw, name)) {
			// 회원가입.
			System.out.println("정상가입...");
			resp.sendRedirect("main.do");
		} else {
			resp.sendRedirect("signUp.do");
			System.out.println("가입 중 오류발생...");
		}
		
		

	}

}
