package ModelClass;

public class EmployeeModel {
	private long EmployeeId;
	private String EmployeeName;
	private String EmployeeMail;
	private String EmployeePassword;
	private int EmployeeLeaveBalance;
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeModel(long employeeId, String employeeName, String employeeMail, String employeePassword,
			int employeeLeaveBalance) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		EmployeeMail = employeeMail;
		EmployeePassword = employeePassword;
		EmployeeLeaveBalance = employeeLeaveBalance;
	}
	public long getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(long employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeeMail() {
		return EmployeeMail;
	}
	public void setEmployeeMail(String employeeMail) {
		EmployeeMail = employeeMail;
	}
	public String getEmployeePassword() {
		return EmployeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}
	public int getEmployeeLeaveBalance() {
		return EmployeeLeaveBalance;
	}
	public void setEmployeeLeaveBalance(int i) {
		EmployeeLeaveBalance = i;
	}
	@Override
	public String toString() {
		return "EmployeeModel [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeMail="
				+ EmployeeMail + ", EmployeePassword=" + EmployeePassword + ", EmployeeLeaveBalance="
				+ EmployeeLeaveBalance + "]";
	}
}
