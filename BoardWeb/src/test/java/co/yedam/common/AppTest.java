package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory =  DataSource.getInstance(); 
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		
		// interface - 구현객체
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		
		Student std = new Student();
		// insert
//		std.setStdNo("S0006");
//		std.setStdName("김영식");
//		std.setPhone("010-9876-5432");
//		std.setBldType("O");
//
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent",std);
//		sqlSession.commit();
		
		// update
		std.setPhone("010-7777-7777");
		std.setStdNo("S0006");
		
		mapper.updateStudent(std);
		sqlSession.commit();
		
		// select
		List<Student> list  // = sqlSession.selectList("co.yedam.mapper.StudentMapper.selectStudent");
							= mapper.selectStudent();
		for (Student std1 : list) {
			System.out.println(std1.toString());
		}
	}
}
