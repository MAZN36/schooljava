package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Student_TalkBO;
import com.vo.Student_Talk;
import com.dao.DBUtil;
/**
 * Servlet implementation class Student_TalkControlle
 */
@WebServlet("/Student_Talk"
)
public class Student_TalkControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Student_TalkBO  bo=new Student_TalkBO(); 
		Student_Talk	Student_Talk=new Student_Talk(); 
		int Stu_id;
		int Stu_Studentid;
		Date Stu_Time;
		String Stu_Content;
		int Stu_Operator;
		String Stu_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Stu_Studentid=Integer.parseInt(request.getParameter("Stu_Studentid"));
		Stu_Time=DBUtil.date(request.getParameter("Stu_Time"));
		Stu_Content=request.getParameter("Stu_Content");
		Stu_Operator=Integer.parseInt(request.getParameter("Stu_Operator"));
		Stu_Note=request.getParameter("Stu_Note");
		Student_Talk.setStu_Studentid(Stu_Studentid);
		Student_Talk.setStu_Time(Stu_Time);
		Student_Talk.setStu_Content(Stu_Content);
		Student_Talk.setStu_Operator(Stu_Operator);
		Student_Talk.setStu_Note(Stu_Note);
		int sum=bo.insert(Student_Talk);
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
		Stu_id=Integer.parseInt(request.getParameter("Stu_id"));
		Stu_Studentid=Integer.parseInt(request.getParameter("Stu_Studentid"));
		Stu_Time=DBUtil.date(request.getParameter("Stu_Time"));
		Stu_Content=request.getParameter("Stu_Content");
		Stu_Operator=Integer.parseInt(request.getParameter("Stu_Operator"));
		Stu_Note=request.getParameter("Stu_Note");
		Student_Talk.setStu_Studentid(Stu_Studentid);
		Student_Talk.setStu_Time(Stu_Time);
		Student_Talk.setStu_Content(Stu_Content);
		Student_Talk.setStu_Operator(Stu_Operator);
		Student_Talk.setStu_Note(Stu_Note);
		Student_Talk.setStu_id(Stu_id);
		int sum=bo.update(Student_Talk);
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
		Stu_id=Integer.parseInt(request.getParameter("Stu_id"));
		int sum=bo.delete(Stu_id);
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
		List<Student_Talk> list=bo.findAll();
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
		List<Student_Talk> list=bo.Paging(page, limit);
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
