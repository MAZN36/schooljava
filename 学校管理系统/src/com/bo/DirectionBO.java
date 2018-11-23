package	com.bo;
import java.util.*;
import com.dao.DirectionDAO;
import com.vo.Direction;
public class DirectionBO {
	/**
	* ����id��ѯ,����Direction,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	DirectionDAO dao=new DirectionDAO(); 
	public Direction findById(int dId) {
		return dao.findById(dId);
	}
	/**
	* ��ѯȫ��,����List<Direction>
	* @param id
	* @return
	*/
	public List<Direction> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Direction>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Direction> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Direction model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Direction model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int dId) {
		return dao.delete(dId);
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
