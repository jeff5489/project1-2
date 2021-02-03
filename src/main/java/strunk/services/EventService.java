package strunk.services;

import javax.servlet.http.HttpServletRequest;

import strunk.models.ReimbursementEvent;
import strunk.repositories.ReimbursementEventRepository;
import strunk.repositories.ReimbursementEventRepositoryImpl;

public class EventService {

	public void addEvent(HttpServletRequest r) {
		
		System.out.println("addEvent in EventSerive reached");
		
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		
		ReimbursementEvent event = new ReimbursementEvent();
		event.setEmployeeId(Integer.parseInt(r.getParameter("employeeId")));
		event.setType(r.getParameter("courseType"));
		event.setLocationState(r.getParameter("locationState"));
		event.setLocationCity(r.getParameter("locationCity"));
		event.setDescription(r.getParameter("description"));
		event.setStartDate(r.getParameter("startDate"));
		event.setEndDate(r.getParameter("endDate"));
		event.setCost(Double.parseDouble(r.getParameter("cost")));
		event.setGradingFormat(r.getParameter("gradingFormatId"));
		event.setPassingGrade(r.getParameter("passingGrade"));
		eRepo.addEvent(event);

	}
	
	public int getLatestEventId() {
		ReimbursementEventRepository eRepo = new ReimbursementEventRepositoryImpl();
		eRepo.getEvents();
		
		return 0;
		
	}
}
