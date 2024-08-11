package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@RestController

public class DeptRestController {
	private DeptService deptService;
	
	@Autowired
	DeptRestController(DeptService deptService){
		this.deptService = deptService;
	}
	
	@GetMapping("depts")
	public List<DeptVO> deptList(){
		return deptService.deptList();
	}
	
	@PutMapping("emps/{departmentId}")
	public Map<String, Object>
		deptUpdate(@PathVariable Integer departmentId,
				   @RequestBody DeptVO deptVO) {
		deptVO.setDepartmentId(departmentId);
		return deptService.deptUpdate(deptVO);
	}
	
	@DeleteMapping("depts/{departmentId}")
	public Map<String, Object> deptDelete(@PathVariable Integer departmentId){
		return deptService.deptDelete(departmentId);
	}
	
}
