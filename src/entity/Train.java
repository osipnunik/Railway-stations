package entity;

import java.sql.Date;
import java.sql.Time;

public class Train {
	private int id;
	private int route_id;
	private int number;
	private Date departure;
	private Route route;
	private Time travel_time;
	private Date arrival;
	private int free_coupes;
	private int free_plats;
	private int free_general;
	private int cost;
	
	public Train() {
		super();
	}
	public Train(int id, int route_id, int number, Date departure, Route route, Time travel_time, Date arrival, int free_coupes,
			int free_plats, int free_general, int cost) {
		super();
		this.id = id;
		this.route_id = route_id;
		this.number = number;
		this.departure = departure;
		this.route = route;
		this.travel_time = travel_time;
		this.arrival = arrival;
		this.free_coupes = free_coupes;
		this.free_plats = free_plats;
		this.free_general = free_general;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Time getTravel_time() {
		return travel_time;
	}
	public void setTravel_time(Time travel_time) {
		this.travel_time = travel_time;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public int getFree_coupes() {
		return free_coupes;
	}
	public void setFree_coupes(int free_coupes) {
		this.free_coupes = free_coupes;
	}
	public int getFree_plats() {
		return free_plats;
	}
	public void setFree_plats(int free_plats) {
		this.free_plats = free_plats;
	}
	public int getFree_general() {
		return free_general;
	}
	public void setFree_general(int free_general) {
		this.free_general = free_general;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "id: "+id+", route_id: "+route_id+", number: "+
	number+", departure: "+ departure+", route: "+route.toString()+
	", travel_time: "+travel_time+", arrival: "+arrival+", coupe,plats,gen: "+
	free_coupes+free_plats+free_general+", cost: "+cost;
	}
	
}
