package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Credits;
public class CreditsDAO {
	/**
	* 根据id查询,返回Credits,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Credits findById(int cIds) {
		String sql = "select * from Credits where cIds=?";
		Object[] in = {cIds};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Credits model = null;
		try {
			if(rs.next()) {
				model = new Credits(
					rs.getInt("cIds"),
					rs.getInt("cClasssName"),
					rs.getString("cStudentid"),
					rs.getInt("cSubjectsName"),
					rs.getInt("cHavecredit"),
					rs.getInt("cOperator"),
					rs.getString("cNotes"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Credits>
	* @param id
	* @return
	*/
	public List<Credits> findAll() {
		String sql = "select * from Credits c join Classs g on c.cClasssName=g.cIds join Course o on c.cSubjectsName=o.course_id join Teacher r on c.cOperator=r.tid";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Credits> modelList = new ArrayList<Credits>();
		Credits model = null;
		try {
			while(rs.next()) {
					model = new Credits(
						rs.getInt("cIds"),
						rs.getInt("cClasssName"),
						rs.getString("cStudentid"),
						rs.getInt("cSubjectsName"),
						rs.getInt("cHavecredit"),
						rs.getInt("cOperator"),
						rs.getString("cNotes"),
						rs.getInt("cid"),
						rs.getString("cName"),
						rs.getInt("course_id"),
						rs.getString("course_name"),
						rs.getInt("tid"),
						rs.getString("tName"));
					modelList.add(model);
				}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Credits>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Credits> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by cIds desc) row FROM [Credits] s join Classs c on s.cClasssName=c.cId join Course o on s.cSubjectsName=o.course_id join Teacher r on s.cOperator=r.tid) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Credits> modelList = new ArrayList<Credits>();
		Credits model = null;
		try {
			while(rs.next()) {
				model = new Credits(
					rs.getInt("cIds"),
					rs.getInt("cClasssName"),
					rs.getString("cStudentid"),
					rs.getInt("cSubjectsName"),
					rs.getInt("cHavecredit"),
					rs.getInt("cOperator"),
					rs.getString("cNotes"),
					rs.getInt("cid"),
					rs.getString("cName"),
					rs.getInt("course_id"),
					rs.getString("course_name"),
					rs.getInt("tid"),
					rs.getString("tName"));
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
	public int insert(Credits model) {
		String sql = "insert into Credits values(?,?,?,?,?,?) ";
		Object[] in = {model.getcClasssName(),model.getcStudentid(),model.getcSubjectsName(),model.getcHavecredit(),model.getcOperator(),model.getcNotes()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Credits model) {
		String sql = "update Credits set cClasssName=?,cStudentid=?,cSubjectsName=?,cHavecredit=?,cOperator=?,cNotes=? where cIds=? ";
		Object[] in = {model.getcClasssName(),model.getcStudentid(),model.getcSubjectsName(),model.getcHavecredit(),model.getcOperator(),model.getcNotes(),model.getcIds()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int cIds) {
		String sql = "delete from Credits where cIds=? ";
		Object[] in = {cIds};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Credits";
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
