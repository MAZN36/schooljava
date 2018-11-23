package	com.bo;
import java.util.*;
import com.dao.Classs_ActivityDAO;
import com.vo.Classs_Activity;
public class Classs_ActivityBO {
	/**
	* 根据id查询,返回Classs_Activity,参数int id   根据id查询
	* @param id
	* @return
	*/
	Classs_ActivityDAO dao=new Classs_ActivityDAO(); 
	public Classs_Activity findById(int act_id) {
		return dao.findById(act_id);
	}
	/**
	* 查询全部,返回List<Classs_Activity>
	* @param id
	* @return
	*/
	public List<Classs_Activity> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Classs_Activity>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Classs_Activity> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Classs_Activity model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Classs_Activity model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int act_id) {
		return dao.delete(act_id);
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
