package longgo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		//学号
		String xh=request.getParameter("xh");
		//充值方式
		String zffs=request.getParameter("zffs");
		//订单号
		String ddh=request.getParameter("ddh");
		try{
			//价格
			double je=Double.parseDouble(request.getParameter("je"));
			if(xh!=null){
				request.getSession().setAttribute("xh", xh);
				request.getSession().setAttribute("je", je);
				request.getSession().setAttribute("zffs", zffs);
				request.getSession().setAttribute("ddh", ddh);
				request.getSession().setAttribute("user", xh);
				response.sendRedirect("czjfbd.jsp");
			}else{
				response.sendRedirect("http://banggang.xyz/");
			}
		}catch(Exception e){
			response.sendRedirect("http://banggang.xyz/");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
