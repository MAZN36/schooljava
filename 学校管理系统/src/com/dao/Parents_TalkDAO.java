package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Parents_Talk;
public class Parents_TalkDAO {
	/**
	* 根据id查询,返回Parents_Talk,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Parents_Talk findById(int par_id) {
		String sql = "select * from Parents_Talk where par_id=?";
		Object[] in = {par_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Parents_Talk model = null;
		try {
			if(rs.next()) {
				model = new Parents_Talk(
					rs.getInt("par_id"),
					rs.getInt("par_Studentid"),
					rs.getDate("par_Time"),
					rs.getString("par_Content"),
					rs.getInt("par_Operator"),
					rs.getString("par_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Parents_Talk>
	* @param id
	* @return
	*/
	public List<Parents_Talk> findAll() {
		String sql = "select * from Parents_Talk";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Parents_Talk> modelList = new ArrayList<Parents_Talk>();
		Parents_Talk model = null;
		try {
			while(rs.next()) {
				model = new Parents_Talk(
					rs.getInt("par_id"),
					rs.getInt("par_Studentid"),
					rs.getDate("par_Time"),
					rs.getString("par_Content"),
					rs.getInt("par_Operator"),
					rs.getString("par_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Parents_Talk>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Parents_Talk> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by par_id desc) row FROM [Parents_Talk]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Parents_Talk> modelList = new ArrayList<Parents_Talk>();
		Parents_Talk model = null;
		try {
			while(rs.next()) {
				model = new Parents_Talk(
					rs.getInt("par_id"),
					rs.getInt("par_Studentid"),
					rs.getDate("par_Time"),
					rs.getString("par_Content"),
					rs.getInt("par_Operator"),
					rs.getString("par_Note"));
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
	public int insert(Parents_Talk model) {
		String sql = "insert into Parents_Talk values(?,?,?,?,?) ";
		Object[] in = {model.getPar_Studentid(),model.getPar_Time(),model.getPar_Content(),model.getPar_Operator(),model.getPar_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Parents_Talk model) {
		String sql = "update Parents_Talk set par_Studentid=?,par_Time=?,par_Content=?,par_Operator=?,par_Note=? where par_id=? ";
		Object[] in = {model.getPar_Studentid(),model.getPar_Time(),model.getPar_Content(),model.getPar_Operator(),model.getPar_Note(),model.getPar_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int par_id) {
		String sql = "delete from Parents_Talk where par_id=? ";
		Object[] in = {par_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Parents_Talk";
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
