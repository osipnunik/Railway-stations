package entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Route {
	int id;
	String initialStation;
	Time departure;
	String endStation;
	Time arrival;
	List<LayOver> layOvers;
	int generalStation;

	public Route() {
		super();
	}

	public Route(int id, String initialStation, Time departure, String endStation, Time arrival) {
		super();
		this.id = id;
		this.initialStation = initialStation;
		this.departure = departure;
		this.endStation = endStation;
		this.arrival = arrival;
	}
	
	public Route(int id, String initialStation, Time departure, String endStation, Time arrival,
			int generalStation) {
		super();
		this.id = id;
		this.initialStation = initialStation;
		this.departure = departure;
		this.endStation = endStation;
		this.arrival = arrival;
		this.generalStation = generalStation;
	}

	public Route(String initialStation, Time departure, String endStation, Time arrival) {
		super();
		this.initialStation = initialStation;
		this.departure = departure;
		this.endStation = endStation;
		this.arrival = arrival;
	}
	
	public int getGeneralStation() {
		return generalStation;
	}

	public void setGeneralStation(int generalStation) {
		this.generalStation = generalStation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LayOver> getLayOvers() {
		return layOvers;
	}

	public void setLayOvers(List<LayOver> layOvers) {
		this.layOvers = layOvers;
	}

	public String getInitialStation() {
		return initialStation;
	}

	public void setInitialStation(String initialStation) {
		this.initialStation = initialStation;
	}

	public Time getDeparture() {
		return departure;
	}

	public void setDeparture(Time departure) {
		this.departure = departure;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public Time getArrival() {
		return arrival;
	}

	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " init_station: " + initialStation + "- endStation: " + endStation +
			" departure: " + departure + "-arrival: " + arrival;// +" list : "+layOvers.toString();
	}

}
