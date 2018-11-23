package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Student_CertificateBO;
import com.vo.Student_Certificate;
import com.dao.DBUtil;
/**
 * Servlet implementation class Student_CertificateControlle
 */
@WebServlet("/Student_Certificate"
)
public class Student_CertificateControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Student_CertificateBO  bo=new Student_CertificateBO(); 
		Student_Certificate	Student_Certificate=new Student_Certificate(); 
		int Cer_id;
		int Cer_Studentid;
		Date Cer_Time;
		Date Cer_Read;
		String Cer_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Cer_Studentid=Integer.parseInt(request.getParameter("Cer_Studentid"));
		Cer_Time=DBUtil.date(request.getParameter("Cer_Time"));
		Cer_Read=DBUtil.date(request.getParameter("Cer_Read"));
		Cer_Note=request.getParameter("Cer_Note");
		Student_Certificate.setCer_Studentid(Cer_Studentid);
		Student_Certificate.setCer_Time(Cer_Time);
		Student_Certificate.setCer_Read(Cer_Read);
		Student_Certificate.setCer_Note(Cer_Note);
		int sum=bo.insert(Student_Certificate);
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
		Cer_id=Integer.parseInt(request.getParameter("Cer_id"));
		Cer_Studentid=Integer.parseInt(request.getParameter("Cer_Studentid"));
		Cer_Time=DBUtil.date(request.getParameter("Cer_Time"));
		Cer_Read=DBUtil.date(request.getParameter("Cer_Read"));
		Cer_Note=request.getParameter("Cer_Note");
		Student_Certificate.setCer_Studentid(Cer_Studentid);
		Student_Certificate.setCer_Time(Cer_Time);
		Student_Certificate.setCer_Read(Cer_Read);
		Student_Certificate.setCer_Note(Cer_Note);
		Student_Certificate.setCer_id(Cer_id);
		int sum=bo.update(Student_Certificate);
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
		Cer_id=Integer.parseInt(request.getParameter("Cer_id"));
		int sum=bo.delete(Cer_id);
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
		List<Student_Certificate> list=bo.findAll();
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
		List<Student_Certificate> list=bo.Paging(page, limit);
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
