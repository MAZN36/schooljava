package	com.bo;
import java.util.*;
import com.dao.CourseDAO;
import com.vo.Course;
public class CourseBO {
	/**
	* ����id��ѯ,����Course,����int id   ����id��ѯ
	* @param id
	* @return
	*/
	CourseDAO dao=new CourseDAO(); 
	public Course findById(int course_id) {
		return dao.findById(course_id);
	}
	/**
	* ��ѯȫ��,����List<Course>
	* @param id
	* @return
	*/
	public List<Course> findAll() {
		return dao.findAll();
	}
	/**
	* ��ҳ��ѯ,����List<Course>,int page,int limit ��һ�������ǵڼ�ҳ,�ڶ��������Ƕ���������
	* @param id
	* @return
	*/
	public List<Course> Paging(int page,int limit) {
		return dao.Paging(page,limit);
	}
	/**
	* ��ӷ���,�����Ƿ�ɾ���ɹ�
	* @param
	* @return
	*/
	public int insert(Course model) {
		return dao.insert(model);
	}
	/**
	* �޸ķ���,�����Ƿ�ɾ���ɹ�,�����������
	* @param model
	* @return
	*/
	public int update(Course model) {
		return dao.update(model);
	}
	/**
	* ɾ������,�����Ƿ�ɾ���ɹ�,��������id ����id����ɾ��
	* @param id
	* @return
	*/
	public int delete(int course_id) {
		return dao.delete(course_id);
	}
	/**
	* ��ȡ��������,���ض�����
	* @param
	* @return
	*/
	public int getcount(){
		return dao.getcount();
	}
}
