package	com.vo;
import java.util.Date;
import java.sql.*;


public class Student_Violate {
	private int vio_id;
	private int vio_Studentid;
	private Date vio_Time;
	private String vio_Content;
	private String vio_Note;
	public Student_Violate(){}
	public Student_Violate(int vio_id,int vio_Studentid,Date vio_Time,String vio_Content,String vio_Note){
		this.vio_id=vio_id;
		this.vio_Studentid=vio_Studentid;
		this.vio_Time=vio_Time;
		this.vio_Content=vio_Content;
		this.vio_Note=vio_Note;
	}
	public void setVio_id(int vio_id){
		this.vio_id = vio_id;
	}
	public int getVio_id(){
		return vio_id;
	}
	public void setVio_Studentid(int vio_Studentid){
		this.vio_Studentid = vio_Studentid;
	}
	public int getVio_Studentid(){
		return vio_Studentid;
	}
	public void setVio_Time(Date vio_Time){
		this.vio_Time = vio_Time;
	}
	public Date getVio_Time(){
		return vio_Time;
	}
	public void setVio_Content(String vio_Content){
		this.vio_Content = vio_Content;
	}
	public String getVio_Content(){
		return vio_Content;
	}
	public void setVio_Note(String vio_Note){
		this.vio_Note = vio_Note;
	}
	public String getVio_Note(){
		return vio_Note;
	}
}
