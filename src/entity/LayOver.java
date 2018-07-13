package entity;

import java.sql.Time;

public class LayOver {
	private int layover_id;
	private int route_id;
	private String station;
	private Time departure;
	private int parking_min;
	private Time arrivel;
	
	public LayOver() {
		super();
	}
	public LayOver(int layover_id, int route_id, String station, Time departure, int parking_min, Time arrivel) {
		super();
		this.layover_id = layover_id;
		this.route_id = route_id;
		this.station = station;
		this.departure = departure;
		this.parking_min = parking_min;
		this.arrivel = arrivel;
	}
	
	public LayOver(int route_id, String station, Time departure, int parking_min, Time arrivel) {
		super();
		this.route_id = route_id;
		this.station = station;
		this.departure = departure;
		this.parking_min = parking_min;
		this.arrivel = arrivel;
	}
	public int getLayover_id() {
		return layover_id;
	}
	public void setLayover_id(int layover_id) {
		this.layover_id = layover_id;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
		
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public int getParking_min() {
		return parking_min;
	}
	public void setParking_min(int parking_min) {
		this.parking_min = parking_min;
	}
	public Time getArrivel() {
		return arrivel;
	}
	public void setArrivel(Time arrivel) {
		this.arrivel = arrivel;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "layover_id: "+layover_id+" route_id: "+route_id+
				" departute: "+departure.toString()+" parking_time: "+parking_min+" arrivel: "+arrivel.toString();
	}
	
}
