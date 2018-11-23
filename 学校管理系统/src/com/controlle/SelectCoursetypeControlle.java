package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.SelectCoursetypeBO;
import com.vo.SelectCoursetype;
import com.dao.DBUtil;
/**
 * Servlet implementation class SelectCoursetypeControlle
 */
@WebServlet("/SelectCoursetype"
)
public class SelectCoursetypeControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static SelectCoursetypeBO  bo=new SelectCoursetypeBO(); 
		SelectCoursetype	SelectCoursetype=new SelectCoursetype(); 
		int Select_id;
		String Select_name;
		String Select_target;
		String Select_introduce;
		String Select_capacityv;
		String Select_jobs;
		String Select_teacher;
		String Select_Headmaster;
		String Select_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Select_name=request.getParameter("Select_name");
		Select_target=request.getParameter("Select_target");
		Select_introduce=request.getParameter("Select_introduce");
		Select_capacityv=request.getParameter("Select_capacityv");
		Select_jobs=request.getParameter("Select_jobs");
		Select_teacher=request.getParameter("Select_teacher");
		Select_Headmaster=request.getParameter("Select_Headmaster");
		Select_Note=request.getParameter("Select_Note");
		SelectCoursetype.setSelect_name(Select_name);
		SelectCoursetype.setSelect_target(Select_target);
		SelectCoursetype.setSelect_introduce(Select_introduce);
		SelectCoursetype.setSelect_capacityv(Select_capacityv);
		SelectCoursetype.setSelect_jobs(Select_jobs);
		SelectCoursetype.setSelect_teacher(Select_teacher);
		SelectCoursetype.setSelect_Headmaster(Select_Headmaster);
		SelectCoursetype.setSelect_Note(Select_Note);
		int sum=bo.insert(SelectCoursetype);
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
		Select_id=Integer.parseInt(request.getParameter("Select_id"));
		Select_name=request.getParameter("Select_name");
		Select_target=request.getParameter("Select_target");
		Select_introduce=request.getParameter("Select_introduce");
		Select_capacityv=request.getParameter("Select_capacityv");
		Select_jobs=request.getParameter("Select_jobs");
		Select_teacher=request.getParameter("Select_teacher");
		Select_Headmaster=request.getParameter("Select_Headmaster");
		Select_Note=request.getParameter("Select_Note");
		SelectCoursetype.setSelect_name(Select_name);
		SelectCoursetype.setSelect_target(Select_target);
		SelectCoursetype.setSelect_introduce(Select_introduce);
		SelectCoursetype.setSelect_capacityv(Select_capacityv);
		SelectCoursetype.setSelect_jobs(Select_jobs);
		SelectCoursetype.setSelect_teacher(Select_teacher);
		SelectCoursetype.setSelect_Headmaster(Select_Headmaster);
		SelectCoursetype.setSelect_Note(Select_Note);
		SelectCoursetype.setSelect_id(Select_id);
		int sum=bo.update(SelectCoursetype);
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
		Select_id=Integer.parseInt(request.getParameter("Select_id"));
		int sum=bo.delete(Select_id);
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
		List<SelectCoursetype> list=bo.findAll();
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
		List<SelectCoursetype> list=bo.Paging(page, limit);
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
