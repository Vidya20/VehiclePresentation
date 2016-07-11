package com.mindtree.devops.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

import com.mindtree.devops.controller.EmployeeController;

public final class DBUtil implements AutoCloseable{
    private static final Logger logger = Logger.getLogger(EmployeeController.class);
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://13.76.132.236:3306/emporderdb";
    private static final String USER = "root";
    private static final String PWD = "welcome123";

    
    /**
     * private default constructor to prevent instantiation of utility class
     */
    public DBUtil() {
    }

    static {
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			logger.error("Unable to find the driver class",e);
		}
    }
     
    /**
     * 
     * @return database connection
     * 
     */
    public static Connection getConnection(){
        Connection con;
        con = null;
        try {
			con=DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e)
                {
                        logger.error("Connection refused ",e);
		}
        return con;
    }

    /**
     * 
     * @param ps
     * statement to release
     */
    public static void releaseResource(Statement ps)  {
    	if(ps !=null){
    		try{
    			ps.close();
    		}catch (SQLException e) {
				logger.error("Cannot close PreparedStatement", e);
			}
    	}
    }

    /**
     * 
     * @param con
     * connection to release
     */
    public static void releaseResource(Connection con)  {
    	if(con != null) {
    		try {
				con.close();
			} catch (SQLException e) {
				logger.error("Cannot Release Connection", e);
			}
    	}
    }

    /**
     * 
     * @param rs
     */
    public static void releaseResource(ResultSet rs)  {
    	if(rs!=null){
    		try{
    			rs.close();
    		}catch (SQLException e) {
				logger.error("Cannot close resultset", e);
			}
    	}
    }

    @Override
    public void close() throws Exception {
        throw new Exception("Unable to close the database Connection");
   
    }
}
