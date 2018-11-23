package	com.controlle;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.bo.TeacherBO;
import com.vo.Teacher;
import com.dao.DBUtil;
import com.dao.TeacherDAO;
/**
 * Servlet implementation class TeacherControlle
 */
@WebServlet("/Teacher"
)
public class TeacherControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static TeacherBO  bo=new TeacherBO(); 
		Teacher	Teacher=new Teacher(); 
		int Tid;
		String TJNumber;
		String TName;
		String Tsex;
		Date TBirthday;
		int TPosition;
		String TTelephone;
		String TPassword;
		String TNation;
		String TPolitical;
		String Tid_card;
		String TEducation;
		String THome;
		String TNative;
		String Img;
		String TContent;
		String SState;
		String TNote;
	/****
	 * ��Ӳ���
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		TJNumber=request.getParameter("TJNumber");
		TName=request.getParameter("TName");
		Tsex=request.getParameter("Tsex");
		TBirthday=DBUtil.date(request.getParameter("TBirthday"));
		TPosition=Integer.parseInt(request.getParameter("TPosition"));
		TTelephone=request.getParameter("TTelephone");
		TPassword=request.getParameter("TPassword");
		TNation=request.getParameter("TNation");
		TPolitical=request.getParameter("TPolitical");
		Tid_card=request.getParameter("Tid_card");
		TEducation=request.getParameter("TEducation");
		THome=request.getParameter("THome");
		TNative=request.getParameter("TNative");
		Img=request.getParameter("Img");
		TContent=request.getParameter("TContent");
		SState=request.getParameter("SState");
		TNote=request.getParameter("TNote");
		Teacher.setTJNumber(TJNumber);
		Teacher.setTName(TName);
		Teacher.setTsex(Tsex);
		Teacher.setTBirthday(TBirthday);
		Teacher.setTPosition(TPosition);
		Teacher.setTTelephone(TTelephone);
		Teacher.setTPassword(DBUtil.MD5(TPassword));
		Teacher.setTNation(TNation);
		Teacher.setTPolitical(TPolitical);
		Teacher.setTid_card(Tid_card);
		Teacher.setTEducation(TEducation);
		Teacher.setTHome(THome);
		Teacher.setTNative(TNative);
		Teacher.setImg(Img);
		Teacher.setTContent(TContent);
		Teacher.setSState(SState);
		Teacher.setTNote(TNote);
		int sum=bo.insert(Teacher);
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
		Tid=Integer.parseInt(request.getParameter("Tid"));
		TJNumber=request.getParameter("TJNumber");
		TName=request.getParameter("TName");
		Tsex=request.getParameter("Tsex");
		TBirthday=DBUtil.date(request.getParameter("TBirthday"));
		TPosition=Integer.parseInt(request.getParameter("TPosition"));
		TTelephone=request.getParameter("TTelephone");
		TPassword=request.getParameter("TPassword");
		TNation=request.getParameter("TNation");
		TPolitical=request.getParameter("TPolitical");
		Tid_card=request.getParameter("Tid_card");
		TEducation=request.getParameter("TEducation");
		THome=request.getParameter("THome");
		TNative=request.getParameter("TNative");
		Img=request.getParameter("Img");
		TContent=request.getParameter("TContent");
		SState=request.getParameter("SState");
		TNote=request.getParameter("TNote");
		Teacher.setTJNumber(TJNumber);
		Teacher.setTName(TName);
		Teacher.setTsex(Tsex);
		Teacher.setTBirthday(TBirthday);
		Teacher.setTPosition(TPosition);
		Teacher.setTTelephone(TTelephone);
		Teacher.setTPassword(DBUtil.MD5(TPassword));
		Teacher.setTNation(TNation);
		Teacher.setTPolitical(TPolitical);
		Teacher.setTid_card(Tid_card);
		Teacher.setTEducation(TEducation);
		Teacher.setTHome(THome);
		Teacher.setTNative(TNative);
		Teacher.setImg(Img);
		Teacher.setTContent(TContent);
		Teacher.setSState(SState);
		Teacher.setTNote(TNote);
		Teacher.setTid(Tid);
		int sum=bo.update(Teacher);
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
	public void updaid(HttpServletRequest request, HttpServletResponse response){
		Tid=Integer.parseInt(request.getParameter("Tid"));
		SState=request.getParameter("SState");
		int sum=bo.update(Tid,SState);
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
	
	
	/**
	* ְλȫ����ѯ
	* @param id
	* @return
	*/
	public static void PagingtPosition(HttpServletRequest request, HttpServletResponse response) {
		int tPosition=Integer.parseInt(request.getParameter("tPosition"));
		String zw=request.getParameter("zw");
		List<Teacher> list=bo.findAll(tPosition,zw);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
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
		String zw=request.getParameter("zw");
		List<Teacher> list=bo.findAll(zw);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setCount(bo.getcount(zw));
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
		String zw=request.getParameter("zw");
		List<Teacher> list=bo.Paging(page, limit,zw);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setCount(bo.getcount(zw));
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	/****
	 * ��ѡ�޸��������
	 * @param request
	 * @param response
	 * @throws IOException 
	*/
	public void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String data[] = request.getParameterValues("data");
		int s = Integer.parseInt(request.getParameter("sum"));
			data=data[0].split(",");
			int sum=0;
			for(int i=0;i<data.length;i++){
				Teacher.setTJNumber(data[i]);
				Teacher.setTPassword(DBUtil.MD5("686868"));
				if(bo.updatepa(Teacher)>0)
					sum++;
			}
			if(s==sum){
				response.getWriter().println("{\"msg\":\"�޸ĳɹ�\"}");
			}
			else{
				response.getWriter().println("{\"msg\":\"�����޸ĳɹ�,��ˢ�º�������\"}");
			}
	}
	/****
	 * �޸��������
	 * @param request
	 * @param response
	 * @throws IOException 
	*/
	public void uppassword(HttpServletRequest request, HttpServletResponse response) throws IOException{
				String user=(String) request.getSession().getAttribute("user");
				String password1=request.getParameter("password1");
				String password2=request.getParameter("password2");
				System.out.println(user);
				System.out.println(password1);
				System.out.println(password2);
				TeacherDAO d=new TeacherDAO();
				try{
					if(d.bdmm(user, password1)>0){
						Teacher.setTJNumber(user);
						Teacher.setTPassword(DBUtil.MD5(password2));
						if(bo.updatepa(Teacher)>0){
							response.getWriter().println("{\"msg\":\"�޸ĳɹ�\"}");
						}
					}else{
						response.getWriter().println("{\"msg\":\"�޸�ʧ��,ԭ���벻һ��\"}");
					}
				}catch (Exception e) {
					response.getWriter().println("{\"msg\":\"�޸�ʧ��\"}");
				}
				
				
			
			
				
			
	}
	/**
	* �������Ʋ�ѯ
	* @param id
	* @return
	*/
	public static void selectsname(HttpServletRequest request, HttpServletResponse response) {
		String tname=request.getParameter("tname");
		String zw=request.getParameter("zw");
		List<Teacher> list=bo.findAll(tname,zw);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	/**
	 * ���ݵ���
	 * @param request
	 * @param response
	 */
	public static void file(HttpServletRequest request, HttpServletResponse response){
		String fileName="��ʦ��Ϣ��";
		String[] head=request.getParameterValues("head");
		head=head[0].split(",");
		List<Teacher> list=(List<com.vo.Teacher>) request.getSession().getAttribute("list");
		// ��һ��������һ��webbook����Ӧһ��Excel�ļ�  
        HSSFWorkbook wb = new HSSFWorkbook();  
         // �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        HSSFSheet sheet = wb.createSheet(fileName);
        sheet.setDefaultColumnWidth(16);
        // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short   
        HSSFRow row = sheet.createRow((int) 0);  
        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����  
        HSSFCellStyle style = wb.createCellStyle();  
        
        style.setAlignment(HorizontalAlignment.CENTER);// ����һ�����и�ʽ  
        HSSFCell cell;
        for(int i=0;i<head.length-1;i++){
        	cell = row.createCell((short) i);  
            cell.setCellValue(head[i]); 
            cell.setCellStyle(style);
            
        }
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            // ���Ĳ���������Ԫ�񣬲�����ֵ  
            row.createCell((short) 0).setCellValue(i+1);  
            row.createCell((short) 1).setCellValue(list.get(i).getTJNumber());  
            row.createCell((short) 2).setCellValue(list.get(i).getTName());  
            row.createCell((short) 3).setCellValue(list.get(i).getTsex()); 
            row.createCell((short) 4).setCellValue(list.get(i).getTBirthday().toString()); 
            row.createCell((short) 5).setCellValue(list.get(i).getpName()); 
            row.createCell((short) 6).setCellValue(list.get(i).getTTelephone()); 
        }  
        // �����������ļ��浽ָ��λ��  
        try  
        {  
        	
        	 String encodedfileName = null;
		       String agent = request.getHeader("USER-AGENT");
		       if(null != agent && -1 != agent.indexOf("MSIE")){//IE
		           encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		       }else if(null != agent && -1 != agent.indexOf("Mozilla")){
		           encodedfileName = new String (fileName.getBytes("UTF-8"),"iso-8859-1");
		       }else{
		           encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		       }
        	//���Excel�ļ�
	        OutputStream output=response.getOutputStream();
	        response.reset();
	        System.out.println();
	        response.setHeader("Content-disposition", "attachment; filename=" + encodedfileName + ".xls");
	        response.setContentType("application/msexcel");
	        wb.write(output);
	        output.close();
           
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        } 
	}
}
