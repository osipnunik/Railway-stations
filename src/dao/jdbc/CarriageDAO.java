package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import entity.Carriage;

public class CarriageDAO {
	private static DBUtil dbUtil;
	private static final Logger log = Logger.getLogger(Logger.class);
	private static final String SQL_GET_Carriages = "select * from carriage where train_id=? and type=? and free_seats>0"; 
	private static final String SQL_DECREMENT_BUY = "UPDATE carriage SET free_seats = free_seats - 1 WHERE id = ?";

	public List<Carriage> getAvailableCarriages(int train_id, String type){
		List<Carriage> carriages = new ArrayList<>();
		try(Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_Carriages);){
			System.out.println(" jdbc : -- tr_id:"+train_id+" type: "+type);
			log.info("some text from jdbc log4j");
			ps.setInt(1, train_id);
			ps.setString(2, type);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Carriage car = new Carriage();
					car.setId(rs.getInt(1));
					car.setTrain_id(rs.getInt(2));
					car.setType(rs.getString(3));
					car.setFree_seats(rs.getInt(4));
					System.out.println("carriage in jdbc: "+car.toString());
					log.info("carriage in jdbc: "+car.toString());
					carriages.add(car);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return carriages;
	}
	
	public void buying(int carrige_id) {
		System.out.println("jdbc : car_id : "+carrige_id);
		try(Connection con = dbUtil.getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DECREMENT_BUY);
				){
			ps.setInt(1, carrige_id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
