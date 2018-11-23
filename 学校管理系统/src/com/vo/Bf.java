package	com.vo;
import java.util.Date;
public class Bf {
	private int id;
	private Date bfsj;
	private String bflq;
	private Date hysj;
	public Bf(){}
	public Bf(int id,Date bfsj,String bflq,Date hysj){
		this.id=id;
		this.bfsj=bfsj;
		this.bflq=bflq;
		this.hysj=hysj;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setBfsj(Date bfsj){
		this.bfsj = bfsj;
	}
	public Date getBfsj(){
		return bfsj;
	}
	public void setBflq(String bflq){
		this.bflq = bflq;
	}
	public String getBflq(){
		return bflq;
	}
	public void setHysj(Date hysj){
		this.hysj = hysj;
	}
	public Date getHysj(){
		return hysj;
	}
}
