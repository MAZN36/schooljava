package	com.bo;
import java.util.*;
import com.dao.Student_TalkDAO;
import com.vo.Student_Talk;
public class Student_TalkBO {
	/**
	* ����id��ѯ,����Student_Talk,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Student_TalkDAO dao=new Student_TalkDAO(); 
	public Student_Talk findById(int stu_id) {
		return dao.findById(stu_id);
	}
	/**
	* ��ѯȫ��,����List<Student_Talk>
	* @param id
	* @return
	*/
	public List<Student_Talk> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Student_Talk>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_Talk> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Student_Talk model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_Talk model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int stu_id) {
		return dao.delete(stu_id);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
		return dao.getcount();
	}
}
