package	com.bo;
import java.util.*;
import com.dao.DownloadDAO;
import com.vo.Download;
public class DownloadBO {
	/**
	* ����id��ѯ,����Download,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	DownloadDAO dao=new DownloadDAO(); 
	public Download findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<Download>
	* @param id
	* @return
	*/
	public List<Download> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Download>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Download> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Download model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Download model) {
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
