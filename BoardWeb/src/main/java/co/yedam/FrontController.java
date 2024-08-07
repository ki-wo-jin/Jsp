package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddForm;
import co.yedam.web.AddReply;
import co.yedam.web.AddStudent;
import co.yedam.web.AjaxForm;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.CenterChart;
import co.yedam.web.CenterInfo;
import co.yedam.web.ChartForm;
import co.yedam.web.CheckIdAjax;
import co.yedam.web.EditIdAjax;
import co.yedam.web.GetBoard;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.MapForm;
import co.yedam.web.MemberAddAjax;
import co.yedam.web.MemberAjax;
import co.yedam.web.MemberList;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.PublicData;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveForm;
import co.yedam.web.RemoveIdAjax;
import co.yedam.web.RemoveReply;
import co.yedam.web.ReplyList;
import co.yedam.web.ScriptForm;
import co.yedam.web.SignUp;
import co.yedam.web.SignUpForm;
import co.yedam.web.StudentForm;
import co.yedam.web.TotalCnt;

// front -> 요청url(*.do) - 실행컨트롤 매칭
// main.do -> FrontController -> /WEB-INF/public/main.jsp
// 객체생성 -> init -> service -> destroy


public class FrontController extends HttpServlet {
	private Map<String, Control> map; // key: url, value: control
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do",new ProductControl());
//		map.put("/board.do","게시판페이지입니다");
		//학생등록화면 studentForm.do
		map.put("/studentForm.do" , new StudentForm()); // 등록화면
		map.put("/addStudent.do", new AddStudent()); // 정보db에 저장
		
		// 게시글목록
		map.put("/boardList.do", new BoardList());
		map.put("/getBoard.do", new GetBoard());
		
		// 게시글등록
		map.put("/boardForm.do", new BoardForm());
		map.put("/addForm.do", new AddForm());
		
		// 게시글삭제
		map.put("/removeForm.do", new RemoveForm());
		map.put("/removeBoard.do", new RemoveBoard());
		
		// 게시글수정
		map.put("/modifyForm.do", new ModifyForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		
		// 로그인화면
		map.put("/loginForm.do", new LoginForm());
		// 로그인기능
		map.put("/login.do", new LoginControl());
		// 로그아웃
		map.put("/logout.do", new LogoutControl());
		
		//회원가입화면
		map.put("/signUpForm.do", new SignUpForm());
		//회원가입기능
		map.put("/signUp.do", new SignUp());
		
		// 회원목록
		map.put("/memberList.do", new MemberList());
		
		// 자바스크립트
		map.put("/script.do", new ScriptForm());
		
		// ajax 연습
		map.put("/ajax.do", new AjaxForm());
		map.put("/membersAjax.do", new MemberAjax());
		map.put("/addAjax.do", new MemberAddAjax());
		map.put("/checkIdAjax.do", new CheckIdAjax());
		map.put("/removeIdAjax.do", new RemoveIdAjax());
		map.put("/editIdAjax.do", new EditIdAjax());
		
		// 댓글관련
		map.put("/replyListJson.do", new ReplyList());
		map.put("/removeReply.do", new RemoveReply());
		map.put("/addReply.do", new AddReply());
		// 댓글전체건수
		map.put("/replyTotalCnt.do", new TotalCnt());
		map.put("/publicData.do", new PublicData());
		
		// map api 호출
		map.put("/map.do", new MapForm());
		
		// json 문자열 db insert
		map.put("/centerInfo.do", new CenterInfo());
		
		// 센터차트
		map.put("/chartForm.do", new ChartForm());
		map.put("/centerChart.do", new CenterChart());
		
	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost/BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb => project name 추출
		String page = uri.substring(context.length()); // /main.do 추출
		
	    Control result = map.get(page);
		result.exec(req, resp);
	}
	
}
