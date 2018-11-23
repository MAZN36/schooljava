package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.ClasssBO;
import com.vo.Classs;
import com.dao.DBUtil;
import com.dao.TeacherDAO;
/**
 * Servlet implementation class ClasssControlle
 */
@WebServlet("/Classs"
)
public class ClasssControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static ClasssBO  bo=new ClasssBO(); 
		Classs	Classs=new Classs(); 
		int CId;
		String CName;
		int CTypeName;
		String CGraduated;
		Date CGtime;
		static String CGstate;
		int CTeacher;
		String CPhone;
		String CNote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		CName=request.getParameter("CName");
		CTypeName=Integer.parseInt(request.getParameter("CTypeName"));
		CGtime=DBUtil.date(request.getParameter("CGtime"));
		CTeacher=Integer.parseInt(request.getParameter("CTeacher"));
		CNote=request.getParameter("CNote");
		Classs.setcName(CName);
		Classs.setcTypeName(CTypeName);
		Classs.setcGtime(CGtime);
		Classs.setcTeacher(CTeacher);
		Classs.setcNote(CNote);
		TeacherDAO r=new TeacherDAO();
		String ph=r.findById(CTeacher).getTTelephone();
		Classs.setcPhone( ph);
		int sum=bo.insert(Classs);
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
		CId=Integer.parseInt(request.getParameter("CId"));
		CName=request.getParameter("CName");
		CTypeName=Integer.parseInt(request.getParameter("CTypeName"));
		CGraduated=request.getParameter("CGraduated");
		CGtime=DBUtil.date(request.getParameter("CGtime"));
		CGstate=request.getParameter("CGstate");
		CTeacher=Integer.parseInt(request.getParameter("CTeacher"));
		CPhone=request.getParameter("CPhone");
		CNote=request.getParameter("CNote");
		Classs.setcName(CName);
		Classs.setcTypeName(CTypeName);
		Classs.setcGraduated(CGraduated);
		Classs.setcGtime(CGtime);
		Classs.setcGstate(CGstate);
		Classs.setcTeacher(CTeacher);
		Classs.setcPhone(CPhone);
		Classs.setcNote(CNote);
		Classs.setcId(CId);
		int sum=bo.update(Classs);
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
	public void updatexx(HttpServletRequest request, HttpServletResponse response){
		CId=Integer.parseInt(request.getParameter("CId"));
		CName=request.getParameter("CName");
		CTeacher=Integer.parseInt(request.getParameter("CTeacher"));
		CNote=request.getParameter("CNote");
		TeacherDAO r=new TeacherDAO();
		String ph=r.findById(CTeacher).getTTelephone();
		int sum=bo.updatexx(CId,CName,CTeacher,CNote,ph);
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
		CId=Integer.parseInt(request.getParameter("CId"));
		int sum=bo.delete(CId);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	/****
	 * 根据年级查询操作
	 * @param request
	 * @param response
	*/
	public void finAlltPosition(HttpServletRequest request, HttpServletResponse response){
		CTypeName=Integer.parseInt(request.getParameter("cTypeName"));
		CGstate=request.getParameter("cGstate");
		List<Classs> list=bo.findAll(CTypeName,CGstate);
		R r=new R();
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
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
		CGstate=request.getParameter("cGstate");
		List<Classs> list=bo.findAll(CGstate);
		R r=new R();
		r.setCount(bo.getcount(CGstate));
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
		CGstate=request.getParameter("cGstate");
		List<Classs> list=bo.Paging(page, limit,CGstate);
		R r=new R();
		r.setCount(bo.getcount(CGstate));
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
}
