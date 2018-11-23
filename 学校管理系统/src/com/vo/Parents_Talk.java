package	com.vo;
import java.util.Date;
import java.sql.*;


public class Parents_Talk {
	private int par_id;
	private int par_Studentid;
	private Date par_Time;
	private String par_Content;
	private int par_Operator;
	private String par_Note;
	public Parents_Talk(){}
	public Parents_Talk(int par_id,int par_Studentid,Date par_Time,String par_Content,int par_Operator,String par_Note){
		this.par_id=par_id;
		this.par_Studentid=par_Studentid;
		this.par_Time=par_Time;
		this.par_Content=par_Content;
		this.par_Operator=par_Operator;
		this.par_Note=par_Note;
	}
	public void setPar_id(int par_id){
		this.par_id = par_id;
	}
	public int getPar_id(){
		return par_id;
	}
	public void setPar_Studentid(int par_Studentid){
		this.par_Studentid = par_Studentid;
	}
	public int getPar_Studentid(){
		return par_Studentid;
	}
	public void setPar_Time(Date par_Time){
		this.par_Time = par_Time;
	}
	public Date getPar_Time(){
		return par_Time;
	}
	public void setPar_Content(String par_Content){
		this.par_Content = par_Content;
	}
	public String getPar_Content(){
		return par_Content;
	}
	public void setPar_Operator(int par_Operator){
		this.par_Operator = par_Operator;
	}
	public int getPar_Operator(){
		return par_Operator;
	}
	public void setPar_Note(String par_Note){
		this.par_Note = par_Note;
	}
	public String getPar_Note(){
		return par_Note;
	}
}
