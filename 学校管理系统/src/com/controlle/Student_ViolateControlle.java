package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Student_ViolateBO;
import com.vo.Student_Violate;
import com.dao.DBUtil;
/**
 * Servlet implementation class Student_ViolateControlle
 */
@WebServlet("/Student_Violate"
)
public class Student_ViolateControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Student_ViolateBO  bo=new Student_ViolateBO(); 
		Student_Violate	Student_Violate=new Student_Violate(); 
		int Vio_id;
		int Vio_Studentid;
		Date Vio_Time;
		String Vio_Content;
		String Vio_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Vio_Studentid=Integer.parseInt(request.getParameter("Vio_Studentid"));
		Vio_Time=DBUtil.date(request.getParameter("Vio_Time"));
		Vio_Content=request.getParameter("Vio_Content");
		Vio_Note=request.getParameter("Vio_Note");
		Student_Violate.setVio_Studentid(Vio_Studentid);
		Student_Violate.setVio_Time(Vio_Time);
		Student_Violate.setVio_Content(Vio_Content);
		Student_Violate.setVio_Note(Vio_Note);
		int sum=bo.insert(Student_Violate);
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
		Vio_id=Integer.parseInt(request.getParameter("Vio_id"));
		Vio_Studentid=Integer.parseInt(request.getParameter("Vio_Studentid"));
		Vio_Time=DBUtil.date(request.getParameter("Vio_Time"));
		Vio_Content=request.getParameter("Vio_Content");
		Vio_Note=request.getParameter("Vio_Note");
		Student_Violate.setVio_Studentid(Vio_Studentid);
		Student_Violate.setVio_Time(Vio_Time);
		Student_Violate.setVio_Content(Vio_Content);
		Student_Violate.setVio_Note(Vio_Note);
		Student_Violate.setVio_id(Vio_id);
		int sum=bo.update(Student_Violate);
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
		Vio_id=Integer.parseInt(request.getParameter("Vio_id"));
		int sum=bo.delete(Vio_id);
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
		List<Student_Violate> list=bo.findAll();
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
		List<Student_Violate> list=bo.Paging(page, limit);
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
