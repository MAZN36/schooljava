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
	 * ��Ӳ���
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
	 * һ����ѧ����
	 * @param request
	 * @param response
	*/
	public void addAll(HttpServletRequest request, HttpServletResponse response){
		StudentinfoDAO dao=new StudentinfoDAO();
				//��ȡ��ѧǰ�༶
				Sxqbj=request.getParameter("Sxqbj");
				int Sxqbjid=Integer.parseInt(request.getParameter("Sxqbjid"));
				
				//��ȡ��ѧ��༶  
				Sxhbj=Integer.parseInt(request.getParameter("Sxhbj"));
				Zt="��ѧ";
				//��ȡ��ѧʱ��
				Sxsj=DBUtil.date(request.getParameter("Sxsj"));
				//��ע
				Bz=request.getParameter("Bz");
				System.out.println(Bz);
				List<Studentinfo> list=dao.sxId(Sxqbjid);
				int sum=0;
				//��ӽ���
				for(int i=0;i<list.size();i++){
					sxcalss.setStuxh(list.get(i).getStuId());//ѧ��
					sxcalss.setSxqbj(Sxqbj);//��ѧǰ�༶
					sxcalss.setSxhbj(Sxhbj);//��ѧ��༶
					sxcalss.setZt(Zt);//״̬
					sxcalss.setSxsj(Sxsj);//��ѧʱ��
					sxcalss.setBz(Bz);//��ע
					bo.insert(sxcalss);
					sum++;
				}
				//�޸�ѧ���İ༶  �޸�ǰ�༶ ��ѧ��༶
				dao.updasc(Sxqbjid, Sxhbj, "�ڶ�");
				//�޸İ༶״̬
				ClasssDAO cd=new ClasssDAO();
				cd.update(Sxqbjid, Sxsj, "��ҵ");
				
			
		try {
			response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	/****
	 * һ����ҵ����
	 * @param request
	 * @param response
	*/
	public void addby(HttpServletRequest request, HttpServletResponse response){
				StudentinfoDAO dao=new StudentinfoDAO();
				
				int Sxqbjid=Integer.parseInt(request.getParameter("Sxqbjid"));
				//��ȡ��ѧǰ�༶
				Sxqbj=request.getParameter("Sxqbj");
				Zt="��ҵ";
				//��ȡ��ҵʱ��
				Sxsj=DBUtil.date(request.getParameter("Sxsj"));
				
				
				System.out.println("��ʼ");
				List<Studentinfo> list=dao.sxId(Sxqbjid);
				int sum=0;
				//��ӽ���
				for(int i=0;i<list.size();i++){
					sxcalss.setStuxh(list.get(i).getStuId());//ѧ��
					sxcalss.setSxqbj(Sxqbj);//��ѧǰ�༶
					sxcalss.setSxhbj(Sxqbjid);//��ѧ��༶
					sxcalss.setZt(Zt);//״̬
					sxcalss.setSxsj(Sxsj);//��ҵʱ��
					bo.insert(sxcalss);
					sum++;
				}
				//�޸�ѧ���İ༶  �޸�ǰ�༶ ��ѧ��༶
				dao.updasc(Sxqbjid, Sxqbjid, "��ҵ");
				//�޸İ༶״̬
				ClasssDAO cd=new ClasssDAO();
				cd.update(Sxqbjid, Sxsj, "��ҵ");
				
			
		try {
			response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	/****
	 * �޸Ĳ���
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
	 * �޸Ĳ���
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
	 * ��ҳ��ѯ����
	 * @param request
	 * @param response
	*/
	public void select(HttpServletRequest request, HttpServletResponse response){
		//��ҳ��ѯ
		Paging(request,response);
		}
	/****
	 * ȫ����ѯ����
	 * @param request
	 * @param response
	*/
	public void selectAll(HttpServletRequest request, HttpServletResponse response){
		//ȫ����ѯ
		finAll(request,response);
		}
	/**
	* ȫ����ѯ
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
	* ��ҳ��ѯ
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
