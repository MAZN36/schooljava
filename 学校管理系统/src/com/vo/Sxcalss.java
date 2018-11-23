package	com.vo;
import java.util.Date;
public class Sxcalss {
	private int id;
	private int stuxh;
	private String sxqbj;
	private int sxhbj;
	private String zt;
	private Date sxsj;
	private String bz;
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
	public Sxcalss(int id, int stuxh, String sxqbj, int sxhbj, String zt, Date sxsj, String bz, int stuId,
			String studentid, int sClasss, String sName, String sSex, String sNational, Date sDate, String sCard,
			String sNativeplace, String sAddress, String sPassword, String sParentsName, String sParentsNumber,
			String sFace, String sNumber, Date sEntranceDate, String sQQ, String sPicture, String sState, String sNote,
			int cId, String cName, int cTypeName, String cGraduated, Date cGtime, String cGstate, String cNote) {
		super();
		this.id = id;
		this.stuxh = stuxh;
		this.sxqbj = sxqbj;
		this.sxhbj = sxhbj;
		this.zt = zt;
		this.sxsj = sxsj;
		this.bz = bz;
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
	private String sPicture;
	@Override
	public String toString() {
		return "Sxcalss [id=" + id + ", stuxh=" + stuxh + ", sxqbj=" + sxqbj + ", sxhbj=" + sxhbj + ", zt=" + zt
				+ ", sxsj=" + sxsj + ", bz=" + bz + ", stuId=" + stuId + ", Studentid=" + Studentid + ", sClasss="
				+ sClasss + ", sName=" + sName + ", sSex=" + sSex + ", sNational=" + sNational + ", sDate=" + sDate
				+ ", sCard=" + sCard + ", sNativeplace=" + sNativeplace + ", sAddress=" + sAddress + ", sPassword="
				+ sPassword + ", sParentsName=" + sParentsName + ", sParentsNumber=" + sParentsNumber + ", sFace="
				+ sFace + ", sNumber=" + sNumber + ", sEntranceDate=" + sEntranceDate + ", sQQ=" + sQQ + ", sPicture="
				+ sPicture + ", sState=" + sState + ", sNote=" + sNote + ", cId=" + cId + ", cName=" + cName
				+ ", cTypeName=" + cTypeName + ", cGraduated=" + cGraduated + ", cGtime=" + cGtime + ", cGstate="
				+ cGstate + ", cNote=" + cNote + "]";
	}
	private String sState;
	private String sNote;
	private int cId;
	private String cName;
	private int cTypeName;
	private String cGraduated;
	private Date cGtime;
	private String cGstate;
	private String cNote;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStudentid() {
		return Studentid;
	}
	public void setStudentid(String studentid) {
		Studentid = studentid;
	}
	public int getsClasss() {
		return sClasss;
	}
	public void setsClasss(int sClasss) {
		this.sClasss = sClasss;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsSex() {
		return sSex;
	}
	public void setsSex(String sSex) {
		this.sSex = sSex;
	}
	public String getsNational() {
		return sNational;
	}
	public void setsNational(String sNational) {
		this.sNational = sNational;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public String getsCard() {
		return sCard;
	}
	public void setsCard(String sCard) {
		this.sCard = sCard;
	}
	public String getsNativeplace() {
		return sNativeplace;
	}
	public void setsNativeplace(String sNativeplace) {
		this.sNativeplace = sNativeplace;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getsParentsName() {
		return sParentsName;
	}
	public void setsParentsName(String sParentsName) {
		this.sParentsName = sParentsName;
	}
	public String getsParentsNumber() {
		return sParentsNumber;
	}
	public void setsParentsNumber(String sParentsNumber) {
		this.sParentsNumber = sParentsNumber;
	}
	public String getsFace() {
		return sFace;
	}
	public void setsFace(String sFace) {
		this.sFace = sFace;
	}
	public String getsNumber() {
		return sNumber;
	}
	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}
	public Date getsEntranceDate() {
		return sEntranceDate;
	}
	public void setsEntranceDate(Date sEntranceDate) {
		this.sEntranceDate = sEntranceDate;
	}
	public String getsQQ() {
		return sQQ;
	}
	public void setsQQ(String sQQ) {
		this.sQQ = sQQ;
	}
	public String getsPicture() {
		return sPicture;
	}
	public void setsPicture(String sPicture) {
		this.sPicture = sPicture;
	}
	public String getsState() {
		return sState;
	}
	public void setsState(String sState) {
		this.sState = sState;
	}
	public String getsNote() {
		return sNote;
	}
	public void setsNote(String sNote) {
		this.sNote = sNote;
	}
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
	public Sxcalss(){}
	public Sxcalss(int id,int stuxh,String sxqbj,int sxhbj,String zt,Date sxsj,String bz){
		this.id=id;
		this.stuxh=stuxh;
		this.sxqbj=sxqbj;
		this.sxhbj=sxhbj;
		this.zt=zt;
		this.sxsj=sxsj;
		this.bz=bz;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setStuxh(int stuxh){
		this.stuxh = stuxh;
	}
	public int getStuxh(){
		return stuxh;
	}
	public void setSxqbj(String sxqbj){
		this.sxqbj = sxqbj;
	}
	public String getSxqbj(){
		return sxqbj;
	}
	public void setSxhbj(int sxhbj){
		this.sxhbj = sxhbj;
	}
	public int getSxhbj(){
		return sxhbj;
	}
	public void setZt(String zt){
		this.zt = zt;
	}
	public String getZt(){
		return zt;
	}
	public void setSxsj(Date sxsj){
		this.sxsj = sxsj;
	}
	public Date getSxsj(){
		return sxsj;
	}
	public void setBz(String bz){
		this.bz = bz;
	}
	public String getBz(){
		return bz;
	}
}
