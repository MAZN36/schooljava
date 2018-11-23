package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Position;
public class PositionDAO {
	/**
	* 根据id查询,返回Position,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Position findById(int pid) {
		String sql = "select * from Position where pid=?";
		Object[] in = {pid};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Position model = null;
		try {
			if(rs.next()) {
				model = new Position(
					rs.getInt("pid"),
					rs.getString("pName"),
					rs.getString("pNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Position>
	* @param id
	* @return
	*/
	public List<Position> findAll() {
		String sql = "select * from Position";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Position> modelList = new ArrayList<Position>();
		Position model = null;
		try {
			while(rs.next()) {
				model = new Position(
					rs.getInt("pid"),
					rs.getString("pName"),
					rs.getString("pNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Position>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Position> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by pid desc) row FROM  Position left join(select count(*) cou,tPosition from Teacher group by tPosition)t on tPosition=Position.pid) t  where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Position> modelList = new ArrayList<Position>();
		Position model = null;
		try {
			while(rs.next()) {
				model = new Position(
					rs.getInt("pid"),
					rs.getString("pName"),
					rs.getString("cou"));
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
	public int insert(Position model) {
		String sql = "insert into Position values(?,?) ";
		Object[] in = {model.getPName(),model.getPNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Position model) {
		String sql = "update Position set pName=?,pNote=? where pid=? ";
		Object[] in = {model.getPName(),model.getPNote(),model.getPid()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int pid) {
		String sql = "delete from Position where pid=? ";
		Object[] in = {pid};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Position";
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
