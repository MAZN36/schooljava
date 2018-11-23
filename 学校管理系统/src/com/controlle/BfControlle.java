package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.BfBO;
import com.vo.Bf;
import com.dao.DBUtil;
/**
 * Servlet implementation class BfControlle
 */
@WebServlet("/Bf"
)
public class BfControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static BfBO  bo=new BfBO(); 
		Bf	bf=new Bf(); 
		int Id;
		Date Bfsj;
		String Bflq;
		Date Hysj;
	/****
	 * ��Ӳ���
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		String sj=request.getParameter("sj");
		String dz="d:"+sj+".bak";
		String sql = "backup database SchoolDB to disk='"+dz+"'";
		DBUtil.execute(sql);
		bf.setBflq(dz);
		int sum=bo.insert(bf);
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
		Id=Integer.parseInt(request.getParameter("Id"));
		Bflq=request.getParameter("lq");
		String sql = "backup database SchoolDB to disk='"+Bflq+"'";
		DBUtil.execute(sql);
		bf.setId(Id);
		int sum=bo.update(bf);
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
		Id=Integer.parseInt(request.getParameter("Id"));
		int sum=bo.delete(Id);
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
		List<Bf> list=bo.findAll();
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
		List<Bf> list=bo.Paging(page, limit);
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
