package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Administrator;
public class AdministratorDAO {
	/**
	* 根据id查询,返回Administrator,参数int id   根据id查询
	* @param id
	* @return
	*/
	/**
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public int bdmm(String user,String password){
		int c=0;
		String sql="select count(*) from Administrator where Admin_Account=? and Admin_Password=? and Admin_State='可用'";
		Object []in={user,DBUtil.MD5(password)};
		ResultSet rs=DBUtil.executeQuery(sql,in);
		try {
			if(rs.next())
			{
				c=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public Administrator findById(int Admin_id) {
		String sql = "select * from Administrator where Admin_id=?";
		Object[] in = {Admin_id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Administrator model = null;
		try {
			if(rs.next()) {
				model = new Administrator(
					rs.getInt("Admin_id"),
					rs.getString("Admin_Name"),
					rs.getString("Admin_Account"),
					rs.getString("Admin_Password"),
					rs.getString("Admin_State"),
					rs.getString("Admin_Note"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Administrator>
	* @param id
	* @return
	*/
	public List<Administrator> findAll() {
		String sql = "select * from Administrator";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Administrator> modelList = new ArrayList<Administrator>();
		Administrator model = null;
		try {
			while(rs.next()) {
				model = new Administrator(
					rs.getInt("Admin_id"),
					rs.getString("Admin_Name"),
					rs.getString("Admin_Account"),
					rs.getString("Admin_Password"),
					rs.getString("Admin_State"),
					rs.getString("Admin_Note"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Administrator>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Administrator> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by Admin_id desc) row FROM [Administrator]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Administrator> modelList = new ArrayList<Administrator>();
		Administrator model = null;
		try {
			while(rs.next()) {
				model = new Administrator(
					rs.getInt("Admin_id"),
					rs.getString("Admin_Name"),
					rs.getString("Admin_Account"),
					rs.getString("Admin_Password"),
					rs.getString("Admin_State"),
					rs.getString("Admin_Note"));
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
	public int insert(Administrator model) {
		String sql = "insert into Administrator values(?,?,?,?,?) ";
		Object[] in = {model.getAdmin_Name(),model.getAdmin_Account(),DBUtil.MD5(model.getAdmin_Password()),model.getAdmin_State(),model.getAdmin_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Administrator model) {
		String sql = "update Administrator set Admin_State=? where Admin_id=? ";
		Object[] in = {model.getAdmin_State(),model.getAdmin_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int updatepa(Administrator model) {
		String sql = "update Administrator set Admin_Password=? where Admin_Account=? ";
		Object[] in = {model.getAdmin_Password(),model.getAdmin_Account()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int Admin_id) {
		String sql = "delete from Administrator where Admin_id=? ";
		Object[] in = {Admin_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Administrator";
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
