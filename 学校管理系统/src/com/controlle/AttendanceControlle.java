package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.AttendanceBO;
import com.vo.Attendance;
import com.dao.DBUtil;
/**
 * Servlet implementation class AttendanceControlle
 */
@WebServlet("/Attendance"
)
public class AttendanceControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static AttendanceBO  bo=new AttendanceBO(); 
		Attendance	Attendance=new Attendance(); 
		int AId;
		int AClasss;
		int AStudentid;
		Date ADate;
		String ACourseName;
		int AOperator;
		String AAttendanceType;
		String ANote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		AClasss=Integer.parseInt(request.getParameter("AClasss"));
		AStudentid=Integer.parseInt(request.getParameter("AStudentid"));
		ADate=DBUtil.date(request.getParameter("ADate"));
		ACourseName=request.getParameter("ACourseName");
		AOperator=Integer.parseInt(request.getParameter("AOperator"));
		AAttendanceType=request.getParameter("AAttendanceType");
		ANote=request.getParameter("ANote");
		Attendance.setAClasss(AClasss);
		Attendance.setAStudentid(AStudentid);
		Attendance.setADate(ADate);
		Attendance.setACourseName(ACourseName);
		Attendance.setAOperator(AOperator);
		Attendance.setAAttendanceType(AAttendanceType);
		Attendance.setANote(ANote);
		int sum=bo.insert(Attendance);
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
		AId=Integer.parseInt(request.getParameter("AId"));
		AClasss=Integer.parseInt(request.getParameter("AClasss"));
		AStudentid=Integer.parseInt(request.getParameter("AStudentid"));
		ADate=DBUtil.date(request.getParameter("ADate"));
		ACourseName=request.getParameter("ACourseName");
		AOperator=Integer.parseInt(request.getParameter("AOperator"));
		AAttendanceType=request.getParameter("AAttendanceType");
		ANote=request.getParameter("ANote");
		Attendance.setAClasss(AClasss);
		Attendance.setAStudentid(AStudentid);
		Attendance.setADate(ADate);
		Attendance.setACourseName(ACourseName);
		Attendance.setAOperator(AOperator);
		Attendance.setAAttendanceType(AAttendanceType);
		Attendance.setANote(ANote);
		Attendance.setAId(AId);
		int sum=bo.update(Attendance);
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
		AId=Integer.parseInt(request.getParameter("AId"));
		int sum=bo.delete(AId);
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
		List<Attendance> list=bo.findAll();
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
		List<Attendance> list=bo.Paging(page, limit);
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
