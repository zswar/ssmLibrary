package com.iteasyup.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteasyup.library.dao.OrderDao;
import com.iteasyup.library.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	public int createOrder(Order order){
		
		int result = orderDao.insert(order);
		return result;
	}
	
}
