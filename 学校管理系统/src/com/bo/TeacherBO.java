package	com.bo;
import java.util.*;

import com.dao.DBUtil;
import com.dao.TeacherDAO;
import com.vo.Teacher;
public class TeacherBO {
	/**
	* ����id��ѯ,����Teacher,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	TeacherDAO dao=new TeacherDAO(); 
	public Teacher findById(int tid) {
		return dao.findById(tid);
	}
	/**
	* ��ѯְλȫ��,����List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(int tPosition,String zt) {
		return dao.findAll(tPosition,zt);
	}
	/**
	* ��ѯȫ��,����List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(String zw) {
		return dao.findAll(zw);
	}
	/**
	* ��ҳ��ѯ,����List<Teacher>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Teacher> Paging(int page,int limit,String zw) {
		return dao.Paging(page,limit,zw);
	}
	/**
	* �������ֲ�ѯ
	* @param id
	* @return
	*/
	public List<Teacher> findAll(String name,String zw) {
		return dao.findAll(name,zw);
	}
	
	
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Teacher model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Teacher model) {
		return dao.update(model);
	}
	/**
	* �޸����뷽��,
	* @param model
	* @return
	*/
	public int updatepa(Teacher model) {
		return dao.updatepa(model);
	}
	/**
	* �޸�ְλ����,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int update(int tid ,String zt) {
		return dao.update(tid,zt);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(String zt){
		return dao.getcount(zt);
	}
}
