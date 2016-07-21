package com.mindtree.devops.jdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import com.mindtree.devops.controller.EmployeeController;
import com.mindtree.devops.entity.CreateResponse;
import com.mindtree.devops.entity.Employee;
import com.mindtree.devops.entity.Order;
import com.mindtree.devops.exceptions.FetchException;
import com.mindtree.devops.util.DBUtil;

@SuppressWarnings("All")
public class RestDBImpl implements DbInterface{
private static final Logger logger = Logger.getLogger(EmployeeController.class);
private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
    /**
     *
     * @param employee
     * @return
     * @throws FetchException
     */
        @Override 
	public CreateResponse createEmployee(Employee employee) throws FetchException {
            
		CreateResponse response = null;
		try{
			con=DBUtil.getConnection();
			logger.info("Inside the createEmployee method");
			String sql ="insert into employee(full_name,age,gender) values(?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, employee.getName());
			stmt.setInt(2, employee.getAge());
			stmt.setString(3, employee.getGender());
			stmt.executeUpdate();
                        response = new CreateResponse();
			response.setMessage("Employee is successfully added");
		} catch (SQLException e) {
			response.setMessage("SQL Internal error occured");
			throw new FetchException("Exception Occured while creating employee !!",e); 
		} catch (Exception ex) {
                    
        java.util.logging.Logger.getLogger(RestDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        logger.error("Unable to establish the JDBC connection",ex);
    }
       return response;
	}

        @Override
	public CreateResponse createOrder(Order order) throws FetchException {
		CreateResponse response = new CreateResponse();
		try{
			con=DBUtil.getConnection();
                        logger.info("Established the database connection");
			String sql ="insert into orders(order_name,description) values(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, order.getOrderName());
			stmt.setString(2, order.getDescription());
			stmt.executeUpdate();
			response.setMessage("Order done successfully");
                       
		} catch (SQLException e) {
                   response.setMessage("Internal error occured");
                    throw new FetchException("Exception Occured while creating order!!",e);
		} catch (Exception ex) {
                    java.util.logging.Logger.getLogger(RestDBImpl.class.getName()).log(Level.SEVERE, null, ex);
                    logger.error("Unable to establish the JDBC connection",ex);
                }
                return response;
	}
        
        @Override
	public List<Employee> getEmployeeDetails() throws FetchException {
		List<Employee> result = new ArrayList<>();
		try(Connection con=DBUtil.getConnection();){
			String sql ="SELECT full_name,age,gender FROM employee";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Employee employee = new Employee();
				employee.setName(rs.getString("full_name"));
				employee.setAge(rs.getInt("age"));
				employee.setGender(rs.getString("gender"));
				result.add(employee);
			}
		} catch (SQLException e) {
                    throw new FetchException("Exception Occured while fetching employee details!!",e);
			
		} catch (Exception ex) {
        java.util.logging.Logger.getLogger(RestDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        logger.error("Unable to establish the JDBC connection",ex);
    }
		return result;
	}

        @Override
	public List<Order> getOrderDetails() throws FetchException {
		List<Order> result = new ArrayList<>();
		try {
			 con=DBUtil.getConnection();
			String sql ="SELECT order_name,description FROM orders";
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setOrderName(rs.getString("order_name"));
                                order.setDescription(rs.getString("description"));
				result.add(order);
			}
		} catch (SQLException e) {
                     throw new FetchException("Exception Occured while fetching employee details!!",e);
			
		} catch (Exception ex) {
        java.util.logging.Logger.getLogger(RestDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        logger.error("Unable to establish the JDBC connection", ex);
    }
		return result;
	}

}
