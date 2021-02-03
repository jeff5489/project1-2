package strunk.models;

import java.time.LocalDate;

public class ReimbursementEvent {
	
	private int id;
	private int employeeId;
//	private int requestId;
	private String type;
	private String location;
	private String description;
	private String startDate;
	private String endDate;
	private Double cost;
	private String gradingFormat;
	private String passingGrade;
	
	public ReimbursementEvent() {
		super();
	}

	public ReimbursementEvent(int employeeId, String type, String location, String description,
			String startDate, String endDate, Double cost, String gradingFormat, String passingGrade) {
		super();
		this.employeeId = employeeId;
//		this.requestId = requestId;
		this.type = type;
		this.location = location;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.passingGrade = passingGrade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
//	public int getRequestId() {
//		return requestId;
//	}
//	public void setRequestId(int requestId) {
//		this.requestId = requestId;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	
	public String getPassingGrade() {
		return passingGrade;
	}
	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}
	@Override
	public String toString() {
		return "ReimbursementEvents [id=" + id + ", employeeId=" + employeeId + ", type="
				+ type + ", location=" + location + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", cost=" + cost + ", gradingFormat=" + gradingFormat + "]";
	}
	
}
