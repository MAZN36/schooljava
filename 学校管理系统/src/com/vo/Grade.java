package	com.vo;
import java.util.Date;
import java.sql.*;


public class Grade {
	private int gId;
	private String gName;
	private String gNote;
	public Grade(){}
	public Grade(int gId,String gName,String gNote){
		this.gId=gId;
		this.gName=gName;
		this.gNote=gNote;
	}
	public void setGId(int gId){
		this.gId = gId;
	}
	public int getGId(){
		return gId;
	}
	public void setGName(String gName){
		this.gName = gName;
	}
	public String getGName(){
		return gName;
	}
	public void setGNote(String gNote){
		this.gNote = gNote;
	}
	public String getGNote(){
		return gNote;
	}
}
