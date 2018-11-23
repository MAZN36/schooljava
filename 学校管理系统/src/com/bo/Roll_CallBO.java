package	com.bo;
import java.util.*;
import com.dao.Roll_CallDAO;
import com.vo.Roll_Call;
public class Roll_CallBO {
	/**
	* 根据id查询,返回Roll_Call,参数int id   根据id查询
	* @param id
	* @return
	*/
	Roll_CallDAO dao=new Roll_CallDAO(); 
	public Roll_Call findById(int Roll_id) {
		return dao.findById(Roll_id);
	}
	/**
	* 查询全部,返回List<Roll_Call>
	* @param id
	* @return
	*/
	public List<Roll_Call> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Roll_Call>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Roll_Call> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Roll_Call model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Roll_Call model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int Roll_id) {
		return dao.delete(Roll_id);
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
