package com.iteasyup.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * book类
 * @author dongcheng.liao
 * @since 2020/02/14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private Integer id;
	
	private String bookname;
	
	private String author;
	
	private String publishlocation;
	
	private String publishtime;
	
	private int price;
	
	private Integer typeid;
	
	
}
