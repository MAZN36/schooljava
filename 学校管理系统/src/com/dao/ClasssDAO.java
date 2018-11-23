package	com.dao;
import java.sql.*;
import java.util.*;
import java.util.Date;

import com.vo.Classs;
public class ClasssDAO {
	/**
	* 根据id查询,返回Classs,参数int id   根据id查询
	* @param id
	* @return
	*/
	public Classs findById(int cId) {
		String sql = "select * from Classs c join Grade g on c.cTypeName=g.gId where cId=?";
		Object[] in = {cId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Classs model = null;
		try {
			if(rs.next()) {
				model = new Classs(
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getInt("cTypeName"),
						rs.getString("cGraduated"),
						rs.getDate("cGtime"),
						rs.getString("cGstate"),
						rs.getInt("cTeacher"),
						rs.getString("cPhone"),
						rs.getString("cNote"),
						rs.getInt(11),
						rs.getString(12),
						rs.getString(13),
						rs.getInt(14),
						rs.getString("tName"),
						rs.getDate("cttime"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* 查询全部,返回List<Classs>
	* @param id
	* @return
	*/
	public List<Classs> findAll(String cGstate) {
		String sql = "select * from Classs c join Grade g on c.cTypeName=g.gId join Teacher t on c.cTeacher=t.tid where cGstate=?";
		Object []in={cGstate};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Classs> modelList = new ArrayList<Classs>();
		Classs model = null;
		try {
			while(rs.next()) {
				model = new Classs(
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getInt("cTypeName"),
						rs.getString("cGraduated"),
						rs.getDate("cGtime"),
						rs.getString("cGstate"),
						rs.getInt("cTeacher"),
						rs.getString("cPhone"),
						rs.getString("cNote"),
						rs.getInt(11),
						rs.getString(12),
						rs.getString(13),
						rs.getInt(14),
						rs.getString("tName"),
						rs.getDate("cttime"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 查询全部,返回List<Classs>
	* @param id
	* @return
	*/
	public List<Classs> findAll(int cId,String cGstate) {
		String sql = "SELECT cId,cName,cTypeName,cGraduated, cGtime,cGstate, cTeacher,cPhone,cNote, gId, gName,gNote,tid,tName,cttime,cou FROM [Classs] c join  grade g on c.cTypeName=g.gId join Teacher a on c.cTeacher=a.tid  left join (select count(sclasss) cou,sclasss from Studentinfo group by sclasss)t on t.sclasss=cid where ctypeName=? and cGstate=?";
		Object []in={cId,cGstate};
		ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Classs> modelList = new ArrayList<Classs>();
		Classs model = null;
		try {
			while(rs.next()) {
				model = new Classs(
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getInt("cTypeName"),
						rs.getString("cGraduated"),
						rs.getDate("cGtime"),
						rs.getString("cGstate"),
						rs.getInt("cTeacher"),
						rs.getString("cPhone"),
						rs.getString("cNote"),
						rs.getInt("gId"),
						rs.getString("gName"),
						rs.getString("gNote"),
						rs.getInt("tid"),
						rs.getString("tName"),
						rs.getDate("cttime")
						,rs.getInt("cou"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* 分页查询,返回List<Classs>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Classs> Paging(int page,int limit,String cGstate) {
	//开始
	//第几页-1乘每页多少条数据+1
	int start=(page-1)*limit+1;//公式用于获取从哪里开始
	//结束
	//第几页乘每页多少条数据
	int end=page*limit;
	String sql = "select cId,cName,cTypeName,cGraduated,cGtime,cGstate,cTeacher,cPhone,cNote, gId, gName,gNote,tid,tName,cttime,cou from(SELECT *,ROW_NUMBER() over(order by cId desc) row FROM  Classs s join Grade g on s.ctypename=g.gId join Teacher te on s.cTeacher=te.tid left join  (select count(sclasss) cou,sclasss from Studentinfo group by sclasss)d on d.sclasss=cId where cGstate=?) t where t.row>="+start+" and t.row<="+end;;
		Object []in={cGstate};
	ResultSet rs = DBUtil.executeQuery(sql,in);
		List<Classs> modelList = new ArrayList<Classs>();
		Classs model = null;
		try {
			while(rs.next()) {
				model = new Classs(
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getInt("cTypeName"),
						rs.getString("cGraduated"),
						rs.getDate("cGtime"),
						rs.getString("cGstate"),
						rs.getInt("cTeacher"),
						rs.getString("cPhone"),
						rs.getString("cNote"),
						rs.getInt("gId"),
						rs.getString("gName"),
						rs.getString("gNote"),
						rs.getInt("tid"),
						rs.getString("tName"),
						rs.getDate("cttime")
						,rs.getInt("cou"));
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
	public int insert(Classs model) {
		String sql = "insert into Classs(cName,cTypeName,cGtime,cTeacher,cPhone,cNote) values(?,?,?,?,?,?) ";
		Object[] in = {model.getcName(),model.getcTypeName(),model.getcGtime(),model.getcTeacher(),model.getcPhone(),model.getcNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Classs model) {
		String sql = "update Classs set cName=?,cTypeName=?,cGraduated=?,cGtime=?,cGstate=?,cNote=? where cId=? ";
		Object[] in = {model.getcName(),model.getcTypeName(),model.getcGraduated(),model.getcGtime(),model.getcGstate(),model.getcNote(),model.getcId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 修改结业
	* @param model
	* @return
	*/
	//班级id 结业时间  状态   结业或者毕业
	public int update(int cId,Date cttime,String cGstate) {
		String sql = "update Classs set cttime=?,cGstate=? where cId=? ";
		Object[] in = {cttime,cGstate,cId};
		return DBUtil.executeUpdate(sql, in);
	}
	public int updatexx(int cId,String CName ,int CTeacher,String CNote,String CPhone) {
		String sql = "update Classs set cName=?,cTeacher=?,CNote=? ,CPhone=? where cId=? ";
		Object[] in = {CName,CTeacher,CNote,CPhone,cId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int cId) {
		String sql = "delete from Classs where cId=? ";
		Object[] in = {cId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(String cGstate){
	int count=0;
	String sql = "select count(*) from Classs where cGstate=?";
	Object [] in={ cGstate};
	ResultSet rs = DBUtil.executeQuery(sql,in);
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
