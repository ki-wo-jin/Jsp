package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	private DeptService deptService;
	
	@Autowired
	DeptController(DeptService deptService){
		this.deptService = deptService;
	}
	
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		model.addAttribute("depts", list);
		return "dept/list";
	}
	
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}
	
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.deptInsert(deptVO);
		String url = null;
		if(did > -1) {
			url = "redirect:deptInfo?departmentId=" + did;
		} else {
			url = "redirect:deptList";
		}
		return url;
	}
	
	@GetMapping("deptUpdate")
	public String deptUpdateForm(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/update";
	}
	
	
	//@PostMapping("deptUpdate")
	@ResponseBody // AJAX
	public Map<String, Object> deptupdateAJAXQueryString(DeptVO deptVO){
		return deptService.deptUpdate(deptVO); 
	}
	
	// 수정 - 처리 : AJAX => JSON (@RequestBody)
	@PostMapping("deptUpdate")
	@ResponseBody // AJAX
	public Map<String, Object> deptupdateAJAXJSON(@RequestBody DeptVO deptVO){
		return deptService.deptUpdate(deptVO); 
	}
	
	// 삭제 - 처리 : GET
	@GetMapping("deptDelete")
	public String deptDelete(Integer departmentId) {
		deptService.deptDelete(departmentId);
		return "redirect:deptList";
	}
}
