<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
  <link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<style>
th .layui-table-cell,td {text-align:center;}
.layui-input-block {margin-top: 20px;margin-left:117px; min-height: 36px;}
.layui-form-select dl{max-height: 300px;}

#demo1{
	width: 150px;
    height: 170px;
}
#tp{
	position:absolute;
	left:980px;
	 top: 60px;
}
.rig{width:1155px;
   }
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">个人设置</a></li>
    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
   <div class="rig">
   	<form class="layui-form" style="margin-top: 40px;margin-left: 250px;" >
  
  		<div class="layui-form-item">
    		<label class="layui-form-label">旧密码：</label>
    		<div class="layui-input-inline" style="width:370px;">
      			<input type="password" name="password" id="pw" required lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">新密码：</label>
    		<div class="layui-input-inline" style="width:370px;">
      			<input type="password" name="password" id="pw1" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    		</div>
    		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">确认新密码：</label>
    		<div class="layui-input-inline" style="width:370px;">
      			<input type="password" name="password" id="pw2" required lay-verify="required" placeholder="再次输入新密码" autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn layui-btn-normal" id="insertss" type="button" lay-filter="formDemo">确定修改</button>
		      <button class="layui-btn layui-btn-primary" id="reset" lay-submit lay-filter="reset">重置</button>
		    </div>
		  </div>
    </form>
    </div>
    <script>
    var layer;
    layui.use(['layer', 'form'], function () {
        layer = layui.layer
    });
    	 $("#insertss").click(function(){
    		
    		 var pw=$("#pw").val();
    	    	var pw1=$("#pw1").val();
    	    	var pw2=$("#pw2").val();
    	    	 if(pw.length=0)
    	    		 {
    	    		 layer.msg("原密码不能为空!");
    	    		 }
    	    	 if(pw1.length=0)
	    		 {
	    		 layer.msg("新密码不能为空!");
	    		 }
    	    	 if(pw2.length=0)
	    		 {
	    		 layer.msg("重复密码不能为空!");
	    		 }
    	    	if(pw1!=pw2){
    	    		layer.msg("两次密码不一致,请重新输入!");
    	    		return;
    	    	}
    	    	if(pw==pw2){
    	    		layer.msg("原密码和新密码不能一致,请重新输入!");
    	    		return;
    	    	}
    	    	$.ajax({
    	    		url:'Administrator?action=uppassword',
    	    				data:{password1:pw,password2:pw1},
    	    		success:function(data){
    	    			layer.msg(data.msg);
    	    			if(data.msg=="修改成功"){
    	    				alert("修改成功!");
    	    				alert("密码验证失败,请重新登录!");
    	    				window.location.href='Out';
    	    				parent.index();
    	    			}
    	    			
    	    		}
    	    	})
    	    })
   
    </script>
</body>
</html>
