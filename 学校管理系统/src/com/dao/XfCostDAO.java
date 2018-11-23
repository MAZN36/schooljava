package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.XfCost;
public class XfCostDAO {
	/**
	* 根据id查询,返回XfCost,参数int id   根据id查询
	* @param id
	* @return
	*/
	public XfCost findById(int id) {
		String sql = "select * from XfCost where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		XfCost model = null;
		try {
			if(rs.next()) {
				model = new XfCost(
					rs.getInt("id"),
					rs.getInt("stuidxf"),
					rs.getString("danhao"),
					rs.getDate("jysj"),
					rs.getDouble("jyqyr"),
					rs.getDouble("jyhyr"),
					rs.getDouble("jyyr"),
					rs.getString("jyfs"),
					rs.getString("jylx"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	 * 先查询有没有数据
	 * 
	 */
	public int count(int stuidxf) {
		String sql = "select count(*) from XfCost where stuidxf=?";
		Object[] in = {stuidxf};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		int mode=0;
		try {
			if(rs.next()) {
				mode=rs.getInt(1);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mode;
	}
	/**
	* 学号 订单号 交易金额 交易方式 交易类型
	* @param id
	* @return
	*/
	public int findstuidxf(int stuidxf,String danhao,double jyyr,String jyfs,String jylx) {
		
		if(count(stuidxf)>0){
			String sql = "select jyhyr from XfCost where stuidxf=? order by jysj desc";
			Object[] in = {stuidxf};
			ResultSet rs = DBUtil.executeQuery(sql, in);
			double mode=0;
			try {
				if(rs.next()) {
					mode=rs.getInt(1);
				}
				DBUtil.close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql2 = "insert into xfCost(stuidxf,danhao,jyqyr,jyhyr,jyyr,jyfs,jylx) values(?,?,?,?,?,?,?)";
			Object[] in2 = {stuidxf,danhao,mode,jyyr+mode,jyyr,jyfs,jylx};
			return DBUtil.executeUpdate(sql2, in2);
		}
		String sql = "insert into xfCost(stuidxf,danhao,jyqyr,jyhyr,jyyr,jyfs,jylx) values(?,?,0,?,?,?,?)";
		Object[] in = {stuidxf,danhao,jyyr,jyyr,jyfs,jylx};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 查询全部,返回List<XfCost>
	* @param id
	* @return
	*/
	public List<XfCost> findAll() {
		String sql = "select * from XfCost";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<XfCost> modelList = new ArrayList<XfCost>();
		XfCost model = null;
		try {
			while(rs.next()) {
				model = new XfCost(
					rs.getInt("id"),
					rs.getInt("stuidxf"),
					rs.getString("danhao"),
					rs.getDate("jysj"),
					rs.getDouble("jyqyr"),
					rs.getDouble("jyhyr"),
					rs.getDouble("jyyr"),
					rs.getString("jyfs"),
					rs.getString("jylx"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<XfCost>,int page,int limit user第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit,String user) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [XfCost] where stuidxf=?) t where t.row>="+start+" and t.row<="+end;
				Object []in={user};
	ResultSet rs = DBUtil.executeQuery(sql,in);
		List<XfCost> modelList = new ArrayList<XfCost>();
		XfCost model = null;
		try {
			while(rs.next()) {
				model = new XfCost(
					rs.getInt("id"),
					rs.getInt("stuidxf"),
					rs.getString("danhao"),
					rs.getDate("jysj"),
					rs.getDouble("jyqyr"),
					rs.getDouble("jyhyr"),
					rs.getDouble("jyyr"),
					rs.getString("jyfs"),
					rs.getString("jylx"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<XfCost>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [XfCost]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<XfCost> modelList = new ArrayList<XfCost>();
		XfCost model = null;
		try {
			while(rs.next()) {
				model = new XfCost(
					rs.getInt("id"),
					rs.getInt("stuidxf"),
					rs.getString("danhao"),
					rs.getDate("jysj"),
					rs.getDouble("jyqyr"),
					rs.getDouble("jyhyr"),
					rs.getDouble("jyyr"),
					rs.getString("jyfs"),
					rs.getString("jylx"));
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
	public int insert(XfCost model) {
		String sql = "insert into XfCost values(?,?,?,?,?,?,?,?) ";
		Object[] in = {model.getStuidxf(),model.getDanhao(),model.getJysj(),model.getJyqyr(),model.getJyhyr(),model.getJyyr(),model.getJyfs(),model.getJylx()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(XfCost model) {
		String sql = "update XfCost set stuidxf=?,danhao=?,jysj=?,jyqyr=?,jyhyr=?,jyyr=?,jyfs=?,jylx=? where id=? ";
		Object[] in = {model.getStuidxf(),model.getDanhao(),model.getJysj(),model.getJyqyr(),model.getJyhyr(),model.getJyyr(),model.getJyfs(),model.getJylx(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from XfCost where id=? ";
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
	String sql = "select count(*) from XfCost";
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
