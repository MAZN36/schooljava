package	com.bo;
import java.util.*;
import com.dao.NoticeDAO;
import com.vo.Notice;
public class NoticeBO {
	/**
	* ����id��ѯ,����Notice,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	NoticeDAO dao=new NoticeDAO(); 
	public Notice findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<Notice>
	* @param id
	* @return
	*/
	public List<Notice> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Notice>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Notice> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Notice model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Notice model) {
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
