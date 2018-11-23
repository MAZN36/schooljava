package	com.vo;
import java.util.Date;
import java.sql.*;


public class Credits {
	private int cIds;
	private int cClasssName;
	private String cStudentid;
	private int cSubjectsName;
	private int cHavecredit;
	private int cOperator;
	private String cNotes;
	private int cId;
	private String cName;
	private int course_id;
	private String course_name;
	private int tid;
	private String tName;
	public Credits(){}
	public Credits(int cIds, int cClasssName, String cStudentid, int cSubjectsName, int cHavecredit, int cOperator,
			String cNotes) {
		super();
		this.cIds = cIds;
		this.cClasssName = cClasssName;
		this.cStudentid = cStudentid;
		this.cSubjectsName = cSubjectsName;
		this.cHavecredit = cHavecredit;
		this.cOperator = cOperator;
		this.cNotes = cNotes;
	}
	public Credits(int cIds, int cClasssName, String cStudentid, int cSubjectsName, int cHavecredit, int cOperator,
			String cNotes, int cId, String cName, int course_id, String course_name, int tid, String tName) {
		super();
		this.cIds = cIds;
		this.cClasssName = cClasssName;
		this.cStudentid = cStudentid;
		this.cSubjectsName = cSubjectsName;
		this.cHavecredit = cHavecredit;
		this.cOperator = cOperator;
		this.cNotes = cNotes;
		this.cId = cId;
		this.cName = cName;
		this.course_id = course_id;
		this.course_name = course_name;
		this.tid = tid;
		this.tName = tName;
	}
	public int getcIds() {
		return cIds;
	}
	public void setcIds(int cIds) {
		this.cIds = cIds;
	}
	public int getcClasssName() {
		return cClasssName;
	}
	public void setcClasssName(int cClasssName) {
		this.cClasssName = cClasssName;
	}
	public String getcStudentid() {
		return cStudentid;
	}
	public void setcStudentid(String cStudentid) {
		this.cStudentid = cStudentid;
	}
	public int getcSubjectsName() {
		return cSubjectsName;
	}
	public void setcSubjectsName(int cSubjectsName) {
		this.cSubjectsName = cSubjectsName;
	}
	public int getcHavecredit() {
		return cHavecredit;
	}
	public void setcHavecredit(int cHavecredit) {
		this.cHavecredit = cHavecredit;
	}
	public int getcOperator() {
		return cOperator;
	}
	public void setcOperator(int cOperator) {
		this.cOperator = cOperator;
	}
	public String getcNotes() {
		return cNotes;
	}
	public void setcNotes(String cNotes) {
		this.cNotes = cNotes;
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
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
}
