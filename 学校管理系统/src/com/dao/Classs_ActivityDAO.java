package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Classs_Activity;
public class Classs_ActivityDAO {
	/**
	* 根据id查询,返回Classs_Activity,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Classs_Activity findById(int act_id) {
		String sql = "select * from Classs_Activity where act_id=?";
		Object[] in = {act_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Classs_Activity model = null;
		try {
			if(rs.next()) {
				model = new Classs_Activity(
					rs.getInt("act_id"),
					rs.getInt("act_Classs"),
					rs.getString("act_Teme"),
					rs.getDate("act_Time"),
					rs.getString("act_Location"),
					rs.getString("act_Content"),
					rs.getString("act_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Classs_Activity>
	* @param id
	* @return
	*/
	public List<Classs_Activity> findAll() {
		String sql = "select * from Classs_Activity";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Classs_Activity> modelList = new ArrayList<Classs_Activity>();
		Classs_Activity model = null;
		try {
			while(rs.next()) {
				model = new Classs_Activity(
					rs.getInt("act_id"),
					rs.getInt("act_Classs"),
					rs.getString("act_Teme"),
					rs.getDate("act_Time"),
					rs.getString("act_Location"),
					rs.getString("act_Content"),
					rs.getString("act_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Classs_Activity>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Classs_Activity> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by act_id desc) row FROM [Classs_Activity]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Classs_Activity> modelList = new ArrayList<Classs_Activity>();
		Classs_Activity model = null;
		try {
			while(rs.next()) {
				model = new Classs_Activity(
					rs.getInt("act_id"),
					rs.getInt("act_Classs"),
					rs.getString("act_Teme"),
					rs.getDate("act_Time"),
					rs.getString("act_Location"),
					rs.getString("act_Content"),
					rs.getString("act_Note"));
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
	public int insert(Classs_Activity model) {
		String sql = "insert into Classs_Activity values(?,?,?,?,?,?) ";
		Object[] in = {model.getAct_Classs(),model.getAct_Teme(),model.getAct_Time(),model.getAct_Location(),model.getAct_Content(),model.getAct_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Classs_Activity model) {
		String sql = "update Classs_Activity set act_Classs=?,act_Teme=?,act_Time=?,act_Location=?,act_Content=?,act_Note=? where act_id=? ";
		Object[] in = {model.getAct_Classs(),model.getAct_Teme(),model.getAct_Time(),model.getAct_Location(),model.getAct_Content(),model.getAct_Note(),model.getAct_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int act_id) {
		String sql = "delete from Classs_Activity where act_id=? ";
		Object[] in = {act_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Classs_Activity";
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
