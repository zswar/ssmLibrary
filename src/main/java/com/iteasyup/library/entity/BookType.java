package com.iteasyup.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * booktype类
 * @author dongcheng.liao
 * @since 2020/02/14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookType {
	
	private Integer id;
	
	private String typeName;
	
}
