package	com.bo;
import java.util.*;
import com.dao.Classs_AddressDAO;
import com.vo.Classs_Address;
public class Classs_AddressBO {
	/**
	* ����id��ѯ,����Classs_Address,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	Classs_AddressDAO dao=new Classs_AddressDAO(); 
	public Classs_Address findById(int address_id) {
		return dao.findById(address_id);
	}
	/**
	* ��ѯȫ��,����List<Classs_Address>
	* @param id
	* @return
	*/
	public List<Classs_Address> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Classs_Address>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Classs_Address> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Classs_Address model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Classs_Address model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int address_id) {
		return dao.delete(address_id);
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
