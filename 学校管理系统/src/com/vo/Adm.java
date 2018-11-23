package	com.vo;
import java.sql.*;


public class Adm {
	private int id;
	private String department;
	private String adname;
	private String adpost;
	private String adphone;
	private String Mailbox;
	private String adNote;
	public Adm(){}
	public Adm(int id,String department,String adname,String adpost,String adphone,String Mailbox,String adNote){
		this.id=id;
		this.department=department;
		this.adname=adname;
		this.adpost=adpost;
		this.adphone=adphone;
		this.Mailbox=Mailbox;
		this.adNote=adNote;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment(){
		return department;
	}
	public void setAdname(String adname){
		this.adname = adname;
	}
	public String getAdname(){
		return adname;
	}
	public void setAdpost(String adpost){
		this.adpost = adpost;
	}
	public String getAdpost(){
		return adpost;
	}
	public void setAdphone(String adphone){
		this.adphone = adphone;
	}
	public String getAdphone(){
		return adphone;
	}
	public void setMailbox(String Mailbox){
		this.Mailbox = Mailbox;
	}
	public String getMailbox(){
		return Mailbox;
	}
	public void setAdNote(String adNote){
		this.adNote = adNote;
	}
	public String getAdNote(){
		return adNote;
	}
}
