package	com.vo;
import java.util.Date;
import java.sql.*;


public class Teacher {
	private int tid;
	private String tJNumber;
	private String tName;
	private String tsex;
	private Date tBirthday;
	private int tPosition;
	private String tTelephone;
	private String tPassword;
	private String tNation;
	private String tPolitical;
	private String tid_card;
	private String tEducation;
	private String tHome;
	private String tNative;
	private String img;
	private String tContent;
	public String getpName() {
		return pName;
	}
	public Teacher(int tid, String tJNumber, String tName, String tsex, Date tBirthday, int tPosition,
			String tTelephone, String tPassword, String tNation, String tPolitical, String tid_card, String tEducation,
			String tHome, String tNative, String img, String tContent, String sState, String tNote, String pName) {
		super();
		this.tid = tid;
		this.tJNumber = tJNumber;
		this.tName = tName;
		this.tsex = tsex;
		this.tBirthday = tBirthday;
		this.tPosition = tPosition;
		this.tTelephone = tTelephone;
		this.tPassword = tPassword;
		this.tNation = tNation;
		this.tPolitical = tPolitical;
		this.tid_card = tid_card;
		this.tEducation = tEducation;
		this.tHome = tHome;
		this.tNative = tNative;
		this.img = img;
		this.tContent = tContent;
		this.sState = sState;
		this.tNote = tNote;
		this.pName = pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	private String sState;
	private String tNote;
	private String pName;
	public Teacher(){}
	public Teacher(int tid,String tJNumber,String tName,String tsex,Date tBirthday,int tPosition,String tTelephone,String tPassword,String tNation,String tPolitical,String tid_card,String tEducation,String tHome,String tNative,String img,String tContent,String sState,String tNote){
		this.tid=tid;
		this.tJNumber=tJNumber;
		this.tName=tName;
		this.tsex=tsex;
		this.tBirthday=tBirthday;
		this.tPosition=tPosition;
		this.tTelephone=tTelephone;
		this.tPassword=tPassword;
		this.tNation=tNation;
		this.tPolitical=tPolitical;
		this.tid_card=tid_card;
		this.tEducation=tEducation;
		this.tHome=tHome;
		this.tNative=tNative;
		this.img=img;
		this.tContent=tContent;
		this.sState=sState;
		this.tNote=tNote;
	}
	public void setTid(int tid){
		this.tid = tid;
	}
	public int getTid(){
		return tid;
	}
	public void setTJNumber(String tJNumber){
		this.tJNumber = tJNumber;
	}
	public String getTJNumber(){
		return tJNumber;
	}
	public void setTName(String tName){
		this.tName = tName;
	}
	public String getTName(){
		return tName;
	}
	public void setTsex(String tsex){
		this.tsex = tsex;
	}
	public String getTsex(){
		return tsex;
	}
	public void setTBirthday(Date tBirthday){
		this.tBirthday = tBirthday;
	}
	public Date getTBirthday(){
		return tBirthday;
	}
	public void setTPosition(int tPosition){
		this.tPosition = tPosition;
	}
	public int getTPosition(){
		return tPosition;
	}
	public void setTTelephone(String tTelephone){
		this.tTelephone = tTelephone;
	}
	public String getTTelephone(){
		return tTelephone;
	}
	public void setTPassword(String tPassword){
		this.tPassword = tPassword;
	}
	public String getTPassword(){
		return tPassword;
	}
	public void setTNation(String tNation){
		this.tNation = tNation;
	}
	public String getTNation(){
		return tNation;
	}
	public void setTPolitical(String tPolitical){
		this.tPolitical = tPolitical;
	}
	public String getTPolitical(){
		return tPolitical;
	}
	public void setTid_card(String tid_card){
		this.tid_card = tid_card;
	}
	public String getTid_card(){
		return tid_card;
	}
	public void setTEducation(String tEducation){
		this.tEducation = tEducation;
	}
	public String getTEducation(){
		return tEducation;
	}
	public void setTHome(String tHome){
		this.tHome = tHome;
	}
	public String getTHome(){
		return tHome;
	}
	public void setTNative(String tNative){
		this.tNative = tNative;
	}
	public String getTNative(){
		return tNative;
	}
	public void setImg(String img){
		this.img = img;
	}
	public String getImg(){
		return img;
	}
	public void setTContent(String tContent){
		this.tContent = tContent;
	}
	public String getTContent(){
		return tContent;
	}
	public void setSState(String sState){
		this.sState = sState;
	}
	public String getSState(){
		return sState;
	}
	public void setTNote(String tNote){
		this.tNote = tNote;
	}
	public String getTNote(){
		return tNote;
	}
}
