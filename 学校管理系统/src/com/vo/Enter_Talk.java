package	com.vo;
import java.util.Date;
import java.sql.*;


public class Enter_Talk {
	private int enter_id;
	private int enter_Studentid;
	private Date enter_Time;
	private String enter_Content;
	private int enter_Operator;
	private String enter_Note;
	public Enter_Talk(){}
	public Enter_Talk(int enter_id,int enter_Studentid,Date enter_Time,String enter_Content,int enter_Operator,String enter_Note){
		this.enter_id=enter_id;
		this.enter_Studentid=enter_Studentid;
		this.enter_Time=enter_Time;
		this.enter_Content=enter_Content;
		this.enter_Operator=enter_Operator;
		this.enter_Note=enter_Note;
	}
	public void setEnter_id(int enter_id){
		this.enter_id = enter_id;
	}
	public int getEnter_id(){
		return enter_id;
	}
	public void setEnter_Studentid(int enter_Studentid){
		this.enter_Studentid = enter_Studentid;
	}
	public int getEnter_Studentid(){
		return enter_Studentid;
	}
	public void setEnter_Time(Date enter_Time){
		this.enter_Time = enter_Time;
	}
	public Date getEnter_Time(){
		return enter_Time;
	}
	public void setEnter_Content(String enter_Content){
		this.enter_Content = enter_Content;
	}
	public String getEnter_Content(){
		return enter_Content;
	}
	public void setEnter_Operator(int enter_Operator){
		this.enter_Operator = enter_Operator;
	}
	public int getEnter_Operator(){
		return enter_Operator;
	}
	public void setEnter_Note(String enter_Note){
		this.enter_Note = enter_Note;
	}
	public String getEnter_Note(){
		return enter_Note;
	}
}
