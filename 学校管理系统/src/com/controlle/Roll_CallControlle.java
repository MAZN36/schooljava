package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Roll_CallBO;
import com.vo.Roll_Call;
import com.dao.DBUtil;
/**
 * Servlet implementation class Roll_CallControlle
 */
@WebServlet("/Roll_Call"
)
public class Roll_CallControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Roll_CallBO  bo=new Roll_CallBO(); 
		Roll_Call	Roll_Call=new Roll_Call(); 
		int Roll_id;
		int Roll_Classs;
		int Roll_Course;
		String Roll_Type;
		int Roll_Number;
		int Roll_Operator;
		Date Roll_Time;
		String Roll_State;
		String Roll_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Roll_Classs=Integer.parseInt(request.getParameter("Roll_Classs"));
		Roll_Course=Integer.parseInt(request.getParameter("Roll_Course"));
		Roll_Type=request.getParameter("Roll_Type");
		Roll_Number=Integer.parseInt(request.getParameter("Roll_Number"));
		Roll_Operator=Integer.parseInt(request.getParameter("Roll_Operator"));
		Roll_Time=DBUtil.date(request.getParameter("Roll_Time"));
		Roll_State=request.getParameter("Roll_State");
		Roll_Note=request.getParameter("Roll_Note");
		Roll_Call.setRoll_Classs(Roll_Classs);
		Roll_Call.setRoll_Course(Roll_Course);
		Roll_Call.setRoll_Type(Roll_Type);
		Roll_Call.setRoll_Number(Roll_Number);
		Roll_Call.setRoll_Operator(Roll_Operator);
		Roll_Call.setRoll_Time(Roll_Time);
		Roll_Call.setRoll_State(Roll_State);
		Roll_Call.setRoll_Note(Roll_Note);
		int sum=bo.insert(Roll_Call);
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
		Roll_id=Integer.parseInt(request.getParameter("Roll_id"));
		Roll_Classs=Integer.parseInt(request.getParameter("Roll_Classs"));
		Roll_Course=Integer.parseInt(request.getParameter("Roll_Course"));
		Roll_Type=request.getParameter("Roll_Type");
		Roll_Number=Integer.parseInt(request.getParameter("Roll_Number"));
		Roll_Operator=Integer.parseInt(request.getParameter("Roll_Operator"));
		Roll_Time=DBUtil.date(request.getParameter("Roll_Time"));
		Roll_State=request.getParameter("Roll_State");
		Roll_Note=request.getParameter("Roll_Note");
		Roll_Call.setRoll_Classs(Roll_Classs);
		Roll_Call.setRoll_Course(Roll_Course);
		Roll_Call.setRoll_Type(Roll_Type);
		Roll_Call.setRoll_Number(Roll_Number);
		Roll_Call.setRoll_Operator(Roll_Operator);
		Roll_Call.setRoll_Time(Roll_Time);
		Roll_Call.setRoll_State(Roll_State);
		Roll_Call.setRoll_Note(Roll_Note);
		Roll_Call.setRoll_id(Roll_id);
		int sum=bo.update(Roll_Call);
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
		Roll_id=Integer.parseInt(request.getParameter("Roll_id"));
		int sum=bo.delete(Roll_id);
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
		List<Roll_Call> list=bo.findAll();
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
		List<Roll_Call> list=bo.Paging(page, limit);
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
