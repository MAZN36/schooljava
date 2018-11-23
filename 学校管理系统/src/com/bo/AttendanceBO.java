package	com.bo;
import java.util.*;
import com.dao.AttendanceDAO;
import com.vo.Attendance;
public class AttendanceBO {
	/**
	* ����id��ѯ,����Attendance,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	AttendanceDAO dao=new AttendanceDAO(); 
	public Attendance findById(int aId) {
		return dao.findById(aId);
	}
	/**
	* ��ѯȫ��,����List<Attendance>
	* @param id
	* @return
	*/
	public List<Attendance> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Attendance>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Attendance> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Attendance model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Attendance model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int aId) {
		return dao.delete(aId);
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
