package AuthenticationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModelClass.EmployeeModel;
import dao.EmployeeDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		// TODO Auto-generated method stub
		EmployeeModel employeelogindata=new EmployeeModel();
		employeelogindata.setEmployeeId(Long.parseLong(request.getParameter("User-id")));
		employeelogindata.setEmployeePassword(request.getParameter("User-password"));
		EmployeeDao dao=new EmployeeDao();
		long employeeid=Long.parseLong(request.getParameter("User-id"));
		if(dao.EmployeeLogin(employeelogindata))
		{
			request.setAttribute("employeeId", employeeid);
//			request.getRequestDispatcher("EmployeeHome.jsp").forward(request, response);
			request.getRequestDispatcher("/EmployeeDataServlet").forward(request, response);
		}
//		else if(dao.librarian(loginData))
//		{
//			request.getRequestDispatcher("librarian.jsp").forward(request, response);
//		}
		else
		{
			request.setAttribute("invalidmessage","userID or Password are incorrect");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
