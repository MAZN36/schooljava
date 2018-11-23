package	com.vo;
import java.util.Date;
import java.sql.*;


public class Studentinfo {
	private int stuId;
	private String Studentid;
	private int sClasss;
	private String sName;
	private String sSex;
	private String sNational;
	private Date sDate;
	private String sCard;
	private String sNativeplace;
	private String sAddress;
	private String sPassword;
	private String sParentsName;
	private String sParentsNumber;
	private String sFace;
	private String sNumber;
	private Date sEntranceDate;
	private String sQQ;
	private String sPicture;
	private String sState;
	private String sNote;
	private int cId;
	private String cName;
	private int cTypeName;
	private String cGraduated;
	private Date cGtime;
	private String cGstate;
	private String cNote;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcTypeName() {
		return cTypeName;
	}
	public void setcTypeName(int cTypeName) {
		this.cTypeName = cTypeName;
	}
	public String getcGraduated() {
		return cGraduated;
	}
	public void setcGraduated(String cGraduated) {
		this.cGraduated = cGraduated;
	}
	public Date getcGtime() {
		return cGtime;
	}
	public void setcGtime(Date cGtime) {
		this.cGtime = cGtime;
	}
	public String getcGstate() {
		return cGstate;
	}
	public void setcGstate(String cGstate) {
		this.cGstate = cGstate;
	}
	public String getcNote() {
		return cNote;
	}
	public void setcNote(String cNote) {
		this.cNote = cNote;
	}
	public Studentinfo(int stuId){
		this.stuId=stuId;
	}
	
	
	public Studentinfo(int stuId, String studentid, int sClasss, String sName, String sSex, String sNational,
			Date sDate, String sCard, String sNativeplace, String sAddress, String sPassword, String sParentsName,
			String sParentsNumber, String sFace, String sNumber, Date sEntranceDate, String sQQ, String sPicture,
			String sState, String sNote, int cId, String cName, int cTypeName, String cGraduated, Date cGtime,
			String cGstate, String cNote) {
		super();
		this.stuId = stuId;
		Studentid = studentid;
		this.sClasss = sClasss;
		this.sName = sName;
		this.sSex = sSex;
		this.sNational = sNational;
		this.sDate = sDate;
		this.sCard = sCard;
		this.sNativeplace = sNativeplace;
		this.sAddress = sAddress;
		this.sPassword = sPassword;
		this.sParentsName = sParentsName;
		this.sParentsNumber = sParentsNumber;
		this.sFace = sFace;
		this.sNumber = sNumber;
		this.sEntranceDate = sEntranceDate;
		this.sQQ = sQQ;
		this.sPicture = sPicture;
		this.sState = sState;
		this.sNote = sNote;
		this.cId = cId;
		this.cName = cName;
		this.cTypeName = cTypeName;
		this.cGraduated = cGraduated;
		this.cGtime = cGtime;
		this.cGstate = cGstate;
		this.cNote = cNote;
	}
	public Studentinfo(){}
	public Studentinfo(int stuId,String Studentid,int sClasss,String sName,String sSex,String sNational,Date sDate,String sCard,String sNativeplace,String sAddress,String sPassword,String sParentsName,String sParentsNumber,String sFace,String sNumber,Date sEntranceDate,String sQQ,String sPicture,String sState,String sNote){
		this.stuId=stuId;
		this.Studentid=Studentid;
		this.sClasss=sClasss;
		this.sName=sName;
		this.sSex=sSex;
		this.sNational=sNational;
		this.sDate=sDate;
		this.sCard=sCard;
		this.sNativeplace=sNativeplace;
		this.sAddress=sAddress;
		this.sPassword=sPassword;
		this.sParentsName=sParentsName;
		this.sParentsNumber=sParentsNumber;
		this.sFace=sFace;
		this.sNumber=sNumber;
		this.sEntranceDate=sEntranceDate;
		this.sQQ=sQQ;
		this.sPicture=sPicture;
		this.sState=sState;
		this.sNote=sNote;
	}
	public void setStuId(int stuId){
		this.stuId = stuId;
	}
	public int getStuId(){
		return stuId;
	}
	public void setStudentid(String Studentid){
		this.Studentid = Studentid;
	}
	public String getStudentid(){
		return Studentid;
	}
	public void setSClasss(int sClasss){
		this.sClasss = sClasss;
	}
	public int getSClasss(){
		return sClasss;
	}
	public void setSName(String sName){
		this.sName = sName;
	}
	public String getSName(){
		return sName;
	}
	public void setSSex(String sSex){
		this.sSex = sSex;
	}
	public String getSSex(){
		return sSex;
	}
	public void setSNational(String sNational){
		this.sNational = sNational;
	}
	public String getSNational(){
		return sNational;
	}
	public void setSDate(Date sDate){
		this.sDate = sDate;
	}
	public Date getSDate(){
		return sDate;
	}
	public void setSCard(String sCard){
		this.sCard = sCard;
	}
	public String getSCard(){
		return sCard;
	}
	public void setSNativeplace(String sNativeplace){
		this.sNativeplace = sNativeplace;
	}
	public String getSNativeplace(){
		return sNativeplace;
	}
	public void setSAddress(String sAddress){
		this.sAddress = sAddress;
	}
	public String getSAddress(){
		return sAddress;
	}
	public void setSPassword(String sPassword){
		this.sPassword = sPassword;
	}
	public String getSPassword(){
		return sPassword;
	}
	public void setSParentsName(String sParentsName){
		this.sParentsName = sParentsName;
	}
	public String getSParentsName(){
		return sParentsName;
	}
	public void setSParentsNumber(String sParentsNumber){
		this.sParentsNumber = sParentsNumber;
	}
	public String getSParentsNumber(){
		return sParentsNumber;
	}
	public void setSFace(String sFace){
		this.sFace = sFace;
	}
	public String getSFace(){
		return sFace;
	}
	public void setSNumber(String sNumber){
		this.sNumber = sNumber;
	}
	public String getSNumber(){
		return sNumber;
	}
	public void setSEntranceDate(Date sEntranceDate){
		this.sEntranceDate = sEntranceDate;
	}
	public Date getSEntranceDate(){
		return sEntranceDate;
	}
	public void setSQQ(String sQQ){
		this.sQQ = sQQ;
	}
	public String getSQQ(){
		return sQQ;
	}
	public void setSPicture(String sPicture){
		this.sPicture = sPicture;
	}
	public String getSPicture(){
		return sPicture;
	}
	public void setSState(String sState){
		this.sState = sState;
	}
	public String getSState(){
		return sState;
	}
	public void setSNote(String sNote){
		this.sNote = sNote;
	}
	public String getSNote(){
		return sNote;
	}
}
