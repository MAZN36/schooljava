package	com.vo;
import java.util.Date;
import java.sql.*;


public class Position {
	private int pid;
	private String pName;
	private String pNote;
	public Position(){}
	public Position(int pid,String pName,String pNote){
		this.pid=pid;
		this.pName=pName;
		this.pNote=pNote;
	}
	public void setPid(int pid){
		this.pid = pid;
	}
	public int getPid(){
		return pid;
	}
	public void setPName(String pName){
		this.pName = pName;
	}
	public String getPName(){
		return pName;
	}
	public void setPNote(String pNote){
		this.pNote = pNote;
	}
	public String getPNote(){
		return pNote;
	}
}
