package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Worktime;
public class WorktimeDAO {
	/**
	* ����id��ѯ,����Worktime,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Worktime findById(int id) {
		String sql = "select * from Worktime where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Worktime model = null;
		try {
			if(rs.next()) {
				model = new Worktime(
					rs.getInt("id"),
					rs.getInt("Serial"),
					rs.getString("interval"),
					rs.getString("section"),
					rs.getString("wtime"),
					rs.getString("wNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Worktime>
	* @param id
	* @return
	*/
	public List<Worktime> findAll() {
		String sql = "select * from Worktime";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Worktime> modelList = new ArrayList<Worktime>();
		Worktime model = null;
		try {
			while(rs.next()) {
				model = new Worktime(
					rs.getInt("id"),
					rs.getInt("Serial"),
					rs.getString("interval"),
					rs.getString("section"),
					rs.getString("wtime"),
					rs.getString("wNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Worktime>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Worktime> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Worktime]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Worktime> modelList = new ArrayList<Worktime>();
		Worktime model = null;
		try {
			while(rs.next()) {
				model = new Worktime(
					rs.getInt("id"),
					rs.getInt("Serial"),
					rs.getString("interval"),
					rs.getString("section"),
					rs.getString("wtime"),
					rs.getString("wNote"));
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
	public int insert(Worktime model) {
		String sql = "insert into Worktime values(?,?,?,?,?) ";
		Object[] in = {model.getSerial(),model.getInterval(),model.getSection(),model.getWtime(),model.getWNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Worktime model) {
		String sql = "update Worktime set Serial=?,interval=?,section=?,wtime=?,wNote=? where id=? ";
		Object[] in = {model.getSerial(),model.getInterval(),model.getSection(),model.getWtime(),model.getWNote(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Worktime where id=? ";
		Object[] in = {id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Worktime";
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
