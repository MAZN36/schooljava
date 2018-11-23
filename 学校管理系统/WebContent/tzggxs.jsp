<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

    <div>
    	 <form>
		<div class="layui-form-item" >
    		<label class="layui-form-label">标题：</label>
    		<div class="layui-input-inline" style="width:350px">
      			<input type="text" id="title" required lay-verify="required"  autocomplete="off" class="layui-input" placeholder="请输入公告标题"  >
    		</div>
  		</div>
  		</form>
  		<label class="layui-form-label">内容：</label>
        <textarea cols="80" rows="10" id="details" style="width:80%;height:535px"></textarea>
<fieldset class="layui-elem-field site-demo-button">
  <legend>预览或发布</legend>
  <div>
    <button class="layui-btn layui-btn-normal layui-btn-radius"id="btnSubmit" style="width:49%">预览</button>
    <button class="layui-btn layui-btn-warm layui-btn-radius" id="insert"style="width:50%;margin:0px">发布</button>
  </div>
</fieldset>
    </div>
<table width="600px" height="100%" cellspacing="0" cellpadding="0" align="center" border="0">
	<tr>
		<td width="100%" align="center" height="100%" style="padding:10px" bgcolor="#ffffff">
			<table width="100%" height="100%" cellspacing="0" cellpadding="0" align="center">
				<tr><td height="5px"></td></tr>
				<tr><td height="10px" align="center">
					<table width="100%" >
						<tr><td height="5px" align="center" style="color:#f00;font-weight:bolder">
							<span id="lbl_Title" ></span></td></tr>
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
    var editor;
    KindEditor.ready(function(K) {
       editor = K.create('#details',{
           uploadJson : 'js/Kindeditor/jsp/upload_json.jsp',  //上传程序
           fileManagerJson : 'js/Kindeditor/jsp/file_manager_json.jsp',  //文件管理
           allowFileManager : true  //是否允许上传
        });  //创建一个富文本编辑器
    });

$("#btnSubmit").click(function(){
	$("#lbl_Title").html($("#title").val());
    $("#nrs").html(editor.html());
    	window.scrollTo(0, document.documentElement.scrollHeight-document.documentElement.clientHeight);
});
$("#insert").click(function(){
	
if(confirm('确定发布?')){
	$.ajax({
		type:"post",
		url:"Notice?action=add"
		,data:{
			Title:$("#title").val(),
			Content:editor.html(),
			Relepeople:1
			}
		,success:function(data){
			if(data>0){
				alert("添加成功");
				window.close();
				}
			else{
				alert("添加失败");
			}
		}
	});
}
	
    });
    </script>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
</script>
</body>
</html>