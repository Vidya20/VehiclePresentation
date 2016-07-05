package com.mindtree.devops.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.devops.entity.CreateResponse;
import com.mindtree.devops.entity.Employee;
import com.mindtree.devops.exceptions.FetchException;
import com.mindtree.devops.service.ServiceImpl;
import com.mindtree.devops.service.ServiceInterface;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@RestController
@Api("Employee")
@RequestMapping("/Employee")
public class EmployeeController {
	ServiceInterface service = new ServiceImpl();
	
	@POST
	@ApiOperation(value="Insert employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/insertEmployee",method = RequestMethod.POST) 
	public CreateResponse createEmployee(@RequestBody Employee employee) {
		CreateResponse response = new CreateResponse();
		try {
			response=service.createEmployee(employee);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return response;	
	}
	
	@GET
	@Produces("application/json")
	@RequestMapping(value="/getEmployee",method = RequestMethod.GET)
	public List<Employee> getEmployeeDetails(){
		List<Employee> listEmployee=new ArrayList<Employee>();
		try {
			listEmployee= service.getEmployeeDetails();
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return listEmployee;
	}
}
