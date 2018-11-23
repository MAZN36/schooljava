package	com.bo;
import java.util.*;
import com.dao.CreditsDAO;
import com.vo.Credits;
public class CreditsBO {
	/**
	* ����id��ѯ,����Credits,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	CreditsDAO dao=new CreditsDAO(); 
	public Credits findById(int cId) {
		return dao.findById(cId);
	}
	/**
	* ��ѯȫ��,����List<Credits>
	* @param id
	* @return
	*/
	public List<Credits> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Credits>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Credits> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Credits model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Credits model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int cId) {
		return dao.delete(cId);
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
