package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import entity.LayOver;
import entity.Route;
import entity.User;
import listener.TestLog4jServlet;

public class RouteDAO {
	// Connector connector = new Connector();
	DBUtil dbUtil = new DBUtil();
	Clozer clozer = new Clozer();
    static final Logger log = Logger.getLogger(TestLog4jServlet.class);

	private static final String SQL_GET_ROUTE_BY_START_END_STATION_START_TIME = "SELECT * FROM routes "
			+ "WHERE initial_station=? AND finite_station=? AND departure=?";
	private static final String SQL_INSERT_ROUTE = "INSERT INTO routes (initial_station, departure, finite_station, arrival) VALUES(?, ?, ?, ?)";
	private static final String SQL_GET_LAYOVERS_BY_ROUTE_ID = "SELECT * FROM layovers where route_id=?";
	private static final String SQL_GET_ALL_ROUTES = "SELECT * FROM routes";
	private static final String SQL_GET_COUNT_OF_STATION = "select count(*) from layovers where route_id=?"; 
	private static final String SQL_GET_ID = "SELECT MAX(id) from routes";
	private static final String SQL_INSERT_LAYOVER = "INSERT INTO layovers(route_id, station, departure,"
			+ " parking_min, arrival) values(?, ?, ?, ?)";
	private static final String SQL_GET_ALL_ROUTES_BETWEEN_STATION = "SELECT * FROM routes WHERE initial_station='Kiev' AND finite_station='Poltava'";
	private static final String SQL_GET_ROUTE_BY_ID = "SELECT * FROM routes WHERE id=?";
	private static final String SQL_DELETE_ROUTE = "DELETE FROM routes WHERE id = ?";
	private static final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
	private static StringBuilder SQL_UPDATE_ROUTE = new StringBuilder("UPDATE routes SET ");// str+str+str

	// Not tested
	public List<Route> getRoutsTwoStation(String from, String to) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement psgetLayOv = null;
		ResultSet rsR = null;
		ResultSet rsgetLayOV = null;
		Route route;
		List<Route> routes = new ArrayList<>();
		try {
			con = dbUtil.getDataSource().getConnection();
			pstmt = con.prepareStatement(SQL_GET_ALL_ROUTES_BETWEEN_STATION);
			pstmt.setString(1, from);
			pstmt.setString(2, to);
			rsR = pstmt.executeQuery();
			while (rsR.next()) {
				int id = rsR.getInt(1);
				String initStation = rsR.getString(2);
				Time departure = rsR.getTime(3);
				String finateStation = rsR.getString(4);
				Time arrival = rsR.getTime(5);
				route = new Route(id, initStation, departure, finateStation, arrival);
				List<LayOver> layOvers = new ArrayList<>();
				psgetLayOv = con.prepareStatement(SQL_GET_LAYOVERS_BY_ROUTE_ID);
				psgetLayOv.setInt(1, id);
				rsgetLayOV = psgetLayOv.executeQuery();
				while (rsgetLayOV.next()) {
					LayOver layover = new LayOver();
					layover.setLayover_id(rsgetLayOV.getInt(1));
					layover.setRoute_id(id);
					layover.setDeparture(rsgetLayOV.getTime(3));
					layover.setParking_min(rsgetLayOV.getInt(4));
					layover.setArrivel(rsgetLayOV.getTime(5));
					layOvers.add(layover);
				}
				route.setLayOvers(layOvers);
				System.out.println(route);
				routes.add(route);

			}
			return routes;
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			clozer.closeAll(con, pstmt, rsR);
		}
		return routes;
	}

	public int getCountOfStationFromRoutes(int route_id){
		int count = 0;
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_COUNT_OF_STATION);) {
				ps.setInt(1, route_id);
				try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					count = rs.getInt(1);
				}
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Route> getRouts() {
		try(Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL_GET_ALL_ROUTES);
				PreparedStatement psgetLayOv = con.prepareStatement(SQL_GET_LAYOVERS_BY_ROUTE_ID)
				){
		/*PreparedStatement pstmt = null;
		PreparedStatement psgetLayOv = null;*/
		/*ResultSet rsR = null;
		ResultSet rsgetLayOV = null;*/
		Route route;
		List<Route> routes = new ArrayList<>();
		try (ResultSet rsR = pstmt.executeQuery()){
			/*con = dbUtil.getDataSource().getConnection();
			pstmt = con.prepareStatement(SQL_GET_ALL_ROUTES);*/

			//rsR = pstmt.executeQuery();
			while (rsR.next()) {
				int id = rsR.getInt(1);
				String initStation = rsR.getString(2);
				Time departure = rsR.getTime(3);
				String finateStation = rsR.getString(4);
				Time arrival = rsR.getTime(5);
				int stationCount = getCountOfStationFromRoutes(id);
				route = new Route(id, initStation, departure, finateStation, arrival, stationCount);
				List<LayOver> layOvers = new ArrayList<>();
				/*psgetLayOv = con.prepareStatement(SQL_GET_LAYOVERS_BY_ROUTE_ID);*/
				psgetLayOv.setInt(1, id);
				try(ResultSet rsgetLayOV = psgetLayOv.executeQuery()){
				while (rsgetLayOV.next()) {
					LayOver layover = new LayOver();
					layover.setLayover_id(rsgetLayOV.getInt(1));
					layover.setRoute_id(id);
					layover.setStation(rsgetLayOV.getString(3));
					layover.setDeparture(rsgetLayOV.getTime(4));
					layover.setParking_min(rsgetLayOV.getInt(5));
					layover.setArrivel(rsgetLayOV.getTime(6));
					layOvers.add(layover);
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				route.setLayOvers(layOvers);
				System.out.println(route);
				routes.add(route);

			}
			return routes;
		
		}catch (SQLException ex) {
			ex.printStackTrace();

		} 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Route getRouteById(Integer id) {// String initialStation, String endStation, Date start) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement psgetLayOv = null;
		ResultSet rsR = null;
		ResultSet rsgetLayOV = null;
		Route route;

		try {
			con = dbUtil.getDataSource().getConnection();
			pstmt = con.prepareStatement(SQL_GET_ROUTE_BY_ID);

			pstmt.setInt(1, id);

			rsR = pstmt.executeQuery();
			if (rsR.next()) {
				String initStation = rsR.getString(2);
				Time departure = rsR.getTime(3);
				String finateStation = rsR.getString(4);
				Time arrival = rsR.getTime(5);
				route = new Route(id, initStation, departure, finateStation, arrival);
				List<LayOver> layOvers = new ArrayList<>();
				psgetLayOv = con.prepareStatement(SQL_GET_LAYOVERS_BY_ROUTE_ID);
				psgetLayOv.setInt(1, id);
				rsgetLayOV = psgetLayOv.executeQuery();
				while (rsgetLayOV.next()) {
					LayOver layover = new LayOver();
					layover.setLayover_id(rsgetLayOV.getInt(1));
					layover.setRoute_id(id);
					layover.setStation(rsgetLayOV.getString(3));
					layover.setDeparture(rsgetLayOV.getTime(4));
					layover.setParking_min(rsgetLayOV.getInt(5));
					layover.setArrivel(rsgetLayOV.getTime(6));
					layOvers.add(layover);
				}
				route.setGeneralStation(id);
				route.setLayOvers(layOvers);
				System.out.println(route);
				return route;
			} else
				return null;
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			try {
				/*
				 * pstmt.close(); rsR.close();
				 */
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public Route getRoute(String initSt, String endSt) {// String initialStation, String endStation, Date start) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement psgetLayOv = null;
		ResultSet rsR = null;
		ResultSet rsgetLayOV = null;
		Route route;

		try {
			con = dbUtil.getDataSource().getConnection();
			pstmt = con.prepareStatement(SQL_GET_ROUTE_BY_START_END_STATION_START_TIME);

			pstmt.setString(1, initSt);
			pstmt.setString(2, endSt);
			Time time = Time.valueOf("13:40:00");
			pstmt.setTime(3, time);
			rsR = pstmt.executeQuery();
			if (rsR.next()) {
				int id = rsR.getInt(1);
				String initStation = rsR.getString(2);
				Time departure = rsR.getTime(3);
				String finateStation = rsR.getString(4);
				Time arrival = rsR.getTime(5);
				route = new Route(id, initStation, departure, finateStation, arrival);
				List<LayOver> layOvers = new ArrayList<>();
				psgetLayOv = con.prepareStatement(SQL_GET_LAYOVERS_BY_ROUTE_ID);
				psgetLayOv.setInt(1, id);
				rsgetLayOV = psgetLayOv.executeQuery();
				while (rsgetLayOV.next()) {
					LayOver layover = new LayOver();
					layover.setLayover_id(rsgetLayOV.getInt(1));
					layover.setRoute_id(id);
					layover.setDeparture(rsgetLayOV.getTime(3));
					layover.setParking_min(rsgetLayOV.getInt(4));
					layover.setArrivel(rsgetLayOV.getTime(5));
					layOvers.add(layover);
				}
				route.setLayOvers(layOvers);
				System.out.println(route);
				return route;
			} else
				return null;
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			clozer.closeAll(con, pstmt, rsR);
		}
		return null;
	}

	/*not uses*/
	void insertAllRoute(Route route) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstGetId = null;
		PreparedStatement pstLO = null;
		ResultSet rsId = null;
		try {
			con = dbUtil.getDataSource().getConnection();
			pst = con.prepareStatement(SQL_INSERT_ROUTE);
			pst.setString(1, route.getInitialStation());
			pst.setTime(2, route.getDeparture());
			pst.setString(3, route.getEndStation());
			pst.setTime(4, route.getArrival());
			pst.executeUpdate();
			pstGetId = con.prepareStatement(SQL_GET_ID);
			rsId = pstGetId.executeQuery();
			int id = 0;
			if (rsId.next()) {
				id = rsId.getInt(1);
			}
			for (LayOver layover : route.getLayOvers()) {
				pstLO = con.prepareStatement(SQL_INSERT_LAYOVER);
				pstLO.setInt(1, id);
				pstLO.setString(2, layover.getStation());
				pstLO.setTime(2, layover.getDeparture());
				pstLO.setInt(3, layover.getParking_min());
				pstLO.setTime(4, layover.getArrivel());
				pstLO.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clozer.closeAll(con, pst, rsId);
			clozer.close(pstGetId);
			clozer.close(pstLO);
		}
	}

	private void close(AutoCloseable ac) {
		if (ac != null) {
			try {
				ac.close();
			} catch (Exception ex) {
				throw new IllegalStateException("Cannot close " + ac);
			}
		}
	}

	public void updateRoute(int id, Map<String, String> map) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement(genarateUpdateQuery(map));) {
			//int idInt = 1;
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			SQL_UPDATE_ROUTE = new StringBuilder("UPDATE routes SET ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private String genarateUpdateQuery(Map<String, String> map) {
		for (Map.Entry<String, String> pair : map.entrySet()) {
			SQL_UPDATE_ROUTE.append(pair.getKey() + " = '" + pair.getValue() + "', ");
		}
		SQL_UPDATE_ROUTE.setLength(SQL_UPDATE_ROUTE.length() - 2);
		SQL_UPDATE_ROUTE.append(" WHERE id=?");
		System.out.println(SQL_UPDATE_ROUTE.toString());
		return SQL_UPDATE_ROUTE.toString();
	}

	public void deleteRoute(String id) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement pstmt = con.prepareStatement(SQL_DELETE_ROUTE)) {
			int idInt = Integer.parseInt(id);
			pstmt.setInt(1, idInt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int insertRouteWithoutLayoversAndGetId(Route route) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement psInsRoute = con.prepareStatement(SQL_INSERT_ROUTE);
						) {
			psInsRoute.setString(1, route.getInitialStation());
			psInsRoute.setTime(2, route.getDeparture());
			psInsRoute.setString(3, route.getEndStation());
			psInsRoute.setTime(4, route.getArrival());
		psInsRoute.executeUpdate();
		
	}catch (SQLException e) {
        e.printStackTrace();
    }
	int id = 0;	
		try(Connection con = dbUtil.getDataSource().getConnection();
			PreparedStatement psGetId = createPreparedStatement(con);
			ResultSet rsId = psGetId.executeQuery();){
			if(rsId.next()) {
			id = rsId.getInt(1);
			}
		}catch(SQLException e) {
	        e.printStackTrace();
	    }
		return id;
}

	private PreparedStatement createPreparedStatement(Connection con) throws SQLException {
	    String sql = "SELECT LAST_INSERT_ID();";
	    PreparedStatement ps = con.prepareStatement(SQL_GET_LAST_ID);
	    return ps;
	}
}