package	com.vo;
import java.util.Date;
import java.sql.*;


public class Student_results {
	private int rId;
	private int rStudentid;
	private Date rExamDate;
	private double rOperating;
	private double rAnswer;
	private int rClasss;
	private String rPass;
	private String rNote;
	public Student_results(){}
	public Student_results(int rId,int rStudentid,Date rExamDate,double rOperating,double rAnswer,int rClasss,String rPass,String rNote){
		this.rId=rId;
		this.rStudentid=rStudentid;
		this.rExamDate=rExamDate;
		this.rOperating=rOperating;
		this.rAnswer=rAnswer;
		this.rClasss=rClasss;
		this.rPass=rPass;
		this.rNote=rNote;
	}
	public void setRId(int rId){
		this.rId = rId;
	}
	public int getRId(){
		return rId;
	}
	public void setRStudentid(int rStudentid){
		this.rStudentid = rStudentid;
	}
	public int getRStudentid(){
		return rStudentid;
	}
	public void setRExamDate(Date rExamDate){
		this.rExamDate = rExamDate;
	}
	public Date getRExamDate(){
		return rExamDate;
	}
	public void setROperating(double rOperating){
		this.rOperating = rOperating;
	}
	public double getROperating(){
		return rOperating;
	}
	public void setRAnswer(double rAnswer){
		this.rAnswer = rAnswer;
	}
	public double getRAnswer(){
		return rAnswer;
	}
	public void setRClasss(int rClasss){
		this.rClasss = rClasss;
	}
	public int getRClasss(){
		return rClasss;
	}
	public void setRPass(String rPass){
		this.rPass = rPass;
	}
	public String getRPass(){
		return rPass;
	}
	public void setRNote(String rNote){
		this.rNote = rNote;
	}
	public String getRNote(){
		return rNote;
	}
}
