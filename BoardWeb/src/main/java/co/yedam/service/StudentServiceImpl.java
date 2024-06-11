package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class StudentServiceImpl implements StudentService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		return mapper.selectStudent();
	}

	@Override
	public boolean addStudent(Student std) {
		// TODO Auto-generated method stub
		return mapper.insertStudent(std) == 1;
	}

	@Override
	public boolean modifyStudent(Student std) {
		// TODO Auto-generated method stub
		return mapper.updateStudent(std) == 1;
	}

}
