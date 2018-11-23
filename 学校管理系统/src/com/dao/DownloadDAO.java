package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Download;
public class DownloadDAO {
	/**
	* ����id��ѯ,����Download,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Download findById(int id) {
		String sql = "select * from Download where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Download model = null;
		try {
			if(rs.next()) {
				model = new Download(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getDate("Reletime"),
					rs.getString("link"),
					rs.getInt("Relepeople"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Download>
	* @param id
	* @return
	*/
	public List<Download> findAll() {
		String sql = "select * from Download";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Download> modelList = new ArrayList<Download>();
		Download model = null;
		try {
			while(rs.next()) {
				model = new Download(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getDate("Reletime"),
					rs.getString("link"),
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
	* ��ҳ��ѯ,����List<Download>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Download> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Download]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Download> modelList = new ArrayList<Download>();
		Download model = null;
		try {
			while(rs.next()) {
				model = new Download(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getDate("Reletime"),
					rs.getString("link"),
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
	public int insert(Download model) {
		String sql = "insert into download(id,title,link,Relepeople) values(?,?,?,?) ";
		Object[] in = {model.getId(),model.getTitle(),model.getLink(),model.getRelepeople()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Download model) {
		String sql = "update Download set title=? where id=? ";
		Object[] in = {model.getTitle(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Download where id=? ";
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
	String sql = "select count(*) from Download";
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
