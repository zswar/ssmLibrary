package com.iteasyup.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.entity.Order;
import com.iteasyup.library.entity.User;
import com.iteasyup.library.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public ModelAndView init(Book book
						   , String startDate
						   , String endDate
						   , String days
						   , String state
						   , ModelAndView modelAndView
						   , HttpSession session){
		Object user = session.getAttribute("user");
		User user2=(User)user;
		
		Order order=new Order(null, startDate, endDate, user2.getId(), book.getId(), state);
		
		int createOrder = orderService.createOrder(order);
		
		/**
		 * 把selectkey得到的id装入order
		 * */
		order.setId(createOrder);
		
		modelAndView.setViewName(ViewNameConst.ORDER);
		modelAndView.addObject("order", order)
					.addObject("days",days)
					.addObject("userName",user2.getUserName());
		return modelAndView;
	}
	
}
