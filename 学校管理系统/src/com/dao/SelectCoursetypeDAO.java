package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.SelectCoursetype;
public class SelectCoursetypeDAO {
	/**
	* 根据id查询,返回SelectCoursetype,参数int id   根据id查询
	* @param id
	* @return
	*/
	public SelectCoursetype findById(int select_id) {
		String sql = "select * from SelectCoursetype where select_id=?";
		Object[] in = {select_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		SelectCoursetype model = null;
		try {
			if(rs.next()) {
				model = new SelectCoursetype(
					rs.getInt("select_id"),
					rs.getString("select_name"),
					rs.getString("select_target"),
					rs.getString("select_introduce"),
					rs.getString("select_capacityv"),
					rs.getString("select_jobs"),
					rs.getString("select_teacher"),
					rs.getString("select_Headmaster"),
					rs.getString("select_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<SelectCoursetype>
	* @param id
	* @return
	*/
	public List<SelectCoursetype> findAll() {
		String sql = "select * from SelectCoursetype";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<SelectCoursetype> modelList = new ArrayList<SelectCoursetype>();
		SelectCoursetype model = null;
		try {
			while(rs.next()) {
				model = new SelectCoursetype(
					rs.getInt("select_id"),
					rs.getString("select_name"),
					rs.getString("select_target"),
					rs.getString("select_introduce"),
					rs.getString("select_capacityv"),
					rs.getString("select_jobs"),
					rs.getString("select_teacher"),
					rs.getString("select_Headmaster"),
					rs.getString("select_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<SelectCoursetype>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<SelectCoursetype> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by select_id desc) row FROM [SelectCoursetype]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<SelectCoursetype> modelList = new ArrayList<SelectCoursetype>();
		SelectCoursetype model = null;
		try {
			while(rs.next()) {
				model = new SelectCoursetype(
					rs.getInt("select_id"),
					rs.getString("select_name"),
					rs.getString("select_target"),
					rs.getString("select_introduce"),
					rs.getString("select_capacityv"),
					rs.getString("select_jobs"),
					rs.getString("select_teacher"),
					rs.getString("select_Headmaster"),
					rs.getString("select_Note"));
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
	public int insert(SelectCoursetype model) {
		String sql = "insert into SelectCoursetype values(?,?,?,?,?,?,?,?) ";
		Object[] in = {model.getSelect_name(),model.getSelect_target(),model.getSelect_introduce(),model.getSelect_capacityv(),model.getSelect_jobs(),model.getSelect_teacher(),model.getSelect_Headmaster(),model.getSelect_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(SelectCoursetype model) {
		String sql = "update SelectCoursetype set select_name=?,select_target=?,select_introduce=?,select_capacityv=?,select_jobs=?,select_teacher=?,select_Headmaster=?,select_Note=? where select_id=? ";
		Object[] in = {model.getSelect_name(),model.getSelect_target(),model.getSelect_introduce(),model.getSelect_capacityv(),model.getSelect_jobs(),model.getSelect_teacher(),model.getSelect_Headmaster(),model.getSelect_Note(),model.getSelect_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int select_id) {
		String sql = "delete from SelectCoursetype where select_id=? ";
		Object[] in = {select_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from SelectCoursetype";
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
