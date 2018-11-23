package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.XfCostBO;
import com.vo.XfCost;
import com.dao.DBUtil;
/**
 * Servlet implementation class XfCostControlle
 */
@WebServlet("/XfCost"
)
public class XfCostControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static XfCostBO  bo=new XfCostBO(); 
		XfCost	xfCost=new XfCost(); 
		int Id;
		int Stuidxf;
		String Danhao;
		Date Jysj;
		double Jyqyr;
		double Jyhyr;
		double Jyyr;
		String Jyfs;
		String Jylx;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
		
		//学号 订单号 交易金额 交易方式 交易类型
	public void adds(HttpServletRequest request, HttpServletResponse response){
		Stuidxf=Integer.parseInt(request.getParameter("Stuidxf"));
		Danhao=request.getParameter("Danhao");
		Jyyr=Double.parseDouble(request.getParameter("Jyyr"));
		Jyfs=request.getParameter("Jyfs");
		Jylx=request.getParameter("Jylx");
		int sum=bo.findstuidxf(Stuidxf, Danhao, Jyyr, Jyfs, Jylx);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	public void count(HttpServletRequest request, HttpServletResponse response){
		Stuidxf=Integer.parseInt(request.getParameter("Stuidxf"));
		int sum=bo.count(Stuidxf);
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
		Id=Integer.parseInt(request.getParameter("Id"));
		Stuidxf=Integer.parseInt(request.getParameter("Stuidxf"));
		Danhao=request.getParameter("Danhao");
		Jysj=DBUtil.date(request.getParameter("Jysj"));
		Jyqyr=Double.parseDouble(request.getParameter("Jyqyr"));
		Jyhyr=Double.parseDouble(request.getParameter("Jyhyr"));
		Jyyr=Double.parseDouble(request.getParameter("Jyyr"));
		Jyfs=request.getParameter("Jyfs");
		Jylx=request.getParameter("Jylx");
		xfCost.setStuidxf(Stuidxf);
		xfCost.setDanhao(Danhao);
		xfCost.setJysj(Jysj);
		xfCost.setJyqyr(Jyqyr);
		xfCost.setJyhyr(Jyhyr);
		xfCost.setJyyr(Jyyr);
		xfCost.setJyfs(Jyfs);
		xfCost.setJylx(Jylx);
		xfCost.setId(Id);
		int sum=bo.update(xfCost);
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
		Id=Integer.parseInt(request.getParameter("Id"));
		int sum=bo.delete(Id);
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
		List<XfCost> list=bo.findAll();
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
		String sf=(String)request.getSession().getAttribute("sf");
		
		if(sf.equals("xy")){
			String user=(String)request.getSession().getAttribute("user");
			
			int page=Integer.parseInt(request.getParameter("page"));
			int limit=Integer.parseInt(request.getParameter("limit"));
			List<XfCost> list=bo.Paging(page, limit,user);
			R r=new R();
			r.setCount(bo.getcount());
			r.setData(list);
			try {
			response.getWriter().println(DBUtil.toJson(r));
			} catch (IOException e) {
			e.printStackTrace();
			}
			return;
			}
		int page=Integer.parseInt(request.getParameter("page"));
		int limit=Integer.parseInt(request.getParameter("limit"));
		List<XfCost> list=bo.Paging(page, limit);
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
