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
	
	private String startTime;
	
	private String endTime;
	
	private Integer userId;
	
	private Integer bookId;
	
	private String state;
	
	
}
