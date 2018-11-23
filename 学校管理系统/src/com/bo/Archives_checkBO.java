package	com.bo;
import java.util.*;
import com.dao.Archives_checkDAO;
import com.vo.Archives_check;
public class Archives_checkBO {
	/**
	* ����id��ѯ,����Archives_check,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Archives_checkDAO dao=new Archives_checkDAO(); 
	public Archives_check findById(int arc_id) {
		return dao.findById(arc_id);
	}
	/**
	* ��ѯȫ��,����List<Archives_check>
	* @param id
	* @return
	*/
	public List<Archives_check> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Archives_check>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Archives_check> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Archives_check model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Archives_check model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int arc_id) {
		return dao.delete(arc_id);
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
