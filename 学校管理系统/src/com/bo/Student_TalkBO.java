package	com.bo;
import java.util.*;
import com.dao.Student_TalkDAO;
import com.vo.Student_Talk;
public class Student_TalkBO {
	/**
	* 根据id查询,返回Student_Talk,参数int id   根据id查询
	* @param id
	* @return
	*/
	Student_TalkDAO dao=new Student_TalkDAO(); 
	public Student_Talk findById(int stu_id) {
		return dao.findById(stu_id);
	}
	/**
	* 查询全部,返回List<Student_Talk>
	* @param id
	* @return
	*/
	public List<Student_Talk> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Student_Talk>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Student_Talk> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Student_Talk model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Student_Talk model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int stu_id) {
		return dao.delete(stu_id);
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
