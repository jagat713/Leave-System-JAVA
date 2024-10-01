package ModelClass;

public class LeavesModel {
	private Long LeaveID;
	private String LeaveType;
	private String StartDate;
	private String EndDate;
	private String LeaveReason;
	private Long LeaveEmployeeId;
	private String LeaveEmployeeName;
	public LeavesModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeavesModel(Long leaveID, String leaveType, String startDate, String endDate, String leaveReason,
			Long leaveEmployeeId, String leaveEmployeeName) {
		super();
		LeaveID = leaveID;
		LeaveType = leaveType;
		StartDate = startDate;
		EndDate = endDate;
		LeaveReason = leaveReason;
		LeaveEmployeeId = leaveEmployeeId;
		LeaveEmployeeName = leaveEmployeeName;
	}
	public Long getLeaveID() {
		return LeaveID;
	}
	public void setLeaveID(Long leaveID) {
		LeaveID = leaveID;
	}
	public String getLeaveType() {
		return LeaveType;
	}
	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getLeaveReason() {
		return LeaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		LeaveReason = leaveReason;
	}
	public Long getLeaveEmployeeId() {
		return LeaveEmployeeId;
	}
	public void setLeaveEmployeeId(Long leaveEmployeeId) {
		LeaveEmployeeId = leaveEmployeeId;
	}
	public String getLeaveEmployeeName() {
		return LeaveEmployeeName;
	}
	public void setLeaveEmployeeName(String leaveEmployeeName) {
		LeaveEmployeeName = leaveEmployeeName;
	}
	@Override
	public String toString() {
		return "LeavesModel [LeaveID=" + LeaveID + ", LeaveType=" + LeaveType + ", StartDate=" + StartDate
				+ ", EndDate=" + EndDate + ", LeaveReason=" + LeaveReason + ", LeaveEmployeeId=" + LeaveEmployeeId
				+ ", LeaveEmployeeName=" + LeaveEmployeeName + "]";
	}
	
}
