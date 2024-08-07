package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest // 테스트환경에서 IoC 컨테이너를 생성
class Boot01ApplicationTests {
	@Autowired // 필드주입
	private EmpMapper empMapper;
	
	//@Test
	void empList() {
		List<EmpVO> list = empMapper.selectEmpAllList();
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	void empInfo() { //단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals("King", findVO.getLastName());
	}
	
	//@Test
	void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdHong123@google.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(1000);
		
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println(empVO.getEmployeeId());
		
		assertEquals(1, result);
			
	}
	
	//@Test
	public void empDelete() {
		int result = empMapper.deleteEmpInfo(4323);
		assertEquals(1, result);
	}
	
	@Test
	void empUpdate() {
		// -1) 대상 원래 데이터 조회 : 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(4322);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		// -2) 사용자가 수정하는 내용 입력
		findVO.setLastName("Kang");
		
		// -3) UPDATE
		int result = empMapper.updateEmpInfo
				      (findVO.getEmployeeId(), findVO);
		assertEquals(1, result);
	}
	
}
