package	com.vo;
import java.util.Date;
import java.sql.*;


public class Notice {
	private int id;
	private String title;
	private String content;
	private Date Reletime;
	private int Relepeople;
	public Notice(){}
	public Notice(int id,String title,String content,Date Reletime,int Relepeople){
		this.id=id;
		this.title=title;
		this.content=content;
		this.Reletime=Reletime;
		this.Relepeople=Relepeople;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", Reletime=" + Reletime
				+ ", Relepeople=" + Relepeople + "]";
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}
	public void setReletime(Date Reletime){
		this.Reletime = Reletime;
	}
	public Date getReletime(){
		return Reletime;
	}
	public void setRelepeople(int Relepeople){
		this.Relepeople = Relepeople;
	}
	public int getRelepeople(){
		return Relepeople;
	}
}
