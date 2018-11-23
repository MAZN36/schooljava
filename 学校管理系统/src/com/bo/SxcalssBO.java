package	com.bo;
import java.util.*;
import com.dao.SxcalssDAO;
import com.vo.Sxcalss;
public class SxcalssBO {
	/**
	* 根据id查询,返回Sxcalss,参数int id   根据id查询
	* @param id
	* @return
	*/
	SxcalssDAO dao=new SxcalssDAO(); 
	public Sxcalss findById(int id) {
		return dao.findById(id);
	}
	/**
	* 查询全部,返回List<Sxcalss>
	* @param id
	* @return
	*/
	public List<Sxcalss> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Sxcalss>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Sxcalss> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Sxcalss model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Sxcalss model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int id) {
		return dao.delete(id);
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
