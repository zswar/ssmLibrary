package com.iteasyup.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order类
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private Integer id;
	
	private String starttime;
	
	private String endtime;
	
	private Integer userid;
	
	private Integer bookid;
	
	private String state;
	
	
}
