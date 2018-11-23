package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_Violate;
public class Student_ViolateDAO {
	/**
	* ����id��ѯ,����Student_Violate,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Student_Violate findById(int vio_id) {
		String sql = "select * from Student_Violate where vio_id=?";
		Object[] in = {vio_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Student_Violate model = null;
		try {
			if(rs.next()) {
				model = new Student_Violate(
					rs.getInt("vio_id"),
					rs.getInt("vio_Studentid"),
					rs.getDate("vio_Time"),
					rs.getString("vio_Content"),
					rs.getString("vio_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Student_Violate>
	* @param id
	* @return
	*/
	public List<Student_Violate> findAll() {
		String sql = "select * from Student_Violate";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_Violate> modelList = new ArrayList<Student_Violate>();
		Student_Violate model = null;
		try {
			while(rs.next()) {
				model = new Student_Violate(
					rs.getInt("vio_id"),
					rs.getInt("vio_Studentid"),
					rs.getDate("vio_Time"),
					rs.getString("vio_Content"),
					rs.getString("vio_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Student_Violate>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_Violate> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by vio_id desc) row FROM [Student_Violate]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_Violate> modelList = new ArrayList<Student_Violate>();
		Student_Violate model = null;
		try {
			while(rs.next()) {
				model = new Student_Violate(
					rs.getInt("vio_id"),
					rs.getInt("vio_Studentid"),
					rs.getDate("vio_Time"),
					rs.getString("vio_Content"),
					rs.getString("vio_Note"));
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
	public int insert(Student_Violate model) {
		String sql = "insert into Student_Violate values(?,?,?,?) ";
		Object[] in = {model.getVio_Studentid(),model.getVio_Time(),model.getVio_Content(),model.getVio_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_Violate model) {
		String sql = "update Student_Violate set vio_Studentid=?,vio_Time=?,vio_Content=?,vio_Note=? where vio_id=? ";
		Object[] in = {model.getVio_Studentid(),model.getVio_Time(),model.getVio_Content(),model.getVio_Note(),model.getVio_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int vio_id) {
		String sql = "delete from Student_Violate where vio_id=? ";
		Object[] in = {vio_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Student_Violate";
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
