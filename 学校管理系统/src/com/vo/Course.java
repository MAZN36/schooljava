package	com.vo;
import java.util.Date;
import java.sql.*;


public class Course {
	private int course_id;
	private String course_name;
	private int course_number;
	private int course_sum;
	private String course_note;
	public Course(){}
	public Course(int course_id,String course_name,int course_number,int course_sum,String course_note){
		this.course_id=course_id;
		this.course_name=course_name;
		this.course_number=course_number;
		this.course_sum=course_sum;
		this.course_note=course_note;
	}
	public void setCourse_id(int course_id){
		this.course_id = course_id;
	}
	public int getCourse_id(){
		return course_id;
	}
	public void setCourse_name(String course_name){
		this.course_name = course_name;
	}
	public String getCourse_name(){
		return course_name;
	}
	public void setCourse_number(int course_number){
		this.course_number = course_number;
	}
	public int getCourse_number(){
		return course_number;
	}
	public void setCourse_sum(int course_sum){
		this.course_sum = course_sum;
	}
	public int getCourse_sum(){
		return course_sum;
	}
	public void setCourse_note(String course_note){
		this.course_note = course_note;
	}
	public String getCourse_note(){
		return course_note;
	}
}
