package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Teacher;
public class TeacherDAO {
	/**
	* ����id��ѯ,����Teacher,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Teacher findById(int tid) {
		String sql = "select * from Teacher t join Position p on t.tPosition=p.pid where tid=?";
		Object[] in = {tid};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Teacher model = null;
		try {
			if(rs.next()) {
				model = new Teacher(
					rs.getInt("tid"),
					rs.getString("tJNumber"),
					rs.getString("tName"),
					rs.getString("tsex"),
					rs.getDate("tBirthday"),
					rs.getInt("tPosition"),
					rs.getString("tTelephone"),
					rs.getString("tPassword"),
					rs.getString("tNation"),
					rs.getString("tPolitical"),
					rs.getString("tid_card"),
					rs.getString("tEducation"),
					rs.getString("tHome"),
					rs.getString("tNative"),
					rs.getString("img"),
					rs.getString("tContent"),
					rs.getString("tState"),
					rs.getString("tNote"),
					rs.getString("pName"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public int bdmm(String user,String password){
		int c=0;
		String sql="select count(*) from Teacher where tJNumber=? and tPassword=? and tState='��ְ'";
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
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public int bdsf(String user,String password){
		int c=0;
		String sql="select tPosition from Teacher where tJNumber=? and tPassword=? and tState='��ְ'";
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
	* ���ֲ�ѯȫ��,����List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(String selectsname,String zw) {
		String sql = "select * from Teacher t join Position p on t.tPosition=p.pid where tState=? and tName like '%"+selectsname+"%'";
		Object [] in={ zw};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Teacher> modelList = new ArrayList<Teacher>();
		Teacher model = null;
		try {
			while(rs.next()) {
				model = new Teacher(
					rs.getInt("tid"),
					rs.getString("tJNumber"),
					rs.getString("tName"),
					rs.getString("tsex"),
					rs.getDate("tBirthday"),
					rs.getInt("tPosition"),
					rs.getString("tTelephone"),
					rs.getString("tPassword"),
					rs.getString("tNation"),
					rs.getString("tPolitical"),
					rs.getString("tid_card"),
					rs.getString("tEducation"),
					rs.getString("tHome"),
					rs.getString("tNative"),
					rs.getString("img"),
					rs.getString("tContent"),
					rs.getString("tState"),
					rs.getString("tNote"),
					rs.getString("pName"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ְλ��ѯȫ��,����List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(int tPosition,String zw) {
		String sql = "select * from Teacher t join Position p on t.tPosition=p.pid where tPosition=? and tState=?";
		Object []in={tPosition,zw};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Teacher> modelList = new ArrayList<Teacher>();
		Teacher model = null;
		try {
			while(rs.next()) {
				model = new Teacher(
					rs.getInt("tid"),
					rs.getString("tJNumber"),
					rs.getString("tName"),
					rs.getString("tsex"),
					rs.getDate("tBirthday"),
					rs.getInt("tPosition"),
					rs.getString("tTelephone"),
					rs.getString("tPassword"),
					rs.getString("tNation"),
					rs.getString("tPolitical"),
					rs.getString("tid_card"),
					rs.getString("tEducation"),
					rs.getString("tHome"),
					rs.getString("tNative"),
					rs.getString("img"),
					rs.getString("tContent"),
					rs.getString("tState"),
					rs.getString("tNote"),
					rs.getString("pName"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ѯȫ��,����List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(String zt) {
		String sql = "select * from Teacher t join Position p on t.tPosition=p.pid where tState=?";
		Object []in={zt};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Teacher> modelList = new ArrayList<Teacher>();
		Teacher model = null;
		try {
			while(rs.next()) {
				model = new Teacher(
					rs.getInt("tid"),
					rs.getString("tJNumber"),
					rs.getString("tName"),
					rs.getString("tsex"),
					rs.getDate("tBirthday"),
					rs.getInt("tPosition"),
					rs.getString("tTelephone"),
					rs.getString("tPassword"),
					rs.getString("tNation"),
					rs.getString("tPolitical"),
					rs.getString("tid_card"),
					rs.getString("tEducation"),
					rs.getString("tHome"),
					rs.getString("tNative"),
					rs.getString("img"),
					rs.getString("tContent"),
					rs.getString("tState"),
					rs.getString("tNote"),
					rs.getString("pName"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Teacher>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Teacher> Paging(int page,int limit,String zt) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by tid desc) row FROM [Teacher] t join Position p on t.tPosition=p.pid where tState=? ) t where t.row>="+start+" and t.row<="+end;
		Object[]in={zt};
	ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Teacher> modelList = new ArrayList<Teacher>();
		Teacher model = null;
		try {
			while(rs.next()) {
				model = new Teacher(
					rs.getInt("tid"),
					rs.getString("tJNumber"),
					rs.getString("tName"),
					rs.getString("tsex"),
					rs.getDate("tBirthday"),
					rs.getInt("tPosition"),
					rs.getString("tTelephone"),
					rs.getString("tPassword"),
					rs.getString("tNation"),
					rs.getString("tPolitical"),
					rs.getString("tid_card"),
					rs.getString("tEducation"),
					rs.getString("tHome"),
					rs.getString("tNative"),
					rs.getString("img"),
					rs.getString("tContent"),
					rs.getString("tState"),
					rs.getString("tNote"),
					rs.getString("pName"));
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
	public int insert(Teacher model) {
		String sql = "insert into Teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		Object[] in = {model.getTJNumber(),model.getTName(),model.getTsex(),model.getTBirthday(),model.getTPosition(),model.getTTelephone(),model.getTPassword(),model.getTNation(),model.getTPolitical(),model.getTid_card(),model.getTEducation(),model.getTHome(),model.getTNative(),model.getImg(),model.getTContent(),model.getSState(),model.getTNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Teacher model) {
		String sql = "update Teacher set tJNumber=?,tName=?,tsex=?,tBirthday=?,tPosition=?,tTelephone=?,tPassword=?,tNation=?,tPolitical=?,tid_card=?,tEducation=?,tHome=?,tNative=?,img=?,tContent=?,tState=?,tNote=? where tid=? ";
		Object[] in = {model.getTJNumber(),model.getTName(),model.getTsex(),model.getTBirthday(),model.getTPosition(),model.getTTelephone(),model.getTPassword(),model.getTNation(),model.getTPolitical(),model.getTid_card(),model.getTEducation(),model.getTHome(),model.getTNative(),model.getImg(),model.getTContent(),model.getSState(),model.getTNote(),model.getTid()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸����뷽��,
	* @param model
	* @return
	*/
	public int updatepa(Teacher model) {
		String sql = "update Teacher set tPassword=? where tJNumber=? ";
		Object[] in = {model.getTPassword(),model.getTJNumber()};
		return DBUtil.executeUpdate(sql, in);
	}
	
	
	/**
	* �޸�ְλ����
	* @param id
	* @return
	*/
	public int update(int tid,String zt) {
		String sql = "update Teacher set tState=? where tid=? ";
		Object[] in = {zt,tid};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(String zt){
	int count=0;
	String sql = "select count(*) from Teacher where tState=?";
	Object[]in={zt};
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
