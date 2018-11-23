package	com.vo;
import java.util.Date;
import java.sql.*;


public class Download {
	private int id;
	private String title;
	private Date Reletime;
	private String link;
	private int Relepeople;
	public Download(){}
	public Download(int id,String title,Date Reletime,String link,int Relepeople){
		this.id=id;
		this.title=title;
		this.Reletime=Reletime;
		this.link=link;
		this.Relepeople=Relepeople;
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
	public void setReletime(Date Reletime){
		this.Reletime = Reletime;
	}
	public Date getReletime(){
		return Reletime;
	}
	public void setLink(String link){
		this.link = link;
	}
	public String getLink(){
		return link;
	}
	public void setRelepeople(int Relepeople){
		this.Relepeople = Relepeople;
	}
	public int getRelepeople(){
		return Relepeople;
	}
}
