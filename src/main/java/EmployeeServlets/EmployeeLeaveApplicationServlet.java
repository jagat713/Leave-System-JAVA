package EmployeeServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelClass.EmployeeModel;
import ModelClass.LeavesModel;
import dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeLeaveApplicationServlet
 */
@WebServlet("/EmployeeLeaveApplicationServlet")
public class EmployeeLeaveApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLeaveApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    LeavesModel leave = new LeavesModel();
	    EmployeeModel employeeData = new EmployeeModel();
	    
	    // Retrieve parameters from the request
	    leave.setLeaveType(request.getParameter("leaveType"));
	    leave.setStartDate(request.getParameter("fromDate"));
	    leave.setEndDate(request.getParameter("toDate"));
	    leave.setLeaveReason(request.getParameter("reason"));
	    
	    // Retrieve employee ID and name
	    String employeeIdParam = request.getParameter("employeeId");
	    String employeeNameParam = request.getParameter("employeeName");
	    int employeeLeavebalance=Integer.parseInt(request.getParameter("employeeLeaveBalance"));

	    if (employeeIdParam != null && employeeNameParam != null) {
	        employeeData.setEmployeeId(Long.parseLong(employeeIdParam));
	        employeeData.setEmployeeName(employeeNameParam);
	        employeeData.setEmployeeLeaveBalance(employeeLeavebalance);
	    } else {
	        System.out.println("Employee ID or Name is null");
	        // Handle the error (e.g., set an error message)
	    }

	    // Debugging prints
	    System.out.println("Leave Type: " + leave.getLeaveType());
	    System.out.println("Employee ID: " + employeeData.getEmployeeId());
	    System.out.println("Employee Name: " + employeeData.getEmployeeName());

	    EmployeeDao employeeDao = new EmployeeDao();
	    
	    // Pass both leave and employee data to the DAO
	    if (employeeDao.LeaveApplicationSubmitStatus(leave, employeeData)) {
	        request.setAttribute("message", "Leave application submitted successfully.");
	    } else {
	        request.setAttribute("message", "Leave application was unsuccessful.");
	    }

	    // Set the employee data back to request attributes
	    request.setAttribute("employeeData", employeeData);

	    // Forward the request back to the employee dashboard
	    request.getRequestDispatcher("EmployeeHome.jsp").forward(request, response);
	}

}
