package	com.vo;
import java.util.Date;
import java.sql.*;


public class Insurance {
	private int Iid;
	private int IStudentid;
	private String IName;
	private Date ITime;
	private String IContent;
	private String INote;
	public Insurance(){}
	public Insurance(int Iid,int IStudentid,String IName,Date ITime,String IContent,String INote){
		this.Iid=Iid;
		this.IStudentid=IStudentid;
		this.IName=IName;
		this.ITime=ITime;
		this.IContent=IContent;
		this.INote=INote;
	}
	public void setIid(int Iid){
		this.Iid = Iid;
	}
	public int getIid(){
		return Iid;
	}
	public void setIStudentid(int IStudentid){
		this.IStudentid = IStudentid;
	}
	public int getIStudentid(){
		return IStudentid;
	}
	public void setIName(String IName){
		this.IName = IName;
	}
	public String getIName(){
		return IName;
	}
	public void setITime(Date ITime){
		this.ITime = ITime;
	}
	public Date getITime(){
		return ITime;
	}
	public void setIContent(String IContent){
		this.IContent = IContent;
	}
	public String getIContent(){
		return IContent;
	}
	public void setINote(String INote){
		this.INote = INote;
	}
	public String getINote(){
		return INote;
	}
}
