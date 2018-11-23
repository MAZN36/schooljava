package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Adm;
public class AdmDAO {
	/**
	* ����id��ѯ,����Adm,����int id   ����id��ѯ
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
	* ��ѯȫ��,����List<Adm>
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
	/**
	* ��ҳ��ѯ,����List<Adm>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	
	public List<Adm> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
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
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Adm model) {
		String sql = "insert into Adm values(?,?,?,?,?,?) ";
		Object[] in = {model.getDepartment(),model.getAdname(),model.getAdpost(),model.getAdphone(),model.getMailbox(),model.getAdNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Adm model) {
		String sql = "update Adm set department=?,adname=?,adpost=?,adphone=?,Mailbox=?,adNote=? where id=? ";
		Object[] in = {model.getDepartment(),model.getAdname(),model.getAdpost(),model.getAdphone(),model.getMailbox(),model.getAdNote(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		String sql = "delete from Adm where id=? ";
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
