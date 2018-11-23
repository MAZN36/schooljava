package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Archives_checkBO;
import com.vo.Archives_check;
import com.dao.DBUtil;
/**
 * Servlet implementation class Archives_checkControlle
 */
@WebServlet("/Archives_check"
)
public class Archives_checkControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Archives_checkBO  bo=new Archives_checkBO(); 
		Archives_check	Archives_check=new Archives_check(); 
		int Arc_id;
		int Arc_Classs;
		int Arc_Studentid;
		String Arc_Content;
		String Arc_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Arc_Classs=Integer.parseInt(request.getParameter("Arc_Classs"));
		Arc_Studentid=Integer.parseInt(request.getParameter("Arc_Studentid"));
		Arc_Content=request.getParameter("Arc_Content");
		Arc_Note=request.getParameter("Arc_Note");
		Archives_check.setArc_Classs(Arc_Classs);
		Archives_check.setArc_Studentid(Arc_Studentid);
		Archives_check.setArc_Content(Arc_Content);
		Archives_check.setArc_Note(Arc_Note);
		int sum=bo.insert(Archives_check);
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
		Arc_id=Integer.parseInt(request.getParameter("Arc_id"));
		Arc_Classs=Integer.parseInt(request.getParameter("Arc_Classs"));
		Arc_Studentid=Integer.parseInt(request.getParameter("Arc_Studentid"));
		Arc_Content=request.getParameter("Arc_Content");
		Arc_Note=request.getParameter("Arc_Note");
		Archives_check.setArc_Classs(Arc_Classs);
		Archives_check.setArc_Studentid(Arc_Studentid);
		Archives_check.setArc_Content(Arc_Content);
		Archives_check.setArc_Note(Arc_Note);
		Archives_check.setArc_id(Arc_id);
		int sum=bo.update(Archives_check);
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
		Arc_id=Integer.parseInt(request.getParameter("Arc_id"));
		int sum=bo.delete(Arc_id);
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
		List<Archives_check> list=bo.findAll();
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
		List<Archives_check> list=bo.Paging(page, limit);
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
