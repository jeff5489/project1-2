package strunk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import strunk.models.Message;
import strunk.models.ReimbursementEvent;
import strunk.util.JDBCConnection;

public class MessageRepositoryImpl implements MessageRepository {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Message getMessage(int id) {
		try {

			String sql = "SELECT * FROM messages WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();
			
//			private int id;
//			private int employeeId;
//			private int requestId;
//			private String dateTime;
//			private String body;

			if (rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setEmployeeId(rs.getInt("employeeId"));
				message.setRequestId(rs.getInt("requestId"));
				message.setDateTime(rs.getString("dateTime"));
				message.setBody(rs.getString("body"));

				return message;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addMessage(Message message) {
		try {
			
			String sql = "INSERT into messages_seq.nextval values (reimbursementRequests,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(message.getEmployeeId()));
			ps.setString(2, Integer.toString(message.getRequestId()));
			ps.setString(3, message.getDateTime());
			ps.setString(4, message.getBody());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
