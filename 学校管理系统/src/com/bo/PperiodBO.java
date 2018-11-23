package	com.bo;
import java.util.*;
import com.dao.PperiodDAO;
import com.vo.Pperiod;
public class PperiodBO {
	/**
	* ����id��ѯ,����Pperiod,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	PperiodDAO dao=new PperiodDAO(); 
	public Pperiod findById(int pId) {
		return dao.findById(pId);
	}
	/**
	* ��ѯȫ��,����List<Pperiod>
	* @param id
	* @return
	*/
	public List<Pperiod> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Pperiod>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Pperiod> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Pperiod model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Pperiod model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int pId) {
		return dao.delete(pId);
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
