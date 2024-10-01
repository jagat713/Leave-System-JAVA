package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelClass.EmployeeModel;
import ModelClass.LeavesModel;

public class EmployeeDao {
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://@localhost:3306/jleave","root","jagat@6370");
	}
	public boolean EmployeeLogin(EmployeeModel employee)
	{
		Boolean loginstate=false;
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try
		{
			con=EmployeeDao.getConnection();
			st=con.prepareStatement("select employee_id,employee_password from employee_details where employee_id=?;");
			st.setLong(1, employee.getEmployeeId());
			rs=st.executeQuery();
			if(rs.next())
			{
			    String Password = rs.getString("employee_password");
			    if (Password.equals(employee.getEmployeePassword())) {
			        loginstate = true;
			    }
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return loginstate;
	}
	
	//to fetch employee data
	public EmployeeModel EmployeeData(long employeeid) {
	    EmployeeModel EmployeeData = null;
	    Connection con = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    long id = employeeid;
	    try {
	        con = EmployeeDao.getConnection();
	        st = con.prepareStatement("SELECT * FROM employee_details WHERE employee_id=?;");
	        st.setLong(1, id);
	        rs = st.executeQuery();
	        if (rs.next()) {
	            EmployeeData = new EmployeeModel();
	            EmployeeData.setEmployeeId(rs.getLong("employee_id"));
	            EmployeeData.setEmployeeName(rs.getString("employee_name"));
	            EmployeeData.setEmployeePassword(rs.getString("employee_password"));
	            EmployeeData.setEmployeeLeaveBalance(rs.getInt("employee_leave_balance"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	    finally {
	        try {
	            if (con != null) con.close();
	            if (st != null) st.close();
	            if (rs != null) rs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return EmployeeData;
	}
	
	public boolean LeaveApplicationSubmitStatus(LeavesModel leave, EmployeeModel employee) {
	    boolean Status = false;
	    Connection con = null;
	    PreparedStatement st = null;
	    
	    try {
	        System.out.println("Leave Type in DAO: " + leave.getLeaveType());
	        System.out.println("Employee Name in DAO: " + employee.getEmployeeName()); // Check here
	        System.out.println("Employee ID in DAO: " + employee.getEmployeeId()); // Check here
	        
	        con = EmployeeDao.getConnection();
	        st = con.prepareStatement("INSERT INTO leave_details (leave_type, leave_start_date, leave_end_date, leave_reason, employee_id, employee_name) VALUES (?, ?, ?, ?, ?, ?);");
	        
	        // Use leave and employee data correctly
	        st.setString(1, leave.getLeaveType());
	        st.setString(2, leave.getStartDate());
	        st.setString(3, leave.getEndDate());
	        st.setString(4, leave.getLeaveReason());
	        st.setLong(5, employee.getEmployeeId()); // Make sure this is correct
	        st.setString(6, employee.getEmployeeName()); // This should also have data
	        
	        // Execute the update
	        int rowsAffected = st.executeUpdate();
	        Status = rowsAffected > 0; // If rows were affected, set status to true
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (st != null) st.close();
	            if (con != null) con.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return Status;
	}


	}
