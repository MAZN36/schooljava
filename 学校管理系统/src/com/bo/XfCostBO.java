package	com.bo;
import java.util.*;
import com.dao.XfCostDAO;
import com.vo.XfCost;
public class XfCostBO {
	/**
	* 根据id查询,返回XfCost,参数int id   根据id查询
	* @param id
	* @return
	*/
	XfCostDAO dao=new XfCostDAO(); 
	public XfCost findById(int id) {
		return dao.findById(id);
	}
	/**
	* 查询全部,返回List<XfCost>
	* @param id
	* @return
	*/
	public List<XfCost> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<XfCost>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 分页查询,返回List<XfCost>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<XfCost> Paging(int page,int limit,String user) {
		return dao.Paging(page,limit,user);
	}
	public int count(int stuidxf) {
		return dao.count(stuidxf);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(XfCost model) {
		return dao.insert(model);
	}
	public int findstuidxf(int stuidxf,String danhao,double jyyr,String jyfs,String jylx)
	{
		return dao.findstuidxf(stuidxf, danhao, jyyr, jyfs, jylx);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(XfCost model) {
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
