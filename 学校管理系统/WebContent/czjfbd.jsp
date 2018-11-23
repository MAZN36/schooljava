<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>南方学院充值</title>
    <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

<link rel="stylesheet" href="weui-build/weui.min.css">
<link rel="stylesheet" href="weui-build/jquery-weui.css">
<link rel="stylesheet" href="weui-build/demos.css">

  </head>
<%
			String xh=(String)request.getSession().getAttribute("xh");
			double je=(double)request.getSession().getAttribute("je");
			String zffs=(String)request.getSession().getAttribute("zffs");
			String ddh=(String)	request.getSession().getAttribute("ddh");
			if(xh==null)
				response.sendRedirect("http://banggang.xyz/");
			String src="images/wx.png";
			if(zffs.equals("支付宝充值")){
				src="images/zfb.jpg";
			}
%>
  <body ontouchstart>
    <header class='demos-header'>
    <img  src="images/wx.png" width="100%"/>
      <h1 class="demos-title">充值余额:<%=je%></h1>
    </header>

    <div class='demos-content-padded'>
    <a href="javascript:;" id='show-loading' class="weui-btn weui-btn_primary">充&nbsp;&nbsp;&nbsp;值</a>
      <a href="javascript:;" id='show-toast-cancel' class="weui-btn weui-btn_primary">取&nbsp;  &nbsp;  &nbsp;消</a>
    </div>
    <script src="weui-build/jquery-2.1.4.js"></script>
<script src="weui-build/fastclick.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>
<script src="weui-build/jquery-weui.js"></script>

    <script>

      $(document)
      .on("click", "#show-toast-cancel", function() {
    	  if(navigator.userAgent.indexOf("Firefox") != -1 || navigator.userAgent.indexOf("Chrome") != -1) { 
              open(location, '_self').close();
              window.location.href="about:blank"; 
              window.close(); 
          }else { 
              window.opener = null; 
              window.open("", "_self"); 
              window.close(); 
              open(location, '_self').close();
          }
      })
     
      .on("click", "#show-loading", function() {
        $.showLoading();
        setTimeout(function() {
        	$.ajax({
      		  type:'post',
      		  url:'XfCost?action=adds',//学号  交易金额 交易方式 交易类型
      			data:{
						Stuidxf:"<%=xh%>",
						Jyyr:"<%=je%>",
						Jyfs:"<%=zffs%>",
						Jylx:"充值",
						Danhao:"<%=ddh%>"
      			},
        	success:function(data){
        		if(data>0){
        			 $.hideLoading();
        	          $.toast("充值成功");
        	          window.location.href='czjfok.html?ddh='+"<%=ddh%>";
        		}
        		else{
        			$.hideLoading();
      	          $.toast("充值失败");
        		}
        	}
      	  })
         
        }, 500)
        
      });
    </script>
  </body>
</html>