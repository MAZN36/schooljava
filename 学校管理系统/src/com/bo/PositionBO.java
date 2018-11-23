package	com.bo;
import java.util.*;
import com.dao.PositionDAO;
import com.vo.Position;
public class PositionBO {
	/**
	* ����id��ѯ,����Position,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	PositionDAO dao=new PositionDAO(); 
	public Position findById(int pid) {
		return dao.findById(pid);
	}
	/**
	* ��ѯȫ��,����List<Position>
	* @param id
	* @return
	*/
	public List<Position> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Position>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Position> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Position model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Position model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int pid) {
		return dao.delete(pid);
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
