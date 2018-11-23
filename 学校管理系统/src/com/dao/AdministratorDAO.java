package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Administrator;
public class AdministratorDAO {
	/**
	* ����id��ѯ,����Administrator,����int id   ����id��ѯ
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
		String sql="select count(*) from Administrator where Admin_Account=? and Admin_Password=? and Admin_State='����'";
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
	* ��ѯȫ��,����List<Administrator>
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
	* ��ҳ��ѯ,����List<Administrator>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Administrator> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
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
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Administrator model) {
		String sql = "insert into Administrator values(?,?,?,?,?) ";
		Object[] in = {model.getAdmin_Name(),model.getAdmin_Account(),DBUtil.MD5(model.getAdmin_Password()),model.getAdmin_State(),model.getAdmin_Note()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Administrator model) {
		String sql = "update Administrator set Admin_State=? where Admin_id=? ";
		Object[] in = {model.getAdmin_State(),model.getAdmin_id()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int updatepa(Administrator model) {
		String sql = "update Administrator set Admin_Password=? where Admin_Account=? ";
		Object[] in = {model.getAdmin_Password(),model.getAdmin_Account()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int Admin_id) {
		String sql = "delete from Administrator where Admin_id=? ";
		Object[] in = {Admin_id};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
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
