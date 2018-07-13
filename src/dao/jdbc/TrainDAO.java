package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Route;
import entity.Train;

public class TrainDAO {
	DBUtil dbUtil = new DBUtil();

	private static final String SQL_GET_TRAIN = "select t.train_id, t.number, r.departure, t.departure, r.initial_station,"
			+ " TIMEDIFF(r.arrival, r.departure) as dur, r.arrival, t.arrival, r.finite_station, s.coupe_seats, s.plats_seats,\r\n"
			+ " s.general_seats, s.cost from routes as r \r\n" + " left outer join trains as t on r.id=t.route_id \r\n"
			+ " INNER JOIN seats as s ON t.train_id = s.train_id  where r.id=?";

	private static final String SQL_GET_ROUTE_IDS_FROM_LAYOVERS = "SELECT route_id from layovers "
			+ "where station in(?, ?) order by route_id";

	private static final String SQL_GET_ROUTE_IDS_FROM_ROUTE_AND_LAYOVER = "select layovers.route_id from layovers, routes where layovers.route_id=routes.id and ( \r\n"
			+ "(routes.initial_station=? and layovers.station=?) or(routes.finite_station=? and layovers.station=?))";

	private static final String SQL_GET_ROUTE_IDS_FROM_ROUTE = "select * from routes where initial_station=? and finite_station=?";

	public List<Train> getTrains(String from, String to) {

		List<Train> trains = new ArrayList<>();
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_TRAIN)) {
			List<Integer> ids = generateId(from, to);
			for (int i = 0; i < ids.size(); i++) {

				ps.setInt(1, ids.get(i)); // its insane number : try 1, and better calling
				try (ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Train train = new Train();
						Route route = new Route();
						route.setId(ids.get(i));
						train.setId(rs.getInt(1));
						train.setNumber(rs.getInt(2));
						
						route.setDeparture(rs.getTime(3));
						train.setDeparture(rs.getDate(4));
						route.setInitialStation(rs.getString(5));
						train.setTravel_time(rs.getTime(6));
						route.setArrival(rs.getTime(7));
						train.setArrival(rs.getDate(8));
						route.setEndStation(rs.getString(9));
						train.setRoute(route);
						train.setFree_coupes(rs.getInt(10));
						train.setFree_plats(rs.getInt(11));
						train.setFree_general(rs.getInt(12));
						train.setCost(rs.getInt(13));

						trains.add(train);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trains;
	}

	private List<Integer> generateId(String from, String to) {
		ArrayList<Integer> all = new ArrayList<>();
		 all.addAll(getRouteIdsFromLayovers(from, to));
		 all.addAll(getRouteIdsFromRoutesAndLayovers(from, to));
		 Integer possible_id = getRouteIdsFromRoutes(from, to);
		 if(possible_id!=null) {
			 all.add(possible_id);
			 System.out.println("route completely fit");
		 }
			 return all;
	}

	public List<Integer> getRouteIdsFromLayovers(String initial_station, String end_station) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ROUTE_IDS_FROM_LAYOVERS);
				) {
			ps.setString(1, initial_station);
			ps.setString(2, end_station);
			try(ResultSet rs = ps.executeQuery()){
			List<Integer> or = new ArrayList<>();
			while (rs.next()) {
				or.add(rs.getInt(1));
			}
			List<Integer> uniqe = new ArrayList<>();
			if (or.size() > 1) {
				for (int i = 0; i < or.size() - 1; i++) {
					if (or.get(i).equals(or.get(i + 1))) {
						uniqe.add(or.get(i));
						//System.out.println();
					}
				}System.out.println("ids from layovers :"+uniqe.toString());
				return uniqe;
			} else {
				System.out.println(20);
				return uniqe;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(30);
		return null;
	}

	public List<Integer> getRouteIdsFromRoutesAndLayovers(String initial_station, String end_station) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ROUTE_IDS_FROM_ROUTE_AND_LAYOVER);
				) {
			//System.out.println(initial_station+" - "+end_station+" ");
			ps.setString(1, initial_station);
			ps.setString(2, end_station);
			ps.setString(3, initial_station);
			ps.setString(4, end_station);
			List<Integer> list = new ArrayList<>();
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						list.add(rs.getInt(1));
					}
			}
				System.out.println("external-internal list: " + list.toString());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getRouteIdsFromRoutes(String initial_station, String end_station) {
		try (Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ROUTE_IDS_FROM_ROUTE);
				) {
			Integer id = null;
			ps.setString(1, initial_station);
			ps.setString(2, end_station);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next())
				id = rs.getInt(1);
			}	
				return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
