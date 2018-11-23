package	com.bo;
import java.util.*;
import com.dao.BfDAO;
import com.vo.Bf;
public class BfBO {
	/**
	* ����id��ѯ,����Bf,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	BfDAO dao=new BfDAO(); 
	public Bf findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<Bf>
	* @param id
	* @return
	*/
	public List<Bf> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Bf>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Bf> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Bf model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Bf model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int id) {
		return dao.delete(id);
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
