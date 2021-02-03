package strunk.models;

import java.time.LocalDateTime;

public class Message {
	
	private int id;
	private int employeeId;
	private int requestId;
	private String dateTime;
	private String body;
	
	public Message() {
		super();
	}
	public Message(int employeeId, int requestId, String dateTime, String body) {
		super();
		this.employeeId = employeeId;
		this.requestId = requestId;
		this.dateTime = dateTime;
		this.body = body;
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
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", employeeId=" + employeeId + ", requestId=" + requestId + ", dateTime="
				+ dateTime + ", body=" + body + "]";
	}
	
}
