package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.AdmBO;
import com.vo.Adm;
import com.dao.DBUtil;
/**
 * Servlet implementation class AdmControlle
 */
@WebServlet("/Adm"
)
public class AdmControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static AdmBO  bo=new AdmBO(); 
		Adm	adm=new Adm(); 
		int Id;
		String Department;
		String Adname;
		String Adpost;
		String Adphone;
		String Mailbox;
		String AdNote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Department=request.getParameter("Department");
		Adname=request.getParameter("Adname");
		Adpost=request.getParameter("Adpost");
		Adphone=request.getParameter("Adphone");
		Mailbox=request.getParameter("Mailbox");
		AdNote=request.getParameter("AdNote");
		adm.setDepartment(Department);
		adm.setAdname(Adname);
		adm.setAdpost(Adpost);
		adm.setAdphone(Adphone);
		adm.setMailbox(Mailbox);
		adm.setAdNote(AdNote);
		int sum=bo.insert(adm);
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
		Id=Integer.parseInt(request.getParameter("Id"));
		Department=request.getParameter("Department");
		Adname=request.getParameter("Adname");
		Adpost=request.getParameter("Adpost");
		Adphone=request.getParameter("Adphone");
		Mailbox=request.getParameter("Mailbox");
		AdNote=request.getParameter("AdNote");
		adm.setDepartment(Department);
		adm.setAdname(Adname);
		adm.setAdpost(Adpost);
		adm.setAdphone(Adphone);
		adm.setMailbox(Mailbox);
		adm.setAdNote(AdNote);
		adm.setId(Id);
		int sum=bo.update(adm);
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
		Id=Integer.parseInt(request.getParameter("Id"));
		int sum=bo.delete(Id);
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
		List<Adm> list=bo.findAll();
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
		List<Adm> list=bo.Paging(page, limit);
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
