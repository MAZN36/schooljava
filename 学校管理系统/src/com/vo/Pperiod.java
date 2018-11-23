package	com.vo;
import java.util.Date;
import java.sql.*;


public class Pperiod {
	private int pId;
	private int pClasss;
	private int pCourse;
	private Date pDate;
	private String pNote;
	private int cId;
	private String cName;
	private int course_id;
	private String course_name;
	public Pperiod(){}
	public Pperiod(int pId, int pClasss, int pCourse, Date pDate, String pNote) {
		super();
		this.pId = pId;
		this.pClasss = pClasss;
		this.pCourse = pCourse;
		this.pDate = pDate;
		this.pNote = pNote;
	}
	public Pperiod(int pId, int pClasss, int pCourse, Date pDate, String pNote, int cId, String cName, int course_id,
			String course_name) {
		super();
		this.pId = pId;
		this.pClasss = pClasss;
		this.pCourse = pCourse;
		this.pDate = pDate;
		this.pNote = pNote;
		this.cId = cId;
		this.cName = cName;
		this.course_id = course_id;
		this.course_name = course_name;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getpClasss() {
		return pClasss;
	}
	public void setpClasss(int pClasss) {
		this.pClasss = pClasss;
	}
	public int getpCourse() {
		return pCourse;
	}
	public void setpCourse(int pCourse) {
		this.pCourse = pCourse;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public String getpNote() {
		return pNote;
	}
	public void setpNote(String pNote) {
		this.pNote = pNote;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
}
