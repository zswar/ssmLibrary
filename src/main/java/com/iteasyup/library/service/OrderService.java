package com.iteasyup.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteasyup.library.dao.OrderDao;
import com.iteasyup.library.entity.Order;

/**
 * 订单service
 * 
 * @author dongcheng.liao
 * @since 2020/02/14
 */

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	public int createOrder(Order order){
		
		int result = orderDao.insert(order);
		return result;
	}
	
	public List<Order> findOrderByUserId(Integer userId){
		List<Order> selectByUserId = orderDao.selectByUserId(userId);
		return selectByUserId;
	}
	
}
