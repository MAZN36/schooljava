package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Direction;
public class DirectionDAO {
	/**
	* 根据id查询,返回Direction,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Direction findById(int dId) {
		String sql = "select * from Direction where dId=?";
		Object[] in = {dId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Direction model = null;
		try {
			if(rs.next()) {
				model = new Direction(
					rs.getInt("dId"),
					rs.getInt("dStudentid"),
					rs.getInt("dClasss"),
					rs.getInt("dFirstchoice"),
					rs.getInt("dSecondchoice"),
					rs.getDate("dDate"),
					rs.getString("dNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Direction>
	* @param id
	* @return
	*/
	public List<Direction> findAll() {
		String sql = "select * from Direction";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Direction> modelList = new ArrayList<Direction>();
		Direction model = null;
		try {
			while(rs.next()) {
				model = new Direction(
					rs.getInt("dId"),
					rs.getInt("dStudentid"),
					rs.getInt("dClasss"),
					rs.getInt("dFirstchoice"),
					rs.getInt("dSecondchoice"),
					rs.getDate("dDate"),
					rs.getString("dNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Direction>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Direction> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by dId desc) row FROM [Direction]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Direction> modelList = new ArrayList<Direction>();
		Direction model = null;
		try {
			while(rs.next()) {
				model = new Direction(
					rs.getInt("dId"),
					rs.getInt("dStudentid"),
					rs.getInt("dClasss"),
					rs.getInt("dFirstchoice"),
					rs.getInt("dSecondchoice"),
					rs.getDate("dDate"),
					rs.getString("dNote"));
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
	public int insert(Direction model) {
		String sql = "insert into Direction values(?,?,?,?,?,?) ";
		Object[] in = {model.getDStudentid(),model.getDClasss(),model.getDFirstchoice(),model.getDSecondchoice(),model.getDDate(),model.getDNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Direction model) {
		String sql = "update Direction set dStudentid=?,dClasss=?,dFirstchoice=?,dSecondchoice=?,dDate=?,dNote=? where dId=? ";
		Object[] in = {model.getDStudentid(),model.getDClasss(),model.getDFirstchoice(),model.getDSecondchoice(),model.getDDate(),model.getDNote(),model.getDId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int dId) {
		String sql = "delete from Direction where dId=? ";
		Object[] in = {dId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Direction";
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
