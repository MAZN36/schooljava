package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.CreditsBO;
import com.vo.Credits;
import com.dao.DBUtil;
/**
 * Servlet implementation class CreditsControlle
 */
@WebServlet("/Credits"
)
public class CreditsControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static CreditsBO  bo=new CreditsBO(); 
		Credits	Credits=new Credits(); 
		int CIds;
		int CClasssName;
		String CStudentid;
		int CSubjectsName;
		int CHavecredit;
		int COperator;
		String CNotes;
		int CId;
		String CName;
		int Course_id;
		String Course_name;
		int Tid;
		String TName;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		CClasssName=Integer.parseInt(request.getParameter("CClasssName"));
		CStudentid=request.getParameter("CStudentid");
		CSubjectsName=Integer.parseInt(request.getParameter("CSubjectsName"));
		CHavecredit=Integer.parseInt(request.getParameter("CHavecredit"));
		COperator=Integer.parseInt(request.getParameter("COperator"));
		CNotes=request.getParameter("CNotes");
		TName=request.getParameter("TName");
		Credits.setcClasssName(CClasssName);
		Credits.setcStudentid(CStudentid);
		Credits.setcSubjectsName(CSubjectsName);
		Credits.setcHavecredit(CHavecredit);
		Credits.setcOperator(COperator);
		Credits.setcNotes(CNotes);
		int sum=bo.insert(Credits);
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
		CClasssName=Integer.parseInt(request.getParameter("CClasssName"));
		CStudentid=request.getParameter("CStudentid");
		CSubjectsName=Integer.parseInt(request.getParameter("CSubjectsName"));
		CHavecredit=Integer.parseInt(request.getParameter("CHavecredit"));
		COperator=Integer.parseInt(request.getParameter("COperator"));
		CNotes=request.getParameter("CNotes");
		Credits.setcClasssName(CClasssName);
		Credits.setcStudentid(CStudentid);
		Credits.setcSubjectsName(CSubjectsName);
		Credits.setcHavecredit(CHavecredit);
		Credits.setcOperator(COperator);
		Credits.setcNotes(CNotes);
		Credits.setcIds(CIds);
		int sum=bo.update(Credits);
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
		List<Credits> list=bo.findAll();
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
		List<Credits> list=bo.Paging(page, limit);
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
