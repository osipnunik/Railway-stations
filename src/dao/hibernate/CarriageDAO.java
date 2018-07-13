package dao.hibernate;

import java.util.List;

import entity.Carriage;

public interface CarriageDAO {
	public List<Carriage> getAvailableCarriages(int train_id, String type);
}
