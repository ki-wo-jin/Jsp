package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class RemoveIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BoardService svc = new BoardServiceImpl();
		if(svc.removeMemberId(id)) { // {"retCode": "Exist"}
			resp.getWriter().print("{\"retCode\": \"Delete\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Can not Delete\"}");
			
		} 
	}

}