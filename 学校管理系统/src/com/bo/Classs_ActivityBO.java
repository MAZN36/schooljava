package	com.bo;
import java.util.*;
import com.dao.Classs_ActivityDAO;
import com.vo.Classs_Activity;
public class Classs_ActivityBO {
	/**
	* ����id��ѯ,����Classs_Activity,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Classs_ActivityDAO dao=new Classs_ActivityDAO(); 
	public Classs_Activity findById(int act_id) {
		return dao.findById(act_id);
	}
	/**
	* ��ѯȫ��,����List<Classs_Activity>
	* @param id
	* @return
	*/
	public List<Classs_Activity> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Classs_Activity>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Classs_Activity> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Classs_Activity model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Classs_Activity model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int act_id) {
		return dao.delete(act_id);
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
