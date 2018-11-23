package	com.bo;
import java.util.*;
import com.dao.AttendanceDAO;
import com.vo.Attendance;
public class AttendanceBO {
	/**
	* 根据id查询,返回Attendance,参数int id   根据id查询
	* @param id
	* @return
	*/
	AttendanceDAO dao=new AttendanceDAO(); 
	public Attendance findById(int aId) {
		return dao.findById(aId);
	}
	/**
	* 查询全部,返回List<Attendance>
	* @param id
	* @return
	*/
	public List<Attendance> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Attendance>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Attendance> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Attendance model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Attendance model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int aId) {
		return dao.delete(aId);
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
