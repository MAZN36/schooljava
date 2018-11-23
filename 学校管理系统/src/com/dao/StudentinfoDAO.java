package	com.dao;
import java.sql.*;
import java.util.*;
import java.util.Date;

import com.vo.Studentinfo;
public class StudentinfoDAO {
	/**
	* ����id��ѯ,����Studentinfo,����int Studentid   ����Studentidѧ�Ų�ѯ
	* @param id
	* @return
	*/
	public Studentinfo findById(String zt,int Studentid) {
		String sql = "select * from [Studentinfo] s join Classs c on s.sclasss=c.cId where sstate=? and Studentid=?";
		Object[] in = {zt,Studentid};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Studentinfo model = null;
		try {
			if(rs.next()) {
				model = new Studentinfo(
						rs.getInt("stuId"),
						rs.getString("Studentid"),
						rs.getInt("sClasss"),
						rs.getString("sName"),
						rs.getString("sSex"),
					rs.getString("sNational"),
					rs.getDate("sDate"),
					rs.getString("sCard"),
					rs.getString("sNativeplace"),
					rs.getString("sAddress"),
					rs.getString("sPassword"),
					rs.getString("sParentsName"),
					rs.getString("sParentsNumber"),
					rs.getString("sFace"),
					rs.getString("sNumber"),
					rs.getDate("sEntranceDate"),
					rs.getString("sQQ"),
					rs.getString("sPicture"),
					rs.getString("sState"),
					rs.getString("sNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("cTypeName"),
					rs.getString("cGraduated"),
					rs.getDate("cGtime"),
					rs.getString("cGstate"),
					rs.getString("cNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	* ����
	* @param id
	* @return
	*/
	public List<Studentinfo> sxId(int stuId) {
		String sql = "select stuId from Studentinfo where sclasss=?";
		Object[] in = {stuId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		List<Studentinfo> list=new ArrayList<Studentinfo>();
		Studentinfo model = null;
		try {
			while(rs.next()) {
				model = new Studentinfo(rs.getInt("stuId"));
				list.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	* ����
	* @param id
	* @return
	*/
	public int updasc(int xgq,int xgh,String sstate) {
		System.out.println(xgq+"------"+xgh+"-----------"+sstate);
		
		String sql = "update  Studentinfo set sclasss=?,sstate=? where sclasss=?";
		Object[] in = {xgh,sstate,xgq};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ���ݰ༶��ѯȫ��,����List<Studentinfo>
	* @param id
	* @return
	*/
	public List<Studentinfo> findAllsclasss(int sclasss,String zt) {
		String sql = "select * from(SELECT *,ROW_NUMBER() over(order by stuId desc) row FROM [Studentinfo] s join Classs c on s.sclasss=c.cId) t where sstate=? and  sclasss="+sclasss;
		Object[]in={zt};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Studentinfo> modelList = new ArrayList<Studentinfo>();
		Studentinfo model = null;
		try {
			while(rs.next()) {
				model = new Studentinfo(
						rs.getInt("stuId"),
						rs.getString("Studentid"),
						rs.getInt("sClasss"),
						rs.getString("sName"),
						rs.getString("sSex"),
					rs.getString("sNational"),
					rs.getDate("sDate"),
					rs.getString("sCard"),
					rs.getString("sNativeplace"),
					rs.getString("sAddress"),
					rs.getString("sPassword"),
					rs.getString("sParentsName"),
					rs.getString("sParentsNumber"),
					rs.getString("sFace"),
					rs.getString("sNumber"),
					rs.getDate("sEntranceDate"),
					rs.getString("sQQ"),
					rs.getString("sPicture"),
					rs.getString("sState"),
					rs.getString("sNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("cTypeName"),
					rs.getString("cGraduated"),
					rs.getDate("cGtime"),
					rs.getString("cGstate"),
					rs.getString("cNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public int bdmm(String user,String password){
		int c=0;
		String sql="select count(*) from Studentinfo where studentid=? and spassword=? and sstate='�ڶ�'";
		Object []in={user,DBUtil.MD5(password)};
		ResultSet rs=DBUtil.executeQuery(sql,in);
		try {
			if(rs.next())
			{
				c=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	/**
	* ��ѯȫ��,����List<Studentinfo>
	* @param id
	* @return
	*/
	public List<Studentinfo> findAll(int sclasss,String zt) {
		String sql = "select * from Studentinfo s join Classs c on s.sclasss=c.cId where sstate=? and sclasss=?";
		Object [] in={zt,sclasss};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Studentinfo> modelList = new ArrayList<Studentinfo>();
		Studentinfo model = null;
		try {
			while(rs.next()) {
				
				model = new Studentinfo(
						rs.getInt("stuId"),
						rs.getString("Studentid"),
						rs.getInt("sClasss"),
						rs.getString("sName"),
						rs.getString("sSex"),
					rs.getString("sNational"),
					rs.getDate("sDate"),
					rs.getString("sCard"),
					rs.getString("sNativeplace"),
					rs.getString("sAddress"),
					rs.getString("sPassword"),
					rs.getString("sParentsName"),
					rs.getString("sParentsNumber"),
					rs.getString("sFace"),
					rs.getString("sNumber"),
					rs.getDate("sEntranceDate"),
					rs.getString("sQQ"),
					rs.getString("sPicture"),
					rs.getString("sState"),
					rs.getString("sNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("cTypeName"),
					rs.getString("cGraduated"),
					rs.getDate("cGtime"),
					rs.getString("cGstate"),
					rs.getString("cNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ѯȫ��,����List<Studentinfo>
	* @param id
	* @return
	*/
	public List<Studentinfo> findAll(String zt) {
		String sql = "select * from Studentinfo s join Classs c on s.sclasss=c.cId where sstate=? ";
		Object []in={ zt};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Studentinfo> modelList = new ArrayList<Studentinfo>();
		Studentinfo model = null;
		try {
			while(rs.next()) {
				
				model = new Studentinfo(
						rs.getInt("stuId"),
						rs.getString("Studentid"),
						rs.getInt("sClasss"),
						rs.getString("sName"),
						rs.getString("sSex"),
					rs.getString("sNational"),
					rs.getDate("sDate"),
					rs.getString("sCard"),
					rs.getString("sNativeplace"),
					rs.getString("sAddress"),
					rs.getString("sPassword"),
					rs.getString("sParentsName"),
					rs.getString("sParentsNumber"),
					rs.getString("sFace"),
					rs.getString("sNumber"),
					rs.getDate("sEntranceDate"),
					rs.getString("sQQ"),
					rs.getString("sPicture"),
					rs.getString("sState"),
					rs.getString("sNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("cTypeName"),
					rs.getString("cGraduated"),
					rs.getDate("cGtime"),
					rs.getString("cGstate"),
					rs.getString("cNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Studentinfo>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Studentinfo> Paging(int page,int limit,String zt) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by stuId desc) row FROM [Studentinfo] s join Classs c on s.sclasss=c.cId) t where sstate=? and t.row>="+start+" and t.row<="+end;
		Object []in={ zt};
	ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Studentinfo> modelList = new ArrayList<Studentinfo>();
		Studentinfo model = null;
		try {
			while(rs.next()) {
				model = new Studentinfo(
						rs.getInt("stuId"),
						rs.getString("Studentid"),
						rs.getInt("sClasss"),
						rs.getString("sName"),
						rs.getString("sSex"),
					rs.getString("sNational"),
					rs.getDate("sDate"),
					rs.getString("sCard"),
					rs.getString("sNativeplace"),
					rs.getString("sAddress"),
					rs.getString("sPassword"),
					rs.getString("sParentsName"),
					rs.getString("sParentsNumber"),
					rs.getString("sFace"),
					rs.getString("sNumber"),
					rs.getDate("sEntranceDate"),
					rs.getString("sQQ"),
					rs.getString("sPicture"),
					rs.getString("sState"),
					rs.getString("sNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("cTypeName"),
					rs.getString("cGraduated"),
					rs.getDate("cGtime"),
					rs.getString("cGstate"),
					rs.getString("cNote")
						);
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	
	/**
	* ��ҳ��ѯ,����List<Studentinfo>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Studentinfo> Paging(String sname,String zt) {
	
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by stuId desc) row FROM [Studentinfo] s join Classs c on s.sclasss=c.cId) t where sstate=? and  sname  like '%"+sname+"%'";
		Object [] in={zt};
	ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Studentinfo> modelList = new ArrayList<Studentinfo>();
		Studentinfo model = null;
		try {
			while(rs.next()) {
				model = new Studentinfo(
						rs.getInt("stuId"),
						rs.getString("Studentid"),
						rs.getInt("sClasss"),
						rs.getString("sName"),
						rs.getString("sSex"),
					rs.getString("sNational"),
					rs.getDate("sDate"),
					rs.getString("sCard"),
					rs.getString("sNativeplace"),
					rs.getString("sAddress"),
					rs.getString("sPassword"),
					rs.getString("sParentsName"),
					rs.getString("sParentsNumber"),
					rs.getString("sFace"),
					rs.getString("sNumber"),
					rs.getDate("sEntranceDate"),
					rs.getString("sQQ"),
					rs.getString("sPicture"),
					rs.getString("sState"),
					rs.getString("sNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("cTypeName"),
					rs.getString("cGraduated"),
					rs.getDate("cGtime"),
					rs.getString("cGstate"),
					rs.getString("cNote")
					);
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Studentinfo model) {
		String sql = "insert into Studentinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		Object[] in = {model.getStudentid(),model.getSClasss(),model.getSName(),model.getSSex(),model.getSNational(),model.getSDate(),model.getSCard(),model.getSNativeplace(),model.getSAddress(),model.getSPassword(),model.getSParentsName(),model.getSParentsNumber(),model.getSFace(),model.getSNumber(),model.getSEntranceDate(),model.getSQQ(),model.getSPicture(),model.getSState(),model.getSNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* תѧ����
	* @param
	* @return
	*/
	public int upzx(String xh,String bz) {
		String sql = "update Studentinfo set sstate=?,snote=? where Studentid=?";
		Object[] in = {"��ҵ",bz,xh};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Studentinfo model) {
		String sql = "update Studentinfo set Studentid=?,sClasss=?,sName=?,sSex=?,sNational=?,sDate=?,sCard=?,sNativeplace=?,sAddress=?,sPassword=?,sParentsName=?,sParentsNumber=?,sFace=?,sNumber=?,sEntranceDate=?,sQQ=?,sPicture=?,sState=?,sNote=? where stuId=? ";
		Object[] in = {model.getStudentid(),model.getSClasss(),model.getSName(),model.getSSex(),model.getSNational(),model.getSDate(),model.getSCard(),model.getSNativeplace(),model.getSAddress(),model.getSPassword(),model.getSParentsName(),model.getSParentsNumber(),model.getSFace(),model.getSNumber(),model.getSEntranceDate(),model.getSQQ(),model.getSPicture(),model.getSState(),model.getSNote(),model.getStuId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int updatepa(Studentinfo model) {
		String sql = "update Studentinfo set sPassword=? where Studentid=? ";
		Object[] in = {model.getSPassword(),model.getStudentid()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(String Studentid) {
		String sql = "delete from Studentinfo where Studentid=?";
		Object[] in = {Studentid};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(String zt){
	int count=0;
	String sql = "select count(*) from Studentinfo where sstate=?";
	Object [] in={zt};
	ResultSet rs = DBUtil.executeQuery(sql,in);
	try {
		while(rs.next()) {
			count=rs.getInt(1);
		}
		DBUtil.close(rs);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return count;
	}	
	/**
	* ����������ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcountsname(String sname,String zt){
	int count=0;
	String sql = "select count(*) from Studentinfo where sname=? and sstate=?";
	Object [] in={sname,zt};
	ResultSet rs = DBUtil.executeQuery(sql,in);
	try {
		while(rs.next()) {
			count=rs.getInt(1);
		}
		DBUtil.close(rs);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return count;
	}	
	/**
	* ���ݰ༶��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcountsclasss(int sclasss,String zt){
	int count=0;
	String sql = "select count(*) from Studentinfo where sclasss=? and sstate=?";
	Object [] in={sclasss,zt};
	ResultSet rs = DBUtil.executeQuery(sql,in);
	try {
		while(rs.next()) {
			count=rs.getInt(1);
		}
		DBUtil.close(rs);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return count;
	}	
}
