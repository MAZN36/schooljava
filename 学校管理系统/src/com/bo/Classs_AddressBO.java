package	com.bo;
import java.util.*;
import com.dao.Classs_AddressDAO;
import com.vo.Classs_Address;
public class Classs_AddressBO {
	/**
	* 根据id查询,返回Classs_Address,参数int id   根据id查询
	* @param id
	* @return
	*/
	Classs_AddressDAO dao=new Classs_AddressDAO(); 
	public Classs_Address findById(int address_id) {
		return dao.findById(address_id);
	}
	/**
	* 查询全部,返回List<Classs_Address>
	* @param id
	* @return
	*/
	public List<Classs_Address> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Classs_Address>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Classs_Address> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Classs_Address model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Classs_Address model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int address_id) {
		return dao.delete(address_id);
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
