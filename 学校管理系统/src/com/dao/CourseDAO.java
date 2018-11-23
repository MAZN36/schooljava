package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Course;
public class CourseDAO {
	/**
	* ����id��ѯ,����Course,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Course findById(int course_id) {
		String sql = "select * from Course where course_id=?";
		Object[] in = {course_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Course model = null;
		try {
			if(rs.next()) {
				model = new Course(
					rs.getInt("course_id"),
					rs.getString("course_name"),
					rs.getInt("course_number"),
					rs.getInt("course_sum"),
					rs.getString("course_note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Course>
	* @param id
	* @return
	*/
	public List<Course> findAll() {
		String sql = "select * from Course";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Course> modelList = new ArrayList<Course>();
		Course model = null;
		try {
			while(rs.next()) {
				model = new Course(
					rs.getInt("course_id"),
					rs.getString("course_name"),
					rs.getInt("course_number"),
					rs.getInt("course_sum"),
					rs.getString("course_note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Course>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Course> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by course_id desc) row FROM [Course]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Course> modelList = new ArrayList<Course>();
		Course model = null;
		try {
			while(rs.next()) {
				model = new Course(
					rs.getInt("course_id"),
					rs.getString("course_name"),
					rs.getInt("course_number"),
					rs.getInt("course_sum"),
					rs.getString("course_note"));
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
	public int insert(Course model) {
		String sql = "insert into Course values(?,?,?,?) ";
		Object[] in = {model.getCourse_name(),model.getCourse_number(),model.getCourse_sum(),model.getCourse_note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Course model) {
		String sql = "update Course set course_name=?,course_number=?,course_sum=?,course_note=? where course_id=? ";
		Object[] in = {model.getCourse_name(),model.getCourse_number(),model.getCourse_sum(),model.getCourse_note(),model.getCourse_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int course_id) {
		String sql = "delete from Course where course_id=? ";
		Object[] in = {course_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Course";
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
