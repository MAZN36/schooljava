package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Enter_Talk;
public class Enter_TalkDAO {
	/**
	* 根据id查询,返回Enter_Talk,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Enter_Talk findById(int enter_id) {
		String sql = "select * from Enter_Talk where enter_id=?";
		Object[] in = {enter_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Enter_Talk model = null;
		try {
			if(rs.next()) {
				model = new Enter_Talk(
					rs.getInt("enter_id"),
					rs.getInt("enter_Studentid"),
					rs.getDate("enter_Time"),
					rs.getString("enter_Content"),
					rs.getInt("enter_Operator"),
					rs.getString("enter_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Enter_Talk>
	* @param id
	* @return
	*/
	public List<Enter_Talk> findAll() {
		String sql = "select * from Enter_Talk";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Enter_Talk> modelList = new ArrayList<Enter_Talk>();
		Enter_Talk model = null;
		try {
			while(rs.next()) {
				model = new Enter_Talk(
					rs.getInt("enter_id"),
					rs.getInt("enter_Studentid"),
					rs.getDate("enter_Time"),
					rs.getString("enter_Content"),
					rs.getInt("enter_Operator"),
					rs.getString("enter_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Enter_Talk>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Enter_Talk> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by enter_id desc) row FROM [Enter_Talk]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Enter_Talk> modelList = new ArrayList<Enter_Talk>();
		Enter_Talk model = null;
		try {
			while(rs.next()) {
				model = new Enter_Talk(
					rs.getInt("enter_id"),
					rs.getInt("enter_Studentid"),
					rs.getDate("enter_Time"),
					rs.getString("enter_Content"),
					rs.getInt("enter_Operator"),
					rs.getString("enter_Note"));
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
	public int insert(Enter_Talk model) {
		String sql = "insert into Enter_Talk values(?,?,?,?,?) ";
		Object[] in = {model.getEnter_Studentid(),model.getEnter_Time(),model.getEnter_Content(),model.getEnter_Operator(),model.getEnter_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Enter_Talk model) {
		String sql = "update Enter_Talk set enter_Studentid=?,enter_Time=?,enter_Content=?,enter_Operator=?,enter_Note=? where enter_id=? ";
		Object[] in = {model.getEnter_Studentid(),model.getEnter_Time(),model.getEnter_Content(),model.getEnter_Operator(),model.getEnter_Note(),model.getEnter_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int enter_id) {
		String sql = "delete from Enter_Talk where enter_id=? ";
		Object[] in = {enter_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Enter_Talk";
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
