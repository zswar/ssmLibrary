package com.iteasyup.library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.entity.Order;
import com.iteasyup.library.entity.User;
import com.iteasyup.library.service.OrderService;

/**
 * 订单controller
 * 
 * @author dongcheng.liao
 * @since 2020/02/23
 */

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 借阅界面传到订单界面
	 * 
	 * @author dongcheng.liao
	 * @since 2020/02/23
	 */
	@GetMapping("/order")
	public ModelAndView init(Book book
						   , String startDate
						   , String endDate
						   , String days
						   , String state
						   , ModelAndView modelAndView
						   , HttpSession session){
		/**
		 * 取出session里的user
		 */
		Object user = session.getAttribute("user");
		User user2=(User)user;
		
		/**
		 * startDate格式与数据库里的不一样，需要更改
		 */
		System.out.println(startDate);
		
		/**
		 * 将userid等信息装进order对象
		 */
		Order order=new Order(null, startDate, endDate, user2.getId(), book.getId(), state);
		
		/**
		 * 将order装入数据库
		 */
		int createOrder = orderService.createOrder(order);
		
		/**
		 * 把selectkey得到的id装入order
		 */
		order.setId(createOrder);
		
		/**
		 * 把订单界面信息传出
		 */
		modelAndView.setViewName(ViewNameConst.ORDER);
		modelAndView.addObject("order", order)
					.addObject("days",days)
					.addObject("userName",user2.getUserName());
		return modelAndView;
	}
	
	/**
	 * 根据session里的user查询所有订单
	 */
	@PostMapping("/order/center")
	public ModelAndView center(HttpSession session, ModelAndView modelAndView){
		User user=(User)session.getAttribute("user");
		List<Order> orders = orderService.findOrderByUserId(user.getId());
		modelAndView.setViewName(ViewNameConst.ORDERCENTER);
		modelAndView.addObject("orders",orders);
		return modelAndView;
	}
	
}
