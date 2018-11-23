package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.AdministratorBO;
import com.vo.Administrator;
import com.dao.AdministratorDAO;
import com.dao.DBUtil;
import com.dao.TeacherDAO;
/**
 * Servlet implementation class AdministratorControlle
 */
@WebServlet("/Administrator"
)
public class AdministratorControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static AdministratorBO  bo=new AdministratorBO(); 
		Administrator	Administrator=new Administrator(); 
		int Admin_id;
		String Admin_Name;
		String Admin_Account;
		String Admin_Password;
		String Admin_State;
		String Admin_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Admin_Name=request.getParameter("Admin_Name");
		Admin_Account=request.getParameter("Admin_Account");
		Admin_Password=request.getParameter("Admin_Password");
		Admin_State=request.getParameter("Admin_State");
		Admin_Note=request.getParameter("Admin_Note");
		Administrator.setAdmin_Name(Admin_Name);
		Administrator.setAdmin_Account(Admin_Account);
		Administrator.setAdmin_Password(Admin_Password);
		Administrator.setAdmin_State(Admin_State);
		Administrator.setAdmin_Note(Admin_Note);
		int sum=bo.insert(Administrator);
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
		Admin_id=Integer.parseInt(request.getParameter("Admin_id"));
		Admin_State=request.getParameter("Admin_State");
		Administrator.setAdmin_State(Admin_State);
		Administrator.setAdmin_id(Admin_id);
		int sum=bo.update(Administrator);
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
		Admin_id=Integer.parseInt(request.getParameter("Admin_id"));
		int sum=bo.delete(Admin_id);
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
		List<Administrator> list=bo.findAll();
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
		List<Administrator> list=bo.Paging(page, limit);
		R r=new R();
		r.setCount(bo.getcount());
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	public void uppassword(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String user=(String) request.getSession().getAttribute("user");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		System.out.println(user);
		System.out.println(password1);
		System.out.println(password2);
		AdministratorDAO d=new AdministratorDAO();
		try{
			if(d.bdmm(user, password1)>0){
				Administrator.setAdmin_Account(user);
				Administrator.setAdmin_Password((DBUtil.MD5(password2)));
				if(d.updatepa(Administrator)>0){
					response.getWriter().println("{\"msg\":\"修改成功\"}");
				}
			}else{
				response.getWriter().println("{\"msg\":\"修改失败,原密码不一致\"}");
			}
		}catch (Exception e) {
			response.getWriter().println("{\"msg\":\"修改失败\"}");
		}
	}
}
