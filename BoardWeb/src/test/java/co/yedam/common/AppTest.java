package co.yedam.common;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.BoardMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		
		System.out.println(svc.getBoard(100));
		
		SearchVO search = new SearchVO(1, "T", "javascript");
		
		mapper.boardListPaging(search).forEach(bvo -> System.out.println(bvo));
		
	}
}

