package EmployeeServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelClass.EmployeeModel;
import dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeDataServlet
 */
@WebServlet("/EmployeeDataServlet")
public class EmployeeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		long employeeId = (long) request.getAttribute("employeeId");

        // Retrieve employee data
        EmployeeDao dao = new EmployeeDao();
        EmployeeModel employeeData = dao.EmployeeData(employeeId);

        // Set the employee data in the request
        request.setAttribute("employeeData", employeeData);

        // Forward to EmployeeHome.jsp
        request.getRequestDispatcher("EmployeeHome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
