package	com.bo;
import java.util.*;
import com.dao.AdministratorDAO;
import com.vo.Administrator;
public class AdministratorBO {
	/**
	* ����id��ѯ,����Administrator,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	AdministratorDAO dao=new AdministratorDAO(); 
	public Administrator findById(int Admin_id) {
		return dao.findById(Admin_id);
	}
	/**
	* ��ѯȫ��,����List<Administrator>
	* @param id
	* @return
	*/
	public List<Administrator> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Administrator>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Administrator> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Administrator model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Administrator model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int Admin_id) {
		return dao.delete(Admin_id);
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
