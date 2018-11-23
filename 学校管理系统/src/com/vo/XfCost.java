package	com.vo;
import java.util.Date;
public class XfCost {
	private int id;
	private int stuidxf;
	private String danhao;
	private Date jysj;
	private double jyqyr;
	private double jyhyr;
	private double jyyr;
	private String jyfs;
	private String jylx;
	public XfCost(){}
	public XfCost(int id,int stuidxf,String danhao,Date jysj,double jyqyr,double jyhyr,double jyyr,String jyfs,String jylx){
		this.id=id;
		this.stuidxf=stuidxf;
		this.danhao=danhao;
		this.jysj=jysj;
		this.jyqyr=jyqyr;
		this.jyhyr=jyhyr;
		this.jyyr=jyyr;
		this.jyfs=jyfs;
		this.jylx=jylx;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setStuidxf(int stuidxf){
		this.stuidxf = stuidxf;
	}
	public int getStuidxf(){
		return stuidxf;
	}
	public void setDanhao(String danhao){
		this.danhao = danhao;
	}
	public String getDanhao(){
		return danhao;
	}
	public void setJysj(Date jysj){
		this.jysj = jysj;
	}
	public Date getJysj(){
		return jysj;
	}
	public void setJyqyr(double jyqyr){
		this.jyqyr = jyqyr;
	}
	public double getJyqyr(){
		return jyqyr;
	}
	public void setJyhyr(double jyhyr){
		this.jyhyr = jyhyr;
	}
	public double getJyhyr(){
		return jyhyr;
	}
	public void setJyyr(double jyyr){
		this.jyyr = jyyr;
	}
	public double getJyyr(){
		return jyyr;
	}
	public void setJyfs(String jyfs){
		this.jyfs = jyfs;
	}
	public String getJyfs(){
		return jyfs;
	}
	public void setJylx(String jylx){
		this.jylx = jylx;
	}
	public String getJylx(){
		return jylx;
	}
}
