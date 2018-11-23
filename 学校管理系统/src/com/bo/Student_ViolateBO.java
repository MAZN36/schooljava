package	com.bo;
import java.util.*;
import com.dao.Student_ViolateDAO;
import com.vo.Student_Violate;
public class Student_ViolateBO {
	/**
	* ����id��ѯ,����Student_Violate,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Student_ViolateDAO dao=new Student_ViolateDAO(); 
	public Student_Violate findById(int vio_id) {
		return dao.findById(vio_id);
	}
	/**
	* ��ѯȫ��,����List<Student_Violate>
	* @param id
	* @return
	*/
	public List<Student_Violate> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Student_Violate>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_Violate> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Student_Violate model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_Violate model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int vio_id) {
		return dao.delete(vio_id);
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
