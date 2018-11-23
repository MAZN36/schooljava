package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Direction;
public class DirectionDAO {
	/**
	* ����id��ѯ,����Direction,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	public Direction findById(int dId) {
		String sql = "select * from Direction where dId=?";
		Object[] in = {dId};
		ResultSet rs = DBUtil.executeQuery(sql, in);
		Direction model = null;
		try {
			if(rs.next()) {
				model = new Direction(
					rs.getInt("dId"),
					rs.getInt("dStudentid"),
					rs.getInt("dClasss"),
					rs.getInt("dFirstchoice"),
					rs.getInt("dSecondchoice"),
					rs.getDate("dDate"),
					rs.getString("dNote"));
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	/**
	* ��ѯȫ��,����List<Direction>
	* @param id
	* @return
	*/
	public List<Direction> findAll() {
		String sql = "select * from Direction";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Direction> modelList = new ArrayList<Direction>();
		Direction model = null;
		try {
			while(rs.next()) {
				model = new Direction(
					rs.getInt("dId"),
					rs.getInt("dStudentid"),
					rs.getInt("dClasss"),
					rs.getInt("dFirstchoice"),
					rs.getInt("dSecondchoice"),
					rs.getDate("dDate"),
					rs.getString("dNote"));
				modelList.add(model);
			}
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	/**
	* ��ҳ��ѯ,����List<Direction>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Direction> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
	int end=page*limit;
	String sql = "select * from(SELECT *,ROW_NUMBER() over(order by dId desc) row FROM [Direction]) t where t.row>="+start+" and t.row<="+end;
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Direction> modelList = new ArrayList<Direction>();
		Direction model = null;
		try {
			while(rs.next()) {
				model = new Direction(
					rs.getInt("dId"),
					rs.getInt("dStudentid"),
					rs.getInt("dClasss"),
					rs.getInt("dFirstchoice"),
					rs.getInt("dSecondchoice"),
					rs.getDate("dDate"),
					rs.getString("dNote"));
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
	public int insert(Direction model) {
		String sql = "insert into Direction values(?,?,?,?,?,?) ";
		Object[] in = {model.getDStudentid(),model.getDClasss(),model.getDFirstchoice(),model.getDSecondchoice(),model.getDDate(),model.getDNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Direction model) {
		String sql = "update Direction set dStudentid=?,dClasss=?,dFirstchoice=?,dSecondchoice=?,dDate=?,dNote=? where dId=? ";
		Object[] in = {model.getDStudentid(),model.getDClasss(),model.getDFirstchoice(),model.getDSecondchoice(),model.getDDate(),model.getDNote(),model.getDId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int dId) {
		String sql = "delete from Direction where dId=? ";
		Object[] in = {dId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
	int count=0;
	String sql = "select count(*) from Direction";
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
