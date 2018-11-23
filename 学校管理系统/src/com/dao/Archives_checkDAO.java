package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Archives_check;
public class Archives_checkDAO {
	/**
	* 根据id查询,返回Archives_check,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Archives_check findById(int arc_id) {
		String sql = "select * from Archives_check where arc_id=?";
		Object[] in = {arc_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Archives_check model = null;
		try {
			if(rs.next()) {
				model = new Archives_check(
					rs.getInt("arc_id"),
					rs.getInt("arc_Classs"),
					rs.getInt("arc_Studentid"),
					rs.getString("arc_Content"),
					rs.getString("arc_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Archives_check>
	* @param id
	* @return
	*/
	public List<Archives_check> findAll() {
		String sql = "select * from Archives_check";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Archives_check> modelList = new ArrayList<Archives_check>();
		Archives_check model = null;
		try {
			while(rs.next()) {
				model = new Archives_check(
					rs.getInt("arc_id"),
					rs.getInt("arc_Classs"),
					rs.getInt("arc_Studentid"),
					rs.getString("arc_Content"),
					rs.getString("arc_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Archives_check>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Archives_check> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by arc_id desc) row FROM [Archives_check]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Archives_check> modelList = new ArrayList<Archives_check>();
		Archives_check model = null;
		try {
			while(rs.next()) {
				model = new Archives_check(
					rs.getInt("arc_id"),
					rs.getInt("arc_Classs"),
					rs.getInt("arc_Studentid"),
					rs.getString("arc_Content"),
					rs.getString("arc_Note"));
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
	public int insert(Archives_check model) {
		String sql = "insert into Archives_check values(?,?,?,?) ";
		Object[] in = {model.getArc_Classs(),model.getArc_Studentid(),model.getArc_Content(),model.getArc_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Archives_check model) {
		String sql = "update Archives_check set arc_Classs=?,arc_Studentid=?,arc_Content=?,arc_Note=? where arc_id=? ";
		Object[] in = {model.getArc_Classs(),model.getArc_Studentid(),model.getArc_Content(),model.getArc_Note(),model.getArc_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int arc_id) {
		String sql = "delete from Archives_check where arc_id=? ";
		Object[] in = {arc_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Archives_check";
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
