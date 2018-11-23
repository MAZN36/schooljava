package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Student_resultsBO;
import com.vo.Student_results;
import com.dao.DBUtil;
/**
 * Servlet implementation class Student_resultsControlle
 */
@WebServlet("/Student_results"
)
public class Student_resultsControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Student_resultsBO  bo=new Student_resultsBO(); 
		Student_results	Student_results=new Student_results(); 
		int RId;
		int RStudentid;
		Date RExamDate;
		double ROperating;
		double RAnswer;
		int RClasss;
		String RPass;
		String RNote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		RStudentid=Integer.parseInt(request.getParameter("RStudentid"));
		RExamDate=DBUtil.date(request.getParameter("RExamDate"));
		ROperating=Double.parseDouble(request.getParameter("ROperating"));
		RAnswer=Double.parseDouble(request.getParameter("ROperating"));
		RClasss=Integer.parseInt(request.getParameter("RClasss"));
		RPass=request.getParameter("RPass");
		RNote=request.getParameter("RNote");
		Student_results.setRStudentid(RStudentid);
		Student_results.setRExamDate(RExamDate);
		Student_results.setROperating(ROperating);
		Student_results.setRAnswer(RAnswer);
		Student_results.setRClasss(RClasss);
		Student_results.setRPass(RPass);
		Student_results.setRNote(RNote);
		int sum=bo.insert(Student_results);
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
		RId=Integer.parseInt(request.getParameter("RId"));
		RStudentid=Integer.parseInt(request.getParameter("RStudentid"));
		RExamDate=DBUtil.date(request.getParameter("RExamDate"));
		ROperating=Double.parseDouble(request.getParameter("ROperating"));
		RAnswer=Double.parseDouble(request.getParameter("ROperating"));
		RClasss=Integer.parseInt(request.getParameter("RClasss"));
		RPass=request.getParameter("RPass");
		RNote=request.getParameter("RNote");
		Student_results.setRStudentid(RStudentid);
		Student_results.setRExamDate(RExamDate);
		Student_results.setROperating(ROperating);
		Student_results.setRAnswer(RAnswer);
		Student_results.setRClasss(RClasss);
		Student_results.setRPass(RPass);
		Student_results.setRNote(RNote);
		Student_results.setRId(RId);
		int sum=bo.update(Student_results);
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
		RId=Integer.parseInt(request.getParameter("RId"));
		int sum=bo.delete(RId);
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
		List<Student_results> list=bo.findAll();
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
		List<Student_results> list=bo.Paging(page, limit);
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
