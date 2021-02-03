package strunk.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import strunk.models.ReimbursementEvent;
import strunk.models.ReimbursementRequest;
import strunk.repositories.ReimbursementEventRepository;
import strunk.repositories.ReimbursementEventRepositoryImpl;
import strunk.repositories.ReimbursementRequestRepository;
import strunk.repositories.ReimbursementRequestRepositoryImpl;

public class RequestService {
	
	public void addRequest(HttpServletRequest r) {
		
		ReimbursementRequestRepository repo = new ReimbursementRequestRepositoryImpl();
		ReimbursementEventRepository eventRepo = new ReimbursementEventRepositoryImpl();
		
		ReimbursementEvent event = new ReimbursementEvent();
		int eventId = eventRepo.getLatestEventId();
		
		ReimbursementRequest request = new ReimbursementRequest();
		// request id
		request.setEmployeeId(Integer.parseInt(r.getParameter("employeeId")));
		request.setEventId(eventId); 
		request.setStatus("In Process"); 
		request.setDateOfSubmission(java.time.LocalDate.now().toString()); // current date java.time.LocalDate.now()
		request.setWorkRelatedJustification(r.getParameter("justification"));
		request.setUrgent(false); // check if urgent by comparing dates
		request.setBencoApproved(false); 
		request.setSupervisorApproved(false); 
		request.setDepartmentHeadApproved(false); 
		repo.addRequest(request);
		
	}

}
