package	com.vo;
import java.util.Date;
import java.sql.*;


public class Classs {
	private int cId;
	private String cName;
	private int cTypeName;
	private String cGraduated;
	private Date cGtime;
	private String cGstate;
	private int cTeacher;
	private String cPhone;
	private String cNote;
	private int gId;
	private String gName;
	private String gNote;
	private int tid;
	private String tName;
	private int cou;
	public int getCou() {
		return cou;
	}

	public void setCou(int cou) {
		this.cou = cou;
	}

	public Classs(int cId, String cName, int cTypeName, String cGraduated, Date cGtime, String cGstate, int cTeacher,
			String cPhone, String cNote, int gId, String gName, String gNote, int tid, String tName, Date cttime) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cTypeName = cTypeName;
		this.cGraduated = cGraduated;
		this.cGtime = cGtime;
		this.cGstate = cGstate;
		this.cTeacher = cTeacher;
		this.cPhone = cPhone;
		this.cNote = cNote;
		this.gId = gId;
		this.gName = gName;
		this.gNote = gNote;
		this.tid = tid;
		this.tName = tName;
		this.cttime = cttime;
	}
	public Classs(int cId, String cName, int cTypeName, String cGraduated, Date cGtime, String cGstate, int cTeacher,
			String cPhone, String cNote, int gId, String gName, String gNote, int tid, String tName, Date cttime,int cou) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cTypeName = cTypeName;
		this.cGraduated = cGraduated;
		this.cGtime = cGtime;
		this.cGstate = cGstate;
		this.cTeacher = cTeacher;
		this.cPhone = cPhone;
		this.cNote = cNote;
		this.gId = gId;
		this.gName = gName;
		this.gNote = gNote;
		this.tid = tid;
		this.tName = tName;
		this.cttime = cttime;
		this.cou=cou;
	}
	private Date cttime;
	public Date getCttime() {
		return cttime;
	}

	public void setCttime(Date cttime) {
		this.cttime = cttime;
	}

	public Classs(){}

	public Classs(int cId, String cName, int cTypeName, String cGraduated, Date cGtime, String cGstate, int cTeacher,
			String cPhone, String cNote, int gId, String gName, String gNote, int tid, String tName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cTypeName = cTypeName;
		this.cGraduated = cGraduated;
		this.cGtime = cGtime;
		this.cGstate = cGstate;
		this.cTeacher = cTeacher;
		this.cPhone = cPhone;
		this.cNote = cNote;
		this.gId = gId;
		this.gName = gName;
		this.gNote = gNote;
		this.tid = tid;
		this.tName = tName;
	}

	public Classs(int cId, String cName, int cTypeName, String cGraduated, Date cGtime, String cGstate, int cTeacher,
			String cPhone, String cNote) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cTypeName = cTypeName;
		this.cGraduated = cGraduated;
		this.cGtime = cGtime;
		this.cGstate = cGstate;
		this.cTeacher = cTeacher;
		this.cPhone = cPhone;
		this.cNote = cNote;
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

	public int getcTypeName() {
		return cTypeName;
	}

	public void setcTypeName(int cTypeName) {
		this.cTypeName = cTypeName;
	}

	public String getcGraduated() {
		return cGraduated;
	}

	public void setcGraduated(String cGraduated) {
		this.cGraduated = cGraduated;
	}

	public Date getcGtime() {
		return cGtime;
	}

	public void setcGtime(Date cGtime) {
		this.cGtime = cGtime;
	}

	public String getcGstate() {
		return cGstate;
	}

	public void setcGstate(String cGstate) {
		this.cGstate = cGstate;
	}

	public int getcTeacher() {
		return cTeacher;
	}

	public void setcTeacher(int cTeacher) {
		this.cTeacher = cTeacher;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcNote() {
		return cNote;
	}

	public void setcNote(String cNote) {
		this.cNote = cNote;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgNote() {
		return gNote;
	}

	public void setgNote(String gNote) {
		this.gNote = gNote;
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
