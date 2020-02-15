package com.iteasyup.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order类
 * @author dongcheng.liao
 * @since 2020/02/14 
 */

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
