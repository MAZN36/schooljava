package	com.dao;
import java.sql.*;
import java.util.*;
import com.vo.Student_results;
public class Student_resultsDAO {
	/**
	* ����id��ѯ,����Student_results,����int id   ����id��ѯ
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
	* ��ѯȫ��,����List<Student_results>
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
	* ��ҳ��ѯ,����List<Student_results>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_results> Paging(int page,int limit) {
	//��ʼ
	//�ڼ�ҳ-1��ÿҳ����������+1
	int start=(page-1)*limit+1;//��ʽ���ڻ�ȡ�����￪ʼ
	//����
	//�ڼ�ҳ��ÿҳ����������
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
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Student_results model) {
		String sql = "insert into Student_results values(?,?,?,?,?,?,?) ";
		Object[] in = {model.getRStudentid(),model.getRExamDate(),model.getROperating(),model.getRAnswer(),model.getRClasss(),model.getRPass(),model.getRNote()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_results model) {
		String sql = "update Student_results set rStudentid=?,rExamDate=?,rOperating=?,rAnswer=?,rClasss=?,rPass=?,rNote=? where rId=? ";
		Object[] in = {model.getRStudentid(),model.getRExamDate(),model.getROperating(),model.getRAnswer(),model.getRClasss(),model.getRPass(),model.getRNote(),model.getRId()};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int rId) {
		String sql = "delete from Student_results where rId=? ";
		Object[] in = {rId};
		return DBUtil.executeUpdate(sql, in);
	}
	/**
	* ��ȡ��������,���ض�����
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
