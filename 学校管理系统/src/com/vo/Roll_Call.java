package	com.vo;
import java.util.Date;
import java.sql.*;


public class Roll_Call {
	private int Roll_id;
	private int Roll_Classs;
	private int Roll_Course;
	private String Roll_Type;
	private int Roll_Number;
	private int Roll_Operator;
	private Date Roll_Time;
	private String Roll_State;
	private String Roll_Note;
	public Roll_Call(){}
	public Roll_Call(int Roll_id,int Roll_Classs,int Roll_Course,String Roll_Type,int Roll_Number,int Roll_Operator,Date Roll_Time,String Roll_State,String Roll_Note){
		this.Roll_id=Roll_id;
		this.Roll_Classs=Roll_Classs;
		this.Roll_Course=Roll_Course;
		this.Roll_Type=Roll_Type;
		this.Roll_Number=Roll_Number;
		this.Roll_Operator=Roll_Operator;
		this.Roll_Time=Roll_Time;
		this.Roll_State=Roll_State;
		this.Roll_Note=Roll_Note;
	}
	public void setRoll_id(int Roll_id){
		this.Roll_id = Roll_id;
	}
	public int getRoll_id(){
		return Roll_id;
	}
	public void setRoll_Classs(int Roll_Classs){
		this.Roll_Classs = Roll_Classs;
	}
	public int getRoll_Classs(){
		return Roll_Classs;
	}
	public void setRoll_Course(int Roll_Course){
		this.Roll_Course = Roll_Course;
	}
	public int getRoll_Course(){
		return Roll_Course;
	}
	public void setRoll_Type(String Roll_Type){
		this.Roll_Type = Roll_Type;
	}
	public String getRoll_Type(){
		return Roll_Type;
	}
	public void setRoll_Number(int Roll_Number){
		this.Roll_Number = Roll_Number;
	}
	public int getRoll_Number(){
		return Roll_Number;
	}
	public void setRoll_Operator(int Roll_Operator){
		this.Roll_Operator = Roll_Operator;
	}
	public int getRoll_Operator(){
		return Roll_Operator;
	}
	public void setRoll_Time(Date Roll_Time){
		this.Roll_Time = Roll_Time;
	}
	public Date getRoll_Time(){
		return Roll_Time;
	}
	public void setRoll_State(String Roll_State){
		this.Roll_State = Roll_State;
	}
	public String getRoll_State(){
		return Roll_State;
	}
	public void setRoll_Note(String Roll_Note){
		this.Roll_Note = Roll_Note;
	}
	public String getRoll_Note(){
		return Roll_Note;
	}
}
