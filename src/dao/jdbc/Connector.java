package dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Connector {
	Connection getConnectionDS() throws SQLException {
		MysqlDataSource ds = null;
		try {
			ds = new MysqlDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/trains");
			ds.setUser("root");
			ds.setPassword("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con = ds.getConnection();
		return con;
	}
	
	
	
	Connection getConnectionCPool() {
		Connection con = null;
		try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/trains");
		con = ds.getConnection();
		
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
}
