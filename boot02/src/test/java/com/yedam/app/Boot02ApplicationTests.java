package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;


@SpringBootTest
class Boot02ApplicationTests {

	@Autowired // 필드주입
	private BoardMapper boardMapper;
	
	@Test // 전체조회
	void boardList() {
		List<BoardVO> list = boardMapper.selectBoardAll();
		assertTrue(!list.isEmpty());
	}
	
	@Test // 단건조회
	void boardInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(100);
		
		BoardVO findVO = boardMapper.selectBoardInfo(boardVO);
		assertEquals("First Test", findVO.getTitle());
	}
	
	//@Test // 등록
	void boardInsert() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("ABC");
		boardVO.setContents("TEST");
		boardVO.setWriter("TEST");
		boardVO.setRegdate(null);
		
		int result = boardMapper.insertBoardInfo(boardVO);
		System.out.println(boardVO.getBno());
		
		assertEquals(1, result);
	}
	
	@Test // 수정
	void boardUpdate() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(101);
		
		BoardVO findVO = boardMapper.selectBoardInfo(boardVO);

		findVO.setTitle("def");
		int result = boardMapper.updateBoardInfo(findVO);
		assertEquals(1, result);
		
	}
	
	//@Test // 삭제
	void boardDelete() {
		int result = boardMapper.deleteBoardInfo(101);
		assertEquals(1, result);
	}
}
