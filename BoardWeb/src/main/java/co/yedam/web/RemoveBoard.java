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

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String no = req.getParameter("bno");
		String paging = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		
		BoardService bvc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		
		board.setBoardNo(Integer.parseInt(no));
		
		if (bvc.removeBoard(Integer.parseInt(no))) {
			System.out.println("정상삭제...");
			System.out.println(sc);
			System.out.println(kw);
			resp.sendRedirect("boardList.do?page=" + paging + "&searchCondition=" + sc + "&keyword=" + kw);
		} else {
			System.out.println("삭제실패");
			req.setAttribute("message", "처리중 오류가 발생");
			req.getRequestDispatcher("board/boardForm.tiles").forward(req, resp);
		}
		
	}

}
