package	com.controlle;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.SxcalssBO;
import com.vo.Studentinfo;
import com.vo.Sxcalss;
import com.dao.ClasssDAO;
import com.dao.DBUtil;
import com.dao.StudentinfoDAO;
/**
 * Servlet implementation class SxcalssControlle
 */
@WebServlet("/Sxcalss"
)
public class SxcalssControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static SxcalssBO  bo=new SxcalssBO(); 
		Sxcalss	sxcalss=new Sxcalss(); 
		int Id;
		int Stuxh;
		String Sxqbj;
		int Sxhbj;
		String Zt;
		Date Sxsj;
		String Bz;
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Stuxh=Integer.parseInt(request.getParameter("Stuxh"));
		Sxqbj=request.getParameter("Sxqbj");
		Sxhbj=Integer.parseInt(request.getParameter("Sxhbj"));
		Zt=request.getParameter("Zt");
		Sxsj=DBUtil.date(request.getParameter("Sxsj"));
		Bz=request.getParameter("Bz");
		sxcalss.setStuxh(Stuxh);
		sxcalss.setSxqbj(Sxqbj);
		sxcalss.setSxhbj(Sxhbj);
		sxcalss.setZt(Zt);
		sxcalss.setSxsj(Sxsj);
		sxcalss.setBz(Bz);
		int sum=bo.insert(sxcalss);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 一键升学操作
	 * @param request
	 * @param response
	*/
	public void addAll(HttpServletRequest request, HttpServletResponse response){
		StudentinfoDAO dao=new StudentinfoDAO();
				//获取升学前班级
				Sxqbj=request.getParameter("Sxqbj");
				int Sxqbjid=Integer.parseInt(request.getParameter("Sxqbjid"));
				
				//获取升学后班级  
				Sxhbj=Integer.parseInt(request.getParameter("Sxhbj"));
				Zt="升学";
				//获取升学时间
				Sxsj=DBUtil.date(request.getParameter("Sxsj"));
				//备注
				Bz=request.getParameter("Bz");
				System.out.println(Bz);
				List<Studentinfo> list=dao.sxId(Sxqbjid);
				int sum=0;
				//添加进入
				for(int i=0;i<list.size();i++){
					sxcalss.setStuxh(list.get(i).getStuId());//学号
					sxcalss.setSxqbj(Sxqbj);//升学前班级
					sxcalss.setSxhbj(Sxhbj);//升学后班级
					sxcalss.setZt(Zt);//状态
					sxcalss.setSxsj(Sxsj);//升学时间
					sxcalss.setBz(Bz);//备注
					bo.insert(sxcalss);
					sum++;
				}
				//修改学生的班级  修改前班级 升学后班级
				dao.updasc(Sxqbjid, Sxhbj, "在读");
				//修改班级状态
				ClasssDAO cd=new ClasssDAO();
				cd.update(Sxqbjid, Sxsj, "结业");
				
			
		try {
			response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	/****
	 * 一键毕业操作
	 * @param request
	 * @param response
	*/
	public void addby(HttpServletRequest request, HttpServletResponse response){
				StudentinfoDAO dao=new StudentinfoDAO();
				
				int Sxqbjid=Integer.parseInt(request.getParameter("Sxqbjid"));
				//获取升学前班级
				Sxqbj=request.getParameter("Sxqbj");
				Zt="毕业";
				//获取毕业时间
				Sxsj=DBUtil.date(request.getParameter("Sxsj"));
				
				
				System.out.println("开始");
				List<Studentinfo> list=dao.sxId(Sxqbjid);
				int sum=0;
				//添加进入
				for(int i=0;i<list.size();i++){
					sxcalss.setStuxh(list.get(i).getStuId());//学号
					sxcalss.setSxqbj(Sxqbj);//升学前班级
					sxcalss.setSxhbj(Sxqbjid);//升学后班级
					sxcalss.setZt(Zt);//状态
					sxcalss.setSxsj(Sxsj);//毕业时间
					bo.insert(sxcalss);
					sum++;
				}
				//修改学生的班级  修改前班级 升学后班级
				dao.updasc(Sxqbjid, Sxqbjid, "毕业");
				//修改班级状态
				ClasssDAO cd=new ClasssDAO();
				cd.update(Sxqbjid, Sxsj, "结业");
				
			
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
		Stuxh=Integer.parseInt(request.getParameter("Stuxh"));
		Sxqbj=request.getParameter("Sxqbj");
		Sxhbj=Integer.parseInt(request.getParameter("Sxhbj"));
		Zt=request.getParameter("Zt");
		Sxsj=DBUtil.date(request.getParameter("Sxsj"));
		Bz=request.getParameter("Bz");
		sxcalss.setStuxh(Stuxh);
		sxcalss.setSxqbj(Sxqbj);
		sxcalss.setSxhbj(Sxhbj);
		sxcalss.setZt(Zt);
		sxcalss.setSxsj(Sxsj);
		sxcalss.setBz(Bz);
		sxcalss.setId(Id);
		int sum=bo.update(sxcalss);
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
		List<Sxcalss> list=bo.findAll();
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
		List<Sxcalss> list=bo.Paging(page, limit);
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
