package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Adm;
public class AdmDAO {
	/**
	* 根据id查询,返回Adm,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Adm findById(int id) {
		String sql = "select * from Adm where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Adm model = null;
		try {
			if(rs.next()) {
				model = new Adm(
					rs.getInt("id"),
					rs.getString("department"),
					rs.getString("adname"),
					rs.getString("adpost"),
					rs.getString("adphone"),
					rs.getString("Mailbox"),
					rs.getString("adNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Adm>
	* @param id
	* @return
	*/
	public List<Adm> findAll() {
		String sql = "select * from Adm";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Adm> modelList = new ArrayList<Adm>();
		Adm model = null;
		try {
			while(rs.next()) {
				model = new Adm(
					rs.getInt("id"),
					rs.getString("department"),
					rs.getString("adname"),
					rs.getString("adpost"),
					rs.getString("adphone"),
					rs.getString("Mailbox"),
					rs.getString("adNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
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
	/**
	* 分页查询,返回List<Adm>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	
	public List<Adm> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Adm]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Adm> modelList = new ArrayList<Adm>();
		Adm model = null;
		try {
			while(rs.next()) {
				model = new Adm(
					rs.getInt("id"),
					rs.getString("department"),
					rs.getString("adname"),
					rs.getString("adpost"),
					rs.getString("adphone"),
					rs.getString("Mailbox"),
					rs.getString("adNote"));
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
	public int insert(Adm model) {
		String sql = "insert into Adm values(?,?,?,?,?,?) ";
		Object[] in = {model.getDepartment(),model.getAdname(),model.getAdpost(),model.getAdphone(),model.getMailbox(),model.getAdNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Adm model) {
		String sql = "update Adm set department=?,adname=?,adpost=?,adphone=?,Mailbox=?,adNote=? where id=? ";
		Object[] in = {model.getDepartment(),model.getAdname(),model.getAdpost(),model.getAdphone(),model.getMailbox(),model.getAdNote(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Adm where id=? ";
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
	String sql = "select count(*) from Adm";
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
