package	com.bo;
import java.util.*;
import com.dao.Student_CertificateDAO;
import com.vo.Student_Certificate;
public class Student_CertificateBO {
	/**
	* ����id��ѯ,����Student_Certificate,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Student_CertificateDAO dao=new Student_CertificateDAO(); 
	public Student_Certificate findById(int cer_id) {
		return dao.findById(cer_id);
	}
	/**
	* ��ѯȫ��,����List<Student_Certificate>
	* @param id
	* @return
	*/
	public List<Student_Certificate> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Student_Certificate>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Student_Certificate> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Student_Certificate model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Student_Certificate model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int cer_id) {
		return dao.delete(cer_id);
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
