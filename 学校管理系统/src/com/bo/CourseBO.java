package	com.bo;
import java.util.*;
import com.dao.CourseDAO;
import com.vo.Course;
public class CourseBO {
	/**
	* 根据id查询,返回Course,参数int id   根据id查询
	* @param id
	* @return
	*/
	CourseDAO dao=new CourseDAO(); 
	public Course findById(int course_id) {
		return dao.findById(course_id);
	}
	/**
	* 查询全部,返回List<Course>
	* @param id
	* @return
	*/
	public List<Course> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Course>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Course> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Course model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Course model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int course_id) {
		return dao.delete(course_id);
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
