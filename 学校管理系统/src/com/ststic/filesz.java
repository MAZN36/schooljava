package com.ststic;

import java.io.File;
import java.io.IOException;
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

import com.controlle.R;

/**
 * Servlet implementation class filesz
 */
@WebServlet("/filesz")
public class filesz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filesz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		//获取转进来的id
		String id=request.getParameter("pas");
		System.out.println(id+"pas");
		//获取本地路径
		String savePath=this.getServletConfig().getServletContext().getRealPath("");
		//获取设置的文件夹
		String Path=request.getParameter("Path");
		savePath+=Path+"\\";
		File file=new File(savePath);
		//判断是否存在 不存在就创建
		if(!file.exists()){
			file.mkdirs();
		}
		DiskFileItemFactory fac=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List<FileItem> filelist=null;
		try {
			filelist=upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			return;
		}
		Iterator<FileItem> it=filelist.iterator();
		String name="";
		String extName="";
		while(it.hasNext()){
			FileItem item=it.next();
			if(!item.isFormField()){
				name=item.getName();
				long size=item.getSize();
				String type=item.getContentType();
				//判断是否为空
				if(name==null||name.trim().equals("")){
					continue;
				}
				if(name.lastIndexOf(".")>=0){
					extName=name.substring(name.lastIndexOf("."));
				}
				
				File files=null;
				name=id;
				files=new File(savePath+name+extName);
				try {
					item.write(files);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		R r=new R();
		r.setCode(0);
		r.setMsg("上传成功");
		Map<String,String> data=new HashMap<String,String>();
		data.put("src", "images/" + name + extName);
        data.put("name",name + extName);
        r.setData(data);
        response.getWriter().print(r.toJson());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
