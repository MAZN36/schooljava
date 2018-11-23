package	com.vo;
import java.sql.*;


public class Archives_check {
	private int arc_id;
	private int arc_Classs;
	private int arc_Studentid;
	private String arc_Content;
	private String arc_Note;
	public Archives_check(){}
	public Archives_check(int arc_id,int arc_Classs,int arc_Studentid,String arc_Content,String arc_Note){
		this.arc_id=arc_id;
		this.arc_Classs=arc_Classs;
		this.arc_Studentid=arc_Studentid;
		this.arc_Content=arc_Content;
		this.arc_Note=arc_Note;
	}
	public void setArc_id(int arc_id){
		this.arc_id = arc_id;
	}
	public int getArc_id(){
		return arc_id;
	}
	public void setArc_Classs(int arc_Classs){
		this.arc_Classs = arc_Classs;
	}
	public int getArc_Classs(){
		return arc_Classs;
	}
	public void setArc_Studentid(int arc_Studentid){
		this.arc_Studentid = arc_Studentid;
	}
	public int getArc_Studentid(){
		return arc_Studentid;
	}
	public void setArc_Content(String arc_Content){
		this.arc_Content = arc_Content;
	}
	public String getArc_Content(){
		return arc_Content;
	}
	public void setArc_Note(String arc_Note){
		this.arc_Note = arc_Note;
	}
	public String getArc_Note(){
		return arc_Note;
	}
}
