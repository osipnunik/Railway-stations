package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import entity.LayOver;
import listener.TestLog4jServlet;

public class LayoverDAO {
	DBUtil dbUtil = new DBUtil();
	Clozer clozer = new Clozer();
    static final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);

	private static final String SQL_DELETE_LAYOVER = "DELETE FROM layovers WHERE layover_id = ?";
	private static final String SQL_INSERT_LAYOVER = "INSERT INTO layovers (route_id, station, departure, parking_min, arrival) VALUES(?, ?, ?, ?, ?)";

	private static StringBuilder SQL_UPDATE_LAYOVER = new StringBuilder("UPDATE layovers SET ");
	
	public void updateLayover(int id, Map<String, String> map) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement(genarateUpdateQuery(map));) {
			//int idInt = 1;
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			SQL_UPDATE_LAYOVER = new StringBuilder("UPDATE layovers SET ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String genarateUpdateQuery(Map<String, String> map) {
		for (Map.Entry<String, String> pair : map.entrySet()) {
			SQL_UPDATE_LAYOVER.append(pair.getKey() + " = '" + pair.getValue() + "', ");
		}
		SQL_UPDATE_LAYOVER.setLength(SQL_UPDATE_LAYOVER.length() - 2);
		SQL_UPDATE_LAYOVER.append(" WHERE layover_id=?");
		System.out.println(SQL_UPDATE_LAYOVER.toString());
		return SQL_UPDATE_LAYOVER.toString();
	}
	
	public void deleteLayover(String id) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL_DELETE_LAYOVER)) {
			int idInt = Integer.parseInt(id);
			pstmt.setInt(1, idInt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertLayover(LayOver layover) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT_LAYOVER);
						){
			pst.setInt(1, layover.getRoute_id());
			pst.setString(2, layover.getStation());
			pst.setTime(3, layover.getDeparture());
			pst.setInt(4, layover.getParking_min());
			pst.setTime(5, layover.getArrivel());
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
