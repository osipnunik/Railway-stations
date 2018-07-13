package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDAO {
	Connector connector = new Connector();
	Clozer clozer = new Clozer();
	DBUtil dbUtil = new DBUtil();
	
	private static final String SQL_FIND_PASS_AND_ROLE_BY_LOGIN = "SELECT password, role FROM users WHERE login=?";
	private static final String SQL_INSERT_USER = "INSERT INTO users(login, password, role, name) VALUES(?, ?, ?, ?)";
	
	public User getUser(String login) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String password = null;
		String role = null;
		try {
			con = connector.getConnectionDS();
			pstmt = con.prepareStatement(SQL_FIND_PASS_AND_ROLE_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				password = rs.getString("password");
				role = rs.getString("role");
				System.out.println(password + " " + role);
				User user = new User(login, password, role);
				return user;
			} else
				return null;
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			clozer.closeAll(con, pstmt, rs);
		}
		return null;
	}

	public void insertUser(User user) {
		try(Connection con = dbUtil.getDataSource().getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_INSERT_USER);	
				){
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ps.setString(4, user.getName());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
