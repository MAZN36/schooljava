package	com.bo;
import java.util.*;
import com.dao.GradeDAO;
import com.vo.Grade;
public class GradeBO {
	/**
	* ����id��ѯ,����Grade,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	GradeDAO dao=new GradeDAO(); 
	public Grade findById(int gId) {
		return dao.findById(gId);
	}
	/**
	* ��ѯȫ��,����List<Grade>
	* @param id
	* @return
	*/
	public List<Grade> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Grade>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Grade> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Grade model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Grade model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int gId) {
		return dao.delete(gId);
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
