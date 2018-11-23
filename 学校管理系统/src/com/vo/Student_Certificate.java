package	com.vo;
import java.util.Date;
import java.sql.*;


public class Student_Certificate {
	private int cer_id;
	private int cer_Studentid;
	private Date cer_Time;
	private Date cer_Read;
	private String cer_Note;
	public Student_Certificate(){}
	public Student_Certificate(int cer_id,int cer_Studentid,Date cer_Time,Date cer_Read,String cer_Note){
		this.cer_id=cer_id;
		this.cer_Studentid=cer_Studentid;
		this.cer_Time=cer_Time;
		this.cer_Read=cer_Read;
		this.cer_Note=cer_Note;
	}
	public void setCer_id(int cer_id){
		this.cer_id = cer_id;
	}
	public int getCer_id(){
		return cer_id;
	}
	public void setCer_Studentid(int cer_Studentid){
		this.cer_Studentid = cer_Studentid;
	}
	public int getCer_Studentid(){
		return cer_Studentid;
	}
	public void setCer_Time(Date cer_Time){
		this.cer_Time = cer_Time;
	}
	public Date getCer_Time(){
		return cer_Time;
	}
	public void setCer_Read(Date cer_Read){
		this.cer_Read = cer_Read;
	}
	public Date getCer_Read(){
		return cer_Read;
	}
	public void setCer_Note(String cer_Note){
		this.cer_Note = cer_Note;
	}
	public String getCer_Note(){
		return cer_Note;
	}
}
