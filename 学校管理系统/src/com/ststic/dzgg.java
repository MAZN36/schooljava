package com.ststic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bo.NoticeBO;
import com.vo.Notice;

/**
 * Servlet implementation class dzgg
 */
@WebServlet("/dzgg")
public class dzgg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dzgg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				
				response.setContentType("application/json;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				//获取本地路径
				String savePath=this.getServletConfig().getServletContext().getRealPath("");
				//模板文件
		        File file04 = new File(savePath+"Template\\tzgg");
		        //进行读取
		        InputStream is = new FileInputStream(file04);
		        //获取
		        byte[] content =new byte[(int)file04.length()];
		        //写入
		        is.read(content);
		        //关闭
		        is.close();
		        //获取
		        String template=new String(content);
				FileOutputStream fos=new FileOutputStream(savePath+"tzgg.html");
				OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
				StringBuffer sb=new StringBuffer();
				NoticeBO  bo=new NoticeBO(); 
				List<Notice> list=bo.findAll();
				for(int i=0;i<list.size();i++){
					sb.append("<tr>");
					sb.append("<td width=\"15px;\">");
					sb.append("<img src=\"images/index_news_dot.gif\" width=\"11px\" height=\"14px\"/>");
					sb.append("</td>");
					sb.append("<td  class=\"news\" valign=\"bottom\" onclick=\"popOpen("+list.get(i).getId()+")\"/>");
					sb.append("<a href=\"#\">"+list.get(i).getTitle()+"</a>");
					sb.append("<font color=\"#000\">["+list.get(i).getReletime()+"]</font>");
					sb.append("</td >");
					sb.append("</tr>");
				}
				String newcontext=template.replace("<!--%context%-->", sb);
				osw.write(newcontext);
				osw.close();
				response.sendRedirect("tzgg.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
