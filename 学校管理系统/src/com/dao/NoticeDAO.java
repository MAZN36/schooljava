package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Notice;
public class NoticeDAO {
	/**
	* ����id��ѯ,����Notice,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Notice findById(int id) {
		String sql = "select * from Notice where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Notice model = null;
		try {
			if(rs.next()) {
				model = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("Reletime"),
					rs.getInt("Relepeople"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Notice>
	* @param id
	* @return
	*/
	public List<Notice> findAll() {
		String sql = "select * from Notice";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Notice> modelList = new ArrayList<Notice>();
		Notice model = null;
		try {
			while(rs.next()) {
				model = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("Reletime"),
					rs.getInt("Relepeople"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Notice>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Notice> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Notice]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Notice> modelList = new ArrayList<Notice>();
		Notice model = null;
		try {
			while(rs.next()) {
				model = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("Reletime"),
					rs.getInt("Relepeople"));
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
	public int insert(Notice model) {
		String sql = "insert into Notice(title,content,Relepeople) values(?,?,?) ";
		Object[] in = {model.getTitle(),model.getContent(),model.getRelepeople()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Notice model) {
		String sql = "update Notice set title=? where id=? ";
		Object[] in = {model.getTitle(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Notice where id=? ";
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
	String sql = "select count(*) from Notice";
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
