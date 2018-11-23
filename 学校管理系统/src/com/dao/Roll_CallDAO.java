package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Roll_Call;
public class Roll_CallDAO {
	/**
	* 根据id查询,返回Roll_Call,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Roll_Call findById(int Roll_id) {
		String sql = "select * from Roll_Call where Roll_id=?";
		Object[] in = {Roll_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Roll_Call model = null;
		try {
			if(rs.next()) {
				model = new Roll_Call(
					rs.getInt("Roll_id"),
					rs.getInt("Roll_Classs"),
					rs.getInt("Roll_Course"),
					rs.getString("Roll_Type"),
					rs.getInt("Roll_Number"),
					rs.getInt("Roll_Operator"),
					rs.getDate("Roll_Time"),
					rs.getString("Roll_State"),
					rs.getString("Roll_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Roll_Call>
	* @param id
	* @return
	*/
	public List<Roll_Call> findAll() {
		String sql = "select * from Roll_Call";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Roll_Call> modelList = new ArrayList<Roll_Call>();
		Roll_Call model = null;
		try {
			while(rs.next()) {
				model = new Roll_Call(
					rs.getInt("Roll_id"),
					rs.getInt("Roll_Classs"),
					rs.getInt("Roll_Course"),
					rs.getString("Roll_Type"),
					rs.getInt("Roll_Number"),
					rs.getInt("Roll_Operator"),
					rs.getDate("Roll_Time"),
					rs.getString("Roll_State"),
					rs.getString("Roll_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Roll_Call>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Roll_Call> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by Roll_id desc) row FROM [Roll_Call]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Roll_Call> modelList = new ArrayList<Roll_Call>();
		Roll_Call model = null;
		try {
			while(rs.next()) {
				model = new Roll_Call(
					rs.getInt("Roll_id"),
					rs.getInt("Roll_Classs"),
					rs.getInt("Roll_Course"),
					rs.getString("Roll_Type"),
					rs.getInt("Roll_Number"),
					rs.getInt("Roll_Operator"),
					rs.getDate("Roll_Time"),
					rs.getString("Roll_State"),
					rs.getString("Roll_Note"));
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
	public int insert(Roll_Call model) {
		String sql = "insert into Roll_Call values(?,?,?,?,?,?,?,?) ";
		Object[] in = {model.getRoll_Classs(),model.getRoll_Course(),model.getRoll_Type(),model.getRoll_Number(),model.getRoll_Operator(),model.getRoll_Time(),model.getRoll_State(),model.getRoll_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Roll_Call model) {
		String sql = "update Roll_Call set Roll_Classs=?,Roll_Course=?,Roll_Type=?,Roll_Number=?,Roll_Operator=?,Roll_Time=?,Roll_State=?,Roll_Note=? where Roll_id=? ";
		Object[] in = {model.getRoll_Classs(),model.getRoll_Course(),model.getRoll_Type(),model.getRoll_Number(),model.getRoll_Operator(),model.getRoll_Time(),model.getRoll_State(),model.getRoll_Note(),model.getRoll_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int Roll_id) {
		String sql = "delete from Roll_Call where Roll_id=? ";
		Object[] in = {Roll_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Roll_Call";
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
