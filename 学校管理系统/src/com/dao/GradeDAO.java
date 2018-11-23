package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Grade;
public class GradeDAO {
	/**
	* 根据id查询,返回Grade,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Grade findById(int gId) {
		String sql = "select * from Grade where gId=?";
		Object[] in = {gId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Grade model = null;
		try {
			if(rs.next()) {
				model = new Grade(
					rs.getInt("gId"),
					rs.getString("gName"),
					rs.getString("gNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Grade>
	* @param id
	* @return
	*/
	public List<Grade> findAll() {
		String sql = "select * from Grade";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Grade> modelList = new ArrayList<Grade>();
		Grade model = null;
		try {
			while(rs.next()) {
				model = new Grade(
					rs.getInt("gId"),
					rs.getString("gName"),
					rs.getString("gNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Grade>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Grade> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by gId desc) row FROM [Grade]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Grade> modelList = new ArrayList<Grade>();
		Grade model = null;
		try {
			while(rs.next()) {
				model = new Grade(
					rs.getInt("gId"),
					rs.getString("gName"),
					rs.getString("gNote"));
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
	public int insert(Grade model) {
		String sql = "insert into Grade values(?,?) ";
		Object[] in = {model.getGName(),model.getGNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Grade model) {
		String sql = "update Grade set gName=?,gNote=? where gId=? ";
		Object[] in = {model.getGName(),model.getGNote(),model.getGId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int gId) {
		String sql = "delete from Grade where gId=? ";
		Object[] in = {gId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Grade";
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
