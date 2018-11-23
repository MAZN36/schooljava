package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_Talk;
public class Student_TalkDAO {
	/**
	* ����id��ѯ,����Student_Talk,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Student_Talk findById(int stu_id) {
		String sql = "select * from Student_Talk where stu_id=?";
		Object[] in = {stu_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Student_Talk model = null;
		try {
			if(rs.next()) {
				model = new Student_Talk(
					rs.getInt("stu_id"),
					rs.getInt("stu_Studentid"),
					rs.getDate("stu_Time"),
					rs.getString("stu_Content"),
					rs.getInt("stu_Operator"),
					rs.getString("stu_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Student_Talk>
	* @param id
	* @return
	*/
	public List<Student_Talk> findAll() {
		String sql = "select * from Student_Talk";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_Talk> modelList = new ArrayList<Student_Talk>();
		Student_Talk model = null;
		try {
			while(rs.next()) {
				model = new Student_Talk(
					rs.getInt("stu_id"),
					rs.getInt("stu_Studentid"),
					rs.getDate("stu_Time"),
					rs.getString("stu_Content"),
					rs.getInt("stu_Operator"),
					rs.getString("stu_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Student_Talk>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_Talk> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by stu_id desc) row FROM [Student_Talk]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_Talk> modelList = new ArrayList<Student_Talk>();
		Student_Talk model = null;
		try {
			while(rs.next()) {
				model = new Student_Talk(
					rs.getInt("stu_id"),
					rs.getInt("stu_Studentid"),
					rs.getDate("stu_Time"),
					rs.getString("stu_Content"),
					rs.getInt("stu_Operator"),
					rs.getString("stu_Note"));
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
	public int insert(Student_Talk model) {
		String sql = "insert into Student_Talk values(?,?,?,?,?) ";
		Object[] in = {model.getStu_Studentid(),model.getStu_Time(),model.getStu_Content(),model.getStu_Operator(),model.getStu_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_Talk model) {
		String sql = "update Student_Talk set stu_Studentid=?,stu_Time=?,stu_Content=?,stu_Operator=?,stu_Note=? where stu_id=? ";
		Object[] in = {model.getStu_Studentid(),model.getStu_Time(),model.getStu_Content(),model.getStu_Operator(),model.getStu_Note(),model.getStu_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int stu_id) {
		String sql = "delete from Student_Talk where stu_id=? ";
		Object[] in = {stu_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Student_Talk";
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
