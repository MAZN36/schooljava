package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Archives_check;
public class Archives_checkDAO {
	/**
	* ����id��ѯ,����Archives_check,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Archives_check findById(int arc_id) {
		String sql = "select * from Archives_check where arc_id=?";
		Object[] in = {arc_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Archives_check model = null;
		try {
			if(rs.next()) {
				model = new Archives_check(
					rs.getInt("arc_id"),
					rs.getInt("arc_Classs"),
					rs.getInt("arc_Studentid"),
					rs.getString("arc_Content"),
					rs.getString("arc_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Archives_check>
	* @param id
	* @return
	*/
	public List<Archives_check> findAll() {
		String sql = "select * from Archives_check";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Archives_check> modelList = new ArrayList<Archives_check>();
		Archives_check model = null;
		try {
			while(rs.next()) {
				model = new Archives_check(
					rs.getInt("arc_id"),
					rs.getInt("arc_Classs"),
					rs.getInt("arc_Studentid"),
					rs.getString("arc_Content"),
					rs.getString("arc_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Archives_check>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Archives_check> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by arc_id desc) row FROM [Archives_check]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Archives_check> modelList = new ArrayList<Archives_check>();
		Archives_check model = null;
		try {
			while(rs.next()) {
				model = new Archives_check(
					rs.getInt("arc_id"),
					rs.getInt("arc_Classs"),
					rs.getInt("arc_Studentid"),
					rs.getString("arc_Content"),
					rs.getString("arc_Note"));
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
	public int insert(Archives_check model) {
		String sql = "insert into Archives_check values(?,?,?,?) ";
		Object[] in = {model.getArc_Classs(),model.getArc_Studentid(),model.getArc_Content(),model.getArc_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Archives_check model) {
		String sql = "update Archives_check set arc_Classs=?,arc_Studentid=?,arc_Content=?,arc_Note=? where arc_id=? ";
		Object[] in = {model.getArc_Classs(),model.getArc_Studentid(),model.getArc_Content(),model.getArc_Note(),model.getArc_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int arc_id) {
		String sql = "delete from Archives_check where arc_id=? ";
		Object[] in = {arc_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Archives_check";
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
