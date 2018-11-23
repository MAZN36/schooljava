package	com.bo;
import java.util.*;
import com.dao.Enter_TalkDAO;
import com.vo.Enter_Talk;
public class Enter_TalkBO {
	/**
	* 根据id查询,返回Enter_Talk,参数int id   根据id查询
	* @param id
	* @return
	*/
	Enter_TalkDAO dao=new Enter_TalkDAO(); 
	public Enter_Talk findById(int enter_id) {
		return dao.findById(enter_id);
	}
	/**
	* 查询全部,返回List<Enter_Talk>
	* @param id
	* @return
	*/
	public List<Enter_Talk> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Enter_Talk>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Enter_Talk> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Enter_Talk model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Enter_Talk model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int enter_id) {
		return dao.delete(enter_id);
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
