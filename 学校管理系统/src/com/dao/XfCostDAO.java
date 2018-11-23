package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.XfCost;
public class XfCostDAO {
	/**
	* ����id��ѯ,����XfCost,����int id   ����id��ѯ
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
	 * �Ȳ�ѯ��û������
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
	* ѧ�� ������ ���׽�� ���׷�ʽ ��������
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
	* ��ѯȫ��,����List<XfCost>
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
	* ��ҳ��ѯ,����List<XfCost>,int page,int limit user��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit,String user) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
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
	* ��ҳ��ѯ,����List<XfCost>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
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
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(XfCost model) {
		String sql = "insert into XfCost values(?,?,?,?,?,?,?,?) ";
		Object[] in = {model.getStuidxf(),model.getDanhao(),model.getJysj(),model.getJyqyr(),model.getJyhyr(),model.getJyyr(),model.getJyfs(),model.getJylx()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(XfCost model) {
		String sql = "update XfCost set stuidxf=?,danhao=?,jysj=?,jyqyr=?,jyhyr=?,jyyr=?,jyfs=?,jylx=? where id=? ";
		Object[] in = {model.getStuidxf(),model.getDanhao(),model.getJysj(),model.getJyqyr(),model.getJyhyr(),model.getJyyr(),model.getJyfs(),model.getJylx(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from XfCost where id=? ";
		Object[] in = {id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
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
