package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class BoardForm implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		BoardVO bvo = new BoardVO();
		
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.addBoard(bvo)) {
			resp.sendRedirect("boardList.do");
		} else {
			req.getRequestDispatcher("board/insertBoardForm.tiles").forward(req, resp);
		}
	}
}
