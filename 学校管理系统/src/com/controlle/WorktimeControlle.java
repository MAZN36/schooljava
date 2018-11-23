package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.WorktimeBO;
import com.vo.Worktime;
import com.dao.DBUtil;
/**
 * Servlet implementation class WorktimeControlle
 */
@WebServlet("/Worktime"
)
public class WorktimeControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static WorktimeBO  bo=new WorktimeBO(); 
		Worktime	Worktime=new Worktime(); 
		int Id;
		int Serial;
		String Interval;
		String Section;
		String Wtime;
		String WNote;
	/****
	 * ��Ӳ���
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Serial=Integer.parseInt(request.getParameter("Serial"));
		Interval=request.getParameter("Interval");
		Section=request.getParameter("Section");
		Wtime=request.getParameter("Wtime");
		WNote=request.getParameter("WNote");
		Worktime.setSerial(Serial);
		Worktime.setInterval(Interval);
		Worktime.setSection(Section);
		Worktime.setWtime(Wtime);
		Worktime.setWNote(WNote);
		int sum=bo.insert(Worktime);
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
		Serial=Integer.parseInt(request.getParameter("Serial"));
		Interval=request.getParameter("Interval");
		Section=request.getParameter("Section");
		Wtime=request.getParameter("Wtime");
		WNote=request.getParameter("WNote");
		Worktime.setSerial(Serial);
		Worktime.setInterval(Interval);
		Worktime.setSection(Section);
		Worktime.setWtime(Wtime);
		Worktime.setWNote(WNote);
		Worktime.setId(Id);
		int sum=bo.update(Worktime);
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
		List<Worktime> list=bo.findAll();
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
		List<Worktime> list=bo.Paging(page, limit);
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
