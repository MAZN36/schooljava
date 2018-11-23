package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_results;
public class Student_resultsDAO {
	/**
	* 根据id查询,返回Student_results,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Student_results findById(int rId) {
		String sql = "select * from Student_results where rId=?";
		Object[] in = {rId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Student_results model = null;
		try {
			if(rs.next()) {
				model = new Student_results(
					rs.getInt("rId"),
					rs.getInt("rStudentid"),
					rs.getDate("rExamDate"),
					rs.getDouble("rOperating"),
					rs.getDouble("rAnswer"),
					rs.getInt("rClasss"),
					rs.getString("rPass"),
					rs.getString("rNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Student_results>
	* @param id
	* @return
	*/
	public List<Student_results> findAll() {
		String sql = "select * from Student_results";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_results> modelList = new ArrayList<Student_results>();
		Student_results model = null;
		try {
			while(rs.next()) {
				model = new Student_results(
					rs.getInt("rId"),
					rs.getInt("rStudentid"),
					rs.getDate("rExamDate"),
					rs.getDouble("rOperating"),
					rs.getDouble("rAnswer"),
					rs.getInt("rClasss"),
					rs.getString("rPass"),
					rs.getString("rNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Student_results>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Student_results> Paging(int page,int limit) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by rId desc) row FROM [Student_results]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Student_results> modelList = new ArrayList<Student_results>();
		Student_results model = null;
		try {
			while(rs.next()) {
				model = new Student_results(
					rs.getInt("rId"),
					rs.getInt("rStudentid"),
					rs.getDate("rExamDate"),
					rs.getDouble("rOperating"),
					rs.getDouble("rAnswer"),
					rs.getInt("rClasss"),
					rs.getString("rPass"),
					rs.getString("rNote"));
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
	public int insert(Student_results model) {
		String sql = "insert into Student_results values(?,?,?,?,?,?,?) ";
		Object[] in = {model.getRStudentid(),model.getRExamDate(),model.getROperating(),model.getRAnswer(),model.getRClasss(),model.getRPass(),model.getRNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Student_results model) {
		String sql = "update Student_results set rStudentid=?,rExamDate=?,rOperating=?,rAnswer=?,rClasss=?,rPass=?,rNote=? where rId=? ";
		Object[] in = {model.getRStudentid(),model.getRExamDate(),model.getROperating(),model.getRAnswer(),model.getRClasss(),model.getRPass(),model.getRNote(),model.getRId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int rId) {
		String sql = "delete from Student_results where rId=? ";
		Object[] in = {rId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Student_results";
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
