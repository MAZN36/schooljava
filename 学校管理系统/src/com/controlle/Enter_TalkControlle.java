package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Enter_TalkBO;
import com.vo.Enter_Talk;
import com.dao.DBUtil;
/**
 * Servlet implementation class Enter_TalkControlle
 */
@WebServlet("/Enter_Talk"
)
public class Enter_TalkControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Enter_TalkBO  bo=new Enter_TalkBO(); 
		Enter_Talk	Enter_Talk=new Enter_Talk(); 
		int Enter_id;
		int Enter_Studentid;
		Date Enter_Time;
		String Enter_Content;
		int Enter_Operator;
		String Enter_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Enter_Studentid=Integer.parseInt(request.getParameter("Enter_Studentid"));
		Enter_Time=DBUtil.date(request.getParameter("Enter_Time"));
		Enter_Content=request.getParameter("Enter_Content");
		Enter_Operator=Integer.parseInt(request.getParameter("Enter_Operator"));
		Enter_Note=request.getParameter("Enter_Note");
		Enter_Talk.setEnter_Studentid(Enter_Studentid);
		Enter_Talk.setEnter_Time(Enter_Time);
		Enter_Talk.setEnter_Content(Enter_Content);
		Enter_Talk.setEnter_Operator(Enter_Operator);
		Enter_Talk.setEnter_Note(Enter_Note);
		int sum=bo.insert(Enter_Talk);
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
		Enter_id=Integer.parseInt(request.getParameter("Enter_id"));
		Enter_Studentid=Integer.parseInt(request.getParameter("Enter_Studentid"));
		Enter_Time=DBUtil.date(request.getParameter("Enter_Time"));
		Enter_Content=request.getParameter("Enter_Content");
		Enter_Operator=Integer.parseInt(request.getParameter("Enter_Operator"));
		Enter_Note=request.getParameter("Enter_Note");
		Enter_Talk.setEnter_Studentid(Enter_Studentid);
		Enter_Talk.setEnter_Time(Enter_Time);
		Enter_Talk.setEnter_Content(Enter_Content);
		Enter_Talk.setEnter_Operator(Enter_Operator);
		Enter_Talk.setEnter_Note(Enter_Note);
		Enter_Talk.setEnter_id(Enter_id);
		int sum=bo.update(Enter_Talk);
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
		Enter_id=Integer.parseInt(request.getParameter("Enter_id"));
		int sum=bo.delete(Enter_id);
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
		List<Enter_Talk> list=bo.findAll();
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
		List<Enter_Talk> list=bo.Paging(page, limit);
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
