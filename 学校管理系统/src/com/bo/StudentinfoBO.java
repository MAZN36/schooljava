package	com.bo;
import java.util.*;
import com.dao.StudentinfoDAO;
import com.vo.Studentinfo;
public class StudentinfoBO {
	/**
	* 根据id查询,返回Studentinfo,参数int id   根据id查询
	* @param id
	* @return
	*/
	StudentinfoDAO dao=new StudentinfoDAO(); 
	public Studentinfo findById(String zt,int stuId) {
		return dao.findById(zt,stuId);
	}
	/**
	* 查询全部,返回List<Studentinfo>
	* @param id
	* @return
	*/
	public List<Studentinfo> findAll(String zt) {
		return dao.findAll(zt);
	}
	/**
	* 分页查询,返回List<Studentinfo>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Studentinfo> Paging(int page,int limit,String zt) {
		return dao.Paging(page,limit,zt);
	}
	/**
	* 分页查询,返回List<Studentinfo>,int page,int limit, sname第一个参数是第几页,第二个参数是多少条数据,第三是模糊名字
	* @param id
	* @return
	*/
	public List<Studentinfo> Paging(String sname,String zt) {
		return dao.Paging(sname,zt);
	}
	/**
	* 根据班级查询全部
	* @param id
	* @return
	*/
	public List<Studentinfo> findAllsclasss(int sclasss,String zt) {
		return dao.findAllsclasss(sclasss,zt);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Studentinfo model) {
		return dao.insert(model);
	}
	/**
	* 转学方法,返回是否删除成功
	* @param
	* @return
	*/
	public int upzx(String xh,String sj) {
		return dao.upzx(xh,sj);
	}
	/**
	* 修改密码方法
	* @param model
	* @return
	*/
	public int updatepa(Studentinfo model) {
		return dao.updatepa(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Studentinfo model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(String Studentid) {
		return dao.delete(Studentid);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(String zt){
		return dao.getcount(zt);
	}
	/**
	* 根据姓名获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcountsname(String sname,String zt){
		return dao.getcountsname(sname,zt);
	}
	/**
	* 根据班级获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcountsclasss(int sclasss,String zt){
		return dao.getcountsclasss(sclasss,zt);
	}
}
