package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Worktime;
public class WorktimeDAO {
	/**
	* 根据id查询,返回Worktime,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Worktime findById(int id) {
		String sql = "select * from Worktime where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Worktime model = null;
		try {
			if(rs.next()) {
				model = new Worktime(
					rs.getInt("id"),
					rs.getInt("Serial"),
					rs.getString("interval"),
					rs.getString("section"),
					rs.getString("wtime"),
					rs.getString("wNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Worktime>
	* @param id
	* @return
	*/
	public List<Worktime> findAll() {
		String sql = "select * from Worktime";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Worktime> modelList = new ArrayList<Worktime>();
		Worktime model = null;
		try {
			while(rs.next()) {
				model = new Worktime(
					rs.getInt("id"),
					rs.getInt("Serial"),
					rs.getString("interval"),
					rs.getString("section"),
					rs.getString("wtime"),
					rs.getString("wNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Worktime>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Worktime> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Worktime]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Worktime> modelList = new ArrayList<Worktime>();
		Worktime model = null;
		try {
			while(rs.next()) {
				model = new Worktime(
					rs.getInt("id"),
					rs.getInt("Serial"),
					rs.getString("interval"),
					rs.getString("section"),
					rs.getString("wtime"),
					rs.getString("wNote"));
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
	public int insert(Worktime model) {
		String sql = "insert into Worktime values(?,?,?,?,?) ";
		Object[] in = {model.getSerial(),model.getInterval(),model.getSection(),model.getWtime(),model.getWNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Worktime model) {
		String sql = "update Worktime set Serial=?,interval=?,section=?,wtime=?,wNote=? where id=? ";
		Object[] in = {model.getSerial(),model.getInterval(),model.getSection(),model.getWtime(),model.getWNote(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Worktime where id=? ";
		Object[] in = {id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Worktime";
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
