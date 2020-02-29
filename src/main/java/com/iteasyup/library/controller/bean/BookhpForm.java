package com.iteasyup.library.controller.bean;

import java.util.List;

import com.iteasyup.library.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookhpForm {
	private int totalPage;
	private int pageNumber;
	private List<Book> subBooks;
	private int sumBook;
}
