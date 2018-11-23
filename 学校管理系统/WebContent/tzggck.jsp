<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import='com.vo.*'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
html,body{
background-color: #f0f9fd;
height:100%;
margin:5px;
}
</style>
<link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<table width="600px" height="100%" cellspacing="0" cellpadding="0" align="center" border="0">
	<tr>
		<td width="100%" align="center" height="100%" style="padding:10px" bgcolor="#ffffff">
			<table width="100%" height="100%" cellspacing="0" cellpadding="0" align="center">
				<tr><td height="5px"></td></tr>
				<tr><td height="10px" align="center">
					<table width="100%" >
						<tr><td height="5px" align="center" style="color:#f00;font-weight:bolder">
							<span id="lbl_Title" >公告</span></td></tr>
						<tr><td width="100%" height="1px" valign="top" align="center"><hr/></td></tr>
					</table>
				</td></tr>
				<tr><td valign="top" align="center" colspan="2">
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" align="center">
						<tr valign="top" align="left" height="26px">
							<td width="100%" style="font-size:12px;">
								
								
							</td>
						</tr>
						<tr><td valign="top" id="nrs" align="left" width="100%" style="font-size:14px;">
						信息有误
						</td>
						</tr>
						
					</table>
				</td></tr>
				<tr><td height="5"><br/></td></tr>
			</table>
		</td>
	</tr>
</table>
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/Kindeditor/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="js/Kindeditor/lang/zh-CN.js"></script>
    <script>
    <%
	int id=Integer.parseInt(request.getParameter("id"));
%>
$.ajax({
	url:'Notice?action=findById&id='+<%=id%>
	,success:function(data){
			$("#lbl_Title").html(data.data.title);
			$("#nrs").html(data.data.content);
	
	}
})
	
    </script>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
</script>
</body>
</html>