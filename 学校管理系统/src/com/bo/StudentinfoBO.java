package	com.bo;
import java.util.*;
import com.dao.StudentinfoDAO;
import com.vo.Studentinfo;
public class StudentinfoBO {
	/**
	* ����id��ѯ,����Studentinfo,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	StudentinfoDAO dao=new StudentinfoDAO(); 
	public Studentinfo findById(String zt,int stuId) {
		return dao.findById(zt,stuId);
	}
	/**
	* ��ѯȫ��,����List<Studentinfo>
	* @param id
	* @return
	*/
	public List<Studentinfo> findAll(String zt) {
		return dao.findAll(zt);
	}
	/**
	* ��ҳ��ѯ,����List<Studentinfo>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Studentinfo> Paging(int page,int limit,String zt) {
		return dao.Paging(page,limit,zt);
	}
	/**
	* ��ҳ��ѯ,����List<Studentinfo>,int page,int limit, sname��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������,������ģ������
	* @param id
	* @return
	*/
	public List<Studentinfo> Paging(String sname,String zt) {
		return dao.Paging(sname,zt);
	}
	/**
	* ���ݰ༶��ѯȫ��
	* @param id
	* @return
	*/
	public List<Studentinfo> findAllsclasss(int sclasss,String zt) {
		return dao.findAllsclasss(sclasss,zt);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Studentinfo model) {
		return dao.insert(model);
	}
	/**
	* תѧ����,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int upzx(String xh,String sj) {
		return dao.upzx(xh,sj);
	}
	/**
	* �޸����뷽��
	* @param model
	* @return
	*/
	public int updatepa(Studentinfo model) {
		return dao.updatepa(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Studentinfo model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(String Studentid) {
		return dao.delete(Studentid);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(String zt){
		return dao.getcount(zt);
	}
	/**
	* ����������ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcountsname(String sname,String zt){
		return dao.getcountsname(sname,zt);
	}
	/**
	* ���ݰ༶��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcountsclasss(int sclasss,String zt){
		return dao.getcountsclasss(sclasss,zt);
	}
}
