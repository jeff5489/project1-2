package strunk.services;

import javax.servlet.http.HttpServletRequest;

import strunk.models.ReimbursementEvent;
import strunk.repositories.ReimbursementEventRepository;
import strunk.repositories.ReimbursementEventRepositoryImpl;

public class EventService {

	public void addEvent(HttpServletRequest r) {
		
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		
		ReimbursementEvent event = new ReimbursementEvent();
		event.setEmployeeId(Integer.parseInt(r.getParameter("employeeId")));
		event.setType(r.getParameter("type"));
		event.setType(r.getParameter("location"));
		event.setType(r.getParameter("description"));
		event.setType(r.getParameter("startDate"));
		event.setType(r.getParameter("endDate"));
		event.setCost(Double.parseDouble(r.getParameter("cost")));
		event.setGradingFormat(r.getParameter("gradingFormat"));
		event.setPassingGrade(r.getParameter("passingGrade"));
		eRepo.addEvent(event);

	}
	
	public int getLatestEventId() {
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		eRepo.getEvents();
		
		return 0;
		
	}
}
