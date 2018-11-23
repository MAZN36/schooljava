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
	 * 添加操作
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
	 * 修改操作
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
	 * 修改操作
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
	
	
	/**
	* 职位全部查询
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
		//全部查询
		finAll(request,response);
		}
	/**
	* 全部查询
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
	* 分页查询
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
	 * 多选修改密码操作
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
				response.getWriter().println("{\"msg\":\"修改成功\"}");
			}
			else{
				response.getWriter().println("{\"msg\":\"部分修改成功,请刷新后再重试\"}");
			}
	}
	/****
	 * 修改密码操作
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
							response.getWriter().println("{\"msg\":\"修改成功\"}");
						}
					}else{
						response.getWriter().println("{\"msg\":\"修改失败,原密码不一致\"}");
					}
				}catch (Exception e) {
					response.getWriter().println("{\"msg\":\"修改失败\"}");
				}
				
				
			
			
				
			
	}
	/**
	* 根据名称查询
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
	 * 数据导出
	 * @param request
	 * @param response
	 */
	public static void file(HttpServletRequest request, HttpServletResponse response){
		String fileName="教师信息表";
		String[] head=request.getParameterValues("head");
		head=head[0].split(",");
		List<Teacher> list=(List<com.vo.Teacher>) request.getSession().getAttribute("list");
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
         // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(fileName);
        sheet.setDefaultColumnWidth(16);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short   
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        
        style.setAlignment(HorizontalAlignment.CENTER);// 创建一个居中格式  
        HSSFCell cell;
        for(int i=0;i<head.length-1;i++){
        	cell = row.createCell((short) i);  
            cell.setCellValue(head[i]); 
            cell.setCellStyle(style);
            
        }
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            // 第四步，创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(i+1);  
            row.createCell((short) 1).setCellValue(list.get(i).getTJNumber());  
            row.createCell((short) 2).setCellValue(list.get(i).getTName());  
            row.createCell((short) 3).setCellValue(list.get(i).getTsex()); 
            row.createCell((short) 4).setCellValue(list.get(i).getTBirthday().toString()); 
            row.createCell((short) 5).setCellValue(list.get(i).getpName()); 
            row.createCell((short) 6).setCellValue(list.get(i).getTTelephone()); 
        }  
        // 第六步，将文件存到指定位置  
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
        	//输出Excel文件
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
