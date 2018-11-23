package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Pperiod;
public class PperiodDAO {
	/**
	* 根据id查询,返回Pperiod,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Pperiod findById(int pId) {
		String sql = "select * from Pperiod where pId=?";
		Object[] in = {pId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Pperiod model = null;
		try {
			if(rs.next()) {
				model = new Pperiod(
					rs.getInt("pId"),
					rs.getInt("pClasss"),
					rs.getInt("pCourse"),
					rs.getDate("pDate"),
					rs.getString("pNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Pperiod>
	* @param id
	* @return
	*/
	public List<Pperiod> findAll() {
		String sql = "select * from Pperiod p join Classs c on p.pClasss=c.cId join Course s on p.pCourse=s.course_id ";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Pperiod> modelList = new ArrayList<Pperiod>();
		Pperiod model = null;
		try {
			while(rs.next()) {
				model = new Pperiod(
						rs.getInt("pId"),
						rs.getInt("pClasss"),
						rs.getInt("pCourse"),
						rs.getDate("pDate"),
						rs.getString("pNote"),
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getInt("course_id"),
						rs.getString("course_name"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Pperiod>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Pperiod> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by pId desc) row FROM [Pperiod] p join Classs c on p.pClasss=c.cId join Course s on p.pCourse=s.course_id) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Pperiod> modelList = new ArrayList<Pperiod>();
		Pperiod model = null;
		try {
			while(rs.next()) {
				model = new Pperiod(
					rs.getInt("pId"),
					rs.getInt("pClasss"),
					rs.getInt("pCourse"),
					rs.getDate("pDate"),
					rs.getString("pNote"),
					rs.getInt("cId"),
					rs.getString("cName"),
					rs.getInt("course_id"),
					rs.getString("course_name"));
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
	public int insert(Pperiod model) {
		String sql = "insert into Pperiod values(?,?,?,?) ";
		Object[] in = {model.getpClasss(),model.getpCourse(),model.getpDate(),model.getpNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Pperiod model) {
		String sql = "update Pperiod set pClasss=?,pCourse=?,pDate=?,pNote=? where pId=? ";
		Object[] in = {model.getpClasss(),model.getpCourse(),model.getpDate(),model.getpNote(),model.getpId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int pId) {
		String sql = "delete from Pperiod where pId=? ";
		Object[] in = {pId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Pperiod";
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
