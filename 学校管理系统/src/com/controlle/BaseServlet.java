package	com.controlle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBUtil;
/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//进行账号是否存在判断
		Code(request,response);
		if(request.getSession().getAttribute("user")!=null){
			String action=request.getParameter("action");
			if(action!=null){
				try {
					//获取方法
					Method method=getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
					if(method!=null){
						method.invoke(this, request,response);
					}
				} catch (Exception e) {
					//异常进入500页面
					request.getRequestDispatcher("Exception500.html").forward(request, response);
				}
			}
			else{
				//进入404页面
				request.getRequestDispatcher("Exception404.html").forward(request, response);
			}
		}
		//不存在
		else{
			System.out.println("进入index");
			R r=new R();
			r.setMsg("用户未登录,请登录!!!");
			r.setCode(3);
			response.getWriter().println(DBUtil.toJson(r));
		}
			
	}
	/****
	 * 设置编码格式
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	protected void Code(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
	}

}
