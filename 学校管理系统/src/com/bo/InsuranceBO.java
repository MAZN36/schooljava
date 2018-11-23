package	com.bo;
import java.util.*;
import com.dao.InsuranceDAO;
import com.vo.Insurance;
public class InsuranceBO {
	/**
	* ����id��ѯ,����Insurance,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	InsuranceDAO dao=new InsuranceDAO(); 
	public Insurance findById(int Iid) {
		return dao.findById(Iid);
	}
	/**
	* ��ѯȫ��,����List<Insurance>
	* @param id
	* @return
	*/
	public List<Insurance> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Insurance>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Insurance> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Insurance model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Insurance model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int Iid) {
		return dao.delete(Iid);
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
