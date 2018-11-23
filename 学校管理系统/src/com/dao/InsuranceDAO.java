package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Insurance;
public class InsuranceDAO {
	/**
	* 根据id查询,返回Insurance,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Insurance findById(int Iid) {
		String sql = "select * from Insurance where Iid=?";
		Object[] in = {Iid};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Insurance model = null;
		try {
			if(rs.next()) {
				model = new Insurance(
					rs.getInt("Iid"),
					rs.getInt("IStudentid"),
					rs.getString("IName"),
					rs.getDate("ITime"),
					rs.getString("IContent"),
					rs.getString("INote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Insurance>
	* @param id
	* @return
	*/
	public List<Insurance> findAll() {
		String sql = "select * from Insurance";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Insurance> modelList = new ArrayList<Insurance>();
		Insurance model = null;
		try {
			while(rs.next()) {
				model = new Insurance(
					rs.getInt("Iid"),
					rs.getInt("IStudentid"),
					rs.getString("IName"),
					rs.getDate("ITime"),
					rs.getString("IContent"),
					rs.getString("INote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Insurance>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Insurance> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by Iid desc) row FROM [Insurance]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Insurance> modelList = new ArrayList<Insurance>();
		Insurance model = null;
		try {
			while(rs.next()) {
				model = new Insurance(
					rs.getInt("Iid"),
					rs.getInt("IStudentid"),
					rs.getString("IName"),
					rs.getDate("ITime"),
					rs.getString("IContent"),
					rs.getString("INote"));
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
	public int insert(Insurance model) {
		String sql = "insert into Insurance values(?,?,?,?,?) ";
		Object[] in = {model.getIStudentid(),model.getIName(),model.getITime(),model.getIContent(),model.getINote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Insurance model) {
		String sql = "update Insurance set IStudentid=?,IName=?,ITime=?,IContent=?,INote=? where Iid=? ";
		Object[] in = {model.getIStudentid(),model.getIName(),model.getITime(),model.getIContent(),model.getINote(),model.getIid()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int Iid) {
		String sql = "delete from Insurance where Iid=? ";
		Object[] in = {Iid};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Insurance";
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
