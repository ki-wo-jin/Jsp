package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.StudentService;
import co.yedam.service.StudentServiceImpl;
import co.yedam.vo.Student;

public class AddStudent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("sno");
		String name = req.getParameter("sname");
		String phone = req.getParameter("phone");
		String btype = req.getParameter("btype");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		StudentService svc = new StudentServiceImpl();
		
		Student student = new Student();
		
		student.setStdNo(no);
		student.setStdName(name);
		student.setPhone(phone);
		student.setBldType(btype);
		
		if (svc.addStudent(student)) {
//			sqlSession.commit();
			System.out.println("정상등록...");
			resp.sendRedirect("main.do");
		} else {
			System.out.println("등록실패");
			req.setAttribute("message", "처리중 오류가 발생");
			req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);
		}

	}

}
