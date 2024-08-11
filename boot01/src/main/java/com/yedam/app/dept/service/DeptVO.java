package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private Integer departmentId;
	private String  departmentName;
	private Integer managerId;
	private Integer locationId;
}
