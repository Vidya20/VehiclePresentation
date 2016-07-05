package com.mindtree.devops.service;

import java.util.List;

import com.mindtree.devops.entity.CreateResponse;
import com.mindtree.devops.entity.Employee;
import com.mindtree.devops.entity.Order;
import com.mindtree.devops.exceptions.FetchException;

public interface ServiceInterface {
	public CreateResponse createEmployee(Employee employee)throws FetchException;
	public CreateResponse createOrder(Order order)throws FetchException;
	public List<Employee> getEmployeeDetails()throws FetchException;
	public List<Order> getOrderDetails()throws FetchException;

}
