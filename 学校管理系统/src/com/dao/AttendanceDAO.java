package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Attendance;
public class AttendanceDAO {
	/**
	* 根据id查询,返回Attendance,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Attendance findById(int aId) {
		String sql = "select * from Attendance where aId=?";
		Object[] in = {aId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Attendance model = null;
		try {
			if(rs.next()) {
				model = new Attendance(
					rs.getInt("aId"),
					rs.getInt("aClasss"),
					rs.getInt("aStudentid"),
					rs.getDate("aDate"),
					rs.getString("aCourseName"),
					rs.getInt("aOperator"),
					rs.getString("aAttendanceType"),
					rs.getString("aNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Attendance>
	* @param id
	* @return
	*/
	public List<Attendance> findAll() {
		String sql = "select * from Attendance";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Attendance> modelList = new ArrayList<Attendance>();
		Attendance model = null;
		try {
			while(rs.next()) {
				model = new Attendance(
					rs.getInt("aId"),
					rs.getInt("aClasss"),
					rs.getInt("aStudentid"),
					rs.getDate("aDate"),
					rs.getString("aCourseName"),
					rs.getInt("aOperator"),
					rs.getString("aAttendanceType"),
					rs.getString("aNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Attendance>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Attendance> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by aId desc) row FROM [Attendance]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Attendance> modelList = new ArrayList<Attendance>();
		Attendance model = null;
		try {
			while(rs.next()) {
				model = new Attendance(
					rs.getInt("aId"),
					rs.getInt("aClasss"),
					rs.getInt("aStudentid"),
					rs.getDate("aDate"),
					rs.getString("aCourseName"),
					rs.getInt("aOperator"),
					rs.getString("aAttendanceType"),
					rs.getString("aNote"));
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
	public int insert(Attendance model) {
		String sql = "insert into Attendance values(?,?,?,?,?,?,?) ";
		Object[] in = {model.getAClasss(),model.getAStudentid(),model.getADate(),model.getACourseName(),model.getAOperator(),model.getAAttendanceType(),model.getANote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Attendance model) {
		String sql = "update Attendance set aClasss=?,aStudentid=?,aDate=?,aCourseName=?,aOperator=?,aAttendanceType=?,aNote=? where aId=? ";
		Object[] in = {model.getAClasss(),model.getAStudentid(),model.getADate(),model.getACourseName(),model.getAOperator(),model.getAAttendanceType(),model.getANote(),model.getAId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int aId) {
		String sql = "delete from Attendance where aId=? ";
		Object[] in = {aId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Attendance";
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
