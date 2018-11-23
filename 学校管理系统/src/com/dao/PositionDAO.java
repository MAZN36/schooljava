package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Position;
public class PositionDAO {
	/**
	* ����id��ѯ,����Position,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Position findById(int pid) {
		String sql = "select * from Position where pid=?";
		Object[] in = {pid};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Position model = null;
		try {
			if(rs.next()) {
				model = new Position(
					rs.getInt("pid"),
					rs.getString("pName"),
					rs.getString("pNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Position>
	* @param id
	* @return
	*/
	public List<Position> findAll() {
		String sql = "select * from Position";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Position> modelList = new ArrayList<Position>();
		Position model = null;
		try {
			while(rs.next()) {
				model = new Position(
					rs.getInt("pid"),
					rs.getString("pName"),
					rs.getString("pNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Position>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Position> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by pid desc) row FROM  Position left join(select count(*) cou,tPosition from Teacher group by tPosition)t on tPosition=Position.pid) t  where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Position> modelList = new ArrayList<Position>();
		Position model = null;
		try {
			while(rs.next()) {
				model = new Position(
					rs.getInt("pid"),
					rs.getString("pName"),
					rs.getString("cou"));
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
	public int insert(Position model) {
		String sql = "insert into Position values(?,?) ";
		Object[] in = {model.getPName(),model.getPNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Position model) {
		String sql = "update Position set pName=?,pNote=? where pid=? ";
		Object[] in = {model.getPName(),model.getPNote(),model.getPid()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int pid) {
		String sql = "delete from Position where pid=? ";
		Object[] in = {pid};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Position";
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
