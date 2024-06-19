package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class EditIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pw = req.getParameter("pass");
		
		BoardService svc = new BoardServiceImpl();
		if(svc.checkMemberId(id)) { // {"retCode": "Exist"}
			resp.getWriter().print("{\"retCode\": \"Exist\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Not Exist\"}");
			
		} 
	}

}
