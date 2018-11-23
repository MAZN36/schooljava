package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_Violate;
public class Student_ViolateDAO {
	/**
	* 根据id查询,返回Student_Violate,参数int id   根据id查询
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
	* 查询全部,返回List<Student_Violate>
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
	* 分页查询,返回List<Student_Violate>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Student_Violate> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
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
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Student_Violate model) {
		String sql = "insert into Student_Violate values(?,?,?,?) ";
		Object[] in = {model.getVio_Studentid(),model.getVio_Time(),model.getVio_Content(),model.getVio_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Student_Violate model) {
		String sql = "update Student_Violate set vio_Studentid=?,vio_Time=?,vio_Content=?,vio_Note=? where vio_id=? ";
		Object[] in = {model.getVio_Studentid(),model.getVio_Time(),model.getVio_Content(),model.getVio_Note(),model.getVio_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int vio_id) {
		String sql = "delete from Student_Violate where vio_id=? ";
		Object[] in = {vio_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
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
