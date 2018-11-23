package	com.bo;
import java.util.*;
import com.dao.PositionDAO;
import com.vo.Position;
public class PositionBO {
	/**
	* 根据id查询,返回Position,参数int id   根据id查询
	* @param id
	* @return
	*/
	PositionDAO dao=new PositionDAO(); 
	public Position findById(int pid) {
		return dao.findById(pid);
	}
	/**
	* 查询全部,返回List<Position>
	* @param id
	* @return
	*/
	public List<Position> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Position>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Position> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Position model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Position model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int pid) {
		return dao.delete(pid);
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
