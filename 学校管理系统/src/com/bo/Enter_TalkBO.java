package	com.bo;
import java.util.*;
import com.dao.Enter_TalkDAO;
import com.vo.Enter_Talk;
public class Enter_TalkBO {
	/**
	* ����id��ѯ,����Enter_Talk,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Enter_TalkDAO dao=new Enter_TalkDAO(); 
	public Enter_Talk findById(int enter_id) {
		return dao.findById(enter_id);
	}
	/**
	* ��ѯȫ��,����List<Enter_Talk>
	* @param id
	* @return
	*/
	public List<Enter_Talk> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Enter_Talk>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Enter_Talk> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Enter_Talk model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Enter_Talk model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int enter_id) {
		return dao.delete(enter_id);
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
