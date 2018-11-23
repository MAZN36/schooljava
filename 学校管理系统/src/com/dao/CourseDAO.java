package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Course;
public class CourseDAO {
	/**
	* 根据id查询,返回Course,参数int id   根据id查询
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
	* 查询全部,返回List<Course>
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
	* 分页查询,返回List<Course>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Course> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
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
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Course model) {
		String sql = "insert into Course values(?,?,?,?) ";
		Object[] in = {model.getCourse_name(),model.getCourse_number(),model.getCourse_sum(),model.getCourse_note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Course model) {
		String sql = "update Course set course_name=?,course_number=?,course_sum=?,course_note=? where course_id=? ";
		Object[] in = {model.getCourse_name(),model.getCourse_number(),model.getCourse_sum(),model.getCourse_note(),model.getCourse_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int course_id) {
		String sql = "delete from Course where course_id=? ";
		Object[] in = {course_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
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
