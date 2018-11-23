package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.DirectionBO;
import com.vo.Direction;
import com.dao.DBUtil;
/**
 * Servlet implementation class DirectionControlle
 */
@WebServlet("/Direction"
)
public class DirectionControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static DirectionBO  bo=new DirectionBO(); 
		Direction	Direction=new Direction(); 
		int DId;
		int DStudentid;
		int DClasss;
		int DFirstchoice;
		int DSecondchoice;
		Date DDate;
		String DNote;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		DStudentid=Integer.parseInt(request.getParameter("DStudentid"));
		DClasss=Integer.parseInt(request.getParameter("DClasss"));
		DFirstchoice=Integer.parseInt(request.getParameter("DFirstchoice"));
		DSecondchoice=Integer.parseInt(request.getParameter("DSecondchoice"));
		DDate=DBUtil.date(request.getParameter("DDate"));
		DNote=request.getParameter("DNote");
		Direction.setDStudentid(DStudentid);
		Direction.setDClasss(DClasss);
		Direction.setDFirstchoice(DFirstchoice);
		Direction.setDSecondchoice(DSecondchoice);
		Direction.setDDate(DDate);
		Direction.setDNote(DNote);
		int sum=bo.insert(Direction);
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
		DId=Integer.parseInt(request.getParameter("DId"));
		DStudentid=Integer.parseInt(request.getParameter("DStudentid"));
		DClasss=Integer.parseInt(request.getParameter("DClasss"));
		DFirstchoice=Integer.parseInt(request.getParameter("DFirstchoice"));
		DSecondchoice=Integer.parseInt(request.getParameter("DSecondchoice"));
		DDate=DBUtil.date(request.getParameter("DDate"));
		DNote=request.getParameter("DNote");
		Direction.setDStudentid(DStudentid);
		Direction.setDClasss(DClasss);
		Direction.setDFirstchoice(DFirstchoice);
		Direction.setDSecondchoice(DSecondchoice);
		Direction.setDDate(DDate);
		Direction.setDNote(DNote);
		Direction.setDId(DId);
		int sum=bo.update(Direction);
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
		DId=Integer.parseInt(request.getParameter("DId"));
		int sum=bo.delete(DId);
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
		List<Direction> list=bo.findAll();
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
		List<Direction> list=bo.Paging(page, limit);
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
