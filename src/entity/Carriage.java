package entity;

import java.io.Serializable;

public class Carriage implements Serializable{
	private int id;
	private int train_id;
	private String type;
	private int free_seats;
	
	public Carriage() {
		super();
	}
	public Carriage(int id, int train_id, String type, int free_seats) {
		super();
		this.id = id;
		this.train_id = train_id;
		this.type = type;
		this.free_seats = free_seats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFree_seats() {
		return free_seats;
	}
	public void setFree_seats(int free_seats) {
		this.free_seats = free_seats;
	}
	@Override
	public String toString() {
		
		return "id: "+id+" train_id: "+train_id + " type: "+type + " free_seats"+free_seats;
				
	}
	
}
