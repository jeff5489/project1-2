package strunk.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import strunk.models.Employee;
import strunk.repositories.EmployeeRepository;
import strunk.repositories.EmployeeRepositoryImpl;

public class LogInService {
	
	public boolean logIn(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeRepository repo = new EmployeeRepositoryImpl();
		List<Employee> employees = repo.getAllEmployees();
		System.out.println(employees);
				
		for(Employee employee : employees) {
			if(username.equals(employee.getUserName())  && password.equals(employee.getPassword())) {
				HttpSession session=request.getSession();  
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("id", employee.getId());
				session.setAttribute("department", employee.getDepartment());
				session.setAttribute("positionTitle", employee.getPositionTitle());
				return true; 
			}
		}
		System.out.println("username or password didn't match");
		return false;
	}

}
