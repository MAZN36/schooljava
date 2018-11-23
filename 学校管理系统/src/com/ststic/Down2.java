package com.ststic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Down2
 */
@WebServlet("/Down2")
public class Down2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Down2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//通过路径得到一个输入流
		String name=request.getParameter("name");
		String fileName=request.getParameter("id");
        String path =     this.getServletContext().getRealPath("/wenjian");
        String f=(path+"/"+name);
        String encodedfileName = null;
	      String agent = request.getHeader("USER-AGENT");
	       if(null != agent && -1 != agent.indexOf("MSIE")){//IE
	           encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
	       }else if(null != agent && -1 != agent.indexOf("Mozilla")){
	           encodedfileName = new String (fileName.getBytes("UTF-8"),"iso-8859-1");
	       }else{
	           encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
	       }
        
        response.setHeader("content-disposition", "attachment;filename="+encodedfileName+"."+name.substring(name.lastIndexOf(".")+1));
        //输入流，获得文件的字节流 
        InputStream is=new FileInputStream(f);
        byte[] bytes=new byte[is.available()];
        is.read(bytes);
        
        //将字节流写入response中
        response.getOutputStream().write(bytes);
        is.close();
        response.flushBuffer();
        response.getOutputStream().flush();
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
