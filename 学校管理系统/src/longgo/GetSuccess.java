package longgo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controlle.R;
import com.dao.DBUtil;

/**
 * Servlet implementation class GetSuccess
 */
@WebServlet("/GetSuccess")
public class GetSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetSuccess() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//»ñÈ¡sess
		response.setContentType("applocation/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String sf=(String)request.getSession().getAttribute("sf");
		String sfs=request.getParameter("sf");
		R r=new R();
		if(sf.equals(sfs)){
			r.setCode(1);
			r.setMsg(request.getSession().getAttribute("user").toString());
		}else{
			r.setCode(3);
			r.setMsg("ÇëµÇÂ¼!!!");
		}
		response.getWriter().print(DBUtil.toJson(r));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
