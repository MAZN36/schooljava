package	com.vo;
import java.sql.*;


public class Administrator {
	private int Admin_id;
	private String Admin_Name;
	private String Admin_Account;
	private String Admin_Password;
	private String Admin_State;
	private String Admin_Note;
	public Administrator(){}
	public Administrator(int Admin_id,String Admin_Name,String Admin_Account,String Admin_Password,String Admin_State,String Admin_Note){
		this.Admin_id=Admin_id;
		this.Admin_Name=Admin_Name;
		this.Admin_Account=Admin_Account;
		this.Admin_Password=Admin_Password;
		this.Admin_State=Admin_State;
		this.Admin_Note=Admin_Note;
	}
	public void setAdmin_id(int Admin_id){
		this.Admin_id = Admin_id;
	}
	public int getAdmin_id(){
		return Admin_id;
	}
	public void setAdmin_Name(String Admin_Name){
		this.Admin_Name = Admin_Name;
	}
	public String getAdmin_Name(){
		return Admin_Name;
	}
	public void setAdmin_Account(String Admin_Account){
		this.Admin_Account = Admin_Account;
	}
	public String getAdmin_Account(){
		return Admin_Account;
	}
	public void setAdmin_Password(String Admin_Password){
		this.Admin_Password = Admin_Password;
	}
	public String getAdmin_Password(){
		return Admin_Password;
	}
	public void setAdmin_State(String Admin_State){
		this.Admin_State = Admin_State;
	}
	public String getAdmin_State(){
		return Admin_State;
	}
	public void setAdmin_Note(String Admin_Note){
		this.Admin_Note = Admin_Note;
	}
	public String getAdmin_Note(){
		return Admin_Note;
	}
}
