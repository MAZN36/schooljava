package	com.bo;
import java.util.*;
import com.dao.Student_resultsDAO;
import com.vo.Student_results;
public class Student_resultsBO {
	/**
	* ����id��ѯ,����Student_results,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Student_resultsDAO dao=new Student_resultsDAO(); 
	public Student_results findById(int rId) {
		return dao.findById(rId);
	}
	/**
	* ��ѯȫ��,����List<Student_results>
	* @param id
	* @return
	*/
	public List<Student_results> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Student_results>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_results> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Student_results model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_results model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int rId) {
		return dao.delete(rId);
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
