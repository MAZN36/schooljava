package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_Talk;
public class Student_TalkDAO {
	/**
	* 根据id查询,返回Student_Talk,参数int id   根据id查询
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
	* 查询全部,返回List<Student_Talk>
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
	* 分页查询,返回List<Student_Talk>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Student_Talk> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
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
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Student_Talk model) {
		String sql = "insert into Student_Talk values(?,?,?,?,?) ";
		Object[] in = {model.getStu_Studentid(),model.getStu_Time(),model.getStu_Content(),model.getStu_Operator(),model.getStu_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Student_Talk model) {
		String sql = "update Student_Talk set stu_Studentid=?,stu_Time=?,stu_Content=?,stu_Operator=?,stu_Note=? where stu_id=? ";
		Object[] in = {model.getStu_Studentid(),model.getStu_Time(),model.getStu_Content(),model.getStu_Operator(),model.getStu_Note(),model.getStu_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int stu_id) {
		String sql = "delete from Student_Talk where stu_id=? ";
		Object[] in = {stu_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
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
