package	com.bo;
import java.util.*;
import com.dao.Parents_TalkDAO;
import com.vo.Parents_Talk;
public class Parents_TalkBO {
	/**
	* ����id��ѯ,����Parents_Talk,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Parents_TalkDAO dao=new Parents_TalkDAO(); 
	public Parents_Talk findById(int par_id) {
		return dao.findById(par_id);
	}
	/**
	* ��ѯȫ��,����List<Parents_Talk>
	* @param id
	* @return
	*/
	public List<Parents_Talk> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Parents_Talk>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Parents_Talk> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Parents_Talk model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Parents_Talk model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int par_id) {
		return dao.delete(par_id);
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
