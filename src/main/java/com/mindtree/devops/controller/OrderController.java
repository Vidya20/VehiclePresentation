package com.mindtree.devops.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.devops.entity.CreateResponse;
import com.mindtree.devops.entity.Employee;
import com.mindtree.devops.entity.Order;
import com.mindtree.devops.exceptions.FetchException;
import com.mindtree.devops.service.ServiceImpl;
import com.mindtree.devops.service.ServiceInterface;
import com.wordnik.swagger.annotations.Api;

@RestController
@Api("Order")
@RequestMapping("/Order")
public class OrderController {
	ServiceInterface service = new ServiceImpl();
	
	@POST
	@RequestMapping(value="/insertOrder",method = RequestMethod.POST) 
	public CreateResponse createOrder(@RequestBody Order order) {
		CreateResponse response = new CreateResponse();
		try {
		response = service.createOrder(order);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return response;
		
	}

	@Produces("application/json")
	@RequestMapping(value="/getOrder",method = RequestMethod.GET)
	public List<Order> getOrdersDetails(){
		List<Order> listOrder=new ArrayList<Order>();
		try {
			listOrder= service.getOrderDetails();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOrder;
	}

}
