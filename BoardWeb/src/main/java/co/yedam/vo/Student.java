package co.yedam.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data

public class Student {
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;
	

}
