package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.InsuranceBO;
import com.vo.Insurance;
import com.dao.DBUtil;
/**
 * Servlet implementation class InsuranceControlle
 */
@WebServlet("/Insurance"
)
public class InsuranceControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static InsuranceBO  bo=new InsuranceBO(); 
		Insurance	Insurance=new Insurance(); 
		int Iid;
		int IStudentid;
		String IName;
		Date ITime;
		String IContent;
		String INote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		IStudentid=Integer.parseInt(request.getParameter("IStudentid"));
		IName=request.getParameter("IName");
		ITime=DBUtil.date(request.getParameter("ITime"));
		IContent=request.getParameter("IContent");
		INote=request.getParameter("INote");
		Insurance.setIStudentid(IStudentid);
		Insurance.setIName(IName);
		Insurance.setITime(ITime);
		Insurance.setIContent(IContent);
		Insurance.setINote(INote);
		int sum=bo.insert(Insurance);
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
		Iid=Integer.parseInt(request.getParameter("Iid"));
		IStudentid=Integer.parseInt(request.getParameter("IStudentid"));
		IName=request.getParameter("IName");
		ITime=DBUtil.date(request.getParameter("ITime"));
		IContent=request.getParameter("IContent");
		INote=request.getParameter("INote");
		Insurance.setIStudentid(IStudentid);
		Insurance.setIName(IName);
		Insurance.setITime(ITime);
		Insurance.setIContent(IContent);
		Insurance.setINote(INote);
		Insurance.setIid(Iid);
		int sum=bo.update(Insurance);
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
		Iid=Integer.parseInt(request.getParameter("Iid"));
		int sum=bo.delete(Iid);
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
		List<Insurance> list=bo.findAll();
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
		List<Insurance> list=bo.Paging(page, limit);
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
