package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Classs_ActivityBO;
import com.vo.Classs_Activity;
import com.dao.DBUtil;
/**
 * Servlet implementation class Classs_ActivityControlle
 */
@WebServlet("/Classs_Activity"
)
public class Classs_ActivityControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Classs_ActivityBO  bo=new Classs_ActivityBO(); 
		Classs_Activity	Classs_Activity=new Classs_Activity(); 
		int Act_id;
		int Act_Classs;
		String Act_Teme;
		Date Act_Time;
		String Act_Location;
		String Act_Content;
		String Act_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Act_Classs=Integer.parseInt(request.getParameter("Act_Classs"));
		Act_Teme=request.getParameter("Act_Teme");
		Act_Time=DBUtil.date(request.getParameter("Act_Time"));
		Act_Location=request.getParameter("Act_Location");
		Act_Content=request.getParameter("Act_Content");
		Act_Note=request.getParameter("Act_Note");
		Classs_Activity.setAct_Classs(Act_Classs);
		Classs_Activity.setAct_Teme(Act_Teme);
		Classs_Activity.setAct_Time(Act_Time);
		Classs_Activity.setAct_Location(Act_Location);
		Classs_Activity.setAct_Content(Act_Content);
		Classs_Activity.setAct_Note(Act_Note);
		int sum=bo.insert(Classs_Activity);
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
		Act_id=Integer.parseInt(request.getParameter("Act_id"));
		Act_Classs=Integer.parseInt(request.getParameter("Act_Classs"));
		Act_Teme=request.getParameter("Act_Teme");
		Act_Time=DBUtil.date(request.getParameter("Act_Time"));
		Act_Location=request.getParameter("Act_Location");
		Act_Content=request.getParameter("Act_Content");
		Act_Note=request.getParameter("Act_Note");
		Classs_Activity.setAct_Classs(Act_Classs);
		Classs_Activity.setAct_Teme(Act_Teme);
		Classs_Activity.setAct_Time(Act_Time);
		Classs_Activity.setAct_Location(Act_Location);
		Classs_Activity.setAct_Content(Act_Content);
		Classs_Activity.setAct_Note(Act_Note);
		Classs_Activity.setAct_id(Act_id);
		int sum=bo.update(Classs_Activity);
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
		Act_id=Integer.parseInt(request.getParameter("Act_id"));
		int sum=bo.delete(Act_id);
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
		List<Classs_Activity> list=bo.findAll();
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
		List<Classs_Activity> list=bo.Paging(page, limit);
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
