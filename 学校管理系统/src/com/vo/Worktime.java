package	com.vo;
import java.util.Date;
import java.sql.*;


public class Worktime {
	private int id;
	private int Serial;
	private String interval;
	private String section;
	private String wtime;
	private String wNote;
	public Worktime(){}
	public Worktime(int id,int Serial,String interval,String section,String wtime,String wNote){
		this.id=id;
		this.Serial=Serial;
		this.interval=interval;
		this.section=section;
		this.wtime=wtime;
		this.wNote=wNote;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setSerial(int Serial){
		this.Serial = Serial;
	}
	public int getSerial(){
		return Serial;
	}
	public void setInterval(String interval){
		this.interval = interval;
	}
	public String getInterval(){
		return interval;
	}
	public void setSection(String section){
		this.section = section;
	}
	public String getSection(){
		return section;
	}
	public void setWtime(String wtime){
		this.wtime = wtime;
	}
	public String getWtime(){
		return wtime;
	}
	public void setWNote(String wNote){
		this.wNote = wNote;
	}
	public String getWNote(){
		return wNote;
	}
}
