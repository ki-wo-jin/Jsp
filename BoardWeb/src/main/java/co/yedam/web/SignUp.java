package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일첨부일 경우에는 multipart 요청을 처리
		// Multipart요청 (1.요청정보 2.저장위치 3.최대크기 4.인코딩 5.리네임정책) 
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String name = mr.getParameter("name");
		String img = mr.getFilesystemName("myImage");
		
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(name);
		mvo.setImage(img);
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.addMemberImage(mvo)) {
			// 회원가입.
			System.out.println("정상가입...");
			resp.sendRedirect("memberList.do");
		} else {
			resp.sendRedirect("signUp.do");
			System.out.println("가입 중 오류발생...");
		}
		
		

	}

}
