package entity;

public class User {
	
	private String login;
	private String password;
	private String role;
	private String name;
	
	public User(String login, String password, String role, String name) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
		this.name = name;
	}
	public User(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return login + " " + password + " " + role+" "+name;
	}
	
}
