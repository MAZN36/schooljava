package	com.vo;
import java.util.Date;
import java.sql.*;


public class Classs_Address {
	private int address_id;
	private int address_Classs;
	private int adderss_Name;
	private int adderss_Phone;
	private String adderss_Note;
	public Classs_Address(){}
	public Classs_Address(int address_id,int address_Classs,int adderss_Name,int adderss_Phone,String adderss_Note){
		this.address_id=address_id;
		this.address_Classs=address_Classs;
		this.adderss_Name=adderss_Name;
		this.adderss_Phone=adderss_Phone;
		this.adderss_Note=adderss_Note;
	}
	public void setAddress_id(int address_id){
		this.address_id = address_id;
	}
	public int getAddress_id(){
		return address_id;
	}
	public void setAddress_Classs(int address_Classs){
		this.address_Classs = address_Classs;
	}
	public int getAddress_Classs(){
		return address_Classs;
	}
	public void setAdderss_Name(int adderss_Name){
		this.adderss_Name = adderss_Name;
	}
	public int getAdderss_Name(){
		return adderss_Name;
	}
	public void setAdderss_Phone(int adderss_Phone){
		this.adderss_Phone = adderss_Phone;
	}
	public int getAdderss_Phone(){
		return adderss_Phone;
	}
	public void setAdderss_Note(String adderss_Note){
		this.adderss_Note = adderss_Note;
	}
	public String getAdderss_Note(){
		return adderss_Note;
	}
}
