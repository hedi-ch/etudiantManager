package clas;

public class Admin {
	private String adminUserName;
	private String password;
	
	Admin(String adminUserName ,String password){
		this.password=password;
		this.adminUserName=adminUserName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getAdminUserName() {
		return this.adminUserName;
	}
}
