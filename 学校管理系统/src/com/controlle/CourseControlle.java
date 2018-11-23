package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.CourseBO;
import com.vo.Course;
import com.dao.DBUtil;
/**
 * Servlet implementation class CourseControlle
 */
@WebServlet("/Course"
)
public class CourseControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static CourseBO  bo=new CourseBO(); 
		Course	Course=new Course(); 
		int Course_id;
		String Course_name;
		int Course_number;
		int Course_sum;
		String Course_note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Course_name=request.getParameter("Course_name");
		Course_number=Integer.parseInt(request.getParameter("Course_number"));
		Course_sum=Integer.parseInt(request.getParameter("Course_sum"));
		Course_note=request.getParameter("Course_note");
		Course.setCourse_name(Course_name);
		Course.setCourse_number(Course_number);
		Course.setCourse_sum(Course_sum);
		Course.setCourse_note(Course_note);
		int sum=bo.insert(Course);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 修改操作
	 * @param request
	 * @param response
	*/
	public void update(HttpServletRequest request, HttpServletResponse response){
		Course_id=Integer.parseInt(request.getParameter("Course_id"));
		Course_name=request.getParameter("Course_name");
		Course_number=Integer.parseInt(request.getParameter("Course_number"));
		Course_sum=Integer.parseInt(request.getParameter("Course_sum"));
		Course_note=request.getParameter("Course_note");
		Course.setCourse_name(Course_name);
		Course.setCourse_number(Course_number);
		Course.setCourse_sum(Course_sum);
		Course.setCourse_note(Course_note);
		Course.setCourse_id(Course_id);
		int sum=bo.update(Course);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 修改操作
	 * @param request
	 * @param response
	*/
	public void delete(HttpServletRequest request, HttpServletResponse response){
		Course_id=Integer.parseInt(request.getParameter("Course_id"));
		int sum=bo.delete(Course_id);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 分页查询操作
	 * @param request
	 * @param response
	*/
	public void select(HttpServletRequest request, HttpServletResponse response){
		//分页查询
		Paging(request,response);
		}
	/****
	 * 全部查询操作
	 * @param request
	 * @param response
	*/
	public void selectAll(HttpServletRequest request, HttpServletResponse response){
		//全部查询
		finAll(request,response);
		}
	/**
	* 全部查询
	* @param id
	* @return
	*/
	private static void finAll(HttpServletRequest request, HttpServletResponse response) {
		List<Course> list=bo.findAll();
		R r=new R();
		r.setCount(bo.getcount());
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	/**
	* 分页查询
	* @param id
	* @return
	*/
	private static void Paging(HttpServletRequest request, HttpServletResponse response) {
		int page=Integer.parseInt(request.getParameter("page"));
		int limit=Integer.parseInt(request.getParameter("limit"));
		List<Course> list=bo.Paging(page, limit);
		R r=new R();
		r.setCount(bo.getcount());
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
}
