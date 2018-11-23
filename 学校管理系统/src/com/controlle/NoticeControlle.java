package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.NoticeBO;
import com.vo.Notice;
import com.dao.DBUtil;
/**
 * Servlet implementation class NoticeControlle
 */
@WebServlet("/Notice"
)
public class NoticeControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static NoticeBO  bo=new NoticeBO(); 
		Notice	Notice=new Notice(); 
		int Id;
		String Title;
		String Content;
		
		int Relepeople;
	/****
	 * ��Ӳ���
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Title=request.getParameter("Title");
		Content=request.getParameter("Content");
		Relepeople=Integer.parseInt(request.getParameter("Relepeople"));
		Notice.setTitle(Title);
		Notice.setContent(Content);
		Notice.setRelepeople(Relepeople);
		int sum=bo.insert(Notice);
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
		Title=request.getParameter("Title");
		Notice.setTitle(Title);
		Notice.setId(Id);
		int sum=bo.update(Notice);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * ɾ������
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
	public void findById(HttpServletRequest request, HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		Notice list=bo.findById(id);
		R r=new R();
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	public void Rs(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int id=Integer.parseInt(request.getParameter("id"));
		Notice list=bo.findById(id);
		request.setAttribute("list", list);
		//response.sendRedirect("");
		request.getRequestDispatcher("tzggck.jsp").forward(request, response);
	}
	private static void finAll(HttpServletRequest request, HttpServletResponse response) {
		List<Notice> list=bo.findAll();
		R r=new R();
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
		List<Notice> list=bo.Paging(page, limit);
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
