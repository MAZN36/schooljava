package	com.bo;
import java.util.*;
import com.dao.ClasssDAO;
import com.vo.Classs;
public class ClasssBO {
	/**
	* ����id��ѯ,����Classs,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	ClasssDAO dao=new ClasssDAO(); 
	public Classs findById(int cId) {
		return dao.findById(cId);
	}
	/**
	* �����꼶��ѯȫ��,����List<Classs>
	* @param id
	* @return
	*/
	public List<Classs> findAll(int p,String cGstate) {
		return dao.findAll(p,cGstate);
	}
	/**
	* ��ѯȫ��,����List<Classs>
	* @param id
	* @return
	*/
	public List<Classs> findAll(String cGstate) {
		return dao.findAll(cGstate);
	}
	/**
	* ��ҳ��ѯ,����List<Classs>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Classs> Paging(int page,int limit,String cGstate) {
		return dao.Paging(page,limit,cGstate);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Classs model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Classs model) {
		return dao.update(model);
	}
	public int updatexx(int cId,String CName ,int CTeacher,String CNote,String CPhone) {
		return dao.updatexx(cId,CName,CTeacher,CNote,CPhone);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int cId) {
		return dao.delete(cId);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(String cGstate){
		return dao.getcount(cGstate);
	}
}
