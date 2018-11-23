package	com.bo;
import java.util.*;

import com.dao.DBUtil;
import com.dao.TeacherDAO;
import com.vo.Teacher;
public class TeacherBO {
	/**
	* 根据id查询,返回Teacher,参数int id   根据id查询
	* @param id
	* @return
	*/
	TeacherDAO dao=new TeacherDAO(); 
	public Teacher findById(int tid) {
		return dao.findById(tid);
	}
	/**
	* 查询职位全部,返回List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(int tPosition,String zt) {
		return dao.findAll(tPosition,zt);
	}
	/**
	* 查询全部,返回List<Teacher>
	* @param id
	* @return
	*/
	public List<Teacher> findAll(String zw) {
		return dao.findAll(zw);
	}
	/**
	* 分页查询,返回List<Teacher>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Teacher> Paging(int page,int limit,String zw) {
		return dao.Paging(page,limit,zw);
	}
	/**
	* 根据名字查询
	* @param id
	* @return
	*/
	public List<Teacher> findAll(String name,String zw) {
		return dao.findAll(name,zw);
	}
	
	
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Teacher model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Teacher model) {
		return dao.update(model);
	}
	/**
	* 修改密码方法,
	* @param model
	* @return
	*/
	public int updatepa(Teacher model) {
		return dao.updatepa(model);
	}
	/**
	* 修改职位方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int update(int tid ,String zt) {
		return dao.update(tid,zt);
	}
	/**
	* 获取行数方法,返回多少行
	* @param
	* @return
	*/
	public int getcount(String zt){
		return dao.getcount(zt);
	}
}
