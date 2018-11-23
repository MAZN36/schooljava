package	com.vo;
import java.util.Date;
import java.sql.*;


public class Attendance {
	private int aId;
	private int aClasss;
	private int aStudentid;
	private Date aDate;
	private String aCourseName;
	private int aOperator;
	private String aAttendanceType;
	private String aNote;
	public Attendance(){}
	public Attendance(int aId,int aClasss,int aStudentid,Date aDate,String aCourseName,int aOperator,String aAttendanceType,String aNote){
		this.aId=aId;
		this.aClasss=aClasss;
		this.aStudentid=aStudentid;
		this.aDate=aDate;
		this.aCourseName=aCourseName;
		this.aOperator=aOperator;
		this.aAttendanceType=aAttendanceType;
		this.aNote=aNote;
	}
	public void setAId(int aId){
		this.aId = aId;
	}
	public int getAId(){
		return aId;
	}
	public void setAClasss(int aClasss){
		this.aClasss = aClasss;
	}
	public int getAClasss(){
		return aClasss;
	}
	public void setAStudentid(int aStudentid){
		this.aStudentid = aStudentid;
	}
	public int getAStudentid(){
		return aStudentid;
	}
	public void setADate(Date aDate){
		this.aDate = aDate;
	}
	public Date getADate(){
		return aDate;
	}
	public void setACourseName(String aCourseName){
		this.aCourseName = aCourseName;
	}
	public String getACourseName(){
		return aCourseName;
	}
	public void setAOperator(int aOperator){
		this.aOperator = aOperator;
	}
	public int getAOperator(){
		return aOperator;
	}
	public void setAAttendanceType(String aAttendanceType){
		this.aAttendanceType = aAttendanceType;
	}
	public String getAAttendanceType(){
		return aAttendanceType;
	}
	public void setANote(String aNote){
		this.aNote = aNote;
	}
	public String getANote(){
		return aNote;
	}
}
