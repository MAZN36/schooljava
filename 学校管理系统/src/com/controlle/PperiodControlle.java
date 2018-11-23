package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.PperiodBO;
import com.vo.Pperiod;
import com.dao.DBUtil;
/**
 * Servlet implementation class PperiodControlle
 */
@WebServlet("/Pperiod"
)
public class PperiodControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static PperiodBO  bo=new PperiodBO(); 
		Pperiod	Pperiod=new Pperiod(); 
		int PId;
		int PClasss;
		int PCourse;
		Date PDate;
		String PNote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		PClasss=Integer.parseInt(request.getParameter("PClasss"));
		PCourse=Integer.parseInt(request.getParameter("PCourse"));
		PDate=DBUtil.date(request.getParameter("PDate"));
		PNote=request.getParameter("PNote");
		Pperiod.setpClasss(PClasss);
		Pperiod.setpCourse(PCourse);
		Pperiod.setpDate(PDate);
		Pperiod.setpNote(PNote);
		int sum=bo.insert(Pperiod);
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
		PId=Integer.parseInt(request.getParameter("PId"));
		PClasss=Integer.parseInt(request.getParameter("PClasss"));
		PCourse=Integer.parseInt(request.getParameter("PCourse"));
		PDate=DBUtil.date(request.getParameter("PDate"));
		PNote=request.getParameter("PNote");
		Pperiod.setpClasss(PClasss);
		Pperiod.setpCourse(PCourse);
		Pperiod.setpDate(PDate);
		Pperiod.setpNote(PNote);
		Pperiod.setpId(PId);
		int sum=bo.update(Pperiod);
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
		PId=Integer.parseInt(request.getParameter("PId"));
		int sum=bo.delete(PId);
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
		List<Pperiod> list=bo.findAll();
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
		List<Pperiod> list=bo.Paging(page, limit);
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
