package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Insurance;
public class InsuranceDAO {
	/**
	* ����id��ѯ,����Insurance,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Insurance findById(int Iid) {
		String sql = "select * from Insurance where Iid=?";
		Object[] in = {Iid};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Insurance model = null;
		try {
			if(rs.next()) {
				model = new Insurance(
					rs.getInt("Iid"),
					rs.getInt("IStudentid"),
					rs.getString("IName"),
					rs.getDate("ITime"),
					rs.getString("IContent"),
					rs.getString("INote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Insurance>
	* @param id
	* @return
	*/
	public List<Insurance> findAll() {
		String sql = "select * from Insurance";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Insurance> modelList = new ArrayList<Insurance>();
		Insurance model = null;
		try {
			while(rs.next()) {
				model = new Insurance(
					rs.getInt("Iid"),
					rs.getInt("IStudentid"),
					rs.getString("IName"),
					rs.getDate("ITime"),
					rs.getString("IContent"),
					rs.getString("INote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Insurance>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Insurance> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by Iid desc) row FROM [Insurance]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Insurance> modelList = new ArrayList<Insurance>();
		Insurance model = null;
		try {
			while(rs.next()) {
				model = new Insurance(
					rs.getInt("Iid"),
					rs.getInt("IStudentid"),
					rs.getString("IName"),
					rs.getDate("ITime"),
					rs.getString("IContent"),
					rs.getString("INote"));
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
	public int insert(Insurance model) {
		String sql = "insert into Insurance values(?,?,?,?,?) ";
		Object[] in = {model.getIStudentid(),model.getIName(),model.getITime(),model.getIContent(),model.getINote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Insurance model) {
		String sql = "update Insurance set IStudentid=?,IName=?,ITime=?,IContent=?,INote=? where Iid=? ";
		Object[] in = {model.getIStudentid(),model.getIName(),model.getITime(),model.getIContent(),model.getINote(),model.getIid()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int Iid) {
		String sql = "delete from Insurance where Iid=? ";
		Object[] in = {Iid};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Insurance";
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
