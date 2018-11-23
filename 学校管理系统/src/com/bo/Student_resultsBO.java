package	com.bo;
import java.util.*;
import com.dao.Student_resultsDAO;
import com.vo.Student_results;
public class Student_resultsBO {
	/**
	* 根据id查询,返回Student_results,参数int id   根据id查询
	* @param id
	* @return
	*/
	Student_resultsDAO dao=new Student_resultsDAO(); 
	public Student_results findById(int rId) {
		return dao.findById(rId);
	}
	/**
	* 查询全部,返回List<Student_results>
	* @param id
	* @return
	*/
	public List<Student_results> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Student_results>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Student_results> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Student_results model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Student_results model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int rId) {
		return dao.delete(rId);
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
