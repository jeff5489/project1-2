package strunk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import strunk.models.ReimbursementEvent;
import strunk.models.ReimbursementRequest;
import strunk.util.JDBCConnection;

public class ReimbursementEventRepositoryImpl implements ReimbursementEventRepository {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public ReimbursementEvent getEvent(int id) {
		try {

			String sql = "SELECT * FROM reimbursementRequests WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ReimbursementEvent event = new ReimbursementEvent();
				event.setId(rs.getInt("id"));
				event.setEmployeeId(rs.getInt("employeeId"));
//				event.setRequestId(rs.getInt("requestId"));
				event.setType(rs.getString("type"));
				event.setLocation(rs.getString("location"));
				event.setStartDate(rs.getString("startDate"));
				event.setEndDate(rs.getString("endDate"));
				event.setCost(rs.getDouble("cost"));
				event.setGradingFormat(rs.getString("gradingFormat"));
				conn.close();
				return event;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public int getEventId(String type) {
		try {

			String sql = "SELECT * FROM reimbursementRequests WHERE type = created by RequestService";
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
//				ReimbursementEvent event = new ReimbursementEvent();
//				event.setId(rs.getInt("id"));
//				event.setEmployeeId(rs.getInt("employeeId"));
//				event.setRequestId(rs.getInt("requestId"));
//				event.setType(rs.getString("type"));
//				event.setLocation(rs.getString("location"));
//				event.setStartDate(rs.getString("startDate"));
//				event.setEndDate(rs.getString("endDate"));
//				event.setCost(rs.getDouble("cost"));
//				event.setGradingFormat(rs.getString("gradingFormat"));
				conn.close();
				return id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean addEvent(ReimbursementEvent event) {
		try {
			
//			private int id;
//			private int employeeId;
//			private int requestId;
//			private String type;
//			private String location;
//			private String description;
//			private String startDate;
//			private String endDate;
//			private Double cost;
//			private String gradingFormat;
			
			String sql = "INSERT into reimbursementEvents values (reimbursementEvents_seq.nextval ,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, event.getEmployeeId());
//			ps.setInt(2, event.getRequestId());
			ps.setString(2, event.getType());
			ps.setString(3, event.getLocation());
			ps.setString(4, event.getDescription());
			ps.setString(5, event.getStartDate());
			ps.setString(6, event.getEndDate());
			ps.setDouble(7, event.getCost());
			ps.setString(8, event.getGradingFormat());
			ps.setString(9, event.getPassingGrade());

			ps.execute();
			conn.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<ReimbursementEvent> getEvents() {
		List<ReimbursementEvent> events = new ArrayList<ReimbursementEvent>();

		try {

			String sql = "SELECT * FROM reimbursementEvents";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
//				private int id;
//				private int employeeId;
//				private int requestId;
//				private String type;
//				private String location;
//				private String description;
//				private String startDate;
//				private String endDate;
//				private Double cost;
//				private String gradingFormat;

				ReimbursementEvent event = new ReimbursementEvent();
				event.setId(rs.getInt("id"));
				event.setEmployeeId(rs.getInt("employeeId"));
//				event.setRequestId(rs.getInt("requestId"));
				event.setType(rs.getString("type"));
				event.setLocation(rs.getString("location"));
				event.setStartDate(rs.getString("startDate"));
				event.setEndDate(rs.getString("endDate"));
				event.setCost(rs.getDouble("cost"));
				event.setGradingFormat(rs.getString("gradingFormat"));

				events.add(event);

			}
			conn.close();
			return events;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateEvent(ReimbursementEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEvent(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getLatestEventId() {
		
		List<ReimbursementEvent> events = new ArrayList<ReimbursementEvent>();
		
		try {

			String sql = "SELECT * FROM reimbursementEvents ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ReimbursementEvent event = new ReimbursementEvent();
				event.setId(rs.getInt("id"));

				events.add(event);
				
			}

			int id = events.get(0).getId();
			conn.close();
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
