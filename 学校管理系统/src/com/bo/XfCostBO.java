package	com.bo;
import java.util.*;
import com.dao.XfCostDAO;
import com.vo.XfCost;
public class XfCostBO {
	/**
	* ����id��ѯ,����XfCost,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	XfCostDAO dao=new XfCostDAO(); 
	public XfCost findById(int id) {
		return dao.findById(id);
	}
	/**
	* ��ѯȫ��,����List<XfCost>
	* @param id
	* @return
	*/
	public List<XfCost> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<XfCost>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ҳ��ѯ,����List<XfCost>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit,String user) {
		return dao.Paging(page,limit,user);
	}
	public int count(int stuidxf) {
		return dao.count(stuidxf);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(XfCost model) {
		return dao.insert(model);
	}
	public int findstuidxf(int stuidxf,String danhao,double jyyr,String jyfs,String jylx)
	{
		return dao.findstuidxf(stuidxf, danhao, jyyr, jyfs, jylx);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(XfCost model) {
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
