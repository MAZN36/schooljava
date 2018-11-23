package	com.bo;
import java.util.*;
import com.dao.ClasssDAO;
import com.vo.Classs;
public class ClasssBO {
	/**
	* 根据id查询,返回Classs,参数int id   根据id查询
	* @param id
	* @return
	*/
	ClasssDAO dao=new ClasssDAO(); 
	public Classs findById(int cId) {
		return dao.findById(cId);
	}
	/**
	* 根据年级查询全部,返回List<Classs>
	* @param id
	* @return
	*/
	public List<Classs> findAll(int p,String cGstate) {
		return dao.findAll(p,cGstate);
	}
	/**
	* 查询全部,返回List<Classs>
	* @param id
	* @return
	*/
	public List<Classs> findAll(String cGstate) {
		return dao.findAll(cGstate);
	}
	/**
	* 分页查询,返回List<Classs>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Classs> Paging(int page,int limit,String cGstate) {
		return dao.Paging(page,limit,cGstate);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Classs model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Classs model) {
		return dao.update(model);
	}
	public int updatexx(int cId,String CName ,int CTeacher,String CNote,String CPhone) {
		return dao.updatexx(cId,CName,CTeacher,CNote,CPhone);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int cId) {
		return dao.delete(cId);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(String cGstate){
		return dao.getcount(cGstate);
	}
}
