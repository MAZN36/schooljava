package	com.vo;
import java.util.Date;
import java.sql.*;


public class Classs_Activity {
	private int act_id;
	private int act_Classs;
	private String act_Teme;
	private Date act_Time;
	private String act_Location;
	private String act_Content;
	private String act_Note;
	public Classs_Activity(){}
	public Classs_Activity(int act_id,int act_Classs,String act_Teme,Date act_Time,String act_Location,String act_Content,String act_Note){
		this.act_id=act_id;
		this.act_Classs=act_Classs;
		this.act_Teme=act_Teme;
		this.act_Time=act_Time;
		this.act_Location=act_Location;
		this.act_Content=act_Content;
		this.act_Note=act_Note;
	}
	public void setAct_id(int act_id){
		this.act_id = act_id;
	}
	public int getAct_id(){
		return act_id;
	}
	public void setAct_Classs(int act_Classs){
		this.act_Classs = act_Classs;
	}
	public int getAct_Classs(){
		return act_Classs;
	}
	public void setAct_Teme(String act_Teme){
		this.act_Teme = act_Teme;
	}
	public String getAct_Teme(){
		return act_Teme;
	}
	public void setAct_Time(Date act_Time){
		this.act_Time = act_Time;
	}
	public Date getAct_Time(){
		return act_Time;
	}
	public void setAct_Location(String act_Location){
		this.act_Location = act_Location;
	}
	public String getAct_Location(){
		return act_Location;
	}
	public void setAct_Content(String act_Content){
		this.act_Content = act_Content;
	}
	public String getAct_Content(){
		return act_Content;
	}
	public void setAct_Note(String act_Note){
		this.act_Note = act_Note;
	}
	public String getAct_Note(){
		return act_Note;
	}
}
