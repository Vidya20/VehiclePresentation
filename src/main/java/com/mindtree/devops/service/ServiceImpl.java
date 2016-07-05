package com.mindtree.devops.service;

import java.util.List;

import com.mindtree.devops.entity.CreateResponse;
import com.mindtree.devops.entity.Employee;
import com.mindtree.devops.entity.Order;
import com.mindtree.devops.exceptions.FetchException;
import com.mindtree.devops.jdbcImpl.DbInterface;
import com.mindtree.devops.jdbcImpl.RestDBImpl;

public class ServiceImpl implements ServiceInterface{
	DbInterface db = new RestDBImpl();
	public CreateResponse createEmployee(Employee employee) throws FetchException {
		// TODO Auto-generated method stub
		return db.createEmployee(employee);
	}

	public CreateResponse createOrder(Order order) throws FetchException {
		// TODO Auto-generated method stub
		return db.createOrder(order);
	}

	public List<Employee> getEmployeeDetails() throws FetchException {
		// TODO Auto-generated method stub
		return db.getEmployeeDetails();
	}

	public List<Order> getOrderDetails() throws FetchException {
		// TODO Auto-generated method stub
		return db.getOrderDetails();
	}

}
