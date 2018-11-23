package longgo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdmDAO;
import com.dao.DBUtil;
import com.dao.StudentinfoDAO;
import com.dao.TeacherDAO;

/**
 * Servlet implementation class Admgo
 */
@WebServlet("/Admgo")
public class Admgo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admgo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		String action=request.getParameter("action");
		switch(action){
		case "adm":
			adm(request,response,user,password);
			break;
		case "tea":
			tea(request,response,user,password);
			break;
		case "stu":
			stu(request,response,user,password);
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void adm(HttpServletRequest request, HttpServletResponse response,String user,String password){
		AdmDAO adm=new AdmDAO();
		int c=adm.bdmm(user, password);
		if(c>0){
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("sf", "gly");
		}
		try {
			response.getWriter().println(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void stu(HttpServletRequest request, HttpServletResponse response,String user,String password){
		StudentinfoDAO adm=new StudentinfoDAO();
		int c=adm.bdmm(user, password);
		if(c>0){
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("sf", "xy");
			System.out.println(request.getSession().getAttribute("user"));
			System.out.println(request.getSession().getAttribute("sf"));
		}
		try {
			response.getWriter().println(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void tea(HttpServletRequest request, HttpServletResponse response,String user,String password){
		TeacherDAO adm=new TeacherDAO();
		int c=adm.bdmm(user, password);
		
		if(c>0){
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("sf", "jy");
			c=adm.bdsf(user, password);
			if(c==1)
				request.getSession().setAttribute("sf", "bzr");
		}
		try {
			response.getWriter().println(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
