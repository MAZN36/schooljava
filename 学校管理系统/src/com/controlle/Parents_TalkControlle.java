package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Parents_TalkBO;
import com.vo.Parents_Talk;
import com.dao.DBUtil;
/**
 * Servlet implementation class Parents_TalkControlle
 */
@WebServlet("/Parents_Talk"
)
public class Parents_TalkControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Parents_TalkBO  bo=new Parents_TalkBO(); 
		Parents_Talk	Parents_Talk=new Parents_Talk(); 
		int Par_id;
		int Par_Studentid;
		Date Par_Time;
		String Par_Content;
		int Par_Operator;
		String Par_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Par_Studentid=Integer.parseInt(request.getParameter("Par_Studentid"));
		Par_Time=DBUtil.date(request.getParameter("Par_Time"));
		Par_Content=request.getParameter("Par_Content");
		Par_Operator=Integer.parseInt(request.getParameter("Par_Operator"));
		Par_Note=request.getParameter("Par_Note");
		Parents_Talk.setPar_Studentid(Par_Studentid);
		Parents_Talk.setPar_Time(Par_Time);
		Parents_Talk.setPar_Content(Par_Content);
		Parents_Talk.setPar_Operator(Par_Operator);
		Parents_Talk.setPar_Note(Par_Note);
		int sum=bo.insert(Parents_Talk);
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
		Par_id=Integer.parseInt(request.getParameter("Par_id"));
		Par_Studentid=Integer.parseInt(request.getParameter("Par_Studentid"));
		Par_Time=DBUtil.date(request.getParameter("Par_Time"));
		Par_Content=request.getParameter("Par_Content");
		Par_Operator=Integer.parseInt(request.getParameter("Par_Operator"));
		Par_Note=request.getParameter("Par_Note");
		Parents_Talk.setPar_Studentid(Par_Studentid);
		Parents_Talk.setPar_Time(Par_Time);
		Parents_Talk.setPar_Content(Par_Content);
		Parents_Talk.setPar_Operator(Par_Operator);
		Parents_Talk.setPar_Note(Par_Note);
		Parents_Talk.setPar_id(Par_id);
		int sum=bo.update(Parents_Talk);
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
		Par_id=Integer.parseInt(request.getParameter("Par_id"));
		int sum=bo.delete(Par_id);
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
		List<Parents_Talk> list=bo.findAll();
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
		List<Parents_Talk> list=bo.Paging(page, limit);
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
