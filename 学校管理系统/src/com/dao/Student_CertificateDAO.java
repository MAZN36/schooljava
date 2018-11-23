package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_Certificate;
public class Student_CertificateDAO {
	/**
	* ����id��ѯ,����Student_Certificate,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Student_Certificate findById(int cer_id) {
		String sql = "select * from Student_Certificate where cer_id=?";
		Object[] in = {cer_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Student_Certificate model = null;
		try {
			if(rs.next()) {
				model = new Student_Certificate(
					rs.getInt("cer_id"),
					rs.getInt("cer_Studentid"),
					rs.getDate("cer_Time"),
					rs.getDate("cer_Read"),
					rs.getString("cer_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Student_Certificate>
	* @param id
	* @return
	*/
	public List<Student_Certificate> findAll() {
		String sql = "select * from Student_Certificate";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_Certificate> modelList = new ArrayList<Student_Certificate>();
		Student_Certificate model = null;
		try {
			while(rs.next()) {
				model = new Student_Certificate(
					rs.getInt("cer_id"),
					rs.getInt("cer_Studentid"),
					rs.getDate("cer_Time"),
					rs.getDate("cer_Read"),
					rs.getString("cer_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Student_Certificate>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_Certificate> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by cer_id desc) row FROM [Student_Certificate]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_Certificate> modelList = new ArrayList<Student_Certificate>();
		Student_Certificate model = null;
		try {
			while(rs.next()) {
				model = new Student_Certificate(
					rs.getInt("cer_id"),
					rs.getInt("cer_Studentid"),
					rs.getDate("cer_Time"),
					rs.getDate("cer_Read"),
					rs.getString("cer_Note"));
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
	public int insert(Student_Certificate model) {
		String sql = "insert into Student_Certificate values(?,?,?,?) ";
		Object[] in = {model.getCer_Studentid(),model.getCer_Time(),model.getCer_Read(),model.getCer_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_Certificate model) {
		String sql = "update Student_Certificate set cer_Studentid=?,cer_Time=?,cer_Read=?,cer_Note=? where cer_id=? ";
		Object[] in = {model.getCer_Studentid(),model.getCer_Time(),model.getCer_Read(),model.getCer_Note(),model.getCer_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int cer_id) {
		String sql = "delete from Student_Certificate where cer_id=? ";
		Object[] in = {cer_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Student_Certificate";
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
