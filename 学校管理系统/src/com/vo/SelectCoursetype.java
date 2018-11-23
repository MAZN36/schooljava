package	com.vo;
import java.util.Date;
import java.sql.*;


public class SelectCoursetype {
	private int select_id;
	private String select_name;
	private String select_target;
	private String select_introduce;
	private String select_capacityv;
	private String select_jobs;
	private String select_teacher;
	private String select_Headmaster;
	private String select_Note;
	public SelectCoursetype(){}
	public SelectCoursetype(int select_id,String select_name,String select_target,String select_introduce,String select_capacityv,String select_jobs,String select_teacher,String select_Headmaster,String select_Note){
		this.select_id=select_id;
		this.select_name=select_name;
		this.select_target=select_target;
		this.select_introduce=select_introduce;
		this.select_capacityv=select_capacityv;
		this.select_jobs=select_jobs;
		this.select_teacher=select_teacher;
		this.select_Headmaster=select_Headmaster;
		this.select_Note=select_Note;
	}
	public void setSelect_id(int select_id){
		this.select_id = select_id;
	}
	public int getSelect_id(){
		return select_id;
	}
	public void setSelect_name(String select_name){
		this.select_name = select_name;
	}
	public String getSelect_name(){
		return select_name;
	}
	public void setSelect_target(String select_target){
		this.select_target = select_target;
	}
	public String getSelect_target(){
		return select_target;
	}
	public void setSelect_introduce(String select_introduce){
		this.select_introduce = select_introduce;
	}
	public String getSelect_introduce(){
		return select_introduce;
	}
	public void setSelect_capacityv(String select_capacityv){
		this.select_capacityv = select_capacityv;
	}
	public String getSelect_capacityv(){
		return select_capacityv;
	}
	public void setSelect_jobs(String select_jobs){
		this.select_jobs = select_jobs;
	}
	public String getSelect_jobs(){
		return select_jobs;
	}
	public void setSelect_teacher(String select_teacher){
		this.select_teacher = select_teacher;
	}
	public String getSelect_teacher(){
		return select_teacher;
	}
	public void setSelect_Headmaster(String select_Headmaster){
		this.select_Headmaster = select_Headmaster;
	}
	public String getSelect_Headmaster(){
		return select_Headmaster;
	}
	public void setSelect_Note(String select_Note){
		this.select_Note = select_Note;
	}
	public String getSelect_Note(){
		return select_Note;
	}
}
