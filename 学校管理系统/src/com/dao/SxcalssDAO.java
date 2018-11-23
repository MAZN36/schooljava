package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Sxcalss;
public class SxcalssDAO {
	/**
	* 根据id查询,返回Sxcalss,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Sxcalss findById(int id) {
		String sql = "select * from Sxcalss where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Sxcalss model = null;
		try {
			if(rs.next()) {
				model = new Sxcalss(
					rs.getInt("id"),
					rs.getInt("stuxh"),
					rs.getString("sxqbj"),
					rs.getInt("sxhbj"),
					rs.getString("zt"),
					rs.getDate("sxsj"),
					rs.getString("bz"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Sxcalss>
	* @param id
	* @return
	*/
	public List<Sxcalss> findAll() {
		String sql = "select * from Sxcalss";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Sxcalss> modelList = new ArrayList<Sxcalss>();
		Sxcalss model = null;
		try {
			while(rs.next()) {
				model = new Sxcalss(
					rs.getInt("id"),
					rs.getInt("stuxh"),
					rs.getString("sxqbj"),
					rs.getInt("sxhbj"),
					rs.getString("zt"),
					rs.getDate("sxsj"),
					rs.getString("bz"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Sxcalss>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Sxcalss> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Sxcalss] sx join Studentinfo st on sx.stuxh=st.stuId join Classs c on c.cId=sx.sxhbj) t  where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Sxcalss> modelList = new ArrayList<Sxcalss>();
		Sxcalss model = null;
		try {
			while(rs.next()) {
				model = new Sxcalss(
					rs.getInt("id"),
					rs.getInt("stuxh"),
					rs.getString("sxqbj"),
					rs.getInt("sxhbj"),
					rs.getString("zt"),
					rs.getDate("sxsj"),
					rs.getString("bz"),
					rs.getInt("stuId"),
					rs.getString("Studentid"),
					rs.getInt("sClasss"),
					rs.getString("sName"),
					rs.getString("sSex"),
				rs.getString("sNational"),
				rs.getDate("sDate"),
				rs.getString("sCard"),
				rs.getString("sNativeplace"),
				rs.getString("sAddress"),
				rs.getString("sPassword"),
				rs.getString("sParentsName"),
				rs.getString("sParentsNumber"),
				rs.getString("sFace"),
				rs.getString("sNumber"),
				rs.getDate("sEntranceDate"),
				rs.getString("sQQ"),
				rs.getString("sPicture"),
				rs.getString("sState"),
				rs.getString("sNote"),
				rs.getInt("cId"),
				rs.getString("cName"),
				rs.getInt("cTypeName"),
				rs.getString("cGraduated"),
				rs.getDate("cGtime"),
				rs.getString("cGstate"),
				rs.getString("cNote"));
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
	public int insert(Sxcalss model) {
		String sql = "insert into Sxcalss values(?,?,?,?,?,?) ";
		Object[] in = {model.getStuxh(),model.getSxqbj(),model.getSxhbj(),model.getZt(),model.getSxsj(),model.getBz()};
		
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Sxcalss model) {
		String sql = "update Sxcalss set stuxh=?,sxqbj=?,sxhbj=?,zt=?,sxsj=?,bz=? where id=? ";
		Object[] in = {model.getStuxh(),model.getSxqbj(),model.getSxhbj(),model.getZt(),model.getSxsj(),model.getBz(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Sxcalss where id=? ";
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
	String sql = "select count(*) from Sxcalss";
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
