package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Bf;
public class BfDAO {
	/**
	* ����id��ѯ,����Bf,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Bf findById(int id) {
		String sql = "select * from Bf where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Bf model = null;
		try {
			if(rs.next()) {
				model = new Bf(
					rs.getInt("id"),
					rs.getDate("bfsj"),
					rs.getString("bflq"),
					rs.getDate("hysj"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Bf>
	* @param id
	* @return
	*/
	public List<Bf> findAll() {
		String sql = "select * from Bf";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Bf> modelList = new ArrayList<Bf>();
		Bf model = null;
		try {
			while(rs.next()) {
				model = new Bf(
					rs.getInt("id"),
					rs.getDate("bfsj"),
					rs.getString("bflq"),
					rs.getDate("hysj"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Bf>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Bf> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Bf]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Bf> modelList = new ArrayList<Bf>();
		Bf model = null;
		try {
			while(rs.next()) {
				model = new Bf(
					rs.getInt("id"),
					rs.getDate("bfsj"),
					rs.getString("bflq"),
					rs.getDate("hysj"));
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
	public int insert(Bf model) {
		String sql = "insert into Bf(bflq) values(?) ";
		Object[] in = {model.getBflq()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Bf model) {
		String sql = "update Bf set hysj=getdate() where id=? ";
		Object[] in = {model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Bf where id=? ";
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
	String sql = "select count(*) from Bf";
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
