package	com.bo;
import java.util.*;
import com.dao.PperiodDAO;
import com.vo.Pperiod;
public class PperiodBO {
	/**
	* 根据id查询,返回Pperiod,参数int id   根据id查询
	* @param id
	* @return
	*/
	PperiodDAO dao=new PperiodDAO(); 
	public Pperiod findById(int pId) {
		return dao.findById(pId);
	}
	/**
	* 查询全部,返回List<Pperiod>
	* @param id
	* @return
	*/
	public List<Pperiod> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Pperiod>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Pperiod> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Pperiod model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Pperiod model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int pId) {
		return dao.delete(pId);
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
