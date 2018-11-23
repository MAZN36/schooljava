package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Notice;
public class NoticeDAO {
	/**
	* 根据id查询,返回Notice,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Notice findById(int id) {
		String sql = "select * from Notice where id=?";
		Object[] in = {id};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Notice model = null;
		try {
			if(rs.next()) {
				model = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("Reletime"),
					rs.getInt("Relepeople"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Notice>
	* @param id
	* @return
	*/
	public List<Notice> findAll() {
		String sql = "select * from Notice";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Notice> modelList = new ArrayList<Notice>();
		Notice model = null;
		try {
			while(rs.next()) {
				model = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("Reletime"),
					rs.getInt("Relepeople"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Notice>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Notice> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by id desc) row FROM [Notice]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Notice> modelList = new ArrayList<Notice>();
		Notice model = null;
		try {
			while(rs.next()) {
				model = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("Reletime"),
					rs.getInt("Relepeople"));
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
	public int insert(Notice model) {
		String sql = "insert into Notice(title,content,Relepeople) values(?,?,?) ";
		Object[] in = {model.getTitle(),model.getContent(),model.getRelepeople()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Notice model) {
		String sql = "update Notice set title=? where id=? ";
		Object[] in = {model.getTitle(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Notice where id=? ";
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
	String sql = "select count(*) from Notice";
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
