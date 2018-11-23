package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Attendance;
public class AttendanceDAO {
	/**
	* ����id��ѯ,����Attendance,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Attendance findById(int aId) {
		String sql = "select * from Attendance where aId=?";
		Object[] in = {aId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Attendance model = null;
		try {
			if(rs.next()) {
				model = new Attendance(
					rs.getInt("aId"),
					rs.getInt("aClasss"),
					rs.getInt("aStudentid"),
					rs.getDate("aDate"),
					rs.getString("aCourseName"),
					rs.getInt("aOperator"),
					rs.getString("aAttendanceType"),
					rs.getString("aNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Attendance>
	* @param id
	* @return
	*/
	public List<Attendance> findAll() {
		String sql = "select * from Attendance";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Attendance> modelList = new ArrayList<Attendance>();
		Attendance model = null;
		try {
			while(rs.next()) {
				model = new Attendance(
					rs.getInt("aId"),
					rs.getInt("aClasss"),
					rs.getInt("aStudentid"),
					rs.getDate("aDate"),
					rs.getString("aCourseName"),
					rs.getInt("aOperator"),
					rs.getString("aAttendanceType"),
					rs.getString("aNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Attendance>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Attendance> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by aId desc) row FROM [Attendance]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Attendance> modelList = new ArrayList<Attendance>();
		Attendance model = null;
		try {
			while(rs.next()) {
				model = new Attendance(
					rs.getInt("aId"),
					rs.getInt("aClasss"),
					rs.getInt("aStudentid"),
					rs.getDate("aDate"),
					rs.getString("aCourseName"),
					rs.getInt("aOperator"),
					rs.getString("aAttendanceType"),
					rs.getString("aNote"));
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
	public int insert(Attendance model) {
		String sql = "insert into Attendance values(?,?,?,?,?,?,?) ";
		Object[] in = {model.getAClasss(),model.getAStudentid(),model.getADate(),model.getACourseName(),model.getAOperator(),model.getAAttendanceType(),model.getANote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Attendance model) {
		String sql = "update Attendance set aClasss=?,aStudentid=?,aDate=?,aCourseName=?,aOperator=?,aAttendanceType=?,aNote=? where aId=? ";
		Object[] in = {model.getAClasss(),model.getAStudentid(),model.getADate(),model.getACourseName(),model.getAOperator(),model.getAAttendanceType(),model.getANote(),model.getAId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int aId) {
		String sql = "delete from Attendance where aId=? ";
		Object[] in = {aId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Attendance";
	ResultSet rs = DBUtil.executeQuery(sql);
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
