package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.GradeBO;
import com.vo.Grade;
import com.dao.DBUtil;
/**
 * Servlet implementation class GradeControlle
 */
@WebServlet("/Grade"
)
public class GradeControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static GradeBO  bo=new GradeBO(); 
		Grade	Grade=new Grade(); 
		int GId;
		String GName;
		String GNote;
	/****
	 * ��Ӳ���
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		GName=request.getParameter("GName");
		GNote=request.getParameter("GNote");
		Grade.setGName(GName);
		Grade.setGNote(GNote);
		int sum=bo.insert(Grade);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * �޸Ĳ���
	 * @param request
	 * @param response
	*/
	public void update(HttpServletRequest request, HttpServletResponse response){
		GId=Integer.parseInt(request.getParameter("GId"));
		GName=request.getParameter("GName");
		GNote=request.getParameter("GNote");
		Grade.setGName(GName);
		Grade.setGNote(GNote);
		Grade.setGId(GId);
		int sum=bo.update(Grade);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * �޸Ĳ���
	 * @param request
	 * @param response
	*/
	public void delete(HttpServletRequest request, HttpServletResponse response){
		GId=Integer.parseInt(request.getParameter("GId"));
		int sum=bo.delete(GId);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * ��ҳ��ѯ����
	 * @param request
	 * @param response
	*/
	public void select(HttpServletRequest request, HttpServletResponse response){
		//��ҳ��ѯ
		Paging(request,response);
		}
	/****
	 * ȫ����ѯ����
	 * @param request
	 * @param response
	*/
	public void selectAll(HttpServletRequest request, HttpServletResponse response){
		//ȫ����ѯ
		finAll(request,response);
		}
	/**
	* ȫ����ѯ
	* @param id
	* @return
	*/
	private static void finAll(HttpServletRequest request, HttpServletResponse response) {
		List<Grade> list=bo.findAll();
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
	* ��ҳ��ѯ
	* @param id
	* @return
	*/
	private static void Paging(HttpServletRequest request, HttpServletResponse response) {
		int page=Integer.parseInt(request.getParameter("page"));
		int limit=Integer.parseInt(request.getParameter("limit"));
		List<Grade> list=bo.Paging(page, limit);
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
