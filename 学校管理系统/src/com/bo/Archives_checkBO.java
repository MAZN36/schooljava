package	com.bo;
import java.util.*;
import com.dao.Archives_checkDAO;
import com.vo.Archives_check;
public class Archives_checkBO {
	/**
	* 根据id查询,返回Archives_check,参数int id   根据id查询
	* @param id
	* @return
	*/
	Archives_checkDAO dao=new Archives_checkDAO(); 
	public Archives_check findById(int arc_id) {
		return dao.findById(arc_id);
	}
	/**
	* 查询全部,返回List<Archives_check>
	* @param id
	* @return
	*/
	public List<Archives_check> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Archives_check>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Archives_check> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Archives_check model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Archives_check model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int arc_id) {
		return dao.delete(arc_id);
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
