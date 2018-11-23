package com.ststic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bo.DownloadBO;
import com.controlle.R;
import com.vo.Download;

/**
 * Servlet implementation class Down
 */
@WebServlet("/Down")
public class Down extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Down() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**      写入html
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取本地路径
		String savePath=this.getServletConfig().getServletContext().getRealPath("");
		//模板文件
        File file04 = new File(savePath+"Template\\Down");
        //进行读取
        InputStream is = new FileInputStream(file04);
        //获取
        byte[] content =new byte[(int)file04.length()];
        //写入
        is.read(content);
        //关闭
        is.close();
        //存取
        String template=new String(content);
		//获取路径
		//读取
		FileOutputStream fos=new FileOutputStream(savePath+"ggxz.html");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		StringBuffer sb=new StringBuffer();
		DownloadBO  bo=new DownloadBO(); 
		List<Download> list=bo.findAll();
		for(int i=0;i<list.size();i++){
			sb.append("<tr>");
			sb.append("<td width=\"15px\" nowrap><img src=\"images/index_news_dot.gif\" width=\"11px\" height=\"14px\"/></td>");
			sb.append("	<td class=\"news\" valign=\"bottom\" onclick=\"popOpen('"+list.get(i).getLink()+"','"+list.get(i).getTitle()+"')\">");
			sb.append("	<a href=\"#\">"+list.get(i).getTitle()+"</a>");
			sb.append("	<font color=\"#000\">"+list.get(i).getReletime()+"上传</font></td>");
			sb.append("</tr>");
		}
		
		String newcontext=template.replace("<!--%context%-->", sb);
		osw.write(newcontext);
		osw.close();
		response.sendRedirect("ggxz.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
