package	com.bo;
import java.util.*;
import com.dao.Roll_CallDAO;
import com.vo.Roll_Call;
public class Roll_CallBO {
	/**
	* ����id��ѯ,����Roll_Call,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Roll_CallDAO dao=new Roll_CallDAO(); 
	public Roll_Call findById(int Roll_id) {
		return dao.findById(Roll_id);
	}
	/**
	* ��ѯȫ��,����List<Roll_Call>
	* @param id
	* @return
	*/
	public List<Roll_Call> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Roll_Call>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Roll_Call> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Roll_Call model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Roll_Call model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int Roll_id) {
		return dao.delete(Roll_id);
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
