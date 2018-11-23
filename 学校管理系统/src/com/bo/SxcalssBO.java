package	com.bo;
import java.util.*;
import com.dao.SxcalssDAO;
import com.vo.Sxcalss;
public class SxcalssBO {
	/**
	* ����id��ѯ,����Sxcalss,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	SxcalssDAO dao=new SxcalssDAO(); 
	public Sxcalss findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<Sxcalss>
	* @param id
	* @return
	*/
	public List<Sxcalss> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Sxcalss>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Sxcalss> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Sxcalss model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Sxcalss model) {
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
