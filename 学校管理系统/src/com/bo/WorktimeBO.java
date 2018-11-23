package	com.bo;
import java.util.*;
import com.dao.WorktimeDAO;
import com.vo.Worktime;
public class WorktimeBO {
	/**
	* ����id��ѯ,����Worktime,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	WorktimeDAO dao=new WorktimeDAO(); 
	public Worktime findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<Worktime>
	* @param id
	* @return
	*/
	public List<Worktime> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Worktime>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Worktime> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Worktime model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Worktime model) {
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
