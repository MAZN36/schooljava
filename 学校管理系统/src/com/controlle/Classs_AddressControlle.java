package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.Classs_AddressBO;
import com.vo.Classs_Address;
import com.dao.DBUtil;
/**
 * Servlet implementation class Classs_AddressControlle
 */
@WebServlet("/Classs_Address"
)
public class Classs_AddressControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static Classs_AddressBO  bo=new Classs_AddressBO(); 
		Classs_Address	Classs_Address=new Classs_Address(); 
		int Address_id;
		int Address_Classs;
		int Adderss_Name;
		int Adderss_Phone;
		String Adderss_Note;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Address_Classs=Integer.parseInt(request.getParameter("Address_Classs"));
		Adderss_Name=Integer.parseInt(request.getParameter("Adderss_Name"));
		Adderss_Phone=Integer.parseInt(request.getParameter("Adderss_Phone"));
		Adderss_Note=request.getParameter("Adderss_Note");
		Classs_Address.setAddress_Classs(Address_Classs);
		Classs_Address.setAdderss_Name(Adderss_Name);
		Classs_Address.setAdderss_Phone(Adderss_Phone);
		Classs_Address.setAdderss_Note(Adderss_Note);
		int sum=bo.insert(Classs_Address);
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
		Address_id=Integer.parseInt(request.getParameter("Address_id"));
		Address_Classs=Integer.parseInt(request.getParameter("Address_Classs"));
		Adderss_Name=Integer.parseInt(request.getParameter("Adderss_Name"));
		Adderss_Phone=Integer.parseInt(request.getParameter("Adderss_Phone"));
		Adderss_Note=request.getParameter("Adderss_Note");
		Classs_Address.setAddress_Classs(Address_Classs);
		Classs_Address.setAdderss_Name(Adderss_Name);
		Classs_Address.setAdderss_Phone(Adderss_Phone);
		Classs_Address.setAdderss_Note(Adderss_Note);
		Classs_Address.setAddress_id(Address_id);
		int sum=bo.update(Classs_Address);
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
		Address_id=Integer.parseInt(request.getParameter("Address_id"));
		int sum=bo.delete(Address_id);
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
		List<Classs_Address> list=bo.findAll();
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
		List<Classs_Address> list=bo.Paging(page, limit);
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
