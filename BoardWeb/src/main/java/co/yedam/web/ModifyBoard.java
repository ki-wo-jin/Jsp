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

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String paging = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		// editBoard메소드의 매개값
		BoardService svc = new BoardServiceImpl();

		BoardVO bvo = new BoardVO();
		bvo.setBoardNo(Integer.parseInt(bno));
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		if(svc.editBoard(bvo)) {
			System.out.println("정상수정...");
			resp.sendRedirect("boardList.do?page=" + paging + "&searchCondition=" + sc + "&keyword=" + kw);
		} else {
			req.getRequestDispatcher("board/modifyBoardForm.tiles").forward(req, resp);
		}
	}
}