package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

/*
 * 업무프로세스를 따라 실행하기 위한 서비스
 */
public class BoardServiceImpl implements BoardService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList(SearchVO search) {
		// mapper등록된 기능 활용
		return mapper.boardListPaging(search);
	}

	@Override
	public int boardTotal(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.getTotalCnt(search);
	}
	
	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(bvo)==1;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(bvo)==1;
	}

	@Override
	public boolean removeBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(bno)==1;
	}

	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	@Override
	public boolean addMember(String id, String pw, String name) {
		return mapper.insertMember(id, pw, name) == 1;
	}

	@Override
	public List<MemberVO> memberList() {
		return mapper.memberList();
	}

	@Override
	public boolean addMemberAjax(MemberVO mvo) {
		return mapper.insertMemberAjax(mvo) == 1;
	}

	@Override
	public boolean checkMemberId(String id) {
		return mapper.selectMemberAjax(id) == 1;
	}

	@Override
	public boolean removeMemberId(String id) {
		return mapper.deleteMemberAjax(id) == 1;
	}

	@Override
	public boolean editMemberId(MemberVO mvo) {
		return mapper.updateMemberAjax(mvo) == 1;
	}
	

	
}
