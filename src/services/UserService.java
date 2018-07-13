package services;

import dao.jdbc.UserDAO;
import entity.User;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public void insertUser(User user) {
		dao.insertUser(user);
	}

}
