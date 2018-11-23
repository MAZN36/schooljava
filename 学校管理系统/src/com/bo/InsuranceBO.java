package	com.bo;
import java.util.*;
import com.dao.InsuranceDAO;
import com.vo.Insurance;
public class InsuranceBO {
	/**
	* 根据id查询,返回Insurance,参数int id   根据id查询
	* @param id
	* @return
	*/
	InsuranceDAO dao=new InsuranceDAO(); 
	public Insurance findById(int Iid) {
		return dao.findById(Iid);
	}
	/**
	* 查询全部,返回List<Insurance>
	* @param id
	* @return
	*/
	public List<Insurance> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Insurance>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Insurance> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Insurance model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Insurance model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int Iid) {
		return dao.delete(Iid);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(){
		return dao.getcount();
	}
}
