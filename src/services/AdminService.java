package services;

import java.util.List;

import dao.jdbc.CarriageDAO;
import dao.jdbc.LayoverDAO;
import dao.jdbc.RouteDAO;
import dao.jdbc.TrainDAO;
import dao.jdbc.UserDAO;
import entity.Route;

public class AdminService extends Service {
	RouteDAO routeDAO = new RouteDAO();
	LayoverDAO layoverDAO = new LayoverDAO();
	TrainDAO trainDAO = new TrainDAO();
	CarriageDAO carriageDAO = new CarriageDAO();
	UserDAO userDAO = new UserDAO();

	public List<Route> getRouts() {
		return routeDAO.getRouts();
	}

	public Route getRouteById(int id) {
		return routeDAO.getRouteById(id);
	}

	public void deleteLayover(String id) {
		layoverDAO.deleteLayover(id);
	}
}
