package	com.controlle;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder.Text;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.bo.StudentinfoBO;
import com.vo.Studentinfo;
import com.dao.DBUtil;
/**
 * Servlet implementation class StudentinfoControlle
 */
@WebServlet("/Studentinfo"
)
public class StudentinfoControlle extends BaseServlet {
	private static final long serialVersionUID = 1L;
		static StudentinfoBO  bo=new StudentinfoBO(); 
		static Studentinfo	Studentinfo=new Studentinfo(); 
		int StuId;
		String Studentid;
		int SClasss;
		String SName;
		String SSex;
		String SNational;
		Date SDate;
		String SCard;
		String SNativeplace;
		String SAddress;
		String SPassword;
		String SParentsName;
		String SParentsNumber;
		String SFace;
		String SNumber;
		Date SEntranceDate;
		String SQQ;
		String SPicture;
		String SState;
		String SNote;
		
	/****
	 * 添加操作
	 * @param request
	 * @param response
	*/
	public void add(HttpServletRequest request, HttpServletResponse response){
		Studentid=request.getParameter("Studentid");
		SClasss=Integer.parseInt(request.getParameter("SClasss"));
		SName=request.getParameter("SName");
		SSex=request.getParameter("SSex");
		SNational=request.getParameter("SNational");
		SDate=DBUtil.date(request.getParameter("SDate"));
		SCard=request.getParameter("SCard");
		SNativeplace=request.getParameter("SNativeplace");
		SAddress=request.getParameter("SAddress");
		SPassword=request.getParameter("SPassword");
		SParentsName=request.getParameter("SParentsName");
		SParentsNumber=request.getParameter("SParentsNumber");
		SFace=request.getParameter("SFace");
		SNumber=request.getParameter("SNumber");
		SEntranceDate=DBUtil.date(request.getParameter("SEntranceDate"));
		SQQ=request.getParameter("SQQ");
		SPicture=request.getParameter("SPicture");
		SState=request.getParameter("SState");
		SNote=request.getParameter("SNote");
		Studentinfo.setStudentid(Studentid);
		Studentinfo.setSClasss(SClasss);
		Studentinfo.setSName(SName);
		Studentinfo.setSSex(SSex);
		Studentinfo.setSNational(SNational);
		Studentinfo.setSDate(SDate);
		Studentinfo.setSCard(SCard);
		Studentinfo.setSNativeplace(SNativeplace);
		Studentinfo.setSAddress(SAddress);
		Studentinfo.setSPassword(DBUtil.MD5(SPassword));
		Studentinfo.setSParentsName(SParentsName);
		Studentinfo.setSParentsNumber(SParentsNumber);
		Studentinfo.setSFace(SFace);
		Studentinfo.setSNumber(SNumber);
		Studentinfo.setSEntranceDate(SEntranceDate);
		Studentinfo.setSQQ(SQQ);
		Studentinfo.setSPicture(SPicture);
		Studentinfo.setSState(SState);
		Studentinfo.setSNote(SNote);
		int sum=bo.insert(Studentinfo);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 修改转学操作
	 * @param request
	 * @param response
	*/
	public void upzx(HttpServletRequest request, HttpServletResponse response){
		Studentid=request.getParameter("Studentid");
		String dat=request.getParameter("Sxsj");
		System.out.println(Studentid);
		System.out.println(dat);
		int sum=bo.upzx(Studentid,"该学生已经转学"+dat);
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
		StuId=Integer.parseInt(request.getParameter("StuId"));
		Studentid=request.getParameter("Studentid");
		SClasss=Integer.parseInt(request.getParameter("SClasss"));
		SName=request.getParameter("SName");
		SSex=request.getParameter("SSex");
		SNational=request.getParameter("SNational");
		SDate=DBUtil.date(request.getParameter("SDate"));
		SCard=request.getParameter("SCard");
		SNativeplace=request.getParameter("SNativeplace");
		SAddress=request.getParameter("SAddress");
		SPassword=request.getParameter("SPassword");
		SParentsName=request.getParameter("SParentsName");
		SParentsNumber=request.getParameter("SParentsNumber");
		SFace=request.getParameter("SFace");
		SNumber=request.getParameter("SNumber");
		SEntranceDate=DBUtil.date(request.getParameter("SEntranceDate"));
		SQQ=request.getParameter("SQQ");
		SPicture=request.getParameter("SPicture");
		SState=request.getParameter("SState");
		SNote=request.getParameter("SNote");
		Studentinfo.setStudentid(Studentid);
		Studentinfo.setSClasss(SClasss);
		Studentinfo.setSName(SName);
		Studentinfo.setSSex(SSex);
		Studentinfo.setSNational(SNational);
		Studentinfo.setSDate(SDate);
		Studentinfo.setSCard(SCard);
		Studentinfo.setSNativeplace(SNativeplace);
		Studentinfo.setSAddress(SAddress);
		Studentinfo.setSPassword(DBUtil.MD5(SPassword));
		Studentinfo.setSParentsName(SParentsName);
		Studentinfo.setSParentsNumber(SParentsNumber);
		Studentinfo.setSFace(SFace);
		Studentinfo.setSNumber(SNumber);
		Studentinfo.setSEntranceDate(SEntranceDate);
		Studentinfo.setSQQ(SQQ);
		Studentinfo.setSPicture(SPicture);
		Studentinfo.setSState(SState);
		Studentinfo.setSNote(SNote);
		Studentinfo.setStuId(StuId);
		int sum=bo.update(Studentinfo);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 删除操作
	 * @param request
	 * @param response
	*/
	public void delete(HttpServletRequest request, HttpServletResponse response){
		Studentid=request.getParameter("Studentid");
		int sum=bo.delete(Studentid);
		try {
		response.getWriter().println(sum);
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	/****
	 * 多选删除操作
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
				Studentinfo.setStudentid(data[i]);
				Studentinfo.setSPassword(DBUtil.MD5("686868"));
				if(bo.updatepa(Studentinfo)>0)
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
	 * 分页查询模糊操作
	 * @param request
	 * @param response
	*/
	public void selectsname(HttpServletRequest request, HttpServletResponse response){
		//分页查询
		Pagingsname(request,response);
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
		String zt=request.getParameter("zt");
		List<Studentinfo> list=bo.findAll(zt);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setCount(bo.getcount(zt));
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
		String zt=request.getParameter("zt");
		List<Studentinfo> list=bo.Paging(page, limit,zt);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setCount(bo.getcount(zt));
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	/**
	* 分页模糊查询
	* @param id
	* @return
	*/
	private static void Pagingsname(HttpServletRequest request, HttpServletResponse response) {
		String sname=request.getParameter("sname");
		String zt=request.getParameter("zt");
		List<Studentinfo> list=bo.Paging(sname,zt);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setCount(bo.getcountsname(sname,zt));
		r.setData(list);
		try {
			
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	/**
	* 分页班级查询
	* @param id
	* @return
	*/
	public static void Pagingsclasss(HttpServletRequest request, HttpServletResponse response) {
		int sclasss=Integer.parseInt(request.getParameter("sclasss"));
		String zt=request.getParameter("zt");
		List<Studentinfo> list=bo.findAllsclasss(sclasss,zt);
		request.getSession().setAttribute("list", list);
		R r=new R();
		r.setCount(bo.getcountsclasss(sclasss,zt));
		r.setData(list);
		try {
		response.getWriter().println(DBUtil.toJson(r));
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	public static void file(HttpServletRequest request, HttpServletResponse response){
		String fileName="学生信息表";
		String[] head=request.getParameterValues("head");
		head=head[0].split(",");
		List<Studentinfo> list=(List<com.vo.Studentinfo>) request.getSession().getAttribute("list");
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
            row.createCell((short) 1).setCellValue(list.get(i).getStuId());  
            row.createCell((short) 2).setCellValue(list.get(i).getcName());  
            row.createCell((short) 3).setCellValue(list.get(i).getSName()); 
            row.createCell((short) 4).setCellValue(list.get(i).getSSex()); 
            row.createCell((short) 5).setCellValue(list.get(i).getSNumber()); 
            row.createCell((short) 6).setCellValue(list.get(i).getSParentsNumber()); 
            row.createCell((short) 7).setCellValue(list.get(i).getSDate().toString()); 
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
