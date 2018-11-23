package	com.bo;
import java.util.*;
import com.dao.AdmDAO;
import com.vo.Adm;
public class AdmBO {
	/**
	* ����id��ѯ,����Adm,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	AdmDAO dao=new AdmDAO(); 
	public Adm findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<Adm>
	* @param id
	* @return
	*/
	public List<Adm> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Adm>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Adm> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Adm model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Adm model) {
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
