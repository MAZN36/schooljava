package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Grade;
public class GradeDAO {
	/**
	* ����id��ѯ,����Grade,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Grade findById(int gId) {
		String sql = "select * from Grade where gId=?";
		Object[] in = {gId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Grade model = null;
		try {
			if(rs.next()) {
				model = new Grade(
					rs.getInt("gId"),
					rs.getString("gName"),
					rs.getString("gNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Grade>
	* @param id
	* @return
	*/
	public List<Grade> findAll() {
		String sql = "select * from Grade";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Grade> modelList = new ArrayList<Grade>();
		Grade model = null;
		try {
			while(rs.next()) {
				model = new Grade(
					rs.getInt("gId"),
					rs.getString("gName"),
					rs.getString("gNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Grade>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Grade> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by gId desc) row FROM [Grade]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Grade> modelList = new ArrayList<Grade>();
		Grade model = null;
		try {
			while(rs.next()) {
				model = new Grade(
					rs.getInt("gId"),
					rs.getString("gName"),
					rs.getString("gNote"));
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
	public int insert(Grade model) {
		String sql = "insert into Grade values(?,?) ";
		Object[] in = {model.getGName(),model.getGNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Grade model) {
		String sql = "update Grade set gName=?,gNote=? where gId=? ";
		Object[] in = {model.getGName(),model.getGNote(),model.getGId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int gId) {
		String sql = "delete from Grade where gId=? ";
		Object[] in = {gId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Grade";
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
