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

		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardService bvc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		
		
		if (bvc.addBoard(board)) {
			System.out.println("정상삭제...");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("삭제실패");
			req.setAttribute("message", "처리중 오류가 발생");
			req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		}
		
	}

}
