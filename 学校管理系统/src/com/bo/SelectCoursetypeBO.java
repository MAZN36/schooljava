package	com.bo;
import java.util.*;
import com.dao.SelectCoursetypeDAO;
import com.vo.SelectCoursetype;
public class SelectCoursetypeBO {
	/**
	* ����id��ѯ,����SelectCoursetype,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	SelectCoursetypeDAO dao=new SelectCoursetypeDAO(); 
	public SelectCoursetype findById(int select_id) {
		return dao.findById(select_id);
	}
	/**
	* ��ѯȫ��,����List<SelectCoursetype>
	* @param id
	* @return
	*/
	public List<SelectCoursetype> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<SelectCoursetype>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<SelectCoursetype> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(SelectCoursetype model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(SelectCoursetype model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int select_id) {
		return dao.delete(select_id);
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
