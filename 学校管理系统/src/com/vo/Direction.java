package	com.vo;
import java.util.Date;
import java.sql.*;


public class Direction {
	private int dId;
	private int dStudentid;
	private int dClasss;
	private int dFirstchoice;
	private int dSecondchoice;
	private Date dDate;
	private String dNote;
	public Direction(){}
	public Direction(int dId,int dStudentid,int dClasss,int dFirstchoice,int dSecondchoice,Date dDate,String dNote){
		this.dId=dId;
		this.dStudentid=dStudentid;
		this.dClasss=dClasss;
		this.dFirstchoice=dFirstchoice;
		this.dSecondchoice=dSecondchoice;
		this.dDate=dDate;
		this.dNote=dNote;
	}
	public void setDId(int dId){
		this.dId = dId;
	}
	public int getDId(){
		return dId;
	}
	public void setDStudentid(int dStudentid){
		this.dStudentid = dStudentid;
	}
	public int getDStudentid(){
		return dStudentid;
	}
	public void setDClasss(int dClasss){
		this.dClasss = dClasss;
	}
	public int getDClasss(){
		return dClasss;
	}
	public void setDFirstchoice(int dFirstchoice){
		this.dFirstchoice = dFirstchoice;
	}
	public int getDFirstchoice(){
		return dFirstchoice;
	}
	public void setDSecondchoice(int dSecondchoice){
		this.dSecondchoice = dSecondchoice;
	}
	public int getDSecondchoice(){
		return dSecondchoice;
	}
	public void setDDate(Date dDate){
		this.dDate = dDate;
	}
	public Date getDDate(){
		return dDate;
	}
	public void setDNote(String dNote){
		this.dNote = dNote;
	}
	public String getDNote(){
		return dNote;
	}
}
