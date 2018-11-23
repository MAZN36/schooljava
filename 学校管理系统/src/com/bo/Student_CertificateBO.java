package	com.bo;
import java.util.*;
import com.dao.Student_CertificateDAO;
import com.vo.Student_Certificate;
public class Student_CertificateBO {
	/**
	* 根据id查询,返回Student_Certificate,参数int id   根据id查询
	* @param id
	* @return
	*/
	Student_CertificateDAO dao=new Student_CertificateDAO(); 
	public Student_Certificate findById(int cer_id) {
		return dao.findById(cer_id);
	}
	/**
	* 查询全部,返回List<Student_Certificate>
	* @param id
	* @return
	*/
	public List<Student_Certificate> findAll() {
		return dao.findAll();
	}
	/**
	* 分页查询,返回List<Student_Certificate>,int page,int limit 第一个参数是第几页,第二个参数是多少条数据
	* @param id
	* @return
	*/
	public List<Student_Certificate> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* 添加方法,返回是否删除成功
	* @param
	* @return
	*/
	public int insert(Student_Certificate model) {
		return dao.insert(model);
	}
	/**
	* 修改方法,返回是否删除成功,参数传入对象
	* @param model
	* @return
	*/
	public int update(Student_Certificate model) {
		return dao.update(model);
	}
	/**
	* 删除方法,返回是否删除成功,参数传入id 根据id进行删除
	* @param id
	* @return
	*/
	public int delete(int cer_id) {
		return dao.delete(cer_id);
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
