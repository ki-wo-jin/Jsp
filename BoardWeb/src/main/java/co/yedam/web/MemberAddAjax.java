package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 4개 -> DB 입력 -> OK 반환
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String auth = req.getParameter("auth");

		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(name);
		mvo.setResponsibility(auth);

		BoardService svc = new BoardServiceImpl();
		if (svc.addMemberAjax(mvo)) { // {"retCode":"OK","retMsg":"Success"}
			resp.getWriter().print("{\"retCode\":\"OK\",\"retMsg\":\"Success\"}");
		} else { // {"retCode":"NG","retMsg":"Fail"}
			resp.getWriter().print("{\"retCode\":\"NG\",\"retMsg\":\"Fail\"}");
		}

	}

}
