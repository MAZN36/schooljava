package	com.vo;
import java.util.Date;
import java.sql.*;


public class Student_Talk {
	private int stu_id;
	private int stu_Studentid;
	private Date stu_Time;
	private String stu_Content;
	private int stu_Operator;
	private String stu_Note;
	public Student_Talk(){}
	public Student_Talk(int stu_id,int stu_Studentid,Date stu_Time,String stu_Content,int stu_Operator,String stu_Note){
		this.stu_id=stu_id;
		this.stu_Studentid=stu_Studentid;
		this.stu_Time=stu_Time;
		this.stu_Content=stu_Content;
		this.stu_Operator=stu_Operator;
		this.stu_Note=stu_Note;
	}
	public void setStu_id(int stu_id){
		this.stu_id = stu_id;
	}
	public int getStu_id(){
		return stu_id;
	}
	public void setStu_Studentid(int stu_Studentid){
		this.stu_Studentid = stu_Studentid;
	}
	public int getStu_Studentid(){
		return stu_Studentid;
	}
	public void setStu_Time(Date stu_Time){
		this.stu_Time = stu_Time;
	}
	public Date getStu_Time(){
		return stu_Time;
	}
	public void setStu_Content(String stu_Content){
		this.stu_Content = stu_Content;
	}
	public String getStu_Content(){
		return stu_Content;
	}
	public void setStu_Operator(int stu_Operator){
		this.stu_Operator = stu_Operator;
	}
	public int getStu_Operator(){
		return stu_Operator;
	}
	public void setStu_Note(String stu_Note){
		this.stu_Note = stu_Note;
	}
	public String getStu_Note(){
		return stu_Note;
	}
}
