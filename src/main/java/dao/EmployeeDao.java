package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelClass.EmployeeModel;

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

	}
