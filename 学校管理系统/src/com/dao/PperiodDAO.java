package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Pperiod;
public class PperiodDAO {
	/**
	* ����id��ѯ,����Pperiod,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Pperiod findById(int pId) {
		String sql = "select * from Pperiod where pId=?";
		Object[] in = {pId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Pperiod model = null;
		try {
			if(rs.next()) {
				model = new Pperiod(
					rs.getInt("pId"),
					rs.getInt("pClasss"),
					rs.getInt("pCourse"),
					rs.getDate("pDate"),
					rs.getString("pNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Pperiod>
	* @param id
	* @return
	*/
	public List<Pperiod> findAll() {
		String sql = "select * from Pperiod p join Classs c on p.pClasss=c.cId join Course s on p.pCourse=s.course_id ";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Pperiod> modelList = new ArrayList<Pperiod>();
		Pperiod model = null;
		try {
			while(rs.next()) {
				model = new Pperiod(
						rs.getInt("pId"),
						rs.getInt("pClasss"),
						rs.getInt("pCourse"),
						rs.getDate("pDate"),
						rs.getString("pNote"),
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getInt("course_id"),
						rs.getString("course_name"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Pperiod>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Pperiod> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by pId desc) row FROM [Pperiod] p join Classs c on p.pClasss=c.cId join Course s on p.pCourse=s.course_id) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Pperiod> modelList = new ArrayList<Pperiod>();
		Pperiod model = null;
		try {
			while(rs.next()) {
				model = new Pperiod(
					rs.getInt("pId"),
					rs.getInt("pClasss"),
					rs.getInt("pCourse"),
					rs.getDate("pDate"),
					rs.getString("pNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("course_id"),
					rs.getString("course_name"));
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
	public int insert(Pperiod model) {
		String sql = "insert into Pperiod values(?,?,?,?) ";
		Object[] in = {model.getpClasss(),model.getpCourse(),model.getpDate(),model.getpNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Pperiod model) {
		String sql = "update Pperiod set pClasss=?,pCourse=?,pDate=?,pNote=? where pId=? ";
		Object[] in = {model.getpClasss(),model.getpCourse(),model.getpDate(),model.getpNote(),model.getpId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int pId) {
		String sql = "delete from Pperiod where pId=? ";
		Object[] in = {pId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Pperiod";
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
